package com.alcatelsbell.cdcp.nodefx;

import com.alcatelsbell.nms.common.JMSSupport;
import com.alcatelsbell.nms.util.DailyFileWriter;
import com.alcatelsbell.nms.util.SysProperty;
import com.alcatelsbell.nms.util.jms.BufferedJMSSupport;
import com.alcatelsbell.nms.util.jms.JMSSupportSpringImpl;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.asb.mule.probe.framework.util.FileLogger;
import org.omg.CosNotification.Property;
import org.omg.CosNotification.StructuredEvent;
import org.springframework.jms.connection.CachingConnectionFactory;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: Ronnie.Chen
 * Date: 13-10-31
 * Time: 上午9:56
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class EventUtil {
    private static EventUtil inst = new EventUtil();
    JMSSupport jmsSupport = null;
    String topic = null;
    private EventUtil() {
        String url = SysProperty.getString("activeMQUrl.AlarmEvent");
          topic = SysProperty.getString("jmsTopic.AlarmEvent","cdcp.pushevent");
        if (url == null)
            url = SysProperty.getString("activeMQUrl");
        if (url == null) {
            logger.error("Failed to find system property : activeMQUrl.AlarmEvent or activeMQUrl ");
            return ;
        }
        jmsSupport = new BufferedJMSSupport(new JMSSupportSpringImpl
                (new CachingConnectionFactory(new ActiveMQConnectionFactory(url))));
        logger.info("Init with ActiveMQ url = "+url+"; topic = "+topic);
    }
    public static EventUtil getUtil() {
        return inst;
    }
    private   Log logger = LogFactory.getLog(getClass());
    private ConcurrentHashMap<String,DailyFileWriter> writerMap = new ConcurrentHashMap();

    public void sendEvent(String source,Serializable eventObject) {

        DailyFileWriter dailyFileWriter = writerMap.get(source);
        if (dailyFileWriter == null) {
            synchronized (writerMap) {
                dailyFileWriter = writerMap.get(source);
                if (dailyFileWriter == null) {
                    dailyFileWriter = new DailyFileWriter(source);
                    writerMap.put(source, dailyFileWriter);
                }

            }
        }


        HashMap properties = new HashMap();
        if (eventObject instanceof StructuredEvent) {
            StructuredEvent notification = (StructuredEvent) eventObject;
            String eventType = notification.header.fixed_header.event_type.type_name;
            if (eventType == null || !eventType.equals("NT_ALARM")) {
                try {
                    dailyFileWriter.write("eventType="+eventType+",ignore!");
                } catch (IOException e) {
                    logger.error(e, e);
                }
                return;
            }

            for (int i = 0; i < notification.filterable_data.length; i++) {
                Property property = notification.filterable_data[i];
                properties.put(property.name, property.value);

            }

            try {
                dailyFileWriter.write("Receive StructuredEvent : "+properties);
            } catch (IOException e) {
                logger.error(e, e);
            }
        }


        HashMap map = new HashMap();
        map.put("CDCP_SOURCE_EVENT",eventObject);
        map.put("CDCP_SOURCE_NAME",source);
        map.putAll(properties);
        try {
            jmsSupport.sendTopicMessage(topic,map);
            dailyFileWriter.write("Send out success");
        } catch (Exception e) {
            logger.error(e, e);
        }
    }


    public static void main(String[] args) throws Exception {
        JMSSupport support = new JMSSupportSpringImpl(new CachingConnectionFactory( new ActiveMQConnectionFactory("tcp://135.251.223.204:61616")));
        //  support = new BufferedJMSSupport(support);

        long t1  = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            support.sendTopicMessage("Suggest_Topic","dfff");
        }
        long t2  = System.currentTimeMillis() -  t1;
        System.out.println("t2 = " + t2);

    }
}
