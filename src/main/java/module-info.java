module groupsix.resume {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;
    requires org.apache.pdfbox;


    opens groupsix.resume to javafx.fxml;
    exports groupsix.resume;
    exports groupsix.resume.PDFConverter;
    opens groupsix.resume.PDFConverter to javafx.fxml;
}