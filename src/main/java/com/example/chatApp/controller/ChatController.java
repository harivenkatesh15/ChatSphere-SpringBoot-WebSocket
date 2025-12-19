package com.example.chatApp.controller;

import com.example.chatApp.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message) {
        return message;
    }

    @MessageMapping("/join")
    @SendTo("/topic/messages")
    public ChatMessage userJoined(ChatMessage message) {
        message.setContent("joined the chat");
        message.setTime(java.time.LocalTime.now().toString());
        return message;
    }

    @GetMapping("/chat")
    public String chatPage() {
        return "chat";
    }
}
