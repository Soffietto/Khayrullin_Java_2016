package com.khayrullin.logger;

class InfoLogger extends Logger {

    InfoLogger() {
        setLevelPattern(Level.INFO + "|" + Level.ERROR);
    }
}