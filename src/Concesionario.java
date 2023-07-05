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

    public void venderCoche(String matricula, Cliente cliente) {
        Coche coche = buscarCochePorMatricula(matricula);
        if (coche != null) {
            coche.setEstado(Coche.EstadoCoche.VENDIDO);
            cliente.addCocheComprado(coche);
            cochesDisponibles.remove(coche);
            System.out.println("El coche con matrícula " + matricula + " ha sido vendido al cliente " + cliente.getNombre());
        } else {
            System.out.println("No se encontró ningún coche con la matrícula " + matricula);
        }
    }

    private Coche buscarCochePorMatricula(String matricula) {
        for (Coche coche : cochesDisponibles) {
            if (coche.getMatricula().equals(matricula)) {
                return coche;
            }
        }
        return null;
    }
}
