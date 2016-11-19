package com.khayrullin.logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Logger {

    private String level;
    private Logger next;
    private Matcher matcher;

    void setLevel(String level) {
        this.level = level;
    }

    void setNext(Logger next) {
        this.next = next;
    }

    void log(String message) {
        matcher =Pattern.compile("\\[(" + level + ")\\] : (?<message>\\[.+\\])$").matcher(message);
        if (matcher.matches()) {
            System.out.println(matcher.group("message"));
        }
        if (next != null) {
            next.log(message);
        }
    }
}