package com.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogDetailUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogDetailUtil.class);

    public static void logDetailInfo(){
        StringBuffer sb = new StringBuffer();
        StackTraceElement[] traceElements = new Throwable().getStackTrace();
        LOGGER.info("class: {}, method: {}, lineNumber {}",traceElements[1].getClassName(),traceElements[1].getMethodName(),traceElements[1].getLineNumber());
    }
}