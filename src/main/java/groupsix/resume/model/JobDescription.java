package groupsix.resume.model;

import groupsix.resume.parsing.Parser;

import java.io.File;

public class JobDescription extends Document {
    public JobDescription() {}

    public JobDescription(File pdf) {
        setPdf(pdf);
        readTextFromPDF();
        fillInParseTable();
    }

    public JobDescription(String text) {
        this.text = text;
        fillInParseTable();
    }

    @Override
    protected void fillInParseTable() {
        parseTable = Parser.parseJobDescription(text);
    }

    public static ParseTable getExampleParseTable() {
        return ParseTable.getExampleJobDescriptionTable();
    }
}
