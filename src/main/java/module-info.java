module ni.edu.uam.clientdesk {
    requires javafx.controls;
    requires javafx.fxml;


    opens ni.edu.uam.clientdesk to javafx.fxml;
    exports ni.edu.uam.clientdesk;
}