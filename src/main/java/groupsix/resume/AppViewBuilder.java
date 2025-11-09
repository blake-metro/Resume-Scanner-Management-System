package groupsix.resume;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Window;
import javafx.util.Builder;

import java.util.function.Consumer;

public class AppViewBuilder implements Builder<Region> {

    private final ResumeModel viewModel;
    private final Consumer<Window> chooseFile;

    BorderPane results;
    Region scoreView;
    Region resumeView;
    Region jobDescView;
    BooleanProperty scoreViewVisible = new SimpleBooleanProperty(true);
    BooleanProperty resumeViewVisible = new SimpleBooleanProperty(false);
    BooleanProperty jobDescViewVisible = new SimpleBooleanProperty(false);
    public AppViewBuilder(ResumeModel viewModel, Consumer<Window> chooseFile) {
        this.viewModel = viewModel;
        this.chooseFile = chooseFile;
    }

    @Override
    public Region build() {
        /*
        TODO: Need to add another button for uploading a job description/keywords.
        TODO: Need to add a label to display a score.
        TODO: Need to add a way to view the score breakdown (new view???)
         */
        ObservableList<ParseModel> resumeTableItems = FXCollections.observableArrayList();
        resumeTableItems.setAll(ParseModel.generateList());

        results = new BorderPane();
        resumeView = new ResumeViewBuilder(resumeTableItems).build();
        jobDescView = new JobDescViewBuilder().build();
        scoreView = new ScoreViewBuilder().build();
        resumeView.visibleProperty().bind(resumeViewVisible);
        jobDescView.visibleProperty().bind(jobDescViewVisible);
        scoreView.visibleProperty().bind(scoreViewVisible);

        results.setCenter(new StackPane(scoreView, jobDescView, resumeView));
        results.setLeft(setUpLeft());
        //results.setMinWidth(0);
        return results;
    }

    private Region setUpLeft() {
        // View Control Buttons
        Button scoreButton = new Button("Score");
        Button jobDescrButton = new Button("Job Description");
        Button resumeButton = new Button("Resume");
        scoreButton.setOnAction(evt -> setVisibility(true, false, false));
        jobDescrButton.setOnAction(evt -> setVisibility(false, false, true));
        resumeButton.setOnAction(evt -> setVisibility(1000, false, true, false));
        scoreButton.disableProperty().bind(scoreViewVisible);
        jobDescrButton.disableProperty().bind(jobDescViewVisible);
        resumeButton.disableProperty().bind(resumeViewVisible);

        // Control Buttons
        // TODO: add controls for each view. Set visibility based on current view
        // Score View
        Button calculateScoreButton = new Button("Calculate Score");    // TODO: make this button do something
        // Resume View
        Button uploadResumeFile = new Button("Upload Resume");
        uploadResumeFile.setOnAction(evt -> {
            chooseFile.accept(uploadResumeFile.getScene().getWindow());
        });

        // Controls VBox
        VBox viewButtons = new VBox(10, scoreButton, jobDescrButton, resumeButton);
        VBox scoreButtons = new VBox(calculateScoreButton);
        VBox resumeButtons = new VBox(uploadResumeFile);
        VBox jobDescrButtons = new VBox();
        scoreButtons.visibleProperty().bind(scoreViewVisible);
        resumeButtons.visibleProperty().bind(resumeViewVisible);
        jobDescrButtons.visibleProperty().bind(jobDescViewVisible);
        VBox results = new VBox(300, viewButtons, new StackPane(scoreButtons, resumeButtons, jobDescrButtons));
        results.setPadding(new Insets(6));
        return results;
    }

    private void setVisibility(Boolean score, Boolean resume, Boolean jobDesc) {
        setVisibility(0, score, resume, jobDesc);
    }

    private void setVisibility(int width, Boolean score, Boolean resume, Boolean jobDesc) {
        scoreViewVisible.set(score);
        resumeViewVisible.set(resume);
        jobDescViewVisible.set(jobDesc);
        results.setMinWidth(width);
        results.getScene().getWindow().sizeToScene();
    }

}
