package groupsix.resume.model;

import java.io.File;
import java.util.Collection;
import java.util.Map;

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

    /**
     * Returns a collection of pairs of section headings and section text from the parse table.
     * This collection can be turned into an ArrayList, or ObservableList for displaying via JavaFX
     * TableView.
     * @return collection of all entries in parse table
     */
    public Collection<Map.Entry<String, String>> getAllEntries() {
        return parseTable.getAllEntries();
    }

    /**
     * Returns all section headings and section text paired together in a Map using the headings
     * as keys and the text as values.
     * @return map of section headings and text
     */
    public Map<String, String> getAllEntriesAsMap() {
        return parseTable.getAllEntriesAsMap();
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
