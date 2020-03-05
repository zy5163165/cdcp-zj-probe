package org.asb.mule.probe.framework.service;

/**
 * Author: Ronnie.Chen
 * Date: 13-7-2
 * Time: 上午10:10
 * rongrong.chen@alcatel-sbell.com.cn
 */

import com.alcatelsbell.nms.db.components.service.JPASupport;
import com.alcatelsbell.nms.db.components.service.JPASupportFactory;
import com.alcatelsbell.nms.db.components.service.JPAUtil;
import com.alcatelsbell.nms.valueobject.BObject;
import org.apache.log4j.Logger;
import org.asb.mule.probe.framework.util.ProbeLog;

import java.util.concurrent.LinkedBlockingQueue;

public class SqliteContext {
    private JPASupport jpaSupport;
    private String dataPath;

    //private Logger logger  = ProbeLog.getInstance().getDataLog();


   public SqliteContext(String dataPath) {
       this.dataPath = dataPath;
       init();
   }

    public void setDataPath(String dataPath) {
        this.dataPath = dataPath;
    }

    public String getDataPath() {
        return dataPath;
    }

    public void init(){
        setJpaSupport(JPASupportFactory.createSqliteJPASupport(getDataPath()));
    }

    public void setJpaSupport(JPASupport jpaSupport) {
        this.jpaSupport = jpaSupport;
    }

    public JPASupport getJpaSupport() {
        return jpaSupport;
    }

    private LinkedBlockingQueue<BObject> queue = new LinkedBlockingQueue();
    private  Runnable consumer = null;
    public void insertBObject(BObject object) {
        queue.offer(object);

        if (consumer == null) {
            consumer = new Runnable() {

                private JPASupport support = JPASupportFactory.createSqliteJPASupport(getDataPath());
                @Override
                public void run() {
                    while (true) {
                        try {
                            BObject bo = queue.take();
                            int consumeSize = queue.size() > 2000 ? 2000 : queue.size();

                            support.begin();
                            JPAUtil.getInstance().createObject(support,-1,bo);
                            for (int i = 0; i < consumeSize; i++) {
                                bo = queue.take();
                                JPAUtil.getInstance().createObject(support,-1,bo);

                            }
                            support.end();
                        } catch (Exception e) {
                            //logger.error(e,e);
                        	e.printStackTrace();
                            support.release();
                            support = JPASupportFactory.createSqliteJPASupport(getDataPath());
                        }
                        //    BObject bo = queue.take();

                    }
                }
            };
            new Thread(consumer).start();
        }
    }


}
