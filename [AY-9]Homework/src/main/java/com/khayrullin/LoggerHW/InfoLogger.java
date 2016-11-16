package com.khayrullin.LoggerHW;

public class InfoLogger extends Logger {

    public InfoLogger() {
        this.level = "INFO";
    }

    @Override
    void writeMessage(String message) {
        System.out.println("INFO: " + message);
    }
}
