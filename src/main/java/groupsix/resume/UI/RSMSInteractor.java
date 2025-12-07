package groupsix.resume.UI;

import groupsix.resume.model.JobDescription;
import groupsix.resume.model.Resume;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RSMSInteractor {
    private final RSMSModel viewModel;
    final FileChooser fileChooser = new FileChooser();
    private Desktop desktop = Desktop.getDesktop();

    public RSMSInteractor(RSMSModel viewModel) {
        this.viewModel = viewModel;
    }

    public void chooseFile(Window window, String target) {
        File file = fileChooser.showOpenDialog(window);
        if (file != null) {
            if(target.equalsIgnoreCase("resume")) {
                viewModel.setResume(new Resume(file));
            } else {
                viewModel.setJobDescription(new JobDescription(file));
            }
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
