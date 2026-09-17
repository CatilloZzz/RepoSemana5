package ni.edu.uam.clientdesk.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ScreenNavigator {

    private static final String CARPETA_FXML = "/ni/edu/uam/clientdesk/fxml/";

    public static <T> T cambiarEscena(Stage stageActual, String nombreFxml, String titulo) throws IOException {
        FXMLLoader loader = new FXMLLoader(ScreenNavigator.class.getResource(CARPETA_FXML + nombreFxml));
        Parent root = loader.load();
        stageActual.setScene(new Scene(root));
        stageActual.setTitle(titulo);
        stageActual.show();
        return loader.getController();
    }

    public static <T> T abrirVentana(String nombreFxml, String titulo) throws IOException {
        FXMLLoader loader = new FXMLLoader(ScreenNavigator.class.getResource(CARPETA_FXML + nombreFxml));
        Parent root = loader.load();
        Stage nuevoStage = new Stage();
        nuevoStage.setScene(new Scene(root));
        nuevoStage.setTitle(titulo);
        nuevoStage.show();
        return loader.getController();
    }
}