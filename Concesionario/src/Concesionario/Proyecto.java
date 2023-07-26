package Concesionario;

import java.util.Scanner;

import Clases.*;
import Excepciones.InvalidException;
import Scanners.*;

public class Proyecto {

    public Proyecto() {}

    public static void menu(Concesionario concesionario) {
        try {

            ScannerCliente clientes = new ScannerCliente(concesionario);
            ScannerVendedor vendedores = new ScannerVendedor(concesionario);
            ScannerMecanico mecanicos = new ScannerMecanico(concesionario);
            ScannerDirector director = new ScannerDirector(concesionario);
            Scanner consola = new Scanner(System.in);

            int num = 0;
            while (num != 5) {
                System.out.println("********************************");
                System.out.println("** Bienvenido a Concesionario **");
                System.out.println("********************************");
                System.out.println("*** MENÚ PRINCIPAL ***");
                System.out.println("1- MENÚ DEL CLIENTE");
                System.out.println("2- MENÚ DEL VENDEDOR");
                System.out.println("3- MENÚ DEL MECÁNICO");
                System.out.println("4- MENÚ DEL DIRECTOR");
                System.out.println("5- SALIR");
                System.out.print("Elija una de estas opciones: ");
                num = consola.nextInt();
                if (num == 1) {clientes.consolaClientes();
                } else if (num == 2) {
                    vendedores.consolaVendedor();
                } else if (num == 3) {
                    mecanicos.consolaMecanico();
                } else if (num == 4) {
                    director.director();
                } else if (num == 5) {
                    System.out.println("Saliendo del programa...");
                } else {
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                }
            }
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws InvalidException {
        Concesionario concesionario = new Concesionario();
        menu(concesionario);
    }
}


