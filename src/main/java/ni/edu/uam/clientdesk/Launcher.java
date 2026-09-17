package ni.edu.uam.clientdesk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(
                Launcher.class.getResource(
                        "/ni/edu/uam/clientdesk/fxml/Login.fxml"
                )
        );

        Scene scene = new Scene(loader.load());

        stage.setTitle("ClientDesk - Inicio de sesión");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}