package Scanners;

import Clases.Cliente;
import Clases.Coche;
import Clases.Concesionario;
import Clases.VendedorAComision;
import Comprobaciones.String.ComprobarDNI;
import Comprobaciones.String.ComprobarMatricula;
import Excepciones.InvalidException;
import Excepciones.NotFoundException;

import java.util.HashMap;
import java.util.Scanner;

import static Concesionario.Proyecto.menu;

public class ScannerConcesionario {
    private Concesionario concesionario;
    private HashMap<String, Cliente> clientes;
    private HashMap<String, VendedorAComision> vendedores;
    private HashMap<String, Coche> coches;
    private HashMap<String, String> ventas;
    private ComprobarDNI comprobarDNI = new ComprobarDNI();
    private ComprobarMatricula comprobarMatricula = new ComprobarMatricula();

    public ScannerConcesionario(Concesionario concesionario) throws InvalidException {
        this.concesionario = concesionario;
        this.clientes = concesionario.getClientes();
        this.vendedores = concesionario.getVendedores();
        this.ventas = concesionario.getVentas();
    }

    public void queCliente() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduce la matrícula del coche a consultar: ");
            String matricula = scanner.nextLine();
            comprobarMatricula.comprobacion(matricula);
            if (ventas.containsKey(matricula)) {
                String nombreCliente = ventas.get(matricula);
                System.out.println("El coche ha sido comprado o reservado por " + nombreCliente);
            } else throw new NotFoundException("El coche no ha sido encontrado en el registro de ventas");
        } catch (NotFoundException | InvalidException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }

    public void queCoches() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduce el dni del vendedor para consultar sus coches vendidos: ");
            String dni = scanner.nextLine();
            comprobarDNI.comprobacion(dni);
            if (vendedores.containsKey(dni)) {
                VendedorAComision vendedor = vendedores.get(dni);
                vendedor.imprimirCochesVendidos();
            } else throw new NotFoundException("El vendedor no está registrado en el concesionario");
        } catch (NotFoundException | InvalidException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }

}
