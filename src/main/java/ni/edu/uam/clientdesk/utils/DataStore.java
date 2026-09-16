package ni.edu.uam.clientdesk.utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;
import lombok.Setter;
import ni.edu.uam.clientdesk.models.Client;

public class DataStore {

    private static DataStore instance;

    @Getter
    private final ObservableList<Client> clients = FXCollections.observableArrayList();

    @Getter
    @Setter
    private String currentUser;

    private DataStore() {
    }

    public static DataStore getInstance() {
        if (instance == null) {
            instance = new DataStore();
        }
        return instance;
    }
}