package client;

import client.factory.StageFactory;
import client.factory.impl.StageFactoryImpl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;

        StageFactory stageFactory = new StageFactoryImpl();
        stageFactory.indexStageFactory(primaryStage);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
