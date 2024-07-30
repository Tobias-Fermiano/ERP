module com.example.erp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.erp to javafx.fxml;
    exports com.example.erp;
    exports com.example.erp.Controller;
    opens com.example.erp.Controller to javafx.fxml;
}