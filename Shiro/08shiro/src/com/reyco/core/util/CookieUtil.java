package com.reyco.core.util;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.CollectionUtils;

public class CookieUtil {

    public static Map<String, String> getCookies(HttpURLConnection conn) {
        Map<String, String> cookies = new HashMap<>();
        Map<String, List<String>> resHeaders = conn.getHeaderFields();
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, List<String>> entry : resHeaders.entrySet()) {
            String name = entry.getKey();
            if (name == null)
                continue; // http/1.1 line
            List<String> values = entry.getValue();
            if (name.equalsIgnoreCase("Set-Cookie")) {
                for (String value : values) {
                    if (value == null) {
                        continue;
                    }

                    String cookie = value.substring(0, value.indexOf(";"));
                    String[] cookieArry = cookie.split("=");
                    cookies.put(cookieArry[0], cookieArry[1]);
                    sb.append(cookie);
                }
            }
        }

        return cookies;
    }

    public static String getCookie(Map<String, String> cookieMap) {
        if (CollectionUtils.isEmpty(cookieMap)) {
            return "";
        }
        String cookie = "";
        for (String s : cookieMap.keySet()) {
            cookie += s + "=" + cookieMap.get(s) + "; ";

        }
        return cookie;
    }

}
