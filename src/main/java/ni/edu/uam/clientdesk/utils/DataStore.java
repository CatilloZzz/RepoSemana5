package ni.edu.uam.clientdesk.utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ni.edu.uam.clientdesk.models.Client;
import ni.edu.uam.clientdesk.models.User;

public class DataStore {

    private static DataStore instancia;
    private final ObservableList<Client> clientes;
    private final ObservableList<User> usuarios;

    private DataStore() {
        clientes = FXCollections.observableArrayList();
        usuarios = FXCollections.observableArrayList();

        usuarios.add(new User("admin", "1234"));
    }

    public static DataStore getInstancia() {
        if (instancia == null) {
            instancia = new DataStore();
        }
        return instancia;
    }

    public ObservableList<Client> getClientes() {
        return clientes;
    }

    public void agregarCliente(Client cliente) {
        clientes.add(cliente);
    }

    public ObservableList<User> getUsuarios() {
        return usuarios;
    }

    public boolean validarCredenciales(String username, String password) {
        return usuarios.stream()
                .anyMatch(u -> u.getUsername().equals(username) && u.getPassword().equals(password));
    }
}