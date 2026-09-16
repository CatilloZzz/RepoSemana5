package ni.edu.uam.clientdesk.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Client {

    private String nombres;
    private String apellidos;
    private String tipoCliente;
    private String ciudad;
    private LocalDate fechaNacimiento;
    private String tipoSolicitud;
    private List<String> servicios;
    private String fotoPath; // guardamos la RUTA de la foto, no la imagen en sí

    public String getNombreCompleto() {
        return nombres + " " + apellidos;
    }

    public String getServiciosTexto() {
        if (servicios == null || servicios.isEmpty()) {
            return "Ninguno";
        }
        return String.join(", ", servicios);
    }
}