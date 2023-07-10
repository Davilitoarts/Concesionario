import java.util.ArrayList;
import java.util.Scanner;

public class VendedorAComision extends Persona {
    private int sueldo;
    private ArrayList<Coche> cochesVendidos;

    public VendedorAComision(String nombre, String direccion, String DNI, int telefono) {
        super(nombre, direccion, DNI, telefono);
        cochesVendidos = new ArrayList<>();
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public ArrayList<Coche> getCochesVendidos() {
        return cochesVendidos;
    }

    public void setCochesVendidos(ArrayList<Coche> cochesVendidos) {
        this.cochesVendidos = cochesVendidos;
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
        System.out.println("El sueldo es de: " + sueldoAComision());
        System.out.println("------------------------");
    }
    public void agregarCocheVendido(Coche coche) {
        cochesVendidos.add(coche);
    }
    public void imprimirCochesVendidos(){
        if (cochesVendidos.isEmpty()) { //Comprueba si el arraylist cochesComprados está vacío y si lo está entra por aquí:
            System.out.println("No existen coches vendidos");
        } else { //Si no está vacío entra por aquí:
            for (Coche coche : cochesVendidos) {
                System.out.println("Coches vendidos: ");
                System.out.println("Marca: " + coche.getMarca());
                System.out.println("Modelo: " + coche.getModelo());
                System.out.println("Color: " + coche.getColor());
                System.out.println("Matrícula: " + coche.getMatricula());
                System.out.println("Precio de compra: " + coche.getPrecioCompra());
                System.out.println("Precio de venta: " + coche.getPrecioVenta());
                System.out.println();
            }
        }
    }

    public int sueldoAComision(){
        return cochesVendidos.size() * 200;
    }

}
