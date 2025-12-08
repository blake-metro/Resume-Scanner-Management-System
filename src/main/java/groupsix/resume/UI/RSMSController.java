package groupsix.resume.UI;

import groupsix.resume.model.JobDescription;
import groupsix.resume.model.Resume;
import groupsix.resume.parsing.Scorer;
import javafx.scene.layout.Region;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.awt.*;
import java.io.File;

public class RSMSController {

    private final AppViewBuilder viewBuilder;
    private final RSMSInteractor interactor;
    private final RSMSModel viewModel;

    public RSMSController() {
        viewModel = new RSMSModel();
        viewBuilder = new AppViewBuilder(viewModel, this::chooseFile, this::calculateScore);
        interactor = new RSMSInteractor(viewModel);
    }

    private void chooseFile(Window window, String target) {
        interactor.chooseFile(window, target);
    }

    private void calculateScore(Resume resume, JobDescription jobDescription) {
        viewModel.setScore(Scorer.calculateScore(resume, jobDescription));
    }

    public Region getView() {
        return viewBuilder.build();
    }
}
