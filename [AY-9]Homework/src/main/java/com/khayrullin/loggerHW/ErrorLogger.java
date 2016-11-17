package com.khayrullin.loggerHW;

public class ErrorLogger extends Logger {

    public ErrorLogger() {
        this.level = "ERROR";
    }

    @Override
    public void log(String message) {
        String[] s = message.split(" : ");
        level = s[0];
        if (level.equals("[ERROR]")) {
            String text = s[1];
            writeMessage(text);
        }
        if (next != null) {
            next.log(message);
        }

    }

    @Override
    void writeMessage(String message) {
        System.out.println(message);
    }
}
