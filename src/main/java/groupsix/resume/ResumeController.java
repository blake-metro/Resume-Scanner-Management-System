package groupsix.resume;

import javafx.scene.layout.Region;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ResumeController {

    private final ResumeViewBuilder viewBuilder;
    private final ResumeInteractor interactor;
    final FileChooser fileChooser = new FileChooser();
    private Desktop desktop = Desktop.getDesktop();

    public ResumeController() {
        ResumeModel viewModel = new ResumeModel();
        viewBuilder = new ResumeViewBuilder(viewModel, this::chooseFile);
        interactor = new ResumeInteractor(viewModel);
    }

    private void chooseFile(Window window) {
        interactor.chooseFile(window);
    }

    public Region getView() {
        return viewBuilder.build();
    }
}
