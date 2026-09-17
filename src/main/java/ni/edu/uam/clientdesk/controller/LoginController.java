package ni.edu.uam.clientdesk.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import ni.edu.uam.clientdesk.utils.DataStore;
import ni.edu.uam.clientdesk.utils.ScreenNavigator;
import ni.edu.uam.clientdesk.utils.ScreenNavigator;

import java.io.IOException;
import java.util.Optional;

public class LoginController {

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private void onIniciarSesion(ActionEvent event) {
        String usuario = txtUsuario.getText();
        String password = txtPassword.getText();

        if (usuario == null || usuario.isBlank() || password == null || password.isBlank()) {
            mostrarAlertaAdvertencia("Campos incompletos",
                    "Debe ingresar usuario y contraseña para continuar.");
            return;
        }

        if (!DataStore.getInstancia().validarCredenciales(usuario, password)) {
            mostrarAlertaAdvertencia("Credenciales incorrectas",
                    "El usuario o la contraseña no son válidos.");
            return;
        }

        try {
            Stage stageActual = (Stage) txtUsuario.getScene().getWindow();
            ScreenNavigator.cambiarEscena(stageActual, "VentanaPrincipal.fxml", "ClientDesk - Menú principal");
        } catch (IOException e) {
            mostrarAlertaAdvertencia("Error al abrir la ventana",
                    "No se pudo cargar la ventana principal: " + e.getMessage());
        }
    }

    @FXML
    private void onSalir(ActionEvent event) {
        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Confirmar salida");
        confirmacion.setHeaderText(null);
        confirmacion.setContentText("¿Está seguro que desea salir de la aplicación?");

        Optional<ButtonType> respuesta = confirmacion.showAndWait();
        if (respuesta.isPresent() && respuesta.get() == ButtonType.OK) {
            Stage stageActual = (Stage) txtUsuario.getScene().getWindow();
            stageActual.close();
        }
    }

    @FXML
    private void onPasswordKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            onIniciarSesion(new ActionEvent());
        }
    }

    private void mostrarAlertaAdvertencia(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
