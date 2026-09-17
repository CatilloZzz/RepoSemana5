package ni.edu.uam.clientdesk.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Client {

    private String nombres;
    private String apellidos;
    private String tipoCliente;
    private String ciudad;
    private LocalDate fechaNacimiento;
    private String tipoSolicitud;
    private List<String> serviciosInteres;
    private String rutaFotografia;

    public Client(String nombres, String apellidos, String tipoCliente, String ciudad,
                  LocalDate fechaNacimiento, String tipoSolicitud,
                  List<String> serviciosInteres, String rutaFotografia) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoCliente = tipoCliente;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoSolicitud = tipoSolicitud;
        this.serviciosInteres = serviciosInteres;
        this.rutaFotografia = rutaFotografia;
    }

    public String getNombreCompleto() {
        return nombres + " " + apellidos;
    }

    @Override
    public String toString() {
        return getNombreCompleto();
    }
}