package groupsix.resume.UI;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Window;
import javafx.util.Builder;

import java.util.function.BiConsumer;

public class AppViewBuilder implements Builder<Region> {

    private final RSMSModel viewModel;
    private final BiConsumer<Window, String> chooseFile;

    BorderPane results;
    Region scoreView;
    Region resumeView;
    Region jobDescView;
    BooleanProperty scoreViewVisible = new SimpleBooleanProperty(true);
    BooleanProperty resumeViewVisible = new SimpleBooleanProperty(false);
    BooleanProperty jobDescViewVisible = new SimpleBooleanProperty(false);
    public AppViewBuilder(RSMSModel viewModel, BiConsumer<Window, String> chooseFile) {
        this.viewModel = viewModel;
        this.chooseFile = chooseFile;
    }

    @Override
    public Region build() {
        /*
        TODO: Need to add another button for uploading a job description/keywords.
        TODO: Need bind label to display a score.
        TODO: Need to implement jobDesc tableView
        TODO: Need to implement score breakdown
         */

        results = new BorderPane();
        resumeView = new ResumeViewBuilder(viewModel).build();
        jobDescView = new JobDescViewBuilder(viewModel).build();
        scoreView = new ScoreViewBuilder().build();
        resumeView.visibleProperty().bind(resumeViewVisible);
        jobDescView.visibleProperty().bind(jobDescViewVisible);
        scoreView.visibleProperty().bind(scoreViewVisible);

        results.setCenter(new StackPane(scoreView, jobDescView, resumeView));
        results.setLeft(setUpLeft());
        return results;
    }

    private Region setUpLeft() {
        // View Control Buttons
        Button scoreButton = new Button("Score");
        Button jobDescrButton = new Button("Job Description");
        Button resumeButton = new Button("Resume");
        scoreButton.setOnAction(evt -> setVisibility(true, false, false));
        jobDescrButton.setOnAction(evt -> setVisibility(1000, false, false, true));
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
        uploadResumeFile.setOnAction(evt -> chooseFile.accept(uploadResumeFile.getScene().getWindow(), "resume"));
        // Job Desc View
        Button uploadJobDescFile = new Button("Upload Job Desc");
        uploadJobDescFile.setOnAction(evt -> chooseFile.accept(uploadResumeFile.getScene().getWindow(), "job"));

        // Controls VBox
        VBox viewButtons = new VBox(10, scoreButton, jobDescrButton, resumeButton);
        VBox scoreButtons = new VBox(calculateScoreButton);
        VBox resumeButtons = new VBox(uploadResumeFile);
        VBox jobDescButtons = new VBox(uploadJobDescFile);
        scoreButtons.visibleProperty().bind(scoreViewVisible);
        resumeButtons.visibleProperty().bind(resumeViewVisible);
        jobDescButtons.visibleProperty().bind(jobDescViewVisible);
        VBox results = new VBox(300, viewButtons, new StackPane(scoreButtons, resumeButtons, jobDescButtons));
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
