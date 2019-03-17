package com.reyco.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PropertiesUtil {

    private static final Log  log = LogFactory.getLog(PropertiesUtil.class.getName());

    private static final Map<String, String> env = new HashMap<String, String>();

    
    static {
        Properties properties = new Properties();
        try {
            InputStream input = PropertiesUtil.class.getResourceAsStream("/jdbc.properties");
            properties.load(input);
            Set<Map.Entry<Object, Object>> entrySet = properties.entrySet();
            for (Map.Entry<Object, Object> entry : entrySet) {
                String key = (String) entry.getKey();
                String value = (String) entry.getValue();
                if (!StringUtils.isBlank(value)) {
                    value = new String(value.getBytes("ISO-8859-1"), "GBK");
                }
                env.put(key, value);
            }
            
            log.info("配置项加载成功！");
        } catch (IOException e) {
            if(log.isErrorEnabled()){
                log.error("[EnvUtil]",e);
            }
            //throw new RuntimeException("load env.properties file failure.", e);
        }
    }

    public static String getValue(String key) {
        if (env != null) {
            return env.get(key);
        }
        return "";
    }
}
