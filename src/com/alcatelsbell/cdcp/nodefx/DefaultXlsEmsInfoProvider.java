package com.alcatelsbell.cdcp.nodefx;

import com.alcatelsbell.cdcp.nodefx.ffp.FormattedFileParser;
import com.alcatelsbell.cdcp.nodefx.ffp.XlsFileParser;
import com.alcatelsbell.nms.util.SysProperty;
import org.asb.mule.probe.framework.entity.EmsInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Ronnie.Chen
 * Date: 2016/7/14
 * Time: 10:16
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class DefaultXlsEmsInfoProvider implements EmsInfoProvider {
    private Logger logger = LoggerFactory.getLogger(DefaultXlsEmsInfoProvider.class);

    @Override
    public List<EmsInfo> provide() {
        String csvFileName = SysProperty.getString("emsProvider.xlsFileName","ems.xls");
        final List<EmsInfo> list = new ArrayList<EmsInfo>();
        FormattedFileParser parser = new XlsFileParser();
        try {
            parser.parseFile(new File(csvFileName), new FormattedFileParser.RowHandler() {
                @Override
                public String handleRow(FormattedFileParser.DataRow row) throws Exception {
                    if (row.getValue("#ems_name") == null) return null;
                    EmsInfo emsInfo = new EmsInfo();
                    emsInfo.setName(row.getValue("Agent"));
                //    emsInfo.setType(row.getValue("#ems_name"));
                 //   emsInfo.setAdditionalInfo(row.getValue("#ems_name"));
                    emsInfo.setDesc(row.getValue("ems_desc"));
                    emsInfo.setEmsVersion(row.getValue("version"));
                    emsInfo.setHost(row.getValue("naming_service_host"));
                    emsInfo.setLoader(row.getValue("loader"));
                    String up = row.getValue("username/password");
                    if (up != null && up.contains("/")) {
                        emsInfo.setUsername(up.split("/")[0]);
                        emsInfo.setPassword(up.split("/")[1]);
                    }

                    String path = row.getValue("#ems_name");
                    if (emsInfo.getEmsVersion() != null &&
                            (
                                    emsInfo.getEmsVersion().toLowerCase().startsWith("u2000")
                                    ||
                                            emsInfo.getEmsVersion().toLowerCase().startsWith("t2000")
                            ))  {
                        if (path.contains("/")) {
                            path = path.replaceAll("/","\\\\/");
                        }
                        path = "TMF_MTNM.Class/HUAWEI.Vendor/"+path+".EmsInstance/2\\.0.Version/"+path+".EmsSessionFactory_I";
                    }
                    emsInfo.setPath(path);
                    emsInfo.setType(row.getValue("type"));
                    emsInfo.setDomain(row.getValue("domain"));


                    emsInfo.setPort(row.getValue("naming_service_port"));
                    if (emsInfo.getPort().contains("."))
                        emsInfo.setPort(emsInfo.getPort().substring(0,emsInfo.getPort().indexOf(".")));

                    if (row.getValue("on/off") != null)
                        emsInfo.setPower(row.getValue("on/off"));

                    if (row.getValue("logical") != null) {
                        emsInfo.getProperties().put("logical",row.getValue("logical"));
                        logger.info("logical = " + row.getValue("logical"));
                        System.out.println("logical = " + row.getValue("logical"));
                    }

                    String schedule_type = row.getValue("schedule_type");
                    if (schedule_type == null) schedule_type = "hourly";

                    String schedule_exp = row.getValue("schedule_exp");
                    if (schedule_exp == null) schedule_exp = "168";

                    emsInfo.setScheduleType(schedule_type);
                    emsInfo.setScheduleExpression(schedule_exp);
                 //   emsInfo.setProtocol(row.getValue("#ems_name"));

                    list.add(emsInfo);
                    return null;
                }
            });
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return list;
    }

    public static void main(String[] args) {
 String path = "Huawei/HuHeHaoTe";
        if (path.contains("/")) {
            path = path.replaceAll("/","\\\\/");
        }

        System.out.println("path = " + path);
    }
}
