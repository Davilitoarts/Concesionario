import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Cliente extends Persona {

    private ArrayList<Coche> cochesComprados;
    private ArrayList<Coche> cochesReservados;

    private Concesionario concesionario;

    public Cliente(String nombre, String direccion, String DNI, int telefono) { // lo que pido para crear un cliente
        super(nombre, direccion, DNI, telefono);
        cochesComprados = new ArrayList<>();
        // inicializo los dos arrays vacíos
        cochesReservados = new ArrayList<>();
    }

    public ArrayList<Coche> getCochesComprados() {
        return cochesComprados;
    }

    public void setCochesComprados(ArrayList<Coche> cochesComprados) {
        this.cochesComprados = cochesComprados;
    }

    public ArrayList<Coche> getCochesReservados() {
        return cochesReservados;
    }

    public void setCochesReservados(ArrayList<Coche> cochesReservados) {
        this.cochesReservados = cochesReservados;
    }

    public void agregarCocheComprado(Coche coche) {
        cochesComprados.add(coche);
        coche.setEstado("comprado");
    }


    public void agregarCocheReservado(Coche coche) {
        cochesReservados.add(coche);
        coche.setEstado("reservado");

    }

    public void imprimirCochesComprados() {
        if (cochesComprados.isEmpty()) { //Comprueba si el arraylist cochesComprados está vacío y si lo está entra por aquí:
            System.out.println("No existen coches comprados");
        } else { //Si no está vacío entra por aquí:
            for (Coche coche : cochesComprados) {
                System.out.println("Coches comprados: ");
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

    public void imprimirCochesReservados() {
        if (cochesReservados.isEmpty()) { //Comprueba si el arraylist cochesComprados está vacío y si lo está entra por aquí:
            System.out.println("No existen coches reservados");
        } else { //Si no está vacío entra por aquí:
            for (Coche coche : cochesReservados) {
                System.out.println("Coches reservados: ");
                System.out.println("Marca: " + coche.getMarca());
                System.out.println("Modelo: " + coche.getModelo());
                System.out.println("Matrícula: " + coche.getMatricula());
                System.out.println("Precio de compra: " + coche.getPrecioCompra());
                System.out.println("Precio de venta: " + coche.getPrecioVenta());
                System.out.println();
            }
        }
    }
    public void modificarCliente(){
        Scanner cliente = new Scanner(System.in);
        System.out.println("Introduzca los nuevos datos para el cliente con DNI " + getDNI() + ": ");
        System.out.println("Introduzca su nuevo nombre: ");
        String nuevoNombre = cliente.nextLine();
        setNombre(nuevoNombre);
        System.out.println("Introduzca su nueva dirección: ");
        String nuevaDireccion = cliente.nextLine();
        setDireccion(nuevaDireccion);
        System.out.println("Introduzca su nuevo teléfono: ");
        int nuevoTeléfono = cliente.nextInt();
        // if(nuevoTeléfono < 99999999 && nuevoTeléfono > 999999999) throw new Exception("El nuevo teléfono no puede ser menor ni mayor a 9 cifras");
        setTelefono(nuevoTeléfono);


    }
    public void imprimirDatosCliente(){
        System.out.println("Nombre del cliente: " + getNombre());
        System.out.println("Dirección del cliente: " + getDireccion());
        System.out.println("DNI del cliente: " + getDNI());
        System.out.println("Teléfono del cliente: " + getTelefono());
        System.out.println("------------------------");
    }
}
