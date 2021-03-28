package client;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import server.service.EncryptService;


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
    public void SettingByClick() {

    }
    @FXML
    public void setKey() {
        if(!isDiffKey()) {
            EncryptService.setKey(confirmKey.getText());
            IndexController.keyStage.close();
            IndexController.keyStage = null; // 置空，让GC对内存进行处理
        }
    }

    @FXML
    public void initialize() {

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