package com.alcatelsbell.cdcp.nodefx;

import com.alcatelsbell.nms.db.components.client.JpaClient;
import com.alcatelsbell.nms.modules.task.model.Schedule;
import com.alcatelsbell.nms.valueobject.sys.Ems;
import com.alcatelsbell.nms.valueobject.sys.SysNode;
import org.apache.commons.httpclient.util.DateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: Ronnie.Chen
 * Date: 2015/4/14
 * Time: 9:28
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class LocalEmsJob  implements Job {
    public static final String ATTRIBUTE_SCHEDULE = "schedule";
    private Log logger = LogFactory.getLog(getClass());
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        synchronized (LocalEmsJob.class) {
            doExecute(jobExecutionContext);
        }


    }

    private void doExecute(JobExecutionContext jobExecutionContext) {

        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        Ems ems = (Ems) jobDataMap.get("EMS");
        String loader = (String)jobDataMap.get("loader");
        logger.info("LocalEmsJob : "+ems.getDn());
        String serial = ems.getDn()+"@Local@"+ new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date())+"#"+loader;


        try {

            NodeAdmin nodeAdmin = (NodeAdmin) jobDataMap.get("NodeAdmin");


            EmsJob job = new EmsJob();
            job.setSerial(serial);
            job.setEms(ems);
            job.setJobType(EmsJob.JOB_TYPE_SYNC_EMS);
            nodeAdmin.executeJob(job);
        }  catch (Exception e) {
            logger.error(e, e);

        }  finally {

        }
    }



    public static void main(String[] args) {
        System.out.println(DateUtil.formatDate(new Date(), "yyyyMMdd-HHmmss"));
    }
}

