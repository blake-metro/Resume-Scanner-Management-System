package groupsix.resume;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
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
        return results;
    }

    private Region setUpCenter() {
        final Button chooserButton = new Button("Upload Resume");
        chooserButton.setOnAction(evt -> {
            chooseFile.accept(chooserButton.getScene().getWindow());
        });
        VBox results = new VBox(8, new Label("Hello World"), chooserButton);
        results.setPadding(new Insets(6));
        return results;
    }

}
