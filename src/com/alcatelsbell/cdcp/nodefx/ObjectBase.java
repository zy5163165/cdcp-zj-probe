package com.alcatelsbell.cdcp.nodefx;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.asb.mule.probe.framework.util.Object2XML;

import java.io.File;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Author: Ronnie.Chen
 * Date: 14-3-12
 * Time: 下午3:13
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class ObjectBase {
    private Log logger = LogFactory.getLog(getClass());
    public static final String BASE_DIR = "OBJECTS";
    private ObjectBase() {

        try {
            if (!new File(BASE_DIR).exists())
                new File(BASE_DIR).mkdir();
        } catch (Throwable e) {
            logger.error(e, e);
        }

        startExpireMonitor();
    }

    private void startExpireMonitor() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        DelayEvent delayEvent = expireQueue.take();
                        String token = delayEvent.getToken();
                        logger.warn("Object:"+token+":"+objectMap.get(token)+" expired, be removed !");
                        objectMap.remove(token);
                    } catch (InterruptedException e) {
                        logger.error(e, e);
                    }
                }
            }
        };
        new Thread(r).start();
    }

    private static ObjectBase inst = new ObjectBase();
    public static ObjectBase getInstance() {
        return inst;
    }

    private ConcurrentHashMap<String,Serializable> objectMap = new ConcurrentHashMap<String, Serializable>();
    private DelayQueue<DelayEvent> expireQueue = new DelayQueue();
    public void registerObject(final String token,final Serializable object) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
        //        Object2XML.toXmlFile(object,BASE_DIR+"/"+token);
            }
        };
        new Thread(r).start();

        objectMap.put(token,object);
        expireQueue.offer(new DelayEvent(token,60 * 60 * 24));

    }

    public Serializable getObject(String token) {
        return objectMap.get(token);
    }

    public Serializable destoryObject(String token) {
        return objectMap.remove(token);
    }

    static class DelayEvent implements Delayed {
        private static final long NANO_ORIGIN = System.nanoTime();

        final static long now() {
            return System.nanoTime() - NANO_ORIGIN;
        }

        private final long time;

        private   String token;

        public DelayEvent(String token, long timeoutInSeconds) {
            this.time = now()
                    + TimeUnit.NANOSECONDS.convert(timeoutInSeconds,
                    TimeUnit.SECONDS);
            this.token = token;
        }

        public String getToken() {
            return this.token;
        }

        public long getDelay(TimeUnit unit) {
            long d = unit.convert(time - now(), TimeUnit.NANOSECONDS);
            return d;
        }

        public int compareTo(Delayed other) {
            DelayEvent that = (DelayEvent) other;
            long diff = time - that.time;
            if (diff < 0)
                return -1;
            else if (diff > 0)
                return 1;
            else
                return 0;
        }
    }


}
