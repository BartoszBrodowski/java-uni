module com.example.lab02 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab02 to javafx.fxml;
    exports com.example.lab02;
}