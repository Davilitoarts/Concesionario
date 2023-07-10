import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Concesionario {
    private HashMap<String, Cliente> clientes;
    private HashMap<String, VendedorAComision> vendedores;
    private HashMap<String, Coche> coches;
    private HashMap<Coche, Cliente> compras;
    private ArrayList<Exposicion> exposiciones;

    public Concesionario() { // Creo los hashmap vacíos y llamando a los métodos se agregan de base
        clientes = new HashMap<>();
        clientes();
        vendedores = new HashMap<>();
        vendedores();
        coches = new HashMap<>();
        cochesStock();
        compras = new HashMap<>();
        exposiciones = new ArrayList<>();
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

    public HashMap<Coche, Cliente> getCompras() {
        return compras;
    }

    public void setCompras(HashMap<Coche, Cliente> compras) {
        this.compras = compras;
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

    public Cliente obtenerCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el DNI del cliente: ");
        String dni = scanner.nextLine();

        if (getClientes().containsKey(dni)) {
            return getClientes().get(dni);
        } else {
            System.out.println("El cliente con DNI " + dni + " no existe en el concesionario.");
            System.out.println("Si quiere darse de alta como cliente introduce 1: ");

            return obtenerCliente();
        }
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

    public VendedorAComision obtenerVendedor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el DNI del vendedor: ");
        String dni = scanner.nextLine();

        if (getVendedores().containsKey(dni)) {
            return getVendedores().get(dni);
        } else {
            System.out.println("El vendedor con DNI " + dni + " no existe en el concesionario.");
            System.out.println("Si quiere darse de alta como vendedor introduce 1: ");

            return obtenerVendedor();
        }
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
        String tipo = "x";
        System.out.println("Introduce el tipo de coche a añadir siendo 1-Turismo, 2-Industrial o 3-Todoterreno: ");
        int num = añadirCoche.nextInt();
        añadirCoche.nextLine();
        if (num == 1) tipo = "Turismo";
        if (num == 2) tipo = "Industrial";
        if (num == 3) tipo = "Todoterreno";
        System.out.println("Introduzca los datos del coche a añadir: ");
        System.out.println("Marca: ");
        String marca = añadirCoche.nextLine();
        System.out.println("Modelo: ");
        String modelo = añadirCoche.nextLine();
        System.out.println("Color: ");
        String color = añadirCoche.nextLine();
        String estado = "en venta";
        System.out.println("Matrícula: ");
        String matricula = añadirCoche.nextLine();
        System.out.println("Precio de compra: ");
        float precioCompra = añadirCoche.nextFloat();
        System.out.println("Precio de venta: ");
        float precioVenta = añadirCoche.nextFloat();

        if (num == 1)
            coches.put(matricula, new Turismo(tipo, marca, modelo, color, estado, matricula, precioCompra, precioVenta));
        if (num == 2)
            coches.put(matricula, new Industrial(tipo, marca, modelo, color, estado, matricula, precioCompra, precioVenta));
        if (num == 3)
            coches.put(matricula, new Todoterreno(tipo, marca, modelo, color, estado, matricula, precioCompra, precioVenta));
    }

    public void removeCoche() { //Este servirá para eliminar un coche por scanner
        Scanner removeCoche = new Scanner(System.in);
        System.out.println("Introduce la matrícula del coche a eliminar: ");
        String matricula = removeCoche.nextLine();
        coches.remove(matricula);
    }

    public void registrarVenta(Coche coche, Cliente cliente) {
        compras.put(coche, cliente);
    }

    public HashMap<Coche, Cliente> clientesCompradores() {
        return compras;
    }

    public void queCoches() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce un dni para consultar datos de los coches: ");
        String dni = scanner.nextLine();
        if (clientes.containsKey(dni)) {
            Cliente cliente = clientes.get(dni);
            cliente.imprimirCochesComprados();
            cliente.imprimirCochesReservados();
        }
        if (vendedores.containsKey(dni)) {
            VendedorAComision vendedor = vendedores.get(dni);
            vendedor.imprimirCochesVendidos();
        }
    }

    public HashMap<String, Coche> cochesStock() {
        Turismo coche1 = new Turismo("turismo", "Seat", "Ibiza", "blanco", "en venta", "2452GVW", 15000f, 6000f);
        Turismo coche2 = new Turismo("turismo", "Audi", "Q8", "negro", "en venta", "1648TBD", 85000f, 38000f);

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

    public void venderCoche() {
        Scanner venta = new Scanner(System.in);
        System.out.println("Introduce la matrícula del coche a vender: ");
        String matricula = venta.nextLine();

        if (coches.containsKey(matricula)) { // Comprueba si el coche está en el HashMap de coches del concesionario
            Coche coche = getCoches().get(matricula); // Obtiene el coche del HashMap de coches

            Cliente cliente = obtenerCliente(); // Obtén el cliente de alguna manera, por ejemplo, a través de la entrada del usuario o consultando el concesionario
            VendedorAComision vendedor = obtenerVendedor();

            vendedor.agregarCocheVendido(coche);
            cliente.agregarCocheComprado(coche); // Agrega el coche al método agregarCocheComprado de la clase Cliente
            getCoches().remove(matricula); // Elimina el coche del HashMap de coches del concesionario
            System.out.println("El coche " + coche.getMarca() + " " + coche.getModelo() + " con matrícula " + coche.getMatricula() + " ha sido vendido al cliente: " + cliente.getNombre());
        } else {
            System.out.println("El coche no está disponible en el stock del concesionario.");
        }
    }

    public void reservarCoche() {
        Scanner reserva = new Scanner(System.in);
        System.out.println("Introduce la matrícula del coche a reservar: ");
        String matricula = reserva.nextLine();

        if (getCoches().containsKey(matricula)) { // Comprueba si el coche está en el HashMap de coches del concesionario
            Coche coche = getCoches().get(matricula); // Obtiene el coche del HashMap de coches

            Cliente cliente = obtenerCliente(); // Obtén el cliente de alguna manera, por ejemplo, a través de la entrada del usuario o consultando el concesionario

            cliente.agregarCocheReservado(coche); // Agrega el coche al método agregarCocheComprado de la clase Cliente
            getCoches().remove(matricula); // Elimina el coche del HashMap de coches del concesionario
            System.out.println("El coche " + coche.getMarca() + " " + coche.getModelo() + " con matrícula " + coche.getMatricula() + " ha sido reservado por el cliente: " + cliente.getNombre());
            cliente.imprimirCochesReservados();
        } else {
            System.out.println("El coche no está disponible en el stock del concesionario.");
        }
    }

    public void cambiarExposicion(Coche coche, Exposicion exposicion) {
    }

    public void consola() {
        boolean infinito = true;
        Scanner consola = new Scanner(System.in);
        while (infinito == true) {
            System.out.println("Bienvenido a Concesionarios Pochaula");
            System.out.println("Para entrar como cliente pulsa 1");
            System.out.println("Para entrar como vendedor pulsa 2");
            System.out.println("Para entrar como director pulsa 3");
            System.out.println("Para salir del menú pulsa 4");
            int numero = consola.nextInt();
            if (numero == 4) infinito = false;
            if(numero == 1){
                System.out.println("Para consultar los coches que tenemos en stock pulse 1.");
            }
        }


    }
}
