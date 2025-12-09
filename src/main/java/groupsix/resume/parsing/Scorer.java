package groupsix.resume.parsing;

import groupsix.resume.model.JobDescription;
import groupsix.resume.model.Resume;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for calculating similarity score of a resume with respect
 * to a given job description.
 */
public class Scorer {
    private Scorer(){}

    public static double calculateScore(Resume resume, JobDescription jobDescription) {
        String jobText = jobDescription.getFullText();
        if(jobText == null || jobText.isEmpty()){   // avoid divide by 0 errors
            return 0;
        }

        List<String> resumeTokens = List.of(resume.getFullText().split("\\s+"));
        List<String> jobDescriptionTokens = List.of(jobText.split("\\s+"));

        double count = 0;
        for(String keyword : jobDescriptionTokens){
            if (resumeTokens.contains(keyword)){
                count++;
            }
        }

        return 100 * count / jobDescriptionTokens.size();
    }

}
