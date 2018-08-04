package org.demo.logit.config;

import org.demo.logit.sink.LogSink;

import java.util.List;

public class Config {

    public Config(String logPattern, LogLevel logLevel, List<LogSink> logSinks){
        this.logPattern=logPattern;
        this.loglevel=logLevel;
        this.logSinks=logSinks;
    }

    private String logPattern;
    private LogLevel loglevel;
    private List<LogSink> logSinks;

    public String getLogPattern() {
        return logPattern;
    }

    public List<LogSink> getLogSinks(){
        return logSinks;
    }
    public LogLevel getLoglevel(){
        return loglevel;
    }
}
