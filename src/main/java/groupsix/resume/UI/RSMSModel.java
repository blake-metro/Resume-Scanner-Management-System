package groupsix.resume.UI;

import groupsix.resume.model.JobDescription;
import groupsix.resume.model.Resume;


public class RSMSModel {
    private Resume resume;
    private JobDescription jobDescription;
    private double score;

    public RSMSModel(){
        resume = null;
        jobDescription = null;
        score = 0;
    }

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
