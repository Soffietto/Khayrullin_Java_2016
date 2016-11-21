package com.khayrullin.logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Logger {

    private Logger next;
    private Matcher matcher;
    private Pattern pattern;

    void setLevel(String level) {
        pattern = Pattern.compile("\\[(" + level + ")\\] : (?<message>\\[.+\\])$");
    }

    void setNext(Logger next) {
        this.next = next;
    }

    void log(String message) {
        matcher = pattern.matcher(message);
        if (matcher.matches()) {
            System.out.println(matcher.group("message"));
        }
        if (next != null) {
            next.log(message);
        }
    }
}