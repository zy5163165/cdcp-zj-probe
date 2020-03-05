package com.alcatelsbell.cdcp.nodefx;


import java.io.*;
import java.util.Date;

/**
 * Created by Administrator on 2016/7/14.
 */
public class EmsStateManager {
    private static EmsStateManager ourInstance = new EmsStateManager();

    public static EmsStateManager getInstance() {
        return ourInstance;
    }


    private File root = new File("../state");
    private EmsStateManager() {
        if (!root.exists())
            root.mkdirs();
    }


    private String getFileName(String emsname) {
        return emsname.replaceAll("/",":")+".state";
    }
    public void emsOk(String emsname,String info) {
        synchronized (this) {
            try {
                File okFile = new File(root, "ok." + getFileName(emsname));
                writeToFile(new Date().toString().getBytes(), okFile);
                if (info != null)
                     writeToFile(info.getBytes(), okFile);

                File errorFile = new File(root, "error." + getFileName(emsname));
                if (errorFile.exists())
                    errorFile.delete();
            } catch (Throwable e) {
                e.printStackTrace();
            }

        }
    }

    public void emsError(String emsname,Throwable exp,String info) {
        synchronized (this) {
            try {
                File okFile = new File(root, "ok." + getFileName(emsname));
                if (okFile.exists())
                    okFile.delete();

                File errorFile = new File(root, "error." + getFileName(emsname));
                writeToFile(new Date().toString().getBytes(), errorFile);
                if (info != null)
                    writeToFile(info.getBytes(), errorFile);

                if (exp != null) {
                    try {
                        PrintWriter s = new PrintWriter(new FileOutputStream(errorFile, true));
                        exp.printStackTrace(s);
                        s.flush();
                        s.close();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }

        }
    }

    public static void writeToFile(byte[] bytes, File file) {
        if(bytes != null) {
            FileOutputStream outStream = null;

            try {
                outStream = new FileOutputStream(file,true);
                outStream.write(bytes, 0, bytes.length);
                outStream.write("\r\n".getBytes());
                outStream.flush();
                outStream.close();
            } catch (FileNotFoundException var4) {
                var4.printStackTrace();
            } catch (IOException var5) {
                var5.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        Exception abc = new Exception("abc");
        EmsStateManager.getInstance().emsError("myems",abc,"afff");
    }
}
