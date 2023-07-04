import java.util.ArrayList;
import java.util.List;

public class Exposicion {
    private List<Coche> coches;
    private String ubicacion;

    public Exposicion(String ubicacion) {
        this.ubicacion = ubicacion;
        coches = new ArrayList<>();
    }

    public void agregarCoche(Coche coche) {
        coches.add(coche);
    }

    public void eliminarCoche(Coche coche) {
        coches.remove(coche);
    }

    public List<Coche> getCoches() {
        return coches;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}