package server.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author uio
 * Date 2021/3/27 20:54
 * Description: 加密服务
 */
public class EncryptService {

    // todo 寻求更好的存储和get，set
    private static String key;

    public static void setKey(String unsafeKey) {
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
        key = buf.toString();
    }

    public EncryptService() {
        if(key == null) {
            // todo 密钥为空，进行错误处理
        }

    }


}
