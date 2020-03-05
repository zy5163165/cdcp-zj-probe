package com.alcatelsbell.cdcp.nodefx;

import com.alcatelsbell.nms.valueobject.sys.Ems;

import java.util.HashMap;

/**
 * Author: Ronnie.Chen
 * Date: 13-9-11
 * Time: 上午10:09
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class CorbaEms {

    private Ems ems;
    private String emsName;
    private String namingServiceHost;
    private String corbaUrl;
    private String corbaTree;
    private String corbaUserName;
    private String corbaPassword;
    public CorbaEms(Ems ems) {
        this.ems = ems;
        parse();
    }

    private void parse() {
        String additionalinfo = ems.getAdditionalinfo();
        HashMap<String,String> map = new HashMap();
        String[] split = additionalinfo.split(";");
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            String regex = "\\|";
            String[] split1 = s.split(regex);
            if (split1.length == 2) {
                String key = split1[0];
                String value = split1[1];
                map.put(key.trim(),value.trim());
            }
        }
        emsName = map.get("config_emsname");
        namingServiceHost = map.get("config_namingServiceHost");
        corbaUrl = map.get("config_corbaUrl");
        corbaTree = map.get("config_corbaTree");
        corbaUserName = map.get("config_corbaUserName");
        corbaPassword = map.get("config_corbaPassword");
    }


    public Ems getEms() {
        return ems;
    }

    public void setEms(Ems ems) {
        this.ems = ems;
    }

    public String getEmsName() {
        return emsName;
    }

    public void setEmsName(String emsName) {
        this.emsName = emsName;
    }

    public String getNamingServiceHost() {
        return namingServiceHost;
    }

    public void setNamingServiceHost(String namingServiceHost) {
        this.namingServiceHost = namingServiceHost;
    }

    public String getCorbaUrl() {
        return corbaUrl;
    }

    public void setCorbaUrl(String corbaUrl) {
        this.corbaUrl = corbaUrl;
    }

    public String getCorbaTree() {
        return corbaTree;
    }

    public void setCorbaTree(String corbaTree) {
        this.corbaTree = corbaTree;
    }

    public String getCorbaUserName() {
        return corbaUserName;
    }

    public void setCorbaUserName(String corbaUserName) {
        this.corbaUserName = corbaUserName;
    }

    public String getCorbaPassword() {
        return corbaPassword;
    }

    public void setCorbaPassword(String corbaPassword) {
        this.corbaPassword = corbaPassword;
    }

    @Override
    public String toString() {
        return "CorbaEms{" +
                "ems=" + ems +
                ", emsName='" + emsName + '\'' +
                ", namingServiceHost='" + namingServiceHost + '\'' +
                ", corbaUrl='" + corbaUrl + '\'' +
                ", corbaTree='" + corbaTree + '\'' +
                ", corbaUserName='" + corbaUserName + '\'' +
                ", corbaPassword='" + corbaPassword + '\'' +
                '}';
    }

    public static void main(String[] args) {
       Ems ems = new Ems();
       ems.setAdditionalinfo(
               "config_emsname|WZH-T2000-8-P;config_namingServiceHost|10.212.46.89; config_corbaUrl|corbaloc:iiop:10.77.83.163:12001/NameService;config_corbaTree|TMF_MTNM.Class/HUAWEI.Vendor/WZH-T2000-8-P.EmsInstance/2\\.0.Version/WZH-T2000-8-P.EmsSessionFactory_I;config_corbaUserName|corba3;config_corbaPassword|Corba3$zj123");
        System.out.println(new CorbaEms(ems));

    }
}
