package com.alcatelsbell.cdcp.nodefx;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.asb.mule.probe.framework.util.FileLogger;

import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: Ronnie.Chen
 * Date: 2014/11/23
 * Time: 10:19
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class KeepAliveConnectionsManager {
    private Log logger = LogFactory.getLog(getClass());
    private ReentrantLock lock = new ReentrantLock();
    private HashMap<String,Condition> conditions = new HashMap<String, Condition>();
    private HashMap<String,KeepAliveConnection> connections = new HashMap<String, KeepAliveConnection>();

    public boolean containsConnection(String key) {
        return connections.containsKey(key);
    }
    public KeepAliveConnection getConnection(String key) {
        return connections.get(key);
    }

    public HashMap<String, KeepAliveConnection> getConnections() {
        return connections;
    }

    public void removeConnection(String key) {
        connections.remove(key);
    }
    public KeepAliveConnection borrowConnection(String key) {
        lock.lock();
        logger.info("borrowConnection");
        logger.info("borrowConnection-" + connections.toString());

        KeepAliveConnection keepAliveConnection = null;
        try {
            keepAliveConnection = connections.get(key);
            if (keepAliveConnection == null) return null;
            if (keepAliveConnection.isInUse()) {
                    getCondition(key).await();
            }
            if (keepAliveConnection.isInUse()) throw new Exception("error status : connection "+key);
            keepAliveConnection.setInUse();
        } catch (Exception e) {
            logger.error(e, e);
        }  finally {
            lock.unlock();
        }


        return keepAliveConnection;


    }

    public void addConnection(KeepAliveConnection connection) {
        lock.lock();
        try {
            connections.put(connection.getKey(), connection);
            connection.startHeartBeat (connection);
        } catch (Exception e) {
            logger.error(e,e);
        }

        lock.unlock();


    }



    public void returnConnection(KeepAliveConnection connection) {
        lock.lock();
        try {
            connection.setUnUse();
            getCondition(connection.getKey()).signal();
        } catch (Exception e) {
            logger.error(e,e);
        }
        lock.unlock();
    }

    private synchronized Condition getCondition(String key) {
        Condition condition = conditions.get(key);
        if (condition == null) {
            condition = lock.newCondition();

            conditions.put(key,condition);
        }
        return condition;
    }

    public static void main(String[] args) throws InterruptedException {
        final KeepAliveConnectionsManager manager = new KeepAliveConnectionsManager();
        for (int i = 0; i < 10; i++) {
            manager.addConnection(new KeepAliveConnection(i+"") {
                @Override
                public boolean checkConnection() {
                    return true;
                }

                @Override
                public boolean heartbeat() {
                    return false;
                }

                @Override
                public boolean reconnect() {
                    return true;
                }

                @Override
                public boolean disconnect() {
                    return true;
                }

                @Override
                public boolean connect() {
                    return true;
                }
            });
        }
        Random random = new Random(10);
        for (int i = 0; i < 1000; i++) {

            final int _i = (int)Math.sqrt(random.nextInt());
            final String key =  ""+(_i%10);
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    KeepAliveConnection keepAliveConnection = manager.borrowConnection(key);
                    if (keepAliveConnection == null)
                        System.out.println("Faild to get "+key);
                    System.out.println(new Date()+"  "+_i+" is using :"+keepAliveConnection.getKey());
                    try {
                        Thread.sleep((1+_i%5) * 1000);
                    } catch (InterruptedException e) {

                    }

                    manager.returnConnection(keepAliveConnection);
                    System.out.println(new Date()+"  "+key+" is being returned");
                }
            };
            new Thread(r).start();
        }

        Thread.sleep(23423432l);

    }
}
