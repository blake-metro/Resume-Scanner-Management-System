package groupsix.resume.UI;

import groupsix.resume.model.JobDescription;
import groupsix.resume.model.Resume;
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
    private final BiConsumer<Resume, JobDescription> calculateScore;

    private BorderPane results;
    private Region scoreView;
    private Region resumeView;
    private Region jobDescView;
    private BooleanProperty scoreViewVisible = new SimpleBooleanProperty(true);
    private BooleanProperty resumeViewVisible = new SimpleBooleanProperty(false);
    private BooleanProperty jobDescViewVisible = new SimpleBooleanProperty(false);

    public AppViewBuilder(RSMSModel viewModel, BiConsumer<Window, String> chooseFile, BiConsumer<Resume, JobDescription> calculateScore) {
        this.viewModel = viewModel;
        this.chooseFile = chooseFile;
        this.calculateScore = calculateScore;
    }

    @Override
    public Region build() {
        results = new BorderPane();
        resumeView = new TableViewBuilder(viewModel, TableViewBuilder.Type.RESUME).build();
        jobDescView = new TableViewBuilder(viewModel, TableViewBuilder.Type.JOB_DESCRIPTION).build();
        scoreView = new ScoreViewBuilder(viewModel).build();
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

        // Score View
        Button calculateScoreButton = new Button("Calculate Score");
        calculateScoreButton.setOnAction(evt -> calculateScore.accept(viewModel.getResume(), viewModel.getJobDescription()));
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
