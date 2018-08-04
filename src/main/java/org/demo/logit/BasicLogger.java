package org.demo.logit;

import org.demo.logit.config.Config;
import org.demo.logit.config.LogLevel;

import java.io.StringBufferInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicLogger implements Logger {

    private Config baseConfig;

    @Override
    public void info(String message, Object... args) {
        if(baseConfig.getLoglevel().equals(LogLevel.INFO)){
            writeLogData(message,args);
        }

    }

    @Override
    public void error(String message, Object... args) {
        if(baseConfig.getLoglevel().equals(LogLevel.ERROR)){
            writeLogData(message,args);
        }
    }

    @Override
    public void debug(String message, Object... args) {
        if(baseConfig.getLoglevel().equals(LogLevel.DEBUG)){
            writeLogData(message,args);
        }
    }

    private void writeLogData(String message, Object args){
        String logData = buildPatternString(baseConfig.getLogPattern(), buildString(message,args));
        baseConfig.getLogSinks().forEach(sink -> {
            try {
                sink.write(new StringBufferInputStream(logData));
            }catch (Exception e){

            }
        });
    }

    private String buildString(String message, Object[] args){
        //String strPattern = baseConfig.getLogPattern();
        Pattern pattern = Pattern.compile(".*{}.*");
        Matcher matcher = pattern.matcher(message);
        int i=0;
        while(matcher.find() && i<args.length){
            int start = matcher.start();
            int end = matcher.end();
            message = message.replace(message.substring(start,end),args[i].toString());
            ++i;
        }
        return message;
    }

    private String buildPatternString(String pattern, String message){
        return pattern + message;
    }
}
