package com.example.demo;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(maxAge = 3600)
@Controller
public class GreetingController {
    @MessageMapping("/chat.addUser")  //это придуманный адрес(как при PostMapping), все что придет на этот адрес будет
                                      //обробатываться функцией addUser
    @SendTo("/topic/public")// отюсюда будем подписываться и читать сообщение
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getUsername());
        return chatMessage;
    }

    @MessageMapping("/chat.addMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }
//    Например, сообщение, направленное по адресу /app/chat.sendMessage будет перенаправлено в метод sendMessage().
//    А например, сообщение, направленное по адресу/app/chat.addUser будет перенаправлено в метод addUser().
}