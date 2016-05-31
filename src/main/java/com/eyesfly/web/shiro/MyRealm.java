package com.eyesfly.web.shiro;

import com.eyesfly.entity.User;
import com.eyesfly.service.IResourceService;
import com.eyesfly.service.IRoleService;
import com.eyesfly.service.IUserService;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2016/3/29.
 */
@Component
public class MyRealm extends JdbcRealm {
    public Logger logger = Logger.getLogger(getClass());
    @Resource
    private IUserService userService;
    @Resource
    private IRoleService roleService;
    @Resource
    private IResourceService resourceService;

    //登录认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = String.valueOf(usernamePasswordToken.getUsername());
        User user = null;
        try{

            user = userService.findByUsername(username);
        }catch (Exception e){
            e.printStackTrace();
        }

        SimpleAuthenticationInfo  authenticationInfo = null;

        if(user == null) {
            throw new UnknownAccountException();//没找到帐号
        }
/*
        String password = new String(usernamePasswordToken.getPassword());
        boolean flag = EndecryptUtils.checkMd5Password(username,password,user.getSalt(),user.getPassword());
*/
            authenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
            authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(username+user.getSalt()));
        return authenticationInfo;
    }

    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        String username = (String) principals.getPrimaryPrincipal();
        if (username!=null) {
            SimpleAuthorizationInfo authenticationInfo = new SimpleAuthorizationInfo();
            Set<String> roles = new HashSet<String>();
            Set<String> permissions = new HashSet<String>();
            List<String> roleServiceRoles = roleService.findRoles(username);
            List<String> resourceServicePermissions = resourceService.findPermissions(username);
            for (String role :roleServiceRoles) {
                roles.add(role);
            }
            for (String permission : resourceServicePermissions) {
                permissions.add(permission);
            }
            authenticationInfo.setRoles(roles);
            authenticationInfo.setStringPermissions(permissions);
            return authenticationInfo;
        }
        return null;

    }
}
