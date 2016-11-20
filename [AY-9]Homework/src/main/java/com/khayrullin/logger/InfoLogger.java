package com.khayrullin.logger;

class InfoLogger extends Logger {

    InfoLogger() {
        setLevel(Level.INFO + "|" + Level.ERROR);
    }
}