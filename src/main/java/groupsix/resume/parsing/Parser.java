package groupsix.resume.parsing;

import groupsix.resume.model.ParseTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parser {
    private Parser(){}

    public static ParseTable parseText(String text){
        List<String> lines = List.of(text.split("\n"));

        ArrayList<Integer> headingIndices = new ArrayList<>();
        for(String word : Headings.getResumeHeadings()) {
            if(lines.contains(word) || lines.contains(word.toUpperCase())) {  // sometimes headings are in all caps
                headingIndices.add(lines.indexOf(word));
            }
        }
        headingIndices.add(lines.size());   // makes sure the last section runs until the end
        Collections.sort(headingIndices);

        ParseTable parseTable = new ParseTable();
        parseTable.addSection("Resume Head",
                String.join("\n", lines.subList(0, headingIndices.get(0))));
        for(int i=1; i<headingIndices.size();i++) {
            parseTable.addSection(lines.get(headingIndices.get(i-1)),
                    String.join("\n", lines.subList(headingIndices.get(i-1) + 1, headingIndices.get(i))));
        }

        return parseTable;
    }
}
