package com.khayrullin.logger;

class InfoLogger extends Logger {

    InfoLogger() {
        this.setLevel(Level.INFO.toString() + "|" + Level.ERROR.toString());
    }
}