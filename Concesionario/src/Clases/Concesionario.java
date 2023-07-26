package Clases;

import Excepciones.InvalidException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Concesionario {
    private HashMap<String, Cliente> clientes;
    private HashMap<String, VendedorAComision> vendedores;
    private HashMap<String, Mecanico> mecanicos;
    private HashMap<String, Coche> coches;
    private HashMap<String, Coche> reservas;
    private HashMap<String, String> ventas;
    private DirectorComercial director;
    private HashMap<Integer, Exposicion> exposiciones;

    public Concesionario() throws InvalidException {
        this.clientes = new HashMap<>();
        this.vendedores = new HashMap<>();
        this.mecanicos = new HashMap<>();
        this.coches = new HashMap<>();
        this.ventas = new HashMap<>();
        this.director = new DirectorComercial("Juan", "Álvarez", "C/Albaricoque", "12345678F", 666778899);
        exposiciones = new HashMap<>();


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

    public void agregarDirector(DirectorComercial director) {
        this.director = director;
    }

    public HashMap<String, Mecanico> getMecanicos() {
        return mecanicos;
    }

    public void setMecanicos(HashMap<String, Mecanico> mecanicos) {
        this.mecanicos = mecanicos;
    }

    public void setVentas(HashMap<String, String> ventas) {
        this.ventas = ventas;
    }

    public HashMap<String, Coche> getReservas() {
        return reservas;
    }

    public void setReservas(HashMap<String, Coche> reservas) {
        this.reservas = reservas;
    }

    public void agregarCliente(Cliente cliente) {
        clientes.put(cliente.getDNI(), cliente);
    }

    public void removeCliente(String dni) {
        clientes.remove(dni);
    }

    public void agregarVendedor(VendedorAComision vendedor) { // dar de alta a un vendedor
        vendedores.put(vendedor.getDNI(), vendedor);
    }

    public void removeVendedor(String dni) {
        vendedores.remove(dni);
    }
    public void agregarMecanico(Mecanico mecanico){
        mecanicos.put(mecanico.getDNI(), mecanico);
    }
    public void removeMecanico(String dni) {
        mecanicos.remove(dni);
    }

    public void agregarCoche(Coche coche) { // dar de alta a un coche
        coches.put(coche.getMatricula(), coche);
    }

    public void removeCoche(String matricula) { //Este servirá para eliminar un coche por scanner
        coches.remove(matricula);
    }



    public void agregarReserva (Coche coche){
        reservas.put(coche.getMatricula(), coche);
    }
    public void removeReserva(String matricula){
        reservas.remove(matricula);
    }




    public void registrarVenta(String matriculaCoche, String nombreCliente) {
        ventas.put(matriculaCoche, nombreCliente);
    }

    public String queCliente(String cliente) {
        return ventas.get(cliente);
    }


    public void llenar() throws InvalidException {
        clientes.put("12345678A", new Cliente ("Pepe", "Vaca", 23, "C/CULO", "12345678A", 987654321));
        coches.put("1234ABC", new Coche(TipoCoche.TURISMO, "Q", "Q", "Q", EstadoCoche.EN_VENTA, "1234ABC", 10000, 5000));
        coches.put("1234AAA", new Coche(TipoCoche.TURISMO, "K", "K", "K", EstadoCoche.EN_VENTA, "1234AAA", 1000, 500));
        vendedores.put("12345678B", new VendedorAComision("P","P", "P","12345678B", 123456789));
        vendedores.put("12345678C", new VendedorAComision("L","L", "L","12345678C", 123456788));

    }


    public void imprimirStock() {
        if (coches.isEmpty()) {
            System.out.println("No hay coches en stock");
        } else {
            System.out.println("Coches en venta: ");
            for (Coche stock : coches.values()) {
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
    public void imprimirCochesReservados() {
        try {
            System.out.println("*** COCHES RESERVADOS ***");
            if (!clientes.isEmpty()) {
                for (Cliente cliente : clientes.values()) {
                    for (Coche coche : cliente.getCochesReservados()) {
                        System.out.println("Tipo: " + coche.getTipo());
                        System.out.println("Marca: " + coche.getMarca());
                        System.out.println("Modelo: " + coche.getModelo());
                        System.out.println("Color: " + coche.getColor());
                        System.out.println("Estado: " + coche.getEstado());
                        System.out.println("Matrícula: " + coche.getMatricula());
                        System.out.println("-------------------------------");
                    }
                }
            } else throw new InvalidException("No existen clientes en el concesionario");
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
        }
    }
    public void imprimirClienteConReservas() {
        try {
            if (clientes.isEmpty()) {
                System.out.println("No hay clientes disponibles");
            } else {
                for (Cliente cliente : clientes.values()) {
                    System.out.println("Nombre: " + cliente.getNombre());
                    System.out.println("Apellido: " + cliente.getApellido());
                    System.out.println("Dirección: " + cliente.getDireccion());
                    System.out.println("DNI: " + cliente.getDNI());
                    System.out.println("Teléfono: " + cliente.getTelefono());
                    System.out.println("------------------------");
                    System.out.println("*** COCHES RESERVADOS ***");
                    if (!cliente.getCochesReservados().isEmpty()) {
                        for (Coche coche : cliente.getCochesReservados()) {
                            System.out.println("Tipo: " + coche.getTipo());
                            System.out.println("Marca: " + coche.getMarca());
                            System.out.println("Modelo: " + coche.getModelo());
                            System.out.println("Color: " + coche.getColor());
                            System.out.println("Estado: " + coche.getEstado());
                            System.out.println("Matrícula: " + coche.getMatricula());
                            System.out.println("-------------------------------");
                        }
                    } else throw new InvalidException("Este cliente no tiene coches reservados");
                }
            }
        } catch (InvalidException e){
            System.out.println(e.getMessage());
        }
    }

    public void agregarExposicion(Exposicion exposicion) {
        exposiciones.put(exposicion.getNumExposicion(), exposicion);
    }

    public void removeExposicion(int numExpo) {
        exposiciones.remove(numExpo);
    }

    public void imprimirExposiciones() {
        if (exposiciones.isEmpty()) {
            System.out.println("No hay exposiciones disponibles");
        } else {
            System.out.println("*** LISTA DE EXPOSICIONES ***");
            for (Exposicion exposicion : exposiciones.values()) {
                System.out.println("Número de exposición: " + exposicion.getNumExposicion());
                System.out.println("Dirección : " + exposicion.getDireccion());
                System.out.println("Teléfono : " + exposicion.getTelefono());
            }
        }
    }

    public void imprimirVentas() {
        if (ventas.isEmpty()) {
            System.out.println("No hay coches en stock");
        } else {
            for (String nombre : ventas.values()) {
                System.out.println(nombre);
            }
        }
    }
    public void imprimirClientes(){
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes disponibles");
        } else {
            System.out.println("*** LISTA DE CLIENTES ***");
            for (Cliente cliente : clientes.values()) {
                System.out.println("Nombre: " + cliente.getNombre());
                System.out.println("Apellido: " + cliente.getApellido());
                System.out.println("Dirección: " + cliente.getDireccion());
                System.out.println("DNI: " + cliente.getDNI());
                System.out.println("Teléfono: " + cliente.getTelefono());
                System.out.println("------------------------");
            }
        }
    }
    public void imprimirVendedores(){
        if (vendedores.isEmpty()) {
            System.out.println("No hay vendedores disponibles");
        } else {System.out.println("*** LISTA DE VENDEDORES ***");
            for (VendedorAComision vendedor : vendedores.values()) {
                System.out.println("Nombre: " + vendedor.getNombre());
                System.out.println("DNI: " + vendedor.getDNI());
                System.out.println("------------------------");
            }
        }
    }
    public List<VendedorAComision> listadoPorTotalVendido() {
        List<VendedorAComision> sueldos = new ArrayList<>();

        if (vendedores.isEmpty()) {
            System.out.println("No existen vendedores en el concesionario");
        } else {
            System.out.println("*** LISTA DE VENDEDORES ***");
            for (VendedorAComision vendedor : vendedores.values()) {
                sueldos.add(vendedor);
            }

            // Ordenar la lista de vendedores por volumen total de ventas realizadas (de mayor a menor)
            Collections.sort(sueldos, Comparator.comparing(VendedorAComision::getVolumenVentas).reversed());

            for (VendedorAComision vendedor : sueldos) {
                System.out.println("Nombre: " + vendedor.getNombre() + " " + vendedor.getApellido());
                System.out.println("Dirección: " + vendedor.getDireccion());
                System.out.println("DNI: " + vendedor.getDNI());
                System.out.println("Teléfono: " + vendedor.getTelefono());
                System.out.println("Ha vendido: " + vendedor.getNumeroVentas() + " unidades");
                System.out.println("Cantidad total vendida en €: " + vendedor.getVolumenVentas());
                System.out.println("El sueldo es de: " + vendedor.sueldoAComision());
                System.out.println("------------------------");
            }
        }

        return sueldos; // Devolver la lista ordenada de vendedores
    }
    public void imprimirMecanicos(){
        if (mecanicos.isEmpty()) {
            System.out.println("No hay mecánicos disponibles");
        } else {
            System.out.println("*** LISTA DE MECÁNICOS ***");
            for (Mecanico mecanico : mecanicos.values()) {
                System.out.println("Nombre: " + mecanico.getNombre());
                System.out.println("Apellido: " + mecanico.getApellido());
                System.out.println("Dni: " + mecanico.getDNI());
            }
        }
    }

    public void consultarCochesAReparar() {
        ArrayList<Coche> coches1 = new ArrayList<>();
        for (Coche coche : coches.values()) {
            coches1.add(coche);
        }
        for (Coche coche : coches1) {
            if (coche.getEstado() == EstadoCoche.EN_REPARACION) {
                coche.imprimirReparaciones();
            }
        }
    }
}

