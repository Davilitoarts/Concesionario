package Scanners;

import Clases.Coche;
import Clases.Concesionario;
import Clases.EstadoCoche;
import Clases.Exposicion;

import Comprobaciones.Int.ComprobarNumExpo;
import Comprobaciones.Int.ComprobarTlf;
import Comprobaciones.String.ComprobarDireccion;
import Excepciones.InvalidException;
import Excepciones.NotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static Concesionario.Proyecto.menu;

public class ScannerExpo {
    private Concesionario concesionario;
    private HashMap<Integer, Exposicion> exposiciones;
    private HashMap<String, Coche> coches;
    private ComprobarNumExpo comprobarNumExpo = new ComprobarNumExpo();
    private ComprobarTlf comprobarTlf = new ComprobarTlf();
    private ComprobarDireccion comprobarDireccion = new ComprobarDireccion();

    public ScannerExpo(Concesionario concesionario) throws InvalidException {
        this.concesionario = concesionario;
        this.exposiciones = concesionario.getExposiciones();
        this.coches = concesionario.getCoches();
    }

    public Exposicion agregarExposicion() {
        try {
            Scanner expo = new Scanner(System.in);
            System.out.println("Introduce los datos para crear una exposición: ");
            System.out.print("Número de exposición: ");
            int numExpo = expo.nextInt();
            comprobarNumExpo.comprobacion(numExpo);


            System.out.print("Teléfono: ");
            int telefono = expo.nextInt();
            comprobarTlf.comprobacion(telefono);

            System.out.print("Dirección: ");
            expo.nextLine();
            String direccion = expo.nextLine();
            comprobarDireccion.comprobacion(direccion);

            Exposicion exposicion = new Exposicion(numExpo, telefono, direccion);
            concesionario.agregarExposicion(exposicion);
            return exposicion;
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
        return null;
    }

    public void removeExposicion() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce el número de exposición a eliminar: ");
            int numExpo = scanner.nextInt();
            comprobarNumExpo.comprobacion(numExpo);
            if (exposiciones.containsKey(numExpo)) {
                Exposicion exposicion = exposiciones.get(numExpo);
                if (exposicion.getCoches().size() == 0) {
                    exposiciones.remove(numExpo, exposicion);
                    System.out.println("La exposición ha sido eliminada correctamente");
                } else throw new InvalidException("No se puede eliminar porque esta exposición tiene coches");
            } else throw new NotFoundException("La exposición indicada no existe en el concesionario");
        } catch (NotFoundException | InvalidException notFound) {
            System.out.println(notFound.getMessage());
            menu(concesionario);
        }
    }

    public void imprimirDatosExposicion() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce el número de exposición a ver: ");
            int numExpo = scanner.nextInt();
            comprobarNumExpo.comprobacion(numExpo);
            if (exposiciones.containsKey(numExpo)) {
                Exposicion exposicion = exposiciones.get(numExpo);
                System.out.println("Número de exposición: " + exposicion.getNumExposicion());
                System.out.println("Teléfono: " + exposicion.getTelefono());
                System.out.println("Dirección: " + exposicion.getDireccion());
            } else throw new NotFoundException("El número de exposición introducido no existe");
        } catch (NotFoundException | InvalidException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }

    public void imprimirCochesExpo() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduce el número de exposición para mirar sus coches:");
            int numExpo = scanner.nextInt();
            if (exposiciones.containsKey(numExpo)) {
                Exposicion exposicion = exposiciones.get(numExpo);
                ArrayList<Coche> coches = exposicion.getCoches();
                if (coches == null || coches.isEmpty()) {
                    throw new InvalidException("Esta exposición no tiene coches");
                } else {
                    for (Coche coche : coches) {
                        exposicion.imprimirCochesExpo();
                    }
                }
            } else throw new NotFoundException("El número de exposición introducido no existe");
        } catch (InvalidException | NotFoundException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }

    public void modificarExpo() {
        try {
            Scanner expo = new Scanner(System.in);
            System.out.print("Introduce el número de exposición a modificar: ");
            int numExpo = expo.nextInt();
            if (exposiciones.containsKey(numExpo)) {
                Exposicion exposicion = exposiciones.get(numExpo);
                System.out.println("Introduce los nuevos datos de la exposicion número " + exposicion.getNumExposicion() + ": ");
                System.out.print("Teléfono: ");
                int telefono = expo.nextInt();
                exposicion.setTelefono(telefono);

                System.out.print("Dirección: ");
                expo.nextLine();
                String direccion = expo.nextLine();
                exposicion.setDireccion(direccion);


                System.out.println("Los datos han sido modificados correctamente");
            } else throw new NotFoundException("El número de exposición introducido no existe");

        } catch (NotFoundException | InvalidException n) {
            System.out.println(n.getMessage());
            menu(concesionario);
        }
    }

    public void agregarCocheAExpo() {
        try {
            Scanner expo = new Scanner(System.in);
            System.out.print("Introduce la matrícula del coche a agregar a la exposición: ");
            String matricula = expo.nextLine();

            if (coches.containsKey(matricula)) {
                Coche coche = coches.get(matricula);

                System.out.println("Elige si quieres crear una nueva exposición o utilizar una existente: ");
                System.out.println("1-Crear nueva exposición");
                System.out.println("2-Exposición existente");
                int num = expo.nextInt();
                if (num == 1) {
                    Exposicion exposicion = agregarExposicion();
                    coche.setEstado(EstadoCoche.EN_EXPOSICION);
                    exposicion.agregarCoche(coche);
                    coches.remove(matricula);
                    System.out.println("El coche se ha añadido correctamente");
                } else {
                    System.out.print("Introduce el número de exposición para añadir el coche: ");
                    num = expo.nextInt();
                    if (exposiciones.containsKey(num)) {
                        Exposicion exposicion1 = exposiciones.get(num);
                        coche.setEstado(EstadoCoche.EN_EXPOSICION);
                        exposicion1.agregarCoche(coche);
                        coches.remove(matricula);
                        System.out.println("El coche se ha añadido correctamente");
                    } else throw new NotFoundException("La exposición indicada no existe");
                }

            } else throw new NotFoundException("El coche introducido no existe");

        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }

    public void removeCocheExpo() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Para eliminar un coche de la exposición introduce primero el número de exposición: ");
            int numExpo = scanner.nextInt();
            if (exposiciones.containsKey(numExpo)) {
                Exposicion exposicion = exposiciones.get(numExpo);
                System.out.println("------------------------------");
                System.out.println("Estos son los coches que tiene esta exposición: ");
                exposicion.imprimirCochesExpo();
                System.out.print("Introduce la matrícula del coche a eliminar de la exposición: ");
                scanner.nextLine();
                String matricula = scanner.nextLine();
                ArrayList<Coche> coches = exposicion.getCoches();
                for (Coche coche : coches) {
                    if (coche.getMatricula().equals(matricula)) {
                        coche.setEstado(EstadoCoche.EN_VENTA);
                        exposicion.borrarCoche(coche);
                        concesionario.agregarCoche(coche);
                        System.out.println("El coche se ha eliminado correctamente");
                        break;
                    } else throw new InvalidException("El coche introducido no existe");
                }
            } else throw new InvalidException("No existe la exposición introducida");
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }

    public void cambiarCocheDeExposicion() {
        try {
            Scanner cambio = new Scanner(System.in);
            System.out.println("Introduce el número de exposición a modificar: ");
            int numExpo = cambio.nextInt();

            if (exposiciones.containsKey(numExpo)) {
                System.out.println("Aquí está la lista de coches de la exposición: ");
                Exposicion exposicion = exposiciones.get(numExpo);
                exposicion.imprimirCochesExpo();
                System.out.println("-----------------------");
                System.out.println("Introduce la matrícula del coche a cambiar de exposición: ");
                cambio.nextLine();
                String matricula = cambio.nextLine();
                ArrayList<Coche> cochesExpo = exposicion.getCoches();
                for (Coche coche : cochesExpo) {
                    if (coche.getMatricula().equals(matricula)) {
                        exposicion.borrarCoche(coche);
                        System.out.println("Elige entre dos opciones: ");
                        System.out.println("1-Añadir coche a una exposición nueva ");
                        System.out.println("2-Añadir coche a una exposición ya existente ");
                        numExpo = cambio.nextInt();
                        if (numExpo == 1) {
                            Exposicion nuevaExpo = agregarExposicion();
                            nuevaExpo.agregarCoche(coche);
                            System.out.println("El coche se ha añadido correctamente");
                            break;
                        } else if (numExpo == 2) {
                            System.out.println("Introduce el número de exposición donde quieres mover el coche: ");
                            numExpo = cambio.nextInt();
                            if (exposiciones.containsKey(numExpo)) {
                                Exposicion exposicion1 = exposiciones.get(numExpo);
                                exposicion1.agregarCoche(coche);
                                System.out.println("El coche se ha añadido correctamente");
                                break;
                            }
                        } else throw new InvalidException("El número de exposición introducida no existe");
                    } else throw new NotFoundException("El coche no se encuentra en la exposición");
                }
            }
        } catch (InvalidException | NotFoundException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }

    public void consolaExposiciones() {
        try {
            Scanner expo = new Scanner(System.in);
            int opcion = 0;
            while (opcion != 9) {
                System.out.println("********************");
                System.out.println("*** EXPOSICIONES ***");
                System.out.println("********************");
                System.out.println("1-DAR DE ALTA A UNA EXPOSICIÓN");
                System.out.println("2- MODIFICAR UNA EXPOSICIÓN");
                System.out.println("3- AGREGAR VEHÍCULO A UNA EXPOSICIÓN");
                System.out.println("4- ELIMINAR COCHE DE EXPOSICIÓN");
                System.out.println("5- MOVER VEHÍCULO ENTRE EXPOSICIONES");
                System.out.println("6- CONSULTAR DATOS DE EXPOSICIONES");
                System.out.println("7- CONSULTAR COCHES DE EXPOSICIONES");
                System.out.println("8- DAR DE BAJA A UNA EXPOSICIÓN");
                System.out.println("9- MENÚ PRINCIPAL");
                System.out.print("Elija una de las opciones: ");
                opcion = expo.nextInt();
                if (opcion < 1 || opcion > 9) throw new InvalidException("Elige entre una de las opciones");
                if (opcion == 1) agregarExposicion();
                if (opcion == 2) modificarExpo();
                if (opcion == 3) agregarCocheAExpo();
                if (opcion == 4) removeCocheExpo();
                if (opcion == 5) cambiarCocheDeExposicion();
                if (opcion == 6) imprimirDatosExposicion();
                if (opcion == 7) imprimirCochesExpo();
                if (opcion == 8) removeExposicion();
                if (opcion == 9)  menu(concesionario);
            }
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }
}

