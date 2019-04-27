package com.sxt.des.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

/**
 * 加密解密工具类
 */
public class DesCrypt {
	// 默认的KEY。此密匙应该根据用户推算或记录在物理存储中。
    private static final String KEY = "com.sxt.des";
    // 字符编码。
    private static final String CODE_TYPE = "UTF-8";

    /**
     * DES加密
     * @param datasource 要加密的源数据。
     * @return 加密后的数据。
     */
    public static String encode(String key, String datasource) throws Exception{
    	if(null == key){
    		key = KEY;
    	}
    	// 随机生成器。如果种子一样，则生成的随机信息可推测。
        SecureRandom random = new SecureRandom();
        // 创建DES密匙。依据提供的密匙字符串创建密匙。 密钥源信息。 需要通过密钥工厂再次推算的，才能得到最终的密钥数据。
        DESKeySpec desKey = new DESKeySpec(key.getBytes(CODE_TYPE));
        // 创建一个密匙工厂，然后用它把DESKeySpec转换成SecretKey
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(desKey);
        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance("DES");
        // 用密匙初始化Cipher对象。 Cipher.ENCRYPT_MODE - 加密模式
        cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
        // 现在，获取数据并加密。
        // 加密后的数据不要new String。 java中的字符串对象都是有字符集信息的。
        // java中的UTF8字符集又是长度变化的。一个字符串长度为2~3
        byte[] temp = Base64.encodeBase64(cipher.doFinal(datasource.getBytes()));
        return IOUtils.toString(temp,"UTF-8");
    }

    /**
     * DES解密 
     * @param src 要解密的密文数据
     * @return
     */
    public static String decode(String key, String src) throws Exception {
    	if(null == key){
    		key = KEY;
    	}
        // DES算法要求有一个可信任的随机数源
        SecureRandom random = new SecureRandom();
        // 创建一个DESKeySpec对象
        DESKeySpec desKey = new DESKeySpec(key.getBytes(CODE_TYPE));
        // 创建一个密匙工厂
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        // 将DESKeySpec对象转换成SecretKey对象
        SecretKey securekey = keyFactory.generateSecret(desKey);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance("DES");
        // 用密匙初始化Cipher对象。 Cipher.DECRYPT_MODE - 解密模式
        cipher.init(Cipher.DECRYPT_MODE, securekey, random);
        // 真正开始解密操作
        return IOUtils.toString(cipher.doFinal(Base64.decodeBase64(src)),"UTF-8");
    }
    
    public static String getKEY(){
    	return KEY;
    }

}
