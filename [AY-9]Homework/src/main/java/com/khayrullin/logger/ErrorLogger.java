package com.khayrullin.logger;

public class ErrorLogger extends Logger {

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
}