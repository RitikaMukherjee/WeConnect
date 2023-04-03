package com.example.weconnect.Models;//creating packages for ensuring encapsualtion

public class MessageModel {
    Private String uId,message,messageId;// creating private variables to ensure data hiding
    Private long timestamp;// creating private variables to ensure data hiding

    public MessageModel(String uId, String message) {//constructors created
        this.uId = uId;
        this.message = message;
    }

    public MessageModel(String uId, String message, Long timestamp) {//constructors created
        this.uId = uId;
        this.message = message;
        this.timestamp = timestamp;
    }

    public MessageModel() {// default empty constructor
    }

    public String getuId() {//creating getters and setters for accessing private variables
        return uId;
    }

    public void setuId(String uId) {//creating getters and setters for accessing private variables
        this.uId = uId;
    }

    public String getMessage() {//creating getters and setters for accessing private variables
        return message;
    }

    public void setMessage(String message) {//creating getters and setters for accessing private variables
        this.message = message;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {//creating getters and setters for accessing private variables
        this.messageId = messageId;
    }

    public Long getTimestamp() {//creating getters and setters for accessing private variables
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {//creating getters and setters for accessing private variables
        this.timestamp = timestamp;
    }
}
