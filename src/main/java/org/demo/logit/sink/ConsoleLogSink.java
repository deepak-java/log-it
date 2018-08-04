package org.demo.logit.sink;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ConsoleLogSink implements LogSink {

    private BufferedOutputStream outputStream;

    public ConsoleLogSink(){

        outputStream = new BufferedOutputStream(System.out);

    }

    @Override
    public synchronized void write(InputStream inputStream) throws IOException {
        byte[] data = new byte[128];
        while(inputStream.available() > 0){
            inputStream.read(data);
            outputStream.write(data);
        }
        outputStream.flush();
    }
}
