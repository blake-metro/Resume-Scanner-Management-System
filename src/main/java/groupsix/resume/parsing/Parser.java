package groupsix.resume.parsing;

import groupsix.resume.model.ParseTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parser {
    private Parser(){}

    public static ParseTable parseResume(String resumeText){
        return parseText(resumeText, Headings.getResumeHeadings());
    }

    public static ParseTable parseJobDescription(String jobDescriptionText){
        return parseText(jobDescriptionText, Headings.getJobDescriptionHeadings());
    }

    private static ParseTable parseText(String text, String[] headings){
        List<String> lines = List.of(text.split(System.lineSeparator()));

        ArrayList<Integer> headingIndices = new ArrayList<>();
        for(String line : lines) {
            for(String heading : headings) {
                if(line.contains(heading)) {
                    headingIndices.add(lines.indexOf(line));
                }
            }
        }
        headingIndices.add(lines.size());   // makes sure the last section runs until the end
        //Collections.sort(headingIndices);

        ParseTable parseTable = new ParseTable();
        parseTable.addSection("",
                String.join(System.lineSeparator(), lines.subList(0, headingIndices.get(0))));
        for(int i=0; i<headingIndices.size()-1; i++) {
            parseTable.addSection(lines.get(headingIndices.get(i)),
                    String.join(System.lineSeparator(), lines.subList(headingIndices.get(i) + 1, headingIndices.get(i + 1))));
        }

        return parseTable;
    }
}
