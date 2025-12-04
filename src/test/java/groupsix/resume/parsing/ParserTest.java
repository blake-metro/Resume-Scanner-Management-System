package groupsix.resume.parsing;

import groupsix.resume.model.ParseTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    /*
    This test will always pass if it doesn't get an exception.
    Use the breakpoint and debug mode to check if the algorithm is parsing correctly.
     */
    @Test
    void parseResume() {
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

        ParseTable parseTable = Parser.parseResume(fullText);
        System.out.println("Resume parsed");
        assertTrue(true);
    }

    /*
    Use debug and breakpoints, see 'parseResume()' test above
     */
    @Test
    void parseJobDescription() {
        String fullText = """
                Entry-Level Software Engineer
                Location: St. Paul, MN (Hybrid: 3 days on-site, 2 days remote)
                Company: NorthStar Tech Solutions
                Employment Type: Full-Time
                About Us
                NorthStar Tech Solutions is a growing Midwest-based software company specializing in cloud-based logistics and data analytics tools for manufacturing and transportation clients. We value innovation, collaboration, and curiosity—and we’re looking for a motivated software engineer to join our team!
                Position Summary
                As an Entry-Level Software Engineer, you’ll work closely with a team of experienced developers to design, build, and maintain web applications that help clients streamline operations. This is an excellent opportunity for recent graduates or early-career professionals to gain hands-on experience in a supportive environment.
                Key Responsibilities
                * Develop and maintain web applications using JavaScript, React, and Node.js
        
                * Collaborate with senior engineers on API design and integration
        
                * Participate in code reviews, testing, and debugging
        
                * Write clear, maintainable, and efficient code
        
                * Work with SQL and NoSQL databases to store and retrieve application data
        
                * Contribute to Agile development sprints and daily stand-ups
        
                Qualifications
                   * Bachelor’s degree in Computer Science, Software Engineering, or related field (or equivalent experience)
        
                   * Solid understanding of object-oriented programming and data structures
        
                   * Familiarity with at least one modern web framework (React, Angular, or Vue)
        
                   * Basic knowledge of REST APIs and version control systems (Git)
        
                   * Strong problem-solving and communication skills
        
                   * Eagerness to learn and grow in a collaborative team environment
        
                Preferred (Not Required)
                      * Experience with Python, Java, or C#
        
                      * Exposure to AWS, Docker, or CI/CD pipelines
        
                      * Internship or project experience in a team-based software development setting
        
                What We Offer
                         * Competitive starting salary ($65,000–$78,000 DOE)
        
                         * Health, dental, and vision insurance
        
                         * 401(k) with company match
        
                         * Paid time off and flexible work schedule
        
                         * Career growth opportunities and mentorship
        
                How to Apply
                Submit your résumé, a brief cover letter, and a link to your GitHub or portfolio at careers@northstartechmn.com with the subject line: “Entry-Level Software Engineer – St. Paul.”""";

        ParseTable parseTable = Parser.parseJobDescription(fullText);
        System.out.println("Job description parsed");
        assertTrue(true);
    }
}