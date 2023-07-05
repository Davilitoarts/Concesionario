import java.util.ArrayList;
import java.util.List;

public class Vendedor {
    private String nombre;
    private String dni;
    private String domicilio;
    private String telefono;
    private List<Coche> cochesVendidos;

    public Vendedor(String nombre, String dni, String domicilio, String telefono) {
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.cochesVendidos = new ArrayList<>();
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

    public List<Coche> getCochesVendidos() {
        return cochesVendidos;
    }

    public void setCochesVendidos(List<Coche> cochesVendidos) {
        this.cochesVendidos = cochesVendidos;
    }

    public void agregarCocheVendido(Coche coche) {
        cochesVendidos.add(coche);
    }

    // Otros métodos relevantes para la gestión de vendedores

    @Override
    public String toString() {
        return "Vendedor{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", telefono='" + telefono + '\'' +
                ", cochesVendidos=" + cochesVendidos +
                '}';
    }
}