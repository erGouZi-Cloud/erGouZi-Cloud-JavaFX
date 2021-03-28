package client;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.*;
import server.Controller;

import java.io.File;
import java.io.IOException;


public class IndexController {

    private static IndexController indexController = new IndexController();

    public static Stage keyStage = null;

    /**
     * 在Main函数中会调用该函数
     */
    public IndexController() {
    }

    public IndexController getIndexController() {
        return indexController;
    }

    /**
     * 图片Logo
     */
    @FXML
    private ImageView favicon;

    @FXML
    private ImageView fileImage;

    @FXML
    private ImageView folderImage;

    @FXML
    private ImageView keyImage;

    @FXML
    private ImageView upFileImage;


    /**
     * 存储用量百分比条
     * <= 0.3 为绿色
     * <= 0.5 为蓝色
     * <= 0.7 为橙色
     * > 0.7 红色
     */
    @FXML
    private ProgressBar progressForData;

    /**
     * 存储用量数据显示
     */
    @FXML
    private Label dosageForData;

    /**
     * 选择文件夹Pane
     */
    @FXML
    private Pane folder;

    /**
     * 选择文件夹Pane
     */
    @FXML
    private Pane allFile;

    /**
     * 选择文件夹Pane
     */
    @FXML
    private Pane key;

    @FXML
    private Pane upFile;


    /**
     * 初始化方法
     */
    @FXML
    public void initialize() {
        favicon.setImage(new Image(getClass().getResource(IData.favicon).toExternalForm())); //设置Logo图片
        fileImage.setImage(new Image(getClass().getResource(IData.fileImage).toExternalForm())); //设置文件图片
        folderImage.setImage(new Image(getClass().getResource(IData.folderImage).toExternalForm())); //文件夹图片
        keyImage.setImage(new Image(getClass().getResource(IData.keyImage).toExternalForm())); //密钥图片
        upFileImage.setImage(new Image(getClass().getResource(IData.upFileImage).toExternalForm())); //上传队列图片

        progressForData.setProgress(0.5);
        progressForData.setStyle(IData.blue);
        dosageForData.setText("1000G" + " / " + "2T");
    }

    /**
     * Pane触碰和退出效果
     */
    @FXML
    public void folderBeTouched() {
        paneBeTouched(folder);
    }
    @FXML
    public void exitedFolder() {
        exitedPane(folder);
    }

    @FXML
    public void allFileBeTouched() {
        paneBeTouched(allFile);
    }
    @FXML
    public void exitedAllFile() {
        exitedPane(allFile);
    }

    @FXML
    public void keyBeTouched() {
        paneBeTouched(key);
    }

    @FXML
    public void exitedKey() {
        exitedPane(key);
    }

    @FXML
    public void upFileBeTouched() {
        paneBeTouched(upFile);
    }

    @FXML
    public void exitedUpFile() {
        exitedPane(upFile);
    }


    /**
     * 按下Pane 触发事件
     */
    @FXML
    public void pressAllFile() {

    }

    @FXML
    public void pressFolder() {
        DirectoryChooser chooser = new DirectoryChooser();

        chooser.setInitialDirectory(new File("/"));
        chooser.setTitle("选择文件夹");
        try {
            String path = chooser.showDialog(Main.getStage()).toString(); //选择的文件夹路径
            Controller.upFileController(path);
        } catch (NullPointerException e) {
            System.out.println("未选择文件夹");
        }
        // 123

    }

    @FXML
    public void pressKey() throws IOException {
        // todo IO异常处理

        /*
        页面资源载入
         */
        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/KeySetting.fxml"));
        parent.getStylesheets().setAll(getClass().getResource("/css/KeySetting.css").toExternalForm());

        keyStage = new Stage();
        keyStage.setX(Main.getStage().getX() + 200);
        keyStage.setY(Main.getStage().getY() + 100);
        keyStage.setResizable(false); // 固定窗口大小
        keyStage.setScene(new Scene(parent, IData.keySettingWidth, IData.keySettingHeight));
        keyStage.setTitle("密钥设置");
        keyStage.show();
    }

    @FXML
    public void pressUpFile() {

    }

    /**
     * 通用工具
     */

    public void paneBeTouched(Pane pane) {
        pane.setStyle(IData.deepen);
    }

    public void exitedPane(Pane pane) {
        pane.setStyle(IData.shallow);
    }

}
