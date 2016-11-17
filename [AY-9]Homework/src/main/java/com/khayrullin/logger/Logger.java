package com.khayrullin.logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Logger {
    protected String regularExpression;
    protected Logger next;

    public void setNext(Logger next) {
        this.next = next;
    }

    public void log(String message) {
        Pattern pattern = Pattern.compile(regularExpression);
        Matcher matcher = pattern.matcher(message);
        if (matcher.matches()) {
            System.out.println(matcher.group("message"));
        }
        if (next != null) {
            next.log(message);
        }
    }
}