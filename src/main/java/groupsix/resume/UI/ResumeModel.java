package groupsix.resume.UI;

import java.io.File;

public class ResumeModel {
    private File resume;
    public ParseModel parseModel = new ParseModel();

    public File getResume() {
        return resume;
    }

    public void setResume(File file) {
        resume = file;
    }
}
