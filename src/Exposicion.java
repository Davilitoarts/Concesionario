import java.util.ArrayList;

public class Exposicion {
    private String nombre;
    private String direccion;
    private ArrayList<Coche> cochesExposicion;

    public Exposicion(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cochesExposicion = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Coche> getCochesExposicion() {
        return cochesExposicion;
    }

    public void agregarCocheExposicion(Coche coche) {
        cochesExposicion.add(coche);
    }

    public void eliminarCocheExposicion(Coche coche) {
        cochesExposicion.remove(coche);
    }
}
