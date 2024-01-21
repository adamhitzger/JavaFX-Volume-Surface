module com.example.it.geometrycalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.it.geometrycalculator to javafx.fxml;
    exports com.example.it.geometrycalculator;
}