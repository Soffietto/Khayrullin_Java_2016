package com.khayrullin.logger;

class WarnLogger extends Logger {

    WarnLogger() {
        setLevelPattern(Level.WARN);
    }
}