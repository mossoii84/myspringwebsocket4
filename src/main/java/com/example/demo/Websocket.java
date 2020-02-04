package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker //@EnableWebSocketMessageBroker включает обработке сообщений по WebSocket,
                             // возвращаемый брокером сообщений.
public class Websocket  implements WebSocketMessageBrokerConfigurer {

    @Override//создаем точку связи endpoint
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws")
                .setAllowedOrigins("http://localhost:4200")
                .withSockJS(); }
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");//это будет клиент SendMessage
        registry.enableSimpleBroker("/topic"); //это клиент подписывается чтобы получить
         }
//    Он вызывает enableSimpleBroker() для включения простого брокера сообщений в памяти чтобы возвращать
//    обратно сообщения клиенту по направлениям с префиксом /topic.
//    Он также объявляет префикс /app для сообщений, привязанных к методам,
//    аннотированными @MessageMapping.
}
