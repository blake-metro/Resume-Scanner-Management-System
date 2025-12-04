package groupsix.resume.parsing;

import groupsix.resume.model.ParseTable;

import java.util.ArrayList;
import java.util.List;

public class ResumeParser {
    private ResumeParser(){}

    public static ParseTable parseText(String text){
        List<String> lines = List.of(text.split("\n"));

        ArrayList<Integer> headingIndices = new ArrayList<>();
        for(String word : Headings.getWordList()) {
            if(lines.contains(word)) {
                headingIndices.add(lines.indexOf(word));
            }
        }

        ParseTable parseTable = new ParseTable();
        parseTable.addSection("Heading",
                String.join("\n", lines.subList(0, headingIndices.get(0))));
        for(int i=1; i<headingIndices.size();i++) {
            parseTable.addSection(lines.get(i),
                    String.join("\n", lines.subList(headingIndices.get(i-1), headingIndices.get(i))));
        }

        return parseTable;
    }
}
