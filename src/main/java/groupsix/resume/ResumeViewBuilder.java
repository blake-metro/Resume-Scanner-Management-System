package groupsix.resume;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Window;
import javafx.util.Builder;

import java.util.function.Consumer;

public class ResumeViewBuilder implements Builder<Region> {

    private final ResumeModel viewModel;
    private final Consumer<Window> chooseFile;
    public ResumeViewBuilder(ResumeModel viewModel, Consumer<Window> chooseFile) {
        this.viewModel = viewModel;
        this.chooseFile = chooseFile;
    }

    public Region build() {
        /*
        TODO: Need to add another button for uploading a job description/keywords.
        TODO: Need to add a label to display a score.
        TODO: Need to add a way to view the score breakdown (new view???)
         */
        BorderPane results = new BorderPane();
        results.setCenter(setUpCenter());
        results.setBottom(setUpBottom());
        return results;
    }

    private Region setUpCenter() {
        final Button chooserButton = new Button("Upload Resume");
        final Button LoginButton = new Button("Login/Logout");
        chooserButton.setOnAction(evt -> {
            chooseFile.accept(chooserButton.getScene().getWindow());
        });
        HBox results = new HBox(300, chooserButton, LoginButton);
        results.setPadding(new Insets(6));
        return results;
    }

    private Region setUpBottom() {
        TableView results = new TableView<String>();
        return results;
    }

}
