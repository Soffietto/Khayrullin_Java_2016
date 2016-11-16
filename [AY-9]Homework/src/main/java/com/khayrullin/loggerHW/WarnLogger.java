package com.khayrullin.loggerHW;

public class WarnLogger extends Logger {

    public WarnLogger() {
        this.level = "WARN";
    }

    @Override
    void writeMessage(String message) {
        System.out.println("WARN: " + message);
    }
}
