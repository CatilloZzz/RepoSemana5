package ni.edu.uam.clientdesk.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import ni.edu.uam.clientdesk.utils.ScreenNavigator;

public class MainController {

    @FXML private MenuItem menuRegistrarCliente;
    @FXML private MenuItem menuConsultarClientes;
    @FXML private MenuItem menuSalir;
    @FXML private MenuItem menuAcerca;

    @FXML private Button btnRegistrarCliente;
    @FXML private Button btnConsultarClientes;
    @FXML private Button btnRegistrarClienteCentro;
    @FXML private Button btnConsultarClientesCentro;

    @FXML
    public void onRegistrarCliente(ActionEvent event) {
        Stage stage = obtenerStage(event);
        ScreenNavigator.cargarPantallaRegistroCliente(stage);
    }

    @FXML
    public void onConsultarClientes(ActionEvent event) {
        Stage stage = obtenerStage(event);
        ScreenNavigator.cargarPantallaConsultaClientes(stage);
    }

    @FXML
    public void onSalir(ActionEvent event) {
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION,
                "¿Está seguro que desea salir de la aplicación?",
                ButtonType.YES, ButtonType.NO);
        confirm.setTitle("Confirmar salida");
        confirm.setHeaderText(null);
        confirm.showAndWait().ifPresent(response -> {
            if (response == ButtonType.YES) {
                Platform.exit();
            }
        });
    }

    @FXML
    public void onAcercaDe(ActionEvent event) {
        Alert info = new Alert(Alert.AlertType.INFORMATION);
        info.setTitle("Acerca del sistema");
        info.setHeaderText(null);
        info.setContentText("ClientDesk - Sistema de gestión de clientes.\nUniversidad Americana (UAM).");
        info.showAndWait();
    }

    private Stage obtenerStage(ActionEvent event) {
        Object source = event.getSource();
        if (source instanceof MenuItem) {
            return (Stage) ((MenuItem) source).getParentPopup().getOwnerWindow();
        }
        return (Stage) ((Button) source).getScene().getWindow();
    }
}