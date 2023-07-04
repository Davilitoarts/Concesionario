import java.util.ArrayList;

public class Concesionario {
    private String nombre;
    private String direccion;
    private ArrayList<Coche> cochesDisponibles;

    public Concesionario(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cochesDisponibles = new ArrayList<>();
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

    public void agregarCocheDisponible(Coche coche) {
        cochesDisponibles.add(coche);
    }

    public void imprimirCochesDisponibles() {
        if (cochesDisponibles.isEmpty()) {
            System.out.println("No hay coches disponibles en el concesionario.");
            System.out.println("------------------------");
        } else {
            System.out.println("Coches disponibles en el concesionario:");
            for (Coche coche : cochesDisponibles) {
                System.out.println(coche.getMarca() + " " + coche.getModelo());
                System.out.println("------------------------");
            }
        }
    }
}
