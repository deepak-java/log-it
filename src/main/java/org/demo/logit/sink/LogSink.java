package org.demo.logit.sink;

import java.io.InputStream;

public interface LogSink {

    void write(InputStream inputStream) throws Exception;

}
