package com.alcatelsbell.cdcp.domain;

import com.alcatelsbell.nms.db.components.service.JPASupport;
import com.alcatelsbell.nms.db.components.service.JPAUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.asb.mule.probe.framework.entity.EDS_PTN;
import org.asb.mule.probe.framework.service.SqliteConn;

import java.util.Date;
import java.util.List;

/**
 * Author: Ronnie.Chen
 * Date: 14-9-22
 * Time: 下午3:21
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class SummaryUtil {
    private static Log logger = LogFactory.getLog(SummaryUtil.class);

    public static EDS_PTN geyEDS(String serial,SqliteConn sqliteConn,String emsdn,String fileName) {
        EDS_PTN eds = new EDS_PTN();
        try {
            JPASupport jpaSupport = sqliteConn.getJpaSupport();
            jpaSupport.begin();
            String[] sqls = { "SELECT count(ne.dn)     FROM  ManagedElement ne ",
                    "SELECT count(slot.dn)       FROM  EquipmentHolder slot",
                    "SELECT count(subslot.dn)    FROM  EquipmentHolder subslot WHERE subslot.holderType='sub_slot' ",
                    "SELECT count(card.dn)       FROM  Equipment card ",
                    "SELECT count(ptp.dn)        FROM  PTP ptp WHERE dn like '%PTP%' ",
                    "SELECT count(ftp.dn)        FROM  PTP ftp WHERE dn like '%FTP%' ",
                    "SELECT count(section.dn)    FROM  Section section",
                    "SELECT count(tunnel.dn)     FROM  SubnetworkConnection tunnel where tunnel.rate='1001' ",
                    "SELECT count(pw.dn)         FROM  SubnetworkConnection pw   where pw.rate='1002' ",
                    "SELECT count(fdfr.dn)       FROM  FlowDomainFragment fdfr ",
                    "SELECT count(route.dn)      FROM  R_TrafficTrunk_CC_Section route where route.type='CC' ",
                    "SELECT count(pg.dn)         FROM  TrailNtwProtection pg ",
                    "SELECT count(snc.dn)         FROM  SubnetworkConnection snc",
                    "SELECT count(cc.dn)         FROM  CrossConnect cc ",
                    "SELECT count(c.dn)         FROM  CTP c ",
                    "SELECT count(rtc.dn)         FROM  R_TrafficTrunk_CC_Section rtc "

            };
            StringBuilder sb = new StringBuilder();
            int[] count = new int[sqls.length];
            for (int i = 0; i < sqls.length; i++) {
                List list = JPAUtil.getInstance().queryQL(jpaSupport, sqls[i]);
                sb.append(list.get(0)).append("	");

                count[i] = ((Long) list.get(0)).intValue();
            }
             jpaSupport.end();
   //         jpaSupport.release();

            eds.setDn(fileName);
            eds.setCollectTime(new Date());
            eds.setCreateDate(new Date());
            eds.setTaskSerial(serial);
            eds.setEmsname(emsdn);
            eds.setNeCount(count[0]);
            eds.setSlotCount(count[1]);
            eds.setSubSlotCount(count[2]);
            eds.setEquipmentCount(count[3]);
            eds.setPtpCount(count[4]);
            eds.setFtpCount(count[5]);
            eds.setSectionCount(count[6]);
            eds.setTunnelCount(count[7]);
            eds.setPwCount(count[8]);
            eds.setPwe3Count(count[9]);
            eds.setRouteCount(count[10]);
            eds.setTunnelPG(count[11]);

            eds.setSncCount(count[12]);
            eds.setCcCount(count[13]);
            eds.setCtpCount(count[14]);
            eds.setRouteCount(count[15]);


        } catch (Exception e) {
            logger.error(e,e);
         }
        return eds;
    }

}
