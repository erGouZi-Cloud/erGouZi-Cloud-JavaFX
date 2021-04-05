package client;

import common.StageManage;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import server.service.EncryptService;
import server.service.SettingKeyService;


/**
 * @author uio
 * Date 2021/3/27 18:56
 * Description:
 */
public class KeyController {

    @FXML
    private PasswordField inputKey;
    @FXML
    private PasswordField confirmKey;
    @FXML
    private Label errorAlert;
    @FXML
    private Pane keySetPane;
    @FXML
    private Pane confirmChangeKeyPane;

    @FXML
    public void SettingByClick() {

    }


    @FXML
    public void resetKey() {
        confirmChangeKeyPane.setVisible(false);
        keySetPane.setVisible(true);
    }

    @FXML
    public void denySetKey() {
        StageManage.closeKeyStage();
    }

    /**
     * 按下确认修改密钥按键
     */
    @FXML
    public void setKey() {
        if(!isDiffKey()) {
            SettingKeyService.setKey(confirmKey.getText());
            StageManage.closeKeyStage(); //调用Stage管理者，进行关闭页面
        }
    }

    @FXML
    public void initialize() {
        if(SettingKeyService.isKeyExist()) {
            // 存在key,显示确认是否重新设置密码界面
            confirmChangeKeyPane.setVisible(true);
            keySetPane.setVisible(false);
        } else {
            // 不存在key，直接跳过进入设置密钥界面
            confirmChangeKeyPane.setVisible(false);
            keySetPane.setVisible(true);
        }

        errorAlert.setVisible(false);

        /*
         确认框松开键盘 触发事件
         */
        confirmKey.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(isDiffKey()) {
                    // 两个文本框内容不同
                    errorAlert.setVisible(true);
                } else {
                    // 文本框内容相同
                    errorAlert.setVisible(false);

                    //按下回车出发setKey事件
                    if(event.getCode() == KeyCode.ENTER){
                        setKey();
                    };
                }

            }
        });
    }

    private boolean isDiffKey() {
        return !inputKey.getText().equals(confirmKey.getText());
    }

}