package groupsix.resume.UI;

import groupsix.resume.model.JobDescription;
import groupsix.resume.model.Resume;


public class RSMSModel {
    private Resume resume;
    private JobDescription jobDescription;
    public ParseModel resParseModel = new ParseModel();
    public ParseModel jobDescrParseModel = new ParseModel();

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public JobDescription getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(JobDescription jobDescription) {
        this.jobDescription = jobDescription;
    }
}
