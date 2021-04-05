package common;

import client.factory.StageFactory;
import client.factory.impl.StageFactoryImpl;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * @author uio
 * Date 2021/3/28 15:35
 * Description:
 */
public class StageManage {

    /**
     * 密钥设置Stage
     */
    private static Stage keyStage = null;

    private static StageFactory stageFactory = new StageFactoryImpl();

    /**
     * 因为界面是单线程的，所以无需使用单例
     * @return keyStage
     */
    public static Stage getKeyStage() {
        if(keyStage == null) {
            keyStage = stageFactory.keySettingStageFactory();

            /*
             * 设置监听器，监测到窗口关闭（被用户X掉，则触发事件）
             */
            keyStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    keyStage = null;
                }
            });
        }
        return keyStage;
    }

    /**
     * 关闭Stage
     * 并置空对象
     */
    public static void closeKeyStage() {
        keyStage.close();
        keyStage = null;
    }


}
