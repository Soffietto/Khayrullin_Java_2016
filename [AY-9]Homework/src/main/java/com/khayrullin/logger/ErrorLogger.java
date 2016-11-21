package com.khayrullin.logger;

class ErrorLogger extends Logger {

    ErrorLogger() {
        setLevelPattern(Level.ERROR);
    }
}