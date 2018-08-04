package org.demo.logit;

public class LoggerFactory {

    private LoggerFactory(){}

    private Logger logger;

    public Logger getLogger(String name){
        return logger;
    }

    private Logger getLogger(Class<?> classType){
        return logger;
    }
}
