package groupsix.resume.UI;

import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ResumeInteractor {
    private final ResumeModel viewModel;
    final FileChooser fileChooser = new FileChooser();
    private Desktop desktop = Desktop.getDesktop();

    public ResumeInteractor(ResumeModel viewModel) {
        this.viewModel = viewModel;
    }

    public void chooseFile(Window window) {
        File file = fileChooser.showOpenDialog(window);
        if (file != null) {
            viewModel.setResume(file);
            //openFile(file);
        }
    }

    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(
                    AppViewBuilder.class.getName()).log(
                    Level.SEVERE, null, ex
            );
        }
    }

}
