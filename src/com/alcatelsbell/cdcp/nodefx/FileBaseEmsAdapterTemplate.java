package com.alcatelsbell.cdcp.nodefx;

import com.alcatelsbell.nms.valueobject.sys.Ems;
import org.asb.mule.probe.framework.entity.DeviceInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Author: Ronnie.Chen
 * Date: 2016/12/27
 * Time: 10:20
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class FileBaseEmsAdapterTemplate implements EmsAdapterWithURISupport {
    private Logger logger = LoggerFactory.getLogger(FileBaseEmsAdapterTemplate.class);

    private File bakDir = new File("../file_bak");
    private File cpDir = new File("../file_proc");
    public FileBaseEmsAdapterTemplate() {
        if (!bakDir.exists()) bakDir.mkdirs();
        if (!cpDir.exists()) cpDir.mkdirs();
    }

    @Override
    public Serializable obtain(Ems ems, URI uri) throws Exception {
        return null;
    }

    @Override
    public Serializable obtain(Ems ems, String uri) throws Exception {
        return null;
    }

    @Override
    public void newEms(Ems ems) throws NodeException {

    }

    @Override
    public List<DeviceInfo> listDevices(Ems ems) throws NodeException {
        return null;
    }

    @Override
    public void removeEms(Ems ems) throws NodeException {

    }

    @Override
    public void updateEms(Ems ems) throws NodeException {

    }

    @Override
    public boolean testEms(Ems ems) throws NodeException {
        return false;
    }

    @Override
    public LifecycleState getState(Ems ems) throws NodeException {
        return null;
    }

    @Override
    public void executeJob(EmsJob emsJob) throws NodeException {
        syncEMS(emsJob.getEms(), emsJob.getSerial());
    }

    private void syncEMS(Ems ems, String serial) {
        String path = ems.getControlName();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String folder = sdf.format(new Date());
        File bak = new File(bakDir,folder);
        if (!bak.exists()) bak.mkdirs();

        try {
            File dir = new File(path);
            if (!dir.exists()) throw new RuntimeException("Directory not existed ! : "+path);
            File[] files = dir.listFiles();
            for (File file : files) {
                File cp = new File(cpDir, file.getName());
                FileUtil.copyFile(file, cp);
                FileUtil.moveFile(file,new File(bak,file.getName()));
                try {
                    fileReady(cp, serial);
                } catch (Exception e) {
                    logger.error(e.getMessage(),e);
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            try {
                MessageUtil.sendSBIFailedMessage("文件扫描失败:"+e.getMessage(),serial);
            } catch (Exception e1) {
                logger.error(e1.getMessage(), e1);
            }
        }

    }

    protected void fileReady(File file,String serial) throws Exception {
        MessageUtil.sendSBIFinishMessage(file,serial,null);
    }

    @Override
    public String getType() {
        return "localfile";
    }
}
