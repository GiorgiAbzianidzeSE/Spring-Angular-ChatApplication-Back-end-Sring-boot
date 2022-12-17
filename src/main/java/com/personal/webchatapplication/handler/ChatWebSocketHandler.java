package com.personal.webchatapplication.handler;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.*;

public class ChatWebSocketHandler extends TextWebSocketHandler{


    private final List<WebSocketSession> webSocketSessions = new ArrayList<>();


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
      this.webSocketSessions.add(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        this.webSocketSessions.forEach((elem) ->{
            try {
                elem.sendMessage(message);
            } catch (IOException e) {
                throw new RuntimeException("Message didn't send" + message);
            }
        });
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        this.webSocketSessions.remove(session);
    }


    
}
