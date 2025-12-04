package groupsix.resume.model;

import groupsix.resume.parsing.Parser;

import java.io.File;
import java.util.ArrayList;

public class Resume extends Document{
    public Resume() {}

    public Resume(File pdf) {
        this.pdf = pdf;
        readTextFromPDF();
        fillInParseTable();
    }

    public Resume(String text) {
        this.text = text;
        fillInParseTable();
    }

    @Override
    protected void fillInParseTable() {
        parseTable = Parser.parseResume(text);
    }

    public static ParseTable getExampleParseTable() {
        return ParseTable.getExampleResumeTable();
    }
}
