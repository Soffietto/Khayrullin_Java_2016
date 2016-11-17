package com.khayrullin.logger;

import java.util.regex.Pattern;

public class ErrorLogger extends Logger {

    public ErrorLogger() {
        this.regularExpression = "\\[ERROR\\] : (?<message>\\[.+\\])$";
    }
}