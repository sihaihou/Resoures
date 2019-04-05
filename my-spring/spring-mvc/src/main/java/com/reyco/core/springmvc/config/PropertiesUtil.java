package com.reyco.core.springmvc.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesUtil {
    private static final Map<String, String> env = new HashMap<String, String>();
    static {
        Properties properties = new Properties();
        try {
            InputStream input = PropertiesUtil.class.getResourceAsStream("/application.properties");
            properties.load(input);
            Set<Map.Entry<Object, Object>> entrySet = properties.entrySet();
            for (Map.Entry<Object, Object> entry : entrySet) {
                String key = (String) entry.getKey();
                String value = (String) entry.getValue();
                if (null != value && "".equals(value)) {
                    value = new String(value.getBytes("ISO-8859-1"), "GBK");
                }
                env.put(key, value);
            }
        } catch (IOException e) {
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
