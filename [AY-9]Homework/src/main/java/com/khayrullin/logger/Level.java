package com.khayrullin.logger;

enum Level {
    ERROR, WARN, INFO{
        @Override
        public String toString() {
            return "INFO|ERROR";
        }
    }
}
