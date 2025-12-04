package groupsix.resume.parsing;

import groupsix.resume.model.ParseTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResumeParserTest {

    /*
    This test will always pass if it doesn't get an exception.
    Use the breakpoint and debug mode to check if the algorithm is parsing correctly.
     */
    @Test
    void parseText() {
        String fullText = """
                Ivana B. Codin
                📍 St. Paul, MN
                📞 (612) 555-0178
                ✉️ ivana.b.codin@email.com
                💼 github.com/ivanabcodin | linkedin.com/in/ivanabcodin
                ________________
                
                
                Objective
                Motivated and detail-oriented recent Computer Science graduate seeking a software development position where I can apply my strong programming skills, problem-solving mindset, and passion for clean, efficient code to contribute to innovative projects and continue professional growth.
                ________________
                
                
                Education
                Metropolitan State University — St. Paul, MN
                Bachelor of Science in Computer Science
                Graduated: May 2025
                * GPA: 3.78/4.0
                
                * Relevant Coursework: Data Structures & Algorithms, Software Engineering, Database Systems, Operating Systems, Web Application Development, Artificial Intelligence
                
                * Capstone Project: Campus Connect — a full-stack web app that helps students find study groups and campus events (React, Node.js, Express, MongoDB)
                
                ________________
                
                
                Technical Skills
                Programming Languages: Python, Java, C++, JavaScript, SQL, HTML, CSS
                Frameworks & Tools: React, Node.js, Express, Flask, Git/GitHub, Docker, AWS (EC2, S3)
                Databases: MySQL, MongoDB, PostgreSQL
                Other Skills: Agile development, RESTful APIs, Version control, UI/UX design principles
                ________________
                
                
                Projects
                Personal Finance Tracker
                Python, Flask, SQLite, Chart.js
                   * Built a web application to help users visualize spending patterns with interactive dashboards.
                
                   * Implemented secure user authentication and encrypted data storage.
                
                MN Park Finder
                React, Node.js, Google Maps API
                      * Created a mobile-friendly app for locating local parks and trails in Minnesota.
                
                      * Integrated real-time geolocation and filtering by amenities.
                
                ________________
                
                
                Experience
                Software Development Intern — CodeForge Technologies, Minneapolis, MN
                June 2024 – August 2024
                         * Assisted in developing internal tools for automating data entry using Python and SQL.
                
                         * Collaborated with a team of developers using Agile sprints and Git for version control.
                
                         * Reduced manual reporting time by 35% through process automation scripts.
                
                IT Help Desk Assistant — Metropolitan State University
                 September 2023 – May 2024
                            * Provided technical support to students and faculty on hardware, software, and network issues.
                
                            * Documented troubleshooting procedures and created a digital knowledge base for common issues.
                
                ________________
                
                
                Awards & Activities
                               * Dean’s List (2022–2025)
                
                               * Member, Association for Computing Machinery (ACM)
                
                               * Hackathon Participant — Twin Cities CodeFest 2024 (Top 10 Finalist)
                
                               * Volunteer, Girls Who Code Minneapolis Chapter
                
                ________________
                
                
                References
                Available upon request
                ________________
                
                
                (Mock resume created by ChatGPT)""";

        ParseTable parseTable = Parser.parseText(fullText);
        System.out.println("Table created");
        assertTrue(true);
    }
}