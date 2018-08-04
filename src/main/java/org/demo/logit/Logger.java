package org.demo.logit;

public interface Logger {

    public void info(String message, Object... args);
    public void error(String message, Object... args);
    public void debug(String message, Object... args);
}
