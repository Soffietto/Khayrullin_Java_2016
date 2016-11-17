package com.khayrullin.loggerHW;

public abstract class Logger {

    protected String level;
    protected Logger next;

    public void setNext(Logger next) {
        this.next = next;
    }

    public abstract void log(String message);

    private String getLevel(String message) {
        String[] s = message.split(" : ");
        String pr = s[0];
        pr = pr.substring(1, pr.length() - 1);
        return pr;
    }

    abstract void writeMessage(String message);

}
