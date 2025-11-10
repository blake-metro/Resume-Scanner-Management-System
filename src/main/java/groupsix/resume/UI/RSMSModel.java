package groupsix.resume.UI;

import java.io.File;

public class RSMSModel {
    private File resume;
    private File jobDescr;
    public ParseModel resParseModel = new ParseModel();
    public ParseModel jobDescrParseModel = new ParseModel();

    public File getResume() {
        return resume;
    }

    public void setResume(File file) {
        resume = file;
    }

    public File getJobDescr() { return jobDescr;}

    public void setJobDescr(File file) {
        jobDescr = file;
    }
}
