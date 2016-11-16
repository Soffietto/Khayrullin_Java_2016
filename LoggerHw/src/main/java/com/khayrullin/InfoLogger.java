package com.khayrullin;

public class InfoLogger extends Logger {

    public InfoLogger(){
        this.level = "INFO";
    }

    @Override
    void writeMessage(String message)  {
        System.out.println("INFO: " + message);
    }
}
