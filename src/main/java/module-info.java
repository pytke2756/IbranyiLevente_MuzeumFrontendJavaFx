module com.example.muzeumfrontendjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.google.gson;


    opens com.example.muzeumfrontendjavafx to javafx.fxml, com.google.gson;
    exports com.example.muzeumfrontendjavafx;
}