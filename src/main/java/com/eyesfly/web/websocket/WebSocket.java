package com.eyesfly.web.websocket;

/**
 * Created by sunpengfei on 16/6/5.
 */

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * WebSocket 配置类
 */
@ServerEndpoint("/chart/${user}")
public class WebSocket {
    @OnMessage
    public void onMessage(String message, Session session, @PathParam("user") String user)
            throws IOException, InterruptedException {

        String currentUser = session.getUserPrincipal().getName();
        if(currentUser.equals(user)){
            session.getBasicRemote().sendText(message);
        }

        // Print the client message for testing purposes
        System.out.println("Received: " + message);

        // Send the first message to the client
        session.getBasicRemote().sendText("This is the first server message");
        System.out.println("user: "+session.getUserPrincipal().getName());
        // Send 3 messages to the client every 5 seconds
        int sentMessages = 0;
        while(sentMessages < 3){
            Thread.sleep(5000);
            session.getBasicRemote().
                    sendText("This is an intermediate server message. Count: "
                            + sentMessages);
            sentMessages++;
        }

        // Send a final message to the client
        session.getBasicRemote().sendText("This is the last server message");
    }

    @OnOpen
    public void onOpen() {
        System.out.println("Client connected");
    }

    @OnClose
    public void onClose() {
        System.out.println("Connection closed");
    }

}
