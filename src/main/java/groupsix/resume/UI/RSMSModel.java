package groupsix.resume.UI;

import groupsix.resume.model.JobDescription;
import groupsix.resume.model.Resume;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Map;

/**
 * Connects the UI to the rest of the underlying model data.  UI elements should
 * only access and modify data via this class or else they may not work properly.
 */
public class RSMSModel {
    private Resume resume;
    private final ObservableList<ParseTableRow> resumeTable;
    private JobDescription jobDescription;
    private final ObservableList<ParseTableRow>  jobDescriptionTable;
    private final StringProperty score;

    public RSMSModel(){
        resumeTable = FXCollections.observableArrayList();
        jobDescriptionTable = FXCollections.observableArrayList();
        setResume(new Resume());
        setJobDescription(new JobDescription());
        score = new SimpleStringProperty("0.0");
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
        resumeTable.clear();
        for(Map.Entry<String, String> row: resume.getAllEntries()) {
            resumeTable.add(new ParseTableRow(row.getKey(), row.getValue()));
        }
    }

    public JobDescription getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(JobDescription jobDescription) {
        this.jobDescription = jobDescription;
        jobDescriptionTable.clear();
        for(Map.Entry<String, String> row: jobDescription.getAllEntries()) {
            jobDescriptionTable.add(new ParseTableRow(row.getKey(), row.getValue()));
        }
    }

    public ObservableList<ParseTableRow> getResumeTable() {return resumeTable;}
    public ObservableList<ParseTableRow> getJobDescriptionTable() {return jobDescriptionTable;}
    public double getScore() {return Double.parseDouble(score.get());}
    public void setScore(double score) {this.score.set(String.valueOf(score));}
    public StringProperty scoreProperty() {return score;}
}
