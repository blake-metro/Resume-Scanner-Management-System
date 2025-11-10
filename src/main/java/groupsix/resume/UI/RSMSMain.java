package groupsix.resume.UI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RSMSMain extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(new Scene(new RSMSController().getView()));
        primaryStage.setTitle("Resume Scanner");
        primaryStage.show();
    }
}