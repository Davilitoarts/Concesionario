package Scanners;
import java.util.*;

import Clases.*;
import Comprobaciones.Float.ComprobarPrecioCompra;
import Comprobaciones.Float.ComprobarPrecioVenta;
import Comprobaciones.String.ComprobarColor;
import Comprobaciones.String.ComprobarMarca;
import Comprobaciones.String.ComprobarMatricula;
import Comprobaciones.String.ComprobarModelo;
import Excepciones.InvalidException;
import Excepciones.NotFoundException;


import static Concesionario.Proyecto.menu;

public class ScannerCoche {
    private Concesionario concesionario;
    private HashMap<String, Coche> coches;
    private HashMap<String, Mecanico> mecanicos;
    private ComprobarMatricula comprobarMatricula = new ComprobarMatricula();
    private ComprobarMarca comprobarMarca = new ComprobarMarca();
    private ComprobarModelo comprobarModelo = new ComprobarModelo();
    private ComprobarColor comprobarColor = new ComprobarColor();
    private ComprobarPrecioCompra comprobarPrecioCompra = new ComprobarPrecioCompra();
    private ComprobarPrecioVenta comprobarPrecioVenta = new ComprobarPrecioVenta();

    public ScannerCoche(Concesionario concesionario){
        this.concesionario = concesionario;
        this.coches = concesionario.getCoches();
        this.mecanicos = concesionario.getMecanicos();
    }

    public void agregarCoche() {
        try {
            Scanner agregarCoche = new Scanner(System.in);
            TipoCoche tipo = null;
            System.out.print("Introduce el tipo de coche a añadir siendo 1-Turismo, 2-Industrial o 3-Todoterreno: ");
            int num = agregarCoche.nextInt();
            agregarCoche.nextLine();
            if (num == 1) tipo = TipoCoche.TURISMO;
            if (num == 2) tipo = TipoCoche.INDUSTRIAL;
            if (num == 3) tipo = TipoCoche.TODOTERRENO;
            System.out.println("Introduzca los datos del coche a añadir: ");

            System.out.print("Marca: ");
            String marca = agregarCoche.nextLine();
            comprobarMarca.comprobacion(marca);

            System.out.print("Modelo: ");
            String modelo = agregarCoche.nextLine();
            comprobarModelo.comprobacion(modelo);

            System.out.print("Color: ");
            String color = agregarCoche.nextLine();
            comprobarColor.comprobacion(color);

            EstadoCoche estado = EstadoCoche.EN_VENTA;

            System.out.print("Matrícula: ");
            String matricula = agregarCoche.nextLine();
            if(!concesionario.validarMatricula(matricula)) throw new InvalidException ("La matrícula no puede estar repetida");
            comprobarMatricula.comprobacion(matricula);

            System.out.print("Precio de compra: ");
            float precioCompra = agregarCoche.nextFloat();
            comprobarPrecioCompra.comprobacion(precioCompra);

            System.out.print("Precio de venta: ");
            float precioVenta = agregarCoche.nextFloat();
            comprobarPrecioVenta.comprobacion(precioVenta);
            comprobarPrecioVenta.compararPrecios(precioVenta,precioCompra);

            Coche coche = new Coche(tipo, marca, modelo, color, estado, matricula, precioCompra, precioVenta);
            concesionario.agregarCoche(coche);
            System.out.println("El coche se ha añadido al concesionario correctamente");
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }

    public void removeCoche() {
        try {
            Scanner removeCoche = new Scanner(System.in);
            System.out.print("Introduce la matrícula del coche a eliminar: ");
            String matricula = removeCoche.nextLine();
            HashMap<String, Coche> coches = concesionario.getCoches();
            if (coches.containsKey(matricula)) {
                concesionario.removeCoche(matricula);
                System.out.println("El coche se ha eliminado correctamente");
            } else throw new NotFoundException("El coche no está dado de alta en el concesionario");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }

    public void imprimirCoche() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduce la matricula del coche: ");
            String matricula = scanner.nextLine();
            comprobarMatricula.comprobacion(matricula);
            HashMap<String, Coche> coches = concesionario.getCoches();
            if (coches.containsKey(matricula)) {
                Coche coche = coches.get(matricula);
                ArrayList<Reparacion> reparaciones = coche.getReparaciones();
                System.out.println("Datos del coche:");
                System.out.println("Tipo de coche: " + coche.getTipo());
                System.out.println("Marca: " + coche.getMarca());
                System.out.println("Modelo: " + coche.getModelo());
                System.out.println("Color: " + coche.getColor());
                System.out.println("Estado: " + coche.getEstado());
                System.out.println("Matrícula: " + coche.getMatricula());
                System.out.println("Precio de venta: " + coche.getPrecioVenta());
                System.out.println("Precio de compra: " + coche.getPrecioCompra());
                if (reparaciones.size() == 0) throw new InvalidException("Este coche no tiene reparaciones pendientes");
                else for (Reparacion reparacion : reparaciones) {
                    System.out.println("Reparaciones:" + reparacion.toString());
                }
            } else throw new NotFoundException("El coche no se encuentra en el concesionario");
        } catch (InvalidException | NotFoundException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }

    public void modificarCoche() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Introduce la matrícula del coche para modificar sus datos: ");
            String matricula = scanner.nextLine();
            comprobarMatricula.comprobacion(matricula);
            if (coches.containsKey(matricula)) {
                Coche coche = coches.get(matricula);
                System.out.println("Introduce los nuevos datos para el coche con matrícula " + coche.getMatricula() + ": ");
                System.out.print("Color: ");
                String color = scanner.nextLine();
                coche.setColor(color);
                System.out.print("Precio de venta:");
                float nuevoPrecioVenta = scanner.nextFloat();
                coche.setPrecioVenta(nuevoPrecioVenta);
                System.out.print("Precio de compra: ");
                float nuevoPrecioCompra = scanner.nextFloat();
                coche.setPrecioCompra(nuevoPrecioCompra);
                System.out.println("Los datos han sido modificados correctamente");
            } else throw new NotFoundException("El coche no está disponible en el concesionario");
        } catch (NotFoundException | InvalidException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }

    public void listarReparacionesOrdenadas() {
        try {
            Scanner scanner = new Scanner(System.in);
            concesionario.imprimirMecanicos();
            System.out.println("Introduce el dni del mecánico a consultar: ");
            String dni = scanner.nextLine();
            if (mecanicos.containsKey(dni)) {
                Mecanico mecanico = mecanicos.get(dni);
                ArrayList<Reparacion> todasLasReparaciones = new ArrayList<>();
                for (Coche coche : mecanico.getCochesReparados()) {
                    for (Reparacion reparacion : coche.getReparaciones()) {
                        todasLasReparaciones.add(reparacion);

                    }
                }
                Collections.sort(todasLasReparaciones, Comparator.comparing(Reparacion::getFecha).reversed());
                System.out.println("Reparaciones de los coches reparados por el mecánico " + mecanico.getNombre() + " " + mecanico.getApellido() + ":");
                for (Reparacion reparacion : todasLasReparaciones) {
                    if (reparacion.isResuelta()) {
                        System.out.println("Fecha: " + reparacion.getFecha() + ", Tipo: " + reparacion.getTipo());
                    }
                }
            } else throw new NotFoundException("El mecánico no está dado de alta en el concesionario");
        } catch (NotFoundException n) {
            System.out.println(n.getMessage());
            menu(concesionario);
        }
    }

    public void consolaCoches() {
        try {
            Scanner coches = new Scanner(System.in);
            int opcion = 0;
            while (opcion != 6) {
                System.out.println("**********************");
                System.out.println("*** MENÚ VEHÍCULOS ***");
                System.out.println("**********************");
                System.out.println("1-AGREGAR COCHE");
                System.out.println("2-MODIFICAR COCHE");
                System.out.println("3-CONSULTAR DATOS DE UN COCHE");
                System.out.println("4-REPARACIONES DE UN COCHE");
                System.out.println("5-ELIMINAR UN COCHE");
                System.out.println("6-VOLVER AL MENÚ PRINCIPAL");
                System.out.print("Elija una de las opciones: ");
                opcion = coches.nextInt();
                if (opcion < 1 || opcion > 6) throw new InvalidException("Debe introducir una de las opciones disponibles");
                if (opcion == 1) agregarCoche();
                if (opcion == 2) modificarCoche();
                if (opcion == 3) imprimirCoche();
                if (opcion == 4) listarReparacionesOrdenadas();
                if (opcion == 5) removeCoche();
                if (opcion == 6) menu(concesionario);
            }
        } catch (InvalidException e){
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }
}

