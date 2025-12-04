package groupsix.resume.parsing;

import java.util.Arrays;

public class Headings {
    private Headings(){}

    private static String[] defaultLIst = {
            "contact", "introduction", "objective", "education",
            "experience", "skill", "awards", "projects", "volunteer",
            "job", "work"};

    public static String[] getWordList() {
        return Arrays.copyOf(defaultLIst, defaultLIst.length);
    }
}
