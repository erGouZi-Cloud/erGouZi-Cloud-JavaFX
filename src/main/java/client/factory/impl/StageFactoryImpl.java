package client.factory.impl;

import client.IData;
import client.factory.StageFactory;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author uio
 * Date 2021/3/28 12:55
 * Description:
 */
public class StageFactoryImpl implements StageFactory {


    @Override
    public void indexStageFactory(Stage stage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/Index.fxml"));
            root.getStylesheets().setAll(getClass().getResource("/css/Index.css").toExternalForm());
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
         * 获得屏幕的尺寸
         */
        Rectangle2D screenRectangle = Screen.getPrimary().getBounds();
        double width = screenRectangle.getWidth();
        double height = screenRectangle.getHeight();

        /*
         * 设置舞台初始位置
         */
        stage.setX((width - IData.mainWidth) / 2);
        stage.setY((height - IData.mainHeight) / 2);

        stage.setTitle("Moon Cloud");
        stage.setScene(new Scene(root, IData.mainWidth, IData.mainHeight));
    }

    @Override
    public Stage keySettingStageFactory() {
        return null;
    }
}
