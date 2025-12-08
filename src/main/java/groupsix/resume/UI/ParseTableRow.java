package groupsix.resume.UI;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a single row of a ParseTable displayed in the region from
 * TableViewBuilder
 */
public class ParseTableRow {
    private final StringProperty heading = new SimpleStringProperty("");
    private final StringProperty body = new SimpleStringProperty("");

    public ParseTableRow() {

    }

    public ParseTableRow(String heading, String body) {
        this.heading.set(heading);
        this.body.set(body);
    }
    public String getHeading() {
        return heading.get();
    }

    public StringProperty headingProperty() {
        return heading;
    }

    public String getBody() {
        return body.get();
    }

    public StringProperty bodyProperty() {
        return body;
    }

    public static List<ParseTableRow> generateResList() {
        List<ParseTableRow> results = new ArrayList<>();
        results.add(new ParseTableRow("Name", "Ivana B. Codin"));
        results.add(new ParseTableRow("Education", """
                    Metropolitan State University — St. Paul, MN
                    Bachelor of Science in Computer Science
                    Graduated: May 2025
                    * GPA: 3.78/4.0
                    
                    * Relevant Coursework: Data Structures & Algorithms, Software Engineering, Database Systems, Operating Systems, Web Application Development, Artificial Intelligence
                    
                    * Capstone Project: Campus Connect — a full-stack web app that helps students find study groups and campus events (React, Node.js, Express, MongoDB)"""));
        results.add(new ParseTableRow("Experience", """
                    Software Development Intern — CodeForge Technologies, Minneapolis, MN
                    June 2024 – August 2024
                             * Assisted in developing internal tools for automating data entry using Python and SQL.
                    
                             * Collaborated with a team of developers using Agile sprints and Git for version control.
                    
                             * Reduced manual reporting time by 35% through process automation scripts.
                    
                    IT Help Desk Assistant — Metropolitan State University
                     September 2023 – May 2024
                                * Provided technical support to students and faculty on hardware, software, and network issues.
                    
                                * Documented troubleshooting procedures and created a digital knowledge base for common issues."""));
        return results;
    }

    public static List<ParseTableRow> generateJobDescrList() {
        List<ParseTableRow> results = new ArrayList<>();
        results.add(new ParseTableRow("Job Title", "Entry-Level Software Engineer"));
        results.add(new ParseTableRow("Company", "NorthStar Tech Solutions"));
        results.add(new ParseTableRow("Location", "St. Paul, MN"));
        results.add(new ParseTableRow("Responsibilities", """
                * Develop and maintain web applications using JavaScript, React, and Node.js
                
                * Collaborate with senior engineers on API design and integration
                
                * Participate in code reviews, testing, and debugging
                
                * Write clear, maintainable, and efficient code
                
                * Work with SQL and NoSQL databases to store and retrieve application data
                
                * Contribute to Agile development sprints and daily stand-ups"""));
        results.add(new ParseTableRow("Qualifications", """
                * Bachelor’s degree in Computer Science, Software Engineering, or related field (or equivalent experience)
                
                * Solid understanding of object-oriented programming and data structures
                
                * Familiarity with at least one modern web framework (React, Angular, or Vue)
                
                * Basic knowledge of REST APIs and version control systems (Git)
                
                * Strong problem-solving and communication skills
                
                * Eagerness to learn and grow in a collaborative team environment"""));
        return results;
    }

}
