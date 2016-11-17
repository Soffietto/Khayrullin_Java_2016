package com.khayrullin.logger;

public class WarnLogger extends Logger {

    public WarnLogger() {
        this.regularExpression = "\\[WARN\\] : (?<message>\\[.+\\])$";
    }
}