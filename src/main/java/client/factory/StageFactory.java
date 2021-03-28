package client.factory;

import javafx.stage.Stage;

/**
 * @author uio
 * Date 2021/3/28 12:50
 * Description: Stage工厂
 */
public interface StageFactory {

    /**
     * 主页Stage工厂
     */
    void indexStageFactory(Stage stage);

    /**
     * 密钥设置Stage工厂
     * @return stage
     */
    Stage keySettingStageFactory();




}
