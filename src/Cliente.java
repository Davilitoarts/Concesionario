import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String dni;
    private String domicilio;
    private String telefono;
    private List<Coche> cochesComprados;
    private List<Coche> cochesReservados;

    public Cliente(String nombre, String dni, String domicilio, String telefono) {
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.cochesComprados = new ArrayList<>();
        this.cochesReservados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Coche> getCochesComprados() {
        return cochesComprados;
    }

    public void setCochesComprados(List<Coche> cochesComprados) {
        this.cochesComprados = cochesComprados;
    }

    public List<Coche> getCochesReservados() {
        return cochesReservados;
    }

    public void setCochesReservados(List<Coche> cochesReservados) {
        this.cochesReservados = cochesReservados;
    }

    public void agregarCocheComprado(Coche coche) {
        cochesComprados.add(coche);
    }

    public void agregarCocheReservado(Coche coche) {
        cochesReservados.add(coche);
    }

    // Otros métodos relevantes para la gestión de clientes

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", telefono='" + telefono + '\'' +
                ", cochesComprados=" + cochesComprados +
                ", cochesReservados=" + cochesReservados +
                '}';
    }
}
