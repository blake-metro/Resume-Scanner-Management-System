package groupsix.resume.parsing;

import java.util.Arrays;

public class Headings {
    private Headings(){}

    // list is capitalized since headings are usually capitalized
    // if a word appears outside a heading, it will be lowercase and should not be detected as a heading
    private static final String[] defaultResumeHeadings = {
            "Contact", "Introduction", "Objective", "Education",
            "Experience", "Work Experience", "Qualifications", "Skills",
            "Technical Skills", "Awards", "Projects", "Volunteering"};

    public static String[] getResumeHeadings() {
        return Arrays.copyOf(defaultResumeHeadings, defaultResumeHeadings.length);
    }
}
