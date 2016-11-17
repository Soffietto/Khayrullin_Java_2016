package com.khayrullin.logger;

import java.util.regex.Pattern;

public class InfoLogger extends Logger {

    public InfoLogger() {
        this.regularExpression = "\\[(INFO|ERROR)\\] : (?<message>\\[.+\\])$";
    }
}