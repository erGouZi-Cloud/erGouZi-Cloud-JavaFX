package client;

/**
 * @author uio
 * Date 2021/3/26 10:17
 * Description:
 */
public interface IData {

    /**
     * 文件路径
     */
    String favicon = "/static/favicon.png";  //Logo路径
    String fileImage = "/static/file.png"; //文件图标路径
    String folderImage = "/static/folder.png"; //文件夹图标路径
    String keyImage = "/static/key.png"; // 密钥图片
    String upFileImage = "/static/upFile.png"; //上传图片

    /**
     * 进度条颜色
     */
    String blue = "-fx-accent:rgb(56,132,255);";
    String red = "";

    /**
     * 触碰效果与恢复
     */
    String deepen = "-fx-background-color: rgb(229, 229, 229);";
    String shallow = "-fx-background-color: rgb(249, 249, 249);";

    /**
     * 页面尺寸
     */
    int mainWidth = 966;
    int mainHeight = 647;

    int keySettingWidth = mainWidth / 2;
    int keySettingHeight = mainHeight / 2;
}



