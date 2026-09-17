module ni.edu.uam.clientdesk {

    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;

    opens ni.edu.uam.clientdesk to javafx.fxml;
    opens ni.edu.uam.clientdesk.controller to javafx.fxml;
    opens ni.edu.uam.clientdesk.models to javafx.fxml;
    opens ni.edu.uam.clientdesk.utils to javafx.fxml;

    exports ni.edu.uam.clientdesk;
    exports ni.edu.uam.clientdesk.controller;
    exports ni.edu.uam.clientdesk.models;
    exports ni.edu.uam.clientdesk.utils;
}