package server.service;

import entity.PersistenceData;
import server.help.Utils;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


/**
 * @author uio
 * Date 2021/3/27 20:54
 * Description: 加密服务
 */
public class EncryptService {

    /**
     * 对文件进行AES加密
     * @param sourceFile 源文件
     * @param encryptFile 加密后文件
     * @param sKey 密钥
     */
    public static File encryptFile(File sourceFile, File encryptFile, String sKey) {

        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(sourceFile);

            outputStream = new FileOutputStream(encryptFile);
            Cipher cipher = initAESCipher(sKey, Cipher.ENCRYPT_MODE);
            // 以加密流写入文件
            CipherInputStream cipherInputStream = new CipherInputStream(
                    inputStream, cipher);
            byte[] cache = new byte[1024];
            int nRead = 0;
            while ((nRead = cipherInputStream.read(cache)) != -1) {
                outputStream.write(cache, 0, nRead);
                outputStream.flush();
            }
            cipherInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(); // To change body of catch statement use File |
            // Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace(); // To change body of catch statement use File |
            // Settings | File Templates.
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace(); // To change body of catch statement use
                // File | Settings | File Templates.
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace(); // To change body of catch statement use
                // File | Settings | File Templates.
            }
        }
        return encryptFile;
    }

    /**
     * 初始化 AES Cipher
     *
     * @param sKey
     * @param cipherMode
     * @return
     */
    public static Cipher initAESCipher(String sKey, int cipherMode) {
        // 创建Key gen
        KeyGenerator keyGenerator = null;
        Cipher cipher = null;
        try {
            keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128, new SecureRandom(sKey.getBytes()));
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] codeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(codeFormat, "AES");
            cipher = Cipher.getInstance("AES");
            // 初始化
            cipher.init(cipherMode, key);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace(); // To change body of catch statement use File |
            // Settings | File Templates.
        } catch (NoSuchPaddingException e) {
            e.printStackTrace(); // To change body of catch statement use File |
            // Settings | File Templates.
        } catch (InvalidKeyException e) {
            e.printStackTrace(); // To change body of catch statement use File |
            // Settings | File Templates.
        }
        return cipher;
    }


}
