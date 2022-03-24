package com.xzj.base;

public class MessageUtil2 {
    private String message;

    public MessageUtil2(String message){
        this.message = message;
    }

    public String printMessage(){
        System.out.println(message);
        return message;
    }

    public String salutationMessage(){
        message = "wiki." + message;
        System.out.println(message);
        return message;
    }

    public String exitMessage(){
        message = "www." + message;
        System.out.println(message);
        return message;
    }
}
