package com.example.demo;

public class ChatMessage {

    private String username;
    private String body;
    private Type type;

    public enum Type {// это для статуса клиента JOIN-защел,CHAT- в чате,LEAVE-вышел
        JOIN,
        CHAT,
        LEAVE
    }

    public ChatMessage() {
    }

    public ChatMessage(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
