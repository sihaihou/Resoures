package com.reyco.core.util;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Map;

import org.apache.commons.collections.map.LRUMap;

@SuppressWarnings("unchecked")
public class IPDataUtils {

	private static byte[] allData = null;
    private static int dataLength = -1;
    
    private static Map<String, String> cacheMap = null;

    static {
        InputStream in = IPDataUtils.class.getClassLoader().getResourceAsStream("ipdata/17monipdb.dat");
        DataInputStream inputStream = new DataInputStream(in);
        try {
            allData = readStream(inputStream);
            dataLength = (int) getbytesTolong(allData, 0, 4, ByteOrder.BIG_ENDIAN);
            cacheMap = new LRUMap(100000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] readStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = inStream.read(buffer)) != -1) {
            outSteam.write(buffer, 0, len);
        }
        outSteam.close();
        inStream.close();
        return outSteam.toByteArray();
    }

    private static long getbytesTolong(byte[] bytes, int offerSet, int size, ByteOrder byteOrder) {
        if ((offerSet + size) > bytes.length || size <= 0) {
            return -1;
        }
        byte[] b = new byte[size];
        for (int i = 0; i < b.length; i++) {
            b[i] = bytes[offerSet + i];
        }

        ByteBuffer byteBuffer = ByteBuffer.wrap(b);
        byteBuffer.order(byteOrder);

        long temp = -1;
        if (byteBuffer.hasRemaining()) {
            temp = byteBuffer.getInt();
        }
        return temp;
    }

    private static long ip2long(String ip) throws UnknownHostException {
        InetAddress address = InetAddress.getByName(ip);
        byte[] bytes = address.getAddress();
        long reslut = getbytesTolong(bytes, 0, 4, ByteOrder.BIG_ENDIAN);
        return reslut;
    }

    private static int getIntByBytes(byte[] b, int offSet) {
        if (b == null || (b.length < (offSet + 3))) {
            return -1;
        }
        byte[] bytes = Arrays.copyOfRange(allData, offSet, offSet + 3);
        byte[] bs = new byte[4];
        bs[3] = 0;
        for (int i = 0; i < 3; i++) {
            bs[i] = bytes[i];
        }
        return (int) getbytesTolong(bs, 0, 4, ByteOrder.LITTLE_ENDIAN);
    }

    private static String findGeography(String address) {
        if (address == null) {
            return "illegal address";
        }
        if (dataLength < 4 || allData == null) {
            return "illegal ip data";
        }

        String ip = "127.0.0.1";
        try {
            ip = Inet4Address.getByName(address).getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        String[] ipArray = ip.split("\\.");
        int ipHeadValue = Integer.parseInt(ipArray[0]);
        if (ipArray.length != 4 || ipHeadValue < 0 || ipHeadValue > 255) {
            return "illegal ip";
        }
        if (cacheMap.containsKey(ip)) {
            return cacheMap.get(ip);
        }

        long numIp = 1;
        try {
            numIp = ip2long(address);
        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        }

        int tempOffSet = ipHeadValue * 4 + 4;
        long start = getbytesTolong(allData, tempOffSet, 4, ByteOrder.LITTLE_ENDIAN);
        int max_len = dataLength - 1028;
        long resultOffSet = 0;
        int resultSize = 0;
        for (start = start * 8 + 1024; start < max_len; start += 8) {
            if (getbytesTolong(allData, (int) start + 4, 4, ByteOrder.BIG_ENDIAN) >= numIp) {
                resultOffSet = getIntByBytes(allData, (int) (start + 4 + 4));
                resultSize = (char) allData[(int) start + 7 + 4];
                break;
            }
        }

        if (resultOffSet <= 0) {
            return "resultOffSet too small";
        }

        byte[] add = Arrays.copyOfRange(allData, (int) (dataLength + resultOffSet - 1024), (int) (dataLength + resultOffSet - 1024 + resultSize));
        try {
            if (add == null) {
                cacheMap.put(ip, new String("no data found!!"));
            } else {
                cacheMap.put(ip, new String(add, "UTF-8"));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return cacheMap.get(ip);
    }

    public static String getCityName(String ip) {
        String address = findGeography(ip);
        String[] addr = address.split("\t");
        return addr[addr.length - 1]+"�?"; //TODO 其它类型
    }

    public static void main(String[] args) {
        System.out.println(getCityName("211.161.220.202"));
    }
}