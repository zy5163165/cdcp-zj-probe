package com.alcatelsbell.cdcp.nodefx;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Properties;

/**
 * Author: Ronnie.Chen
 * Date: 14-5-8
 * Time: 下午3:42
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class PropertiesUtil {
     public static Properties parseString(String additionalinfo) {
        Properties map = new Properties();
        String[] split = additionalinfo.split(";");
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            String regex = "\\|";
            String[] split1 = s.split(regex);
            if (split1.length == 2) {
                String key = split1[0];
                String value = split1[1];
                map.put(key,value);
            }
        }

        return map;
    }
}
