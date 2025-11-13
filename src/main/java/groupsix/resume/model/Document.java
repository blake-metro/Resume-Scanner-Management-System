package groupsix.resume.model;

import java.io.File;
import java.util.Collection;

public abstract class Document {
    protected File pdf;
    protected String text;
    protected final ParseTable parseTable;

    public Document() {
        pdf = null;
        text = null;
        parseTable = new ParseTable();
    }

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

    public String editEntry(String key, String value) {
        return parseTable.editEntry(key, value);
    }

    public Collection<String> getAllEntries() {
        return parseTable.getAllEntries();
    }

    public String addKeyword(String word, double weight) {
        return parseTable.addKeyword(word, weight);
    }

    public String removeKeyword(String word) {
        return parseTable.removeKeyword(word);
    }

    public String editKeyword(String word, double weight) {
        return parseTable.editKeyword(word, weight);
    }

    public Collection<String> getAllKeywords() {
        return parseTable.getAllKeywords();
    }

    protected abstract void readTextFromPDF();
    protected abstract void fillInParseTable();
}
