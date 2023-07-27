package Scanners;

import Clases.Cliente;
import Clases.Coche;
import Clases.Concesionario;
import Clases.Reparacion;
import Comprobaciones.Int.ComprobarEdad;
import Comprobaciones.Int.ComprobarTlf;
import Comprobaciones.String.ComprobarDNI;
import Comprobaciones.String.ComprobarDireccion;
import Comprobaciones.String.ComprobarNombre;
import Excepciones.InvalidException;
import Excepciones.NotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


import static Concesionario.Proyecto.menu;

public class ScannerCliente {
    private Concesionario concesionario;
    private HashMap<String, Cliente> clientes;
    private ComprobarNombre comprobarNombre = new ComprobarNombre();
    private ComprobarEdad comprobarEdad = new ComprobarEdad();
    private ComprobarDireccion comprobarDireccion = new ComprobarDireccion();
    private ComprobarDNI comprobarDNI = new ComprobarDNI();
    private ComprobarTlf comprobarTlf = new ComprobarTlf();


    public ScannerCliente(Concesionario concesionario) throws InvalidException {
        this.concesionario = concesionario;
        this.clientes = concesionario.getClientes();

    }

    public void agregarCliente() {
        try {
            Scanner cliente = new Scanner(System.in);
            System.out.println("Introduzca los datos del cliente: ");
            System.out.print("Nombre: ");
            String nombre = cliente.nextLine();
            comprobarNombre.comprobacion(nombre);

            System.out.print("Apellido: ");
            String apellido = cliente.nextLine();
            comprobarNombre.comprobacion(apellido);

            System.out.print("Edad: ");
            int edad = cliente.nextInt();
            comprobarEdad.comprobacion(edad);

            System.out.print("Dirección: ");
            cliente.nextLine();
            String direccion = cliente.nextLine();
            comprobarDireccion.comprobacion(direccion);

            System.out.print("DNI (Introducir 8 dígitos y una letra en mayúscula) : ");
            String dni = cliente.nextLine();
            if(!concesionario.validarDni(dni)) throw new InvalidException("El dni introducido no puede estar repetido");
            comprobarDNI.comprobacion(dni);

            System.out.print("Número de teléfono: ");
            int telefono = cliente.nextInt();
            comprobarTlf.comprobacion(telefono);

            concesionario.agregarCliente(new Cliente(nombre, apellido, edad, direccion, dni, telefono));
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }

    public void removeCliente() {

        try {
            Scanner removeCliente = new Scanner(System.in);
            concesionario.imprimirClientes();
            System.out.print("Introduce el DNI del cliente a dar de baja: ");
            String dni = removeCliente.nextLine();
            comprobarDNI.comprobacion(dni);
            Cliente cliente = concesionario.getClientes().get(dni);
            if (clientes.containsKey(dni)) {
                if (cliente.getCochesComprados().isEmpty() && cliente.getCochesReservados().isEmpty()) {
                    concesionario.removeCliente(dni);
                    System.out.println("El cliente se ha eliminado correctamente");
                } else throw new InvalidException("El cliente no se puede eliminar ya que tiene coches reservados y/o comprados");
            } else throw new NotFoundException("El cliente no está registrado en el concesionario");
        } catch (InvalidException | NotFoundException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }

    public void imprimirDatosCliente() {
        try {
            Scanner scanner = new Scanner(System.in);
            concesionario.imprimirClientes();
            System.out.print("Introduce el dni para imprimir los datos del cliente:");
            String dni = scanner.nextLine();
            comprobarDNI.comprobacion(dni);
            HashMap<String, Cliente> clientes = concesionario.getClientes();
            if (clientes.containsKey(dni)) {
                Cliente cliente = clientes.get(dni);
                System.out.println("Datos del cliente: ");
                System.out.println("Nombre: " + cliente.getNombre());
                System.out.println("Apellido: " + cliente.getApellido());
                System.out.println("Dirección: " + cliente.getDireccion());
                System.out.println("DNI: " + cliente.getDNI());
                System.out.println("Teléfono: " + cliente.getTelefono());
                System.out.println("------------------------");
            } else throw new NotFoundException("Este cliente no está dado de alta");
        } catch (NotFoundException | InvalidException n) {
            System.out.println(n.getMessage());
            menu(concesionario);
        }
    }

    public void scannerCochesComprados() {
        try {
            Scanner scanner = new Scanner(System.in);
            concesionario.imprimirClientes();
            System.out.print("Introduce el dni del cliente:");
            String dni = scanner.nextLine();
            comprobarDNI.comprobacion(dni);
            if (clientes.containsKey(dni)) {
                Cliente cliente = clientes.get(dni);
                ArrayList<Coche> compras = cliente.getCochesComprados();
                if (compras.isEmpty()) {
                    throw new InvalidException("No existen coches comprados");
                } else {
                    for (Coche coche : compras) {
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
            } else throw new NotFoundException("El cliente no está dado de alta");

        } catch (InvalidException | NotFoundException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }

    public void scannerCochesReservados() {
        try {
            Scanner scanner = new Scanner(System.in);
            concesionario.imprimirClientes();
            System.out.print("Introduce el dni del cliente:");
            String dni = scanner.nextLine();
            comprobarDNI.comprobacion(dni);
            if (clientes.containsKey(dni)) {
                Cliente cliente = clientes.get(dni);
                ArrayList<Coche> reservas = cliente.getCochesReservados();
                if (reservas.isEmpty()) {
                    throw new InvalidException("No existen coches reservados");
                } else {
                    System.out.println("Coches reservados: ");
                    for (Coche coche : reservas) {
                        ArrayList<Reparacion> reparaciones = coche.getReparaciones();
                        System.out.println("Marca: " + coche.getMarca());
                        System.out.println("Modelo: " + coche.getModelo());
                        System.out.println("Color: " + coche.getColor());
                        System.out.println("Matrícula: " + coche.getMatricula());
                        System.out.println("Precio de compra: " + coche.getPrecioCompra());
                        System.out.println("Precio de venta: " + coche.getPrecioVenta());
                        if (reparaciones.size() == 0)
                            throw new InvalidException("Este coche no tiene reparaciones pendientes");
                        else for (Reparacion reparacion : reparaciones) {
                            System.out.println("Reparaciones:" + reparacion.toString());
                        }
                        System.out.println();
                    }
                }
            } else throw new NotFoundException("El cliente no está dado de alta");
        } catch (InvalidException | NotFoundException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }

    public void modificarCliente() {
        try {
            Scanner scanner = new Scanner(System.in);
            concesionario.imprimirClientes();
            System.out.print("Introduce el dni del cliente a modificar datos:");
            String dni = scanner.nextLine();
            comprobarDNI.comprobacion(dni);
            if (clientes.containsKey(dni)) {
                Cliente cliente = clientes.get(dni);
                System.out.println("Introduzca los nuevos datos para el cliente con DNI " + cliente.getDNI() + ": ");
                System.out.print("Dirección: ");
                String direccion = scanner.nextLine();
                comprobarDireccion.comprobacion(direccion);
                cliente.setDireccion(direccion);
                System.out.print("Teléfono: ");
                int telefono = scanner.nextInt();
                comprobarTlf.comprobacion(telefono);
                cliente.setTelefono(telefono);
            } else throw new NotFoundException("El cliente no está dado de alta");
        } catch (NotFoundException | InvalidException n) {
            System.out.println(n.getMessage());
            menu(concesionario);
        }
    }

    public void consolaClientes() {
        try {
            Scanner consola = new Scanner(System.in);
            int opcion = 0;
            while (opcion != 5) {
                System.out.println("*********************");
                System.out.println("*** MENÚ CLIENTES ***");
                System.out.println("*********************");
                System.out.println("1-CONSULTAR COCHES EN STOCK");
                System.out.println("2-CONSULTA EXPOSICIONES");
                System.out.println("3-CONSULTAR COCHES COMPRADOS");
                System.out.println("4-CONSULTAR COCHES RESERVADOS");
                System.out.println("5-MENU PRINCIPAL");
                System.out.print("Elija una de las opciones: ");
                opcion = consola.nextInt();
                if (opcion < 1 || opcion > 5){
                    System.out.println("*** ERROR ***");
                    throw new InvalidException("Debe elegir entre una de las opciones disponibles");
                }
                if (opcion == 1) concesionario.imprimirStock();
                if (opcion == 2) concesionario.imprimirExposiciones();
                if (opcion == 3) scannerCochesComprados();
                if (opcion == 4) scannerCochesReservados();
                if (opcion == 5)  menu(concesionario);

            }
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }
}

