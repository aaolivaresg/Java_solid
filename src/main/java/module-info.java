module com.example.java_solid {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.java_solid to javafx.fxml;
    exports com.example.java_solid;
}