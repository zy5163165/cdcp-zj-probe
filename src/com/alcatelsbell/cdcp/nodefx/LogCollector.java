package com.alcatelsbell.cdcp.nodefx;

import com.alcatelsbell.nms.util.FileUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;

/**
 * Author: Ronnie.Chen
 * Date: 14-10-13
 * Time: 上午10:02
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class LogCollector {
    private Log logger = LogFactory.getLog(getClass());

    public static void collectNode(File dir,File destLogs) {
        if (!destLogs.exists()) destLogs.mkdirs();
        File logs = new File(dir,"logs");
        if (logs.exists()) {
            File[] files = logs.listFiles();
            for (File ems : files) {
                if (ems.isDirectory()) {
                    File destEms  = new File(destLogs,ems.getName());
                    destEms.mkdirs();

                    File[] emsLogs = ems.listFiles();
                    for (File emsLog : emsLogs) {
                     //   if (emsLog.lastModified() > System.currentTimeMillis() - (3600l * 24l * 5)) {
                            if (emsLog.length() < 10000000l) {
                                copyFile(emsLog, new File(destEms, emsLog.getName()));
                            }
                     //   }
                    }

                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        File file = new File("logs");
        if (file.exists())
            file.renameTo(new File("logs."+System.currentTimeMillis()));
        File newLogs = new File("logs");
        newLogs.mkdirs();



        collectNode(new File( "HW"),new File(newLogs,"HW") );
        collectNode(new File( "HW2"),new File(newLogs,"HW2")  );
        collectNode(new File( "FH"),new File(newLogs,"FH")  );
        collectNode(new File( "ZTE"),new File(newLogs,"ZTE")  );
        collectNode(new File( "ALU"),new File(newLogs,"ALU")  );
        Runtime.getRuntime().exec("rm -f logs.tar.gz");
        Runtime.getRuntime().exec("tar zcvf logs.tar.gz logs");


    }

    public static boolean copyFile(File source, File dest) {
        try {
            if (!dest.exists()) {
                dest.createNewFile();
            }
            InputStream in = new FileInputStream(source);
            FileOutputStream out = new FileOutputStream(dest);
            byte[] by = new byte[1024 * 10];
            int c;
            while ((c = in.read(by)) != -1) {
                out.write(by, 0, c);
            }
            out.close();
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
