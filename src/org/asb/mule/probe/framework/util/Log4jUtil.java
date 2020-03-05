package org.asb.mule.probe.framework.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerRepository;

import java.util.Enumeration;

/**
 * Author: Ronnie.Chen
 * Date: 13-8-9
 * Time: 下午1:13
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class Log4jUtil {
    public static void renameLoggerFileByModuleName(String moduleName) {
        Logger logger = Logger.getRootLogger();
        LoggerRepository loggerRepository = logger.getLoggerRepository();
        loggerRepository.getCurrentLoggers();
        Enumeration allAppenders = logger.getAllAppenders();
        while (allAppenders.hasMoreElements()) {
            Object o = allAppenders.nextElement();
            if (o instanceof FileAppender) {
                String file = ((FileAppender) o).getFile();
                if (file.endsWith(".log")) {
                    file = file.substring(0,file.indexOf(".log"))+"."+moduleName+".log";
                } else {
                    file = file +"."+moduleName+".log";
                }
                ((FileAppender) o).setFile(file);
            }
        }

    }
    public static void main(String[] args) {

        Log log = LogFactory.getLog(Log4jUtil.class);
        log.info("abcdefg");
    }
}
