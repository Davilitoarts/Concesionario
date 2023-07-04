import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Concesionario {
    private HashMap<String, Cliente> clientes;
    private HashMap<String, VendedorAComision> vendedores;
    private HashMap<String, Coche> coches;
    private ArrayList<Exposicion> exposiciones;

    public Concesionario(HashMap<String, Cliente> clientes, HashMap<String, VendedorAComision> vendedores, HashMap<String, Coche> coches, ArrayList<Exposicion> exposiciones) {
        this.clientes = clientes;
        this.vendedores = vendedores;
        this.coches = coches;
        this.exposiciones = exposiciones;

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

    public ArrayList<Exposicion> getExposiciones() {
        return exposiciones;
    }

    public void setExposiciones(ArrayList<Exposicion> exposiciones) {
        this.exposiciones = exposiciones;
    }

    public void clientes() { //Aquí agrego clientes base

        clientes.put("36354641G", new Cliente("Pepe", "C/Sevilla", "36354641G", 634657584));
        clientes.put("26539704W", new Cliente("Lucía", "C/Málaga", "26539704W", 624378512));

    }

    public void agregarCliente() { //Este servirá para agregar un cliente por scanner
        Scanner añadirCliente = new Scanner(System.in);
        System.out.println("Introduzca los datos del cliente: ");
        System.out.println("Introduzca su nombre: ");
        String nombre = añadirCliente.nextLine();
        System.out.println("Introduzca su dirección: ");
        String direccion = añadirCliente.nextLine();
        System.out.println("Introduzca su DNI: ");
        String dni = añadirCliente.nextLine();
        System.out.println("Introduzca su número de teléfono: ");
        int telefono = añadirCliente.nextInt();
        // if(nuevoTeléfono < 99999999 && nuevoTeléfono > 999999999) throw new Exception("El nuevo teléfono no puede ser menor ni mayor a 9 cifras");

        clientes.put(dni, new Cliente(nombre, direccion, dni, telefono));
    }

    public void removeCliente() { //Este servirá para eliminar un cliente por scanner
        Scanner removeCliente = new Scanner(System.in);
        System.out.println("Introduce el DNI del cliente a dar de baja: ");
        String dni = removeCliente.nextLine();
        clientes.remove(dni);
    }

    public void imprimirDatosCliente() {
        for (Map.Entry<String, Cliente> altaClientes : clientes.entrySet()) {
            Cliente cliente = altaClientes.getValue();
            System.out.println("Datos del cliente: ");
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Dirección: " + cliente.getDireccion());
            System.out.println("DNI: " + cliente.getDNI());
            System.out.println("Teléfono: " + cliente.getTelefono());
            System.out.println("------------------------");
        }
    }

    public void vendedores() { //Aquí agrego vendedores base
        vendedores.put("07317266F", new VendedorAComision("Mariano", "Avd. Las Flores", "07317266F", 671365975));
        vendedores.put("53187645H", new VendedorAComision("Carlota", "C/Mayor", "53187645H", 654059348));

    }

    public void agregarVendedor() { //Este servirá para agregar un vendedor por scanner
        Scanner añadirVendedor = new Scanner(System.in);
        System.out.println("Introduzca los datos del cliente: ");
        System.out.println("Introduzca su nombre: ");
        String nombre = añadirVendedor.nextLine();
        System.out.println("Introduzca su dirección: ");
        String direccion = añadirVendedor.nextLine();
        System.out.println("Introduzca su DNI: ");
        String dni = añadirVendedor.nextLine();
        System.out.println("Introduzca su número de teléfono: ");
        int telefono = añadirVendedor.nextInt();
        // if(nuevoTeléfono < 99999999 && nuevoTeléfono > 999999999) throw new Exception("El nuevo teléfono no puede ser menor ni mayor a 9 cifras");

        vendedores.put(dni, new VendedorAComision(nombre, direccion, dni, telefono));
    }

    public void removeVendedor() { //Este servirá para eliminar un vendedor por scanner
        Scanner removeVendedor = new Scanner(System.in);
        System.out.println("Introduce el DNI del vendedor a dar de baja: ");
        String dni = removeVendedor.nextLine();
        vendedores.remove(dni);
    }
    public void imprimirDatosVendedor() {
        for (Map.Entry<String, VendedorAComision> altaVendedor : vendedores.entrySet()) {
            VendedorAComision vendedores = altaVendedor.getValue();
            System.out.println("Datos del vendedor: ");
            System.out.println("Nombre: " + vendedores.getNombre());
            System.out.println("Dirección: " + vendedores.getDireccion());
            System.out.println("DNI: " + vendedores.getDNI());
            System.out.println("Teléfono: " + vendedores.getTelefono());
            System.out.println("------------------------");
        }
    }

    public void agregarCoche() { //Este servirá para agregar un coche por scanner
        Scanner añadirCoche = new Scanner(System.in);
        System.out.println("Introduzca los datos del coche a añadir: ");
        System.out.println("Marca: ");
        String marca = añadirCoche.nextLine();
        System.out.println("Modelo: ");
        String modelo = añadirCoche.nextLine();
        System.out.println("Color: ");
        String color = añadirCoche.nextLine();
        System.out.println("Tipo: ");
        String tipo = añadirCoche.nextLine();
        System.out.println("Estado: ");
        String estado = añadirCoche.nextLine();
        System.out.println("Matrícula: ");
        String matricula = añadirCoche.nextLine();
        System.out.println("Precio de compra: ");
        float precioCompra = añadirCoche.nextFloat();
        System.out.println("Precio de venta: ");
        float precioVenta = añadirCoche.nextFloat();

        coches.put(matricula, new Coche(marca, modelo, color, tipo, estado, matricula, precioCompra, precioVenta));
    }

    public void removeCoche() { //Este servirá para eliminar un coche por scanner
        Scanner removeCoche = new Scanner(System.in);
        System.out.println("Introduce la matrícula del coche a eliminar: ");
        String matricula = removeCoche.nextLine();
        coches.remove(matricula);
    }

    public void queCliente() {
    }

    public void queCoches() {
    }

    public HashMap<String, Coche> cochesStock() {
        Coche coche1 = new Coche("Seat", "Ibiza", "blanco", "turismo", "en venta", "2452GVW", 15000f, 6000f);
        Coche coche2 = new Coche("Audi", "Q8", "negro", "turismo", "en venta", "1648TBD", 85.000f, 38.000f);

        coches.put("2452GVW", coche1);
        coches.put("1648TBD", coche2);
        return coches;
    }

    public void imprimirStock(HashMap<String, Coche> cochesStock) {
        if (cochesStock.isEmpty()) {
            System.out.println("No hay coches en stock");
        } else {
            for (Coche stock : cochesStock.values()) {
                System.out.println("Coches en venta: ");
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

    public void venderCoche(Coche coche, Cliente cliente) {
        if (coches.containsKey(coche)) { //Comprueba si el coche está en ArrayList cochesStock

            cliente.agregarCocheComprado(coche); // el coche que se compra se agrega al método agregarCocheComprado de la clase Cliente
            coches.remove(coche); //y aquí se elimina el coche del arraylist cochesStock

            System.out.println("El coche " + coche.getMarca() + " " + coche.getModelo() + " con matrícula " + coche.getMatricula() + " ha sido vendido al cliente: " + cliente.getNombre());
        } else {
            System.out.println("El coche no está disponible en el stock del concesionario.");
        }
    }

    public void reservarCoche(Coche coche, Cliente cliente) {
        if (coches.containsKey(coche)) { //Comprueba si el coche está en mi arraylist cochesStock

            cliente.agregarCocheReservado(coche); //el coche reservado se agrega al método agregarCocheReservado de la clase Cliente


            System.out.println("El coche " + coche.getMarca() + " " + coche.getModelo() + " con matrícula " + coche.getMatricula() + " ha sido reservado al cliente: " + cliente.getNombre());
        } else {
            System.out.println("El coche no está disponible en el stock del concesionario.");
        }
    }

    public void cambiarExposicion(Coche coche, Exposicion exposicion) {
    }

    public void consola(){

    }

    public void imprimirDatosCoches() {
    }
}
