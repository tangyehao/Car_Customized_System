package cn.com.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class KeyCode {
    public static String getKeyCodeMsg(String msg){
        byte[] bytes = null;
        String md5Code = null;
        try {
            bytes = MessageDigest.getInstance("md5").digest(msg.getBytes());
            md5Code = new BigInteger(1,bytes).toString(16);
            for(int i = 0;i < 32 - md5Code.length();i++) {
                md5Code = "0" + md5Code;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return  md5Code;
    }
}
