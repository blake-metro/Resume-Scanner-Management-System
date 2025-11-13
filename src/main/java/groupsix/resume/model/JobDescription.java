package groupsix.resume.model;

import java.io.File;

public class JobDescription extends Document {
    public JobDescription() {}

    public JobDescription(File pdf) {
        setPdf(pdf);
        readTextFromPDF();
        fillInParseTable();
    }

    public JobDescription(String text) {
        setText(text);
        fillInParseTable();
    }

    @Override
    protected void readTextFromPDF() {
        //todo: add code
    }

    @Override
    protected void fillInParseTable() {
        //todo: add code
    }

    public static ParseTable getExampleParseTable() {
        return ParseTable.getExampleJobDescriptionTable();
    }
}
