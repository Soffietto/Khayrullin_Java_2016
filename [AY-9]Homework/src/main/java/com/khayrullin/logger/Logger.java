package com.khayrullin.logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Logger {

    private Level level;
    private Logger next;

    void setLevel(Level level) {
        this.level = level;
    }

    void setNext(Logger next) {
        this.next = next;
    }

    void log(String message) {
        Pattern pattern = Pattern.compile("\\[(" + level + ")\\] : (?<message>\\[.+\\])$");
        Matcher matcher = pattern.matcher(message);
        if (matcher.matches()) {
            System.out.println(matcher.group("message"));
        }
        if (next != null) {
            next.log(message);
        }
    }
}