module com.example.power {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.power to javafx.fxml;
    exports com.example.power;
}