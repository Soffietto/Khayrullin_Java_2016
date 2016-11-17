package com.khayrullin.logger;

public abstract class Logger {

    protected String level;
    protected Logger next;

    public void setNext(Logger next) {
        this.next = next;
    }

    public abstract void log(String message);

    void writeMessage(String message){
        System.out.println(message);
    }
}