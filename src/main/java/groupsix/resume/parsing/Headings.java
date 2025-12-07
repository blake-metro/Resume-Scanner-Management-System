package groupsix.resume.parsing;

import java.util.Arrays;

public class Headings {
    private Headings(){}

    // list is capitalized since headings are usually capitalized
    // if a word appears outside a heading, it will be lowercase and should not be detected as a heading
    private static final String[] defaultResumeHeadings = {
            "Contact", "Name", "Phone", "Email", "Introduction",
            "Objective", "Education", "Experience", "Qualification",
            "Skill", "Award", "Projects", "Volunteer"};

    private static final String[] defaultJobDescriptionHeadings = {
            "Job Title", "Company", "Location", "Responsibilities",
            "Tasks", "Qualifications", "Requirements", "Skills",
            "Pay", "Benefits", "Shift"};


    public static String[] getResumeHeadings() {
        return Arrays.copyOf(defaultResumeHeadings, defaultResumeHeadings.length);
    }

    public static String[] getJobDescriptionHeadings() {
        return Arrays.copyOf(defaultJobDescriptionHeadings, defaultJobDescriptionHeadings.length);
    }
}
