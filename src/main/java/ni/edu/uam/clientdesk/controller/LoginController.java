package ni.edu.uam.clientdesk.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import ni.edu.uam.clientdesk.utils.DataStore;
import ni.edu.uam.clientdesk.utils.ScreenNavigator;

public class LoginController {

    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtPassword;

    @FXML
    public void onIniciarSesion(ActionEvent event) {
        procesarLogin();
    }

    @FXML
    public void onPasswordKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            procesarLogin();
        }
    }

    @FXML
    public void onSalir(ActionEvent event) {
        Stage stage = (Stage) txtUsuario.getScene().getWindow();
        stage.close();
    }

    private void procesarLogin() {
        String usuario = txtUsuario.getText().trim();
        String password = txtPassword.getText();

        if (usuario.isEmpty() || password.isEmpty()) {
            mostrarAlerta("Campos vacíos", "Por favor ingrese su usuario y contraseña.");
            return;
        }

        boolean autenticado = DataStore.getInstancia().validarCredenciales(usuario, password);

        if (autenticado) {
            Stage stageActual = (Stage) txtUsuario.getScene().getWindow();
            ScreenNavigator.cargarPantallaPrincipal(stageActual);
        } else {
            mostrarAlerta("Credenciales incorrectas", "El usuario o la contraseña no son válidos.");
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}