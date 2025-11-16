module groupsix.resume {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;
    requires org.apache.pdfbox;

    
    exports groupsix.resume.PDFConverter;
    opens groupsix.resume.PDFConverter to javafx.fxml;
    exports groupsix.resume.UI;
    opens groupsix.resume.UI to javafx.fxml;
    exports groupsix.resume.model;
    opens groupsix.resume.model to javafx.fxml;
}