module groupsix.resume {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;


    opens groupsix.resume to javafx.fxml;
    exports groupsix.resume;
}