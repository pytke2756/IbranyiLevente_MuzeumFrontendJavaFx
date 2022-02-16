module com.example.muzeumfrontendjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.muzeumfrontendjavafx to javafx.fxml;
    exports com.example.muzeumfrontendjavafx;
}