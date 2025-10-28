package groupsix.resume;

import java.util.HashMap;
import java.util.Map;

public class ParseTable {
    private Map<String, String> entries;
    private Map<String, Double> keywords;

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

    public static ParseTable getExampleTable(){
        ParseTable parseTable = new ParseTable();
        parseTable.entries = new HashMap<>() {{
            put("Name", "Ivana B. Codin");
            put("Education", """
                    Metropolitan State University — St. Paul, MN
                    Bachelor of Science in Computer Science
                    Graduated: May 2025
                    * GPA: 3.78/4.0
                    
                    * Relevant Coursework: Data Structures & Algorithms, Software Engineering, Database Systems, Operating Systems, Web Application Development, Artificial Intelligence
                    
                    * Capstone Project: Campus Connect — a full-stack web app that helps students find study groups and campus events (React, Node.js, Express, MongoDB)""");
            put("Experience", """
                    Software Development Intern — CodeForge Technologies, Minneapolis, MN
                    June 2024 – August 2024
                             * Assisted in developing internal tools for automating data entry using Python and SQL.
                    
                             * Collaborated with a team of developers using Agile sprints and Git for version control.
                    
                             * Reduced manual reporting time by 35% through process automation scripts.
                    
                    IT Help Desk Assistant — Metropolitan State University
                     September 2023 – May 2024
                                * Provided technical support to students and faculty on hardware, software, and network issues.
                    
                                * Documented troubleshooting procedures and created a digital knowledge base for common issues.""");
        }};
        return parseTable;
    }
}
