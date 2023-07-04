import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class VendedorAComision extends Persona {
    private int sueldo;
    private HashMap<String, Coche> cochesVendidos;

    public VendedorAComision(String nombre, String direccion, String DNI, int telefono) {
        super(nombre, direccion, DNI, telefono);
        cochesVendidos = new HashMap<>();
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public HashMap<String, Coche> getCochesVendidos() {
        return cochesVendidos;
    }

    public void setCochesVendidos(HashMap<String, Coche> cochesVendidos) {
        this.cochesVendidos = cochesVendidos;
    }

    public void agregarCocheVendido(String matricula, Coche coche) {
        cochesVendidos.put(matricula, coche);
    }
    public int sueldoAComision(){
        return sueldo = cochesVendidos.size() * 200;
    }
    public void modificarVendedor(){
        Scanner vendedor = new Scanner(System.in);
        System.out.println("Introduzca los nuevos datos para el cliente con DNI " + getDNI() + ": ");
        System.out.println("Introduzca su nuevo nombre: ");
        String nuevoNombre = vendedor.nextLine();
        setNombre(nuevoNombre);
        System.out.println("Introduzca su nueva dirección: ");
        String nuevaDireccion = vendedor.nextLine();
        setDireccion(nuevaDireccion);
        System.out.println("Introduzca su nuevo teléfono: ");
        int nuevoTeléfono = vendedor.nextInt();
        // if(nuevoTeléfono < 99999999 && nuevoTeléfono > 999999999) throw new Exception("El nuevo teléfono no puede ser menor ni mayor a 9 cifras");
        setTelefono(nuevoTeléfono);


    }
    public void imprimirDatosVendedor(){
        System.out.println("Nombre del vendedor: " + getNombre());
        System.out.println("Dirección del vendedor: " + getDireccion());
        System.out.println("DNI del vendedor: " + getDNI());
        System.out.println("Teléfono del vendedor: " + getTelefono());
        System.out.println("------------------------");
    }
}

