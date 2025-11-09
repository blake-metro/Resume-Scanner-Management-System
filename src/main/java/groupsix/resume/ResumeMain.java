package groupsix.resume;

import groupsix.resume.UI.ResumeController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ResumeMain extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(new Scene(new ResumeController().getView()));
        primaryStage.setTitle("Resume Scanner");
        primaryStage.show();
    }
}