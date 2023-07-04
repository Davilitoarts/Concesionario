import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String direccion;
    private String dni;
    private ArrayList<Coche> cochesReservados;
    private ArrayList<Coche> cochesComprados;

    public Cliente(String nombre, String direccion, String dni) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.dni = dni;
        this.cochesReservados = new ArrayList<>();
        this.cochesComprados = new ArrayList<>();
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public ArrayList<Coche> getCochesReservados() {
        return cochesReservados;
    }

    public ArrayList<Coche> getCochesComprados() {
        return cochesComprados;
    }

    public void reservarCoche(Coche coche) {
        cochesReservados.add(coche);
    }

    public void cancelarReserva(Coche coche) {
        cochesReservados.remove(coche);
    }

    public void imprimirCochesComprados() {
        System.out.println("Coches comprados por " + nombre + ":");
        for (Coche coche : cochesComprados) {
            System.out.println(coche.getMarca() + " " + coche.getModelo());
        }
    }

    public void comprarCoche(Coche coche) {
        cochesComprados.add(coche);
    }
}
