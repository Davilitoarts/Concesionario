package Clases;

import Excepciones.InvalidException;

import java.util.HashMap;

public class Concesionario {
    private HashMap<String, Cliente> clientes;
    private HashMap<String, VendedorAComision> vendedores;
    private HashMap<String, Coche> coches;
    private HashMap<String, String> ventas;
    private DirectorComercial director;
    private HashMap<Integer, Exposicion> exposiciones;

    public Concesionario() throws InvalidException {
        this.clientes = new HashMap<>();
        this.vendedores = new HashMap<>();
        this.coches = new HashMap<>();
        this.ventas = new HashMap<>();
        this.director = new DirectorComercial("Juan", "Álvarez", "C/Albaricoque", "12345678F", 666778899);
        exposiciones = new HashMap<>();

    }
    public void agregarDirector(DirectorComercial director) {
        // Lógica para agregar el director a la lista de directores comerciales del concesionario.
    }
    public HashMap<String, Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(HashMap<String, Cliente> clientes) {
        this.clientes = clientes;
    }

    public HashMap<String, VendedorAComision> getVendedores() {
        return vendedores;
    }

    public void setVendedores(HashMap<String, VendedorAComision> vendedores) {
        this.vendedores = vendedores;
    }

    public HashMap<String, Coche> getCoches() {
        return coches;
    }

    public void setCoches(HashMap<String, Coche> coches) {
        this.coches = coches;
    }

    public HashMap<String, String> getVentas() {
        return ventas;
    }

    public HashMap<Integer, Exposicion> getExposiciones() {
        return exposiciones;
    }

    public void setExposiciones(HashMap<Integer, Exposicion> exposiciones) {
        this.exposiciones = exposiciones;
    }

    public DirectorComercial getDirector() {
        return director;
    }
    public void setDirector(DirectorComercial director) {
        this.director = director;
    }

    public void agregarCliente(Cliente cliente){
        clientes.put(cliente.getDNI(), cliente);
    }
    public void removeCliente(String dni){
        clientes.remove(dni);
    }
    public void agregarVendedor(VendedorAComision vendedor) { // dar de alta a un vendedor
        vendedores.put(vendedor.getDNI(), vendedor);
    }
    public void removeVendedor(String dni) {

        vendedores.remove(dni);
    }
    public void agregarCoche(Coche coche) { // dar de alta a un coche
        coches.put(coche.getMatricula(), coche);
    }
    public void removeCoche(String matricula) { //Este servirá para eliminar un coche por scanner
        coches.remove(matricula);
    }
    public void registrarVenta(String matriculaCoche, String nombreCliente){
        ventas.put(matriculaCoche, nombreCliente);
    }
    public String queCliente(String cliente){
        return ventas.get(cliente);
    }

    public void imprimirStock() {
        if (coches.isEmpty()) {
            System.out.println("No hay coches en stock");
        } else {
            for (Coche stock : coches.values()) {
                System.out.println("Coches en venta: ");
                System.out.println("Tipo: " + stock.getTipo());
                System.out.println("Marca: " + stock.getMarca());
                System.out.println("Modelo: " + stock.getModelo());
                System.out.println("Color: " + stock.getColor());
                System.out.println("Estado: " + stock.getEstado());
                System.out.println("Matrícula: " + stock.getMatricula());
                System.out.println("Precio de compra: " + stock.getPrecioCompra());
                System.out.println("Precio de venta: " + stock.getPrecioVenta());
                System.out.println();
            }
        }
    }

    public void agregarExposicion(Exposicion exposicion) {exposiciones.put(exposicion.getNumExposicion(), exposicion);}

    public void removeExposicion(int numExpo) {
        exposiciones.remove(numExpo); }

    public void imprimirVentas(){
        if (ventas.isEmpty()) {
            System.out.println("No hay coches en stock");
        } else {
            for (String nombre : ventas.values()) {
                System.out.println(nombre);
            }
        }
    }
}
