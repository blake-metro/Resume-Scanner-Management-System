package groupsix.resume.model;

import groupsix.resume.PDFConverter.PDFConverter_PDF_To_STRING;
import javafx.collections.ObservableMap;

import java.io.File;

/**
 * Superclass for <code>Resume</code> and <code>JobDescription</code> classes.
 * Most of the shared boilerplate code is located here.  <code>Docuemnt</code>s consist of
 * an original PDF file, the text extracted from that file, and a parse table listing all
 * sections of the document (such as "Name" and "Work Experience" for resumes, "Company" and
 * "Qualifications" for job descriptions) and the text included in each section.
 */
public abstract class Document {
    protected File pdf;
    protected String text;
    protected ParseTable parseTable;

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
        readTextFromPDF();
    }

    /**
     * Get full extracted text of document as read from the PDF file or set using
     * <code>setFullText()</code>
     * @return document text
     */
    public String getFullText() {
        return text;
    }

    /**
     * Directly sets the full text of document and updates the parse table. Only use this if there
     * is no PDF file available, as this will override it. If there is a PDF, use <code>setPDF()</code>
     * instead.
     * @param text new full text of document
     */
    public void setFullText(String text) {
        this.text = text;
    }

    /**
     * Manually add a section to the parse table
     * @param heading section heading text
     * @param text section body text
     * @return body of added section
     */
    public String addSection(String heading, String text) {
        return parseTable.addSection(heading, text);
    }

    public String removeSection(String heading) {
        return parseTable.removeSection(heading);
    }

    public String editSection(String heading, String text) {
        return parseTable.editSection(heading, text);
    }

    /**
     * Returns all section headings and section text paired together in a Map using the headings
     * as keys and the text as values.
     * @return map of section headings and text
     */
    public ObservableMap<String, String> getAllEntriesAsMap() {
        return parseTable.getAllSectionsAsMap();
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

    public ObservableMap<String, Double> getAllKeywordsAsMap() {
        return parseTable.getAllKeywordsAsMap();
    }

    protected void readTextFromPDF() {
        PDFConverter_PDF_To_STRING converter = new PDFConverter_PDF_To_STRING();
        converter.convertPDF(pdf);
        text = converter.getPDFTextList().get(0);
    }

    protected abstract void fillInParseTable();
}
