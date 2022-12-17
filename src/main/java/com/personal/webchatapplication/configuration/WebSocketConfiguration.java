package com.personal.webchatapplication.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.personal.webchatapplication.handler.ChatWebSocketHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfiguration implements WebSocketConfigurer {


    private static final String CHAT_ENDPOINT = "chat";

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(getCharWebSocketHandler() , CHAT_ENDPOINT)
        .setAllowedOrigins("*");
        
    }

    @Bean
    public WebSocketHandler getCharWebSocketHandler(){
        return new ChatWebSocketHandler();
    }
    

}
