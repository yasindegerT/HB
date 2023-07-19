package com.optiim.utilities;

import org.apache.log4j.Logger;

public class LogHelper {
    public static void log(Class className, String logData){
        Logger logger = Logger.getLogger(className);
        logger.info(logData);
    }
}
