package groupsix.resume.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ParseTable {
    private final Map<String, String> entries;
    private final Map<String, Double> keywords;

    public ParseTable() {
        entries = new HashMap<>();
        keywords = new HashMap<>();
    }

    public String addSection(String heading, String text) {
        return entries.put(heading, text);
    }

    public String removeSection(String heading) {
        return entries.remove(heading);
    }

    public String editSection(String heading, String text) {
        return entries.replace(heading, text);
    }

    public Collection<Map.Entry<String, String>> getAllEntries() {
        return entries.entrySet();
    }

    public String addKeyword(String word, double weight) {
        return keywords.put(word, weight) == null ? null : word;
    }

    public String removeKeyword(String word) {
        return keywords.remove(word) == null ? null : word;
    }

    public String editKeyword(String word, double weight) {
        return keywords.replace(word, weight) == null ? null : word;
    }

    public Collection<Map.Entry<String, Double>> getAllKeywords() {
        return keywords.entrySet();
    }

    /**
     * Creates and returns a sample ParseTable for a resume, for use in testing
     * @return sample parse table
     */
    public static ParseTable getExampleResumeTable(){
        ParseTable parseTable = new ParseTable();
        parseTable.addSection("Name", "Ivana B. Codin");
        parseTable.addSection("Education", """
                    Metropolitan State University — St. Paul, MN
                    Bachelor of Science in Computer Science
                    Graduated: May 2025
                    * GPA: 3.78/4.0
                    
                    * Relevant Coursework: Data Structures & Algorithms, Software Engineering, Database Systems, Operating Systems, Web Application Development, Artificial Intelligence
                    
                    * Capstone Project: Campus Connect — a full-stack web app that helps students find study groups and campus events (React, Node.js, Express, MongoDB)""");
        parseTable.addSection("Experience", """
                    Software Development Intern — CodeForge Technologies, Minneapolis, MN
                    June 2024 – August 2024
                             * Assisted in developing internal tools for automating data entry using Python and SQL.
                    
                             * Collaborated with a team of developers using Agile sprints and Git for version control.
                    
                             * Reduced manual reporting time by 35% through process automation scripts.
                    
                    IT Help Desk Assistant — Metropolitan State University
                     September 2023 – May 2024
                                * Provided technical support to students and faculty on hardware, software, and network issues.
                    
                                * Documented troubleshooting procedures and created a digital knowledge base for common issues.""");
        return parseTable;
    }

    public static ParseTable getExampleJobDescriptionTable() {
        ParseTable parseTable = new ParseTable();
        parseTable.addSection("Job Title", "Entry-Level Software Engineer");
        parseTable.addSection("Company", "NorthStar Tech Solutions");
        parseTable.addSection("Location", "St. Paul, MN");
        parseTable.addSection("Responsibilities", """
                * Develop and maintain web applications using JavaScript, React, and Node.js
                
                * Collaborate with senior engineers on API design and integration
                
                * Participate in code reviews, testing, and debugging
                
                * Write clear, maintainable, and efficient code
                
                * Work with SQL and NoSQL databases to store and retrieve application data
                
                * Contribute to Agile development sprints and daily stand-ups""");
        parseTable.addSection("Qualifications", """
                * Bachelor’s degree in Computer Science, Software Engineering, or related field (or equivalent experience)
                
                * Solid understanding of object-oriented programming and data structures
                
                * Familiarity with at least one modern web framework (React, Angular, or Vue)
                
                * Basic knowledge of REST APIs and version control systems (Git)
                
                * Strong problem-solving and communication skills
                
                * Eagerness to learn and grow in a collaborative team environment""");

        return  parseTable;
    }
}
