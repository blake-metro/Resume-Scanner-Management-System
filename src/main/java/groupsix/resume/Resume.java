package groupsix.resume;

import java.io.File;

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
    protected void readTextFromPDF() {
        //todo: add code
    }

    @Override
    protected void fillInParseTable() {
        //todo: add code
    }
}
