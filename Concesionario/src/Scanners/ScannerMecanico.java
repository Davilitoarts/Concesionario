package Scanners;

import Clases.*;
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

public class ScannerMecanico {

    private Concesionario concesionario;
    private HashMap<String, Coche> coches;
    private HashMap<String, Mecanico> mecanicos;
    private ComprobarNombre comprobarNombre = new ComprobarNombre();
    private ComprobarDireccion comprobarDireccion = new ComprobarDireccion();
    private ComprobarDNI comprobarDNI = new ComprobarDNI();
    private ComprobarTlf comprobarTlf = new ComprobarTlf();


    public ScannerMecanico(Concesionario concesionario) throws InvalidException {
        this.concesionario = concesionario;
        this.coches = concesionario.getCoches();
        this.mecanicos = concesionario.getMecanicos();

    }

    public void agregarMecanico() {
        Scanner agregarMecanico = new Scanner(System.in);
        try {
            System.out.println("Introduzca los datos del mecánico: ");
            System.out.print("Nombre: ");
            String nombre = agregarMecanico.nextLine();
            comprobarNombre.comprobacion(nombre);

            System.out.println("Apellido: ");
            String apellido = agregarMecanico.nextLine();
            comprobarNombre.comprobacion(apellido);

            System.out.print("Dirección: ");
            String direccion = agregarMecanico.nextLine();
            comprobarDireccion.comprobacion(direccion);

            System.out.print("DNI (Introducir 8 dígitos y una letra en mayúscula) : ");
            String dni = agregarMecanico.nextLine();
            if(!concesionario.validarDni(dni)) throw new InvalidException("El dni introducido no puede estar repetido");
            comprobarDNI.comprobacion(dni);

            System.out.print("Teléfono: ");
            int telefono = agregarMecanico.nextInt();
            comprobarTlf.comprobacion(telefono);
            Mecanico mecanico = new Mecanico(nombre, apellido, direccion, dni, telefono);
            concesionario.agregarMecanico(mecanico);
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }

    public void imprimirDatosMecanico() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce el dni del mecánico: ");
            String dni = scanner.nextLine();
            comprobarDNI.comprobacion(dni);
            if (mecanicos.containsKey(dni)) {
                Mecanico mecanico = mecanicos.get(dni);
                System.out.println("Datos del mecanico: ");
                System.out.println("Nombre: " + mecanico.getNombre());
                System.out.println("Apellido: " + mecanico.getApellido());
                System.out.println("Dirección: " + mecanico.getDireccion());
                System.out.println("DNI: " + mecanico.getDNI());
                System.out.println("Teléfono: " + mecanico.getTelefono());
                System.out.println("------------------------");
            } else throw new NotFoundException("Este mecánico no está dado de alta");
        } catch (NotFoundException | InvalidException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }

    public void modificarMecanico() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce el dni del mecánico a modificar datos: ");
            String dni = scanner.nextLine();
            comprobarDNI.comprobacion(dni);
            if (mecanicos.containsKey(dni)) {
                Mecanico mecanico = mecanicos.get(dni);
                System.out.println("Introduzca los nuevos datos para el mecánico con DNI " + mecanico.getDNI() + ": ");
                System.out.println("Dirección: ");
                String direccion = scanner.nextLine();
                mecanico.setDireccion(direccion);
                System.out.println("Teléfono: ");
                int telefono = scanner.nextInt();
                mecanico.setTelefono(telefono);
            } else throw new NotFoundException("El mecánico no está dado de alta");

        } catch (NotFoundException | InvalidException n) {
            System.out.println(n.getMessage());
            menu(concesionario);
        }
    }

    public void removeMecanico() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduce el DNI del mecánico a dar de baja: ");
            String dni = scanner.nextLine();
            comprobarDNI.comprobacion(dni);
            HashMap<String, Mecanico> mecanicos = concesionario.getMecanicos();
            if (mecanicos.containsKey(dni)) {
                Mecanico mecanico = mecanicos.get(dni);
                if(mecanico.getCochesReparados().isEmpty()){
                concesionario.removeMecanico(dni);
                } else throw new InvalidException("No se puede dar de baja a un mecánico que ha reparado coches");
            } else throw new NotFoundException("El mecánico no está dado de alta");
        } catch (NotFoundException | InvalidException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }

    public void repararCoche() {
        try {
            Scanner reparar = new Scanner(System.in);
            concesionario.imprimirMecanicos();
            System.out.println("Introduce el dni del mecánico que quieras que arregle tu vehículo: ");
            String dni = reparar.nextLine();
            if (mecanicos.containsKey(dni)) {
                Mecanico mecanico = mecanicos.get(dni);
                System.out.print("Introduce la matrícula del coche a reparar:");
                String matricula = reparar.nextLine();
                    if (coches.containsKey(matricula)) {
                        Coche coche = coches.get(matricula);
                        ArrayList<Reparacion> reparaciones = coche.getReparaciones();
                        if (!reparaciones.isEmpty()) {

                            for (Reparacion reparacion : reparaciones) {
                                reparacion.setResuelta(true);

                            }
                            mecanico.agregarCochesReparados(coche);
                            coche.setEstado(EstadoCoche.EN_VENTA);
                            System.out.println("Todas las reparaciones han sido corregidas");
                        } else throw new InvalidException("El coche no tiene reparaciones");
                    } else throw new NotFoundException("El coche no se encuentra en el stock del concesionario");
            }else throw new NotFoundException("El mecánico escogido no está dado de alta");
        }catch(InvalidException | NotFoundException e){
                System.out.println(e.getMessage());
                menu(concesionario);
            }
        }


    public void consolaMecanico() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("*************************");
            System.out.println("*** MENÚ DEL MECÁNICO ***");
            System.out.println("*************************");
            System.out.println("1-CONSULTAR COCHES A REPARAR");
            System.out.println("2-REPARAR COCHE");
            System.out.println("3-MENÚ PRINCIPAL");
            System.out.print("Elija una de las opciones: ");
            int opcion = scanner.nextInt();
            if (opcion < 1 || opcion > 3) throw new InvalidException("Elige entre una de las opciones");
            if (opcion == 1) concesionario.consultarCochesAReparar();
            if (opcion == 2) repararCoche();
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }
}
