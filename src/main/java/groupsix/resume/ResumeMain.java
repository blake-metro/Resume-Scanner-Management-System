package groupsix.resume;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;

public class ResumeMain extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(new Scene(new ResumeController().getView()));
        primaryStage.setTitle("Resume Scanner");
        primaryStage.setWidth(300);
        primaryStage.show();
    }
}