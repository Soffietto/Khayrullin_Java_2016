package com.khayrullin.logger;

public class InfoLogger extends Logger {

    public InfoLogger() {
        this.regularExpression = "\\[(INFO|ERROR)\\] : (?<message>\\[.+\\])$";
    }
}