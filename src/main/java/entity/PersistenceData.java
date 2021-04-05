package entity;

import java.io.Serializable;

/**
 * @author uio
 * Date 2021/3/28 21:44
 * Description: 需要持久化数据
 */
public class PersistenceData implements Serializable {

    // todo 寻求更好的存储和get，set
    // 保证可见性，防止在上传过程中修改了密钥导致的一系列问题
    private static volatile String key = null;

    public static String getKey() {
        return key;
    }

    public static void setKey(String key) {
        PersistenceData.key = key;
    }
}
