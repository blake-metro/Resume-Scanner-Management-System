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
        interactor = new RSMSInteractor(viewModel);
        viewBuilder = new AppViewBuilder(viewModel, interactor::chooseFile, interactor::calculateScore);
    }

    public Region getView() {
        return viewBuilder.build();
    }
}
