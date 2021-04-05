package server.service;

import entity.PersistenceData;
import server.help.Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author uio
 * Date 2021/3/28 21:51
 * Description:
 */
public class SettingKeyService {
    /**
     * 设置密钥
     * @param unsafeKey
     */
    public static void setKey(String unsafeKey) {
        PersistenceData.setKey(keyToSHA1(unsafeKey));
    }

    /**
     * 是否存在密钥
     * @return 存在返回true，不存在返回false
     */
    public static boolean isKeyExist() {
        return PersistenceData.getKey() != null;
    }

    /**
     * 将字符串进行Hash
     * @param unsafeKey 原字符串
     * @return Hash后的字符串
     */
    private static String keyToSHA1(String unsafeKey) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(unsafeKey.getBytes());
        StringBuilder buf = new StringBuilder();
        byte[] bits = md.digest();
        for (int i = 0; i < bits.length; i++) {
            int a = bits[i];
            if(a < 0) {
                a += 256;
            }
            if(a < 16) {
                buf.append("0");
            }
            buf.append(Integer.toHexString(a));
        }
        return buf.toString();
    }
}
