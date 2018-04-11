package com.alcatelsbell.cdcp.nodefx;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: Ronnie.Chen
 * Date: 13-9-16
 * Time: 下午3:48
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class EmsConcurrentLock {
    private int maxSize;
    private transient int currentSize = 0;
    private ReentrantLock lock = null;
    private Condition free = null;


    public EmsConcurrentLock(int _maxSize) {
        this.maxSize = _maxSize;
        lock = new ReentrantLock();
        free = lock.newCondition();
    }

    public void getLock() throws InterruptedException {
        lock.lock();
        try {
            if (currentSize < maxSize) {
                currentSize ++;
                return;
            } else {
                free.await();
                currentSize ++;
                return;
            }
        } finally {
            lock.unlock();
        }



    }

    public void releaseLock() {
        currentSize --;
        lock.lock();
        try {
           free.signal();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
         EmsConcurrentLock lock1 = new EmsConcurrentLock(3);
        for (int i = 0; i < 100; i++) {
            new TestThread(i+"",lock1).start();
        }
    }

    static class TestThread extends Thread{
        private String name;
        private EmsConcurrentLock lock ;

        TestThread(String name, EmsConcurrentLock lock) {
            this.name = name;
            this.lock = lock;
        }


        public void run() {
            try {
                lock.getLock();
                System.out.println("Running : "+name);
                Thread.sleep(5000l);
                lock.releaseLock();
            } catch (InterruptedException e) {
                //logger.error(e, e);
            }
        }
    }
}
