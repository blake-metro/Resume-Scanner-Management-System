package groupsix.resume.model;

/**
 * Holds a Resume and Job Description, calculates the resume score based on similarity
 * between the two.
 */
public class ScoreResult {
    private double score;
    private Resume resume;
    private JobDescription jobDescription;


    public ScoreResult(){
        score = -1;
        resume = null;
        jobDescription = null;
    }

    public ScoreResult(Resume resume, JobDescription jobDescription) {
        score = -1;
        this.resume = resume;
        this.jobDescription = jobDescription;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
        score = -1;
    }

    public JobDescription getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(JobDescription jobDescription) {
        this.jobDescription = jobDescription;
        score = -1;
    }

    public double calculateScore() {
        //todo: score calculation code goes here
        if (score == -1) {

        }
        return score;
    }
}
