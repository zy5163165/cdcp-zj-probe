package org.asb.mule.probe.framework.util;

import org.apache.log4j.*;
import org.apache.log4j.spi.LoggingEvent;

import java.io.File;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: Ronnie.Chen
 * Date: 13-9-10
 * Time: 上午10:18
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class FileLogger {
    private Logger logger = null;
    private boolean toConsole = false;
    private FileAppender fileAppender = null;
    private ConsoleAppender consoleAppender = null;
    public  void init(String _fileName) throws Exception{
        Logger logger = null;
        if (_fileName == null || _fileName == "") {
            logger = Logger.getRootLogger();
        } else {
        //    logger = Logger.getLogger(_fileName.replace('/', '.')); //???????
            logger = Logger.getLogger("FileLogger."+_fileName.replace('/', '.'));

            String logDir =
                    "../logs/";


            File logFile = new File(logDir + _fileName);
            if (!logFile.getParentFile().exists()) {
                logFile.getParentFile().mkdir();
            }
            if (!logFile.exists()) {
                logFile.createNewFile();
            }
            String fileName = logFile.getCanonicalPath();

            if (mode == this.FILE_LOGGER_MODE_DAILY_ROLLING_FILE) {
                fileAppender = new DailyRollingFileAppender();
            } else if (mode == this.FILE_LOGGER_MODE_ROLLING_FILE) {
                fileAppender = new RollingFileAppender();

            }else if (mode == this.FILE_LOGGER_MODE__FILE) {
                fileAppender = new FileAppender();
            }

            Layout l = new PatternLayout();

            //Layout layout = new   PatternLayout("[%-5p] %d{yyyy-MM-dd HH:mm:ss.SSS} [%t] (%F:%L) %m %n");
            Layout layout = new   PatternLayout("[%-5p] %d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %m %n");
            fileAppender.setLayout(layout);

            fileAppender.setFile(fileName);
            //           fileAppender.setAppend(appender.getAppend());
            fileAppender.setAppend(true);
            //          fileAppender.setEncoding(appender.getEncoding());
            fileAppender.activateOptions();

            if (fileAppender instanceof RollingFileAppender) {
                RollingFileAppender rfileappender = (RollingFileAppender)
                        fileAppender;
//                rfileappender.setMaxBackupIndex(((RollingFileAppender) appender).
//                                                getMaxBackupIndex());
//                rfileappender.setMaximumFileSize(((RollingFileAppender)
//                                                  appender).getMaximumFileSize());
                rfileappender.setMaxBackupIndex(5);
                rfileappender.setMaxFileSize("100M");

            }
            logger.addAppender(fileAppender);

        }
        if (logger != null) {
            setLogger(logger);
        }

        if (getLogger() != null)
            getLogger().setLevel(Level.DEBUG);

//        enableConsole();
    }
    public FileLogger() {

    }
    public void enableConsole() {
        consoleAppender = new ConsoleAppender(fileAppender.getLayout());
        consoleAppender.setThreshold(Level.ERROR);
        logger.addAppender(consoleAppender);
    }

    public FileLogger(String fileName) {
        try {
            this.init(fileName);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static final int FILE_LOGGER_MODE_ROLLING_FILE = 0;
    public static final int FILE_LOGGER_MODE_DAILY_ROLLING_FILE = 1;
    public static final int FILE_LOGGER_MODE__FILE = 2;
    private int mode = FILE_LOGGER_MODE_DAILY_ROLLING_FILE;
    public FileLogger(String fileName,int mode) {
        try {
            this.init(fileName);
            this.mode = mode;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public  void setLogger(Logger _logger) {
        logger = _logger;
    }


    private ReentrantLock lock = new ReentrantLock();

    public void safeLog(Object str,Priority priority) {
        lock.lock();
        try {
            LoggingEvent event = new LoggingEvent(Logger.class.getName(),logger, priority, str, null);
            this.fileAppender.doAppend(event);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
    //    public void info(Object info) {
//        //getLogger().info(info);
//         this.safeLog(info,Priority.INFO);
//    }
//    public void error(Object info) {
//        this.safeLog(info,Priority.ERROR);
//    }
//    public  void debug(Object str) {
//        this.safeLog(str,Priority.DEBUG);
//    }
    public void info(Object info) {
        //getLogger().info(info);
        logger.info(info);
    }
    public void error(Object info) {
        logger.error(info);
    }
    public  void debug(Object str) {
        logger.debug(str);
    }



    public void error(Object info,Throwable exp) {
        logger.error(info,exp);
    }
    public  Logger getLogger() {
        if (logger == null) {
            try {
                init("EomsIfc.log");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return logger;
    }

    public void close() {
        fileAppender.close();
        if (consoleAppender != null)
            consoleAppender.close();
    }


    public static void main(String[] args) throws InterruptedException {
        System.out.println("abcde");
        final FileLogger logger = new FileLogger("ff.log");
        logger.enableConsole();
        Thread t = new Thread(){
            public void run() {
                logger.error("abcdefg");
                logger.error("abcdefg");
                logger.error("abcdefg");
                logger.error("abcdefg");            }
        };
        t.start();
        Thread.sleep(10000);
    }

}
