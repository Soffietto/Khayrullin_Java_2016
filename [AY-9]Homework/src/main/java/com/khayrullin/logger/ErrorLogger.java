package com.khayrullin.logger;

class ErrorLogger extends Logger {

    ErrorLogger() {
        this.setLevel(Level.ERROR.toString());
    }
}