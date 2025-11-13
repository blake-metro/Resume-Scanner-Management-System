package groupsix.resume.model;

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

    public String addEntry(String key, String value) {
        return entries.put(key, value);
    }

    public String removeEntry(String key) {
        return entries.remove(key);
    }

    public String editEntry(String key, String value) {
        return entries.replace(key, value);
    }

    public Collection<String> getAllEntries() {
        return entries.values();
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

    public Collection<String> getAllKeywords() {
        return keywords.keySet();
    }

    /**
     * Creates and returns a sample ParseTable for a resume, for use in testing
     * @return sample parse table
     */
    public static ParseTable getExampleResumeTable(){
        ParseTable parseTable = new ParseTable();
        parseTable.addEntry("Name", "Ivana B. Codin");
        parseTable.addEntry("Education", """
                    Metropolitan State University — St. Paul, MN
                    Bachelor of Science in Computer Science
                    Graduated: May 2025
                    * GPA: 3.78/4.0
                    
                    * Relevant Coursework: Data Structures & Algorithms, Software Engineering, Database Systems, Operating Systems, Web Application Development, Artificial Intelligence
                    
                    * Capstone Project: Campus Connect — a full-stack web app that helps students find study groups and campus events (React, Node.js, Express, MongoDB)""");
        parseTable.addEntry("Experience", """
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
        parseTable.addEntry("Job Title", "Entry-Level Software Engineer");
        parseTable.addEntry("Company", "NorthStar Tech Solutions");
        parseTable.addEntry("Location", "St. Paul, MN");
        parseTable.addEntry("Responsibilities", """
                * Develop and maintain web applications using JavaScript, React, and Node.js
                
                * Collaborate with senior engineers on API design and integration
                
                * Participate in code reviews, testing, and debugging
                
                * Write clear, maintainable, and efficient code
                
                * Work with SQL and NoSQL databases to store and retrieve application data
                
                * Contribute to Agile development sprints and daily stand-ups""");
        parseTable.addEntry("Qualifications", """
                * Bachelor’s degree in Computer Science, Software Engineering, or related field (or equivalent experience)
                
                * Solid understanding of object-oriented programming and data structures
                
                * Familiarity with at least one modern web framework (React, Angular, or Vue)
                
                * Basic knowledge of REST APIs and version control systems (Git)
                
                * Strong problem-solving and communication skills
                
                * Eagerness to learn and grow in a collaborative team environment""");

        return  parseTable;
    }
}
