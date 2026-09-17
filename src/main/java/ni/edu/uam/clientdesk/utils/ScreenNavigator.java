package ni.edu.uam.clientdesk.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ScreenNavigator {

    private static final String PANTALLA_PRINCIPAL = "/ni/edu/uam/clientdesk/fxml/Main-view.fxml";
    private static final String PANTALLA_REGISTRO_CLIENTE = "/ni/edu/uam/clientdesk/fxml/RegistroCliente.fxml";
    private static final String PANTALLA_CONSULTA_CLIENTES = "/ni/edu/uam/clientdesk/fxml/ConsultaClientes.fxml";

    public static void cargarPantallaPrincipal(Stage stageActual) {
        cargarPantalla(stageActual, PANTALLA_PRINCIPAL, "ClientDesk - Sistema de gestión de clientes");
    }

    public static void cargarPantallaRegistroCliente(Stage stageActual) {
        cargarPantalla(stageActual, PANTALLA_REGISTRO_CLIENTE, "ClientDesk - Registro de cliente");
    }

    public static void cargarPantallaConsultaClientes(Stage stageActual) {
        cargarPantalla(stageActual, PANTALLA_CONSULTA_CLIENTES, "ClientDesk - Consulta de clientes");
    }

    private static void cargarPantalla(Stage stageActual, String rutaFxml, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(ScreenNavigator.class.getResource(rutaFxml));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            stageActual.setScene(scene);
            stageActual.setTitle(titulo);

            stageActual.setWidth(1000);
            stageActual.setHeight(650);
            stageActual.centerOnScreen();

        } catch (IOException e) {
            System.err.println("Error al cargar la pantalla: " + rutaFxml + " -> " + e.getMessage());
            e.printStackTrace();
        }
    }
}