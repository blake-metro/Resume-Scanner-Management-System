package groupsix.resume.parsing;

import java.util.Arrays;

public class Headings {
    private Headings(){}

    // list is capitalized since headings are usually capitalized
    // if a word appears outside a heading, it will be lowercase and should not be detected as a heading
    private static final String[] defaultResumeHeadings = {
            "Contact", "Name", "Phone", "Phone Number", "Email", "Introduction",
            "Objective", "Education", "Experience", "Work Experience", "Qualifications",
            "Skills", "Technical Skills", "Awards", "Projects", "Volunteering"};

    private static final String[] defaultJobDescriptionHeadings = {
            "Job Title", "Company", "Location", "Responsibilities", "Key Responsibilities",
            "Tasks", "Qualifications", "Requirements", "Key Requirements", "Skills", "Preferred Skills",
            "Preferred", "Pay", "Benefits", "Shift"};


    public static String[] getResumeHeadings() {
        return Arrays.copyOf(defaultResumeHeadings, defaultResumeHeadings.length);
    }

    public static String[] getJobDescriptionHeadings() {
        return Arrays.copyOf(defaultJobDescriptionHeadings, defaultJobDescriptionHeadings.length);
    }
}
