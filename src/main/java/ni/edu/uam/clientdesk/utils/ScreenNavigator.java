package ni.edu.uam.clientdesk.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ScreenNavigator {

    private static final String PANTALLA_PRINCIPAL = "/ni/edu/uam/clientdesk/fxml/Main.fxml";

    public static void cargarPantallaPrincipal(Stage stageActual) {
        try {
            FXMLLoader loader = new FXMLLoader(ScreenNavigator.class.getResource(PANTALLA_PRINCIPAL));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stageActual.setScene(scene);
            stageActual.setTitle("ClientDesk - Sistema de gestión de clientes");

            stageActual.setWidth(1000);
            stageActual.setHeight(650);
            stageActual.centerOnScreen();

        } catch (IOException e) {
            System.err.println("Error al cargar la pantalla principal: " + e.getMessage());
            e.printStackTrace();
        }
    }
}