package groupsix.resume;

import java.io.File;

public abstract class Document {
    protected File pdf;
    protected String text;
    protected ParseTable parseTable;


    public File getPdf() {
        return pdf;
    }

    public void setPdf(File pdf) {
        this.pdf = pdf;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ParseTable getParseTable() {
        return parseTable;
    }

    public String addEntry(String key, String value) {
        return parseTable.addEntry(key, value);
    }

    public String removeEntry(String key) {
        return parseTable.removeEntry(key);
    }


}
