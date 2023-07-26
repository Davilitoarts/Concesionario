package Scanners;

import Clases.*;
import Comprobaciones.String.ComprobarMatricula;
import Excepciones.InvalidException;
import Excepciones.NotFoundException;

import javax.swing.*;
import java.util.*;


import static Concesionario.Proyecto.menu;

public class ScannerReparacion {
    private Concesionario concesionario;
    private HashMap<String, Coche> coches;
    private HashMap<String, Mecanico> mecanicos;
    private ComprobarMatricula comprobarMatricula = new ComprobarMatricula();

    public ScannerReparacion(Concesionario concesionario) throws InvalidException {
        this.concesionario = concesionario;
        this.coches = concesionario.getCoches();
        this.mecanicos = concesionario.getMecanicos();
    }

    public void agregarReparacion() {
        try {
            Scanner scanner = new Scanner(System.in);
            concesionario.imprimirStock();
            System.out.print("Introduce la matrícula del coche que tiene que ser reparado: ");
            String matricula = scanner.nextLine();
            comprobarMatricula.comprobacion(matricula);
            if (coches.containsKey(matricula)) {
                Coche coche = coches.get(matricula);
                System.out.println("Introduce la reparación a añadir: ");
                System.out.print("Selecciona el tipo de reparación: 1- Mecanica / 2- Electrica / 3- Chapa / 4- Revisión ");
                int opcion = scanner.nextInt();
                TipoReparacion tipo = null;
                if (opcion == 1) tipo = TipoReparacion.MECANICA;
                if (opcion == 2) tipo = TipoReparacion.ELECTRICA;
                if (opcion == 3) tipo = TipoReparacion.CHAPA;
                if (opcion == 4) tipo = TipoReparacion.REVISION;
                System.out.print("Fecha de la reparación: ");
                scanner.nextLine();
                String fecha = scanner.nextLine();
                Reparacion reparacion = new Reparacion(tipo, fecha, false);
                coche.setEstado(EstadoCoche.EN_REPARACION);
                coche.agregarCocheAReparar(reparacion);
                System.out.println("** Reparación añadida **");

            } else throw new NotFoundException("El coche no está en el stock del concesionario ");
        } catch (NotFoundException | InvalidException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }

    public void consultarReparacionesDeCoche() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduce la matrícula del coche a consultar reparaciones: ");
            String matricula = scanner.nextLine();
            comprobarMatricula.comprobacion(matricula);
            if (coches.containsKey(matricula)) {
                Coche coche = coches.get(matricula);
                if (!coche.getReparaciones().isEmpty()) {
                    coche.imprimirReparaciones();
                } else throw new InvalidException("El coche no tiene ninguna reparación");
            } else throw new NotFoundException("El coche introducido no está en el stock del concesionario");
        } catch (NotFoundException | InvalidException notFound) {
            System.out.println(notFound.getMessage());
            menu(concesionario);
        }
    }

    public void consolaTaller() {
        try {
            Scanner taller = new Scanner(System.in);
            System.out.println("**************");
            System.out.println("*** TALLER ***");
            System.out.println("**************");
            System.out.println("1-AGREGAR UNA REPARACIÓN");
            System.out.println("2-CONSULTAR REPARACIONES");
            System.out.println("3-MENÚ PRINCIPAL");
            System.out.print("Elija una de las opciones: ");
            int opcion = taller.nextInt();
            if (opcion < 1 || opcion > 3) throw new InvalidException("Debe elegir entre una de las opciones posibles");
            if (opcion == 1) agregarReparacion();
            if (opcion == 2) consultarReparacionesDeCoche();
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }
}
