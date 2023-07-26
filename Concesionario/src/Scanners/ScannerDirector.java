package Scanners;

import Clases.Concesionario;
import Clases.DirectorComercial;
import Comprobaciones.String.ComprobarDNI;
import Excepciones.InvalidException;
import Excepciones.NotFoundException;


import java.util.Scanner;


import static Concesionario.Proyecto.menu;

public class ScannerDirector {
    private ScannerCoche scannerCoche;
    private ScannerExpo scannerExpo;
    private ScannerReparacion scannerReparacion;
    private ScannerVentas scannerVentas;
    private ScannerReservas scannerReservas;
    private ScannerConcesionario scannerConcesionario;
    private ComprobarDNI comprobarDNI = new ComprobarDNI();
    private Concesionario concesionario;
    private ScannerCliente clientes;
    private ScannerVendedor vendedores;
    private ScannerMecanico mecanicos;

    public ScannerDirector(Concesionario concesionario) throws InvalidException {
        this.concesionario = concesionario;
        this.scannerCoche = new ScannerCoche(concesionario);
        this.scannerExpo = new ScannerExpo(concesionario);
        this.scannerReparacion = new ScannerReparacion(concesionario);
        this.scannerVentas = new ScannerVentas(concesionario);
        this.scannerReservas = new ScannerReservas(concesionario);
        this.scannerConcesionario = new ScannerConcesionario(concesionario);
        this.clientes = new ScannerCliente(concesionario);
        this.vendedores = new ScannerVendedor(concesionario);
        this.mecanicos = new ScannerMecanico(concesionario);

    }

    public void agregarModificarDirector() {
        Scanner agregarDirector = new Scanner(System.in);
        try {
            DirectorComercial director = new DirectorComercial();
            System.out.println("Introduzca los datos para agregar o modificar al director: ");
            System.out.print("Nombre: ");
            String nombre = agregarDirector.nextLine();
            director.setNombre(nombre);

            System.out.print("Apellido: ");
            String apellido = agregarDirector.nextLine();
            director.setApellido(apellido);

            System.out.print("Dirección: ");
            String direccion = agregarDirector.nextLine();
            director.setDireccion(direccion);

            System.out.print("DNI (Introducir 8 dígitos y una letra en mayúscula) : ");
            String dni = agregarDirector.nextLine();
            director.setDNI(dni);

            System.out.print("Número de teléfono: ");
            int telefono = agregarDirector.nextInt();
            director.setTelefono(telefono);

            concesionario.agregarDirector(director);
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }

    public void imprimirDatosDirector() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Introduce el dni del director: ");
            String dni = scanner.nextLine();
            comprobarDNI.comprobacion(dni);
            if (concesionario.getDirector().getDNI().equals(dni)) {
                DirectorComercial director = concesionario.getDirector();
                System.out.println("Datos del director: ");
                System.out.println("Nombre: " + director.getNombre());
                System.out.println("Dirección: " + director.getDireccion());
                System.out.println("DNI: " + director.getDNI());
                System.out.println("Teléfono: " + director.getTelefono());
                System.out.println("------------------------");
            } else throw new NotFoundException("El director no está dado de alta");
        } catch (NotFoundException | InvalidException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }


    public void consultarClientes() {
        try {
            Scanner consulta = new Scanner(System.in);
            int opcion = 0;
            while (opcion != 6) {
                System.out.println("****************");
                System.out.println("*** CLIENTES ***");
                System.out.println("****************");
                System.out.println("1-DAR DE ALTA CLIENTE");
                System.out.println("2-MODIFICAR CLIENTE");
                System.out.println("3-CONSULTAR DATOS CLIENTE");
                System.out.println("4-DAR DE BAJA CLIENTE");
                System.out.println("5-VOLVER AL MENÚ DEL DIRECTOR");
                System.out.println("6-VOLVER AL MENÚ PRINCIPAL");
                System.out.print("Elija una de las opciones: ");
                opcion = consulta.nextInt();
                if (opcion < 1 || opcion > 6)
                    throw new InvalidException("Debe elegir entre una de las opciones disponibles");
                if (opcion == 1) clientes.agregarCliente();
                if (opcion == 2) clientes.modificarCliente();
                if (opcion == 3) clientes.imprimirDatosCliente();
                if (opcion == 4) clientes.removeCliente();
                if (opcion == 5) consolaDirector();
                if (opcion == 6) menu(concesionario);
            }
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }

    public void consultarVendedores() {
        try {
            Scanner consulta = new Scanner(System.in);
            int opcion = 0;
            while (opcion != 6) {
                System.out.println("******************");
                System.out.println("*** VENDEDORES ***");
                System.out.println("******************");
                System.out.println("1-DAR DE ALTA VENDEDOR");
                System.out.println("2-MODIFICAR VENDEDOR");
                System.out.println("3-CONSULTAR DATOS VENDEDOR");
                System.out.println("4-DAR DE BAJA VENDEDOR");
                System.out.println("5-VOLVER AL MENÚ DEL DIRECTOR");
                System.out.println("6-VOLVER AL MENÚ PRINCIPAL");
                System.out.print("Elija una de las opciones: ");
                opcion = consulta.nextInt();
                if (opcion < 1 || opcion > 6)
                    throw new InvalidException("Debe elegir entre una de las opciones disponibles");
                if (opcion == 1) vendedores.agregarVendedor();
                if (opcion == 2) vendedores.modificarVendedor();
                if (opcion == 3) vendedores.imprimirDatosVendedor();
                if (opcion == 4) vendedores.removeVendedor();
                if (opcion == 5) consolaDirector();
                if (opcion == 6) menu(concesionario);
            }
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }

    public void consultarMecanicos() {
        try {
            Scanner consulta = new Scanner(System.in);
            int opcion = 0;
            while (opcion != 6) {
                System.out.println("*****************");
                System.out.println("*** MECÁNICOS ***");
                System.out.println("*****************");
                System.out.println("1-DAR DE ALTA MECÁNICO");
                System.out.println("2-MODIFICAR MECÁNICO");
                System.out.println("3-CONSULTAR DATOS MECÁNICO");
                System.out.println("4-DAR DE BAJA MECÁNICO");
                System.out.println("5-VOLVER AL MENÚ DEL DIRECTOR");
                System.out.println("6-VOLVER AL MENÚ PRINCIPAL");
                System.out.print("Elija una de las opciones: ");
                opcion = consulta.nextInt();
                if (opcion < 1 || opcion > 6)
                    throw new InvalidException("Debe elegir entre una de las opciones disponibles");
                if (opcion == 1) mecanicos.agregarMecanico();
                if (opcion == 2) mecanicos.modificarMecanico();
                if (opcion == 3) mecanicos.imprimirDatosMecanico();
                if (opcion == 4) mecanicos.removeMecanico();
                if (opcion == 5) consolaDirector();
                if (opcion == 6) menu(concesionario);
            }
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }

    public void gestionVentasReservas() {
        try {
            Scanner gestion = new Scanner(System.in);
            int opcion = 0;
            while (opcion != 4) {
                System.out.println("**************");
                System.out.println("*** VENTAS ***");
                System.out.println("**************");
                System.out.println("1-VENTAS");
                System.out.println("2-RESERVAS");
                System.out.println("3-VOLVER AL MENÚ DEL DIRECTOR");
                System.out.println("4-VOLVER AL MENÚ PRINCIPAL");
                System.out.print("Elija una de las opciones: ");
                opcion = gestion.nextInt();
                if (opcion < 1 || opcion > 4)
                    throw new InvalidException("Debe elegir entre una de las opciones disponibles");
                if (opcion == 1) scannerVentas.consolaVentas();
                if (opcion == 2) scannerReservas.consolaReservas();
                if (opcion == 3) consolaDirector();
                if (opcion == 4) menu(concesionario);
            }
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }

    public void informes() {
        try {
            Scanner consultas = new Scanner(System.in);
            int opcion = 0;
            while (opcion != 9) {
                System.out.println("****************");
                System.out.println("*** INFORMES ***");
                System.out.println("****************");
                System.out.println("1-COCHES EN VENTA");
                System.out.println("2-COCHES RESERVADOS");
                System.out.println("3-COCHES EN REPARACIÓN");
                System.out.println("4-COCHES VENDIDOS POR UN VENDEDOR");
                System.out.println("5-CLIENTES CON COCHES RESERVADOS");
                System.out.println("6-CLIENTES QUE HAN COMPRADO UN COCHE");
                System.out.println("7-LISTADO POR TOTAL VENDIDO");
                System.out.println("8-VOLVER AL MENÚ DEL DIRECTOR");
                System.out.println("9-VOLVER AL MENÚ PRINCIPAL");
                System.out.print("Elija una de las opciones: ");
                opcion = consultas.nextInt();
                if (opcion < 1 || opcion > 9)
                    throw new InvalidException("Debe elegir entre una de las opciones disponibles");
                if (opcion == 1) concesionario.imprimirStock();
                if (opcion == 2) concesionario.imprimirCochesReservados();
                if (opcion == 3) concesionario.consultarCochesAReparar();
                if (opcion == 4) scannerConcesionario.queCoches();
                if (opcion == 5) concesionario.imprimirClienteConReservas();
                if (opcion == 6) scannerConcesionario.queCliente();
                if (opcion == 7) concesionario.listadoPorTotalVendido();
                if (opcion == 8) consolaDirector();
                if (opcion == 9) menu(concesionario);
            }

        } catch (InvalidException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }
    public void director() {
        try {
            Scanner scanner = new Scanner(System.in);
            if (concesionario.getDirector() == null) {
                System.out.println("No existe un director a cargo del concesionario");
                System.out.println("Elige una de estas opciones: ");
                System.out.println("1-AGREGAR DIRECTOR");
                System.out.println("2-MENÚ PRINCIPAL");
                int opcion = scanner.nextInt();
                if (opcion < 1 || opcion > 2) throw new InvalidException("Debe introducir una de las opciones");
                if (opcion == 1) agregarModificarDirector();
                if (opcion == 2) menu(concesionario);
            } else {
                System.out.println("Introduce el dni del director");
                String dni = scanner.nextLine();
                concesionario.validarDni(dni);
                comprobarDNI.comprobacion(dni);
                if(concesionario.getDirector().getDNI().equals(dni)) consolaDirector();
                else {
                    System.out.println("** ERROR **");
                    throw new InvalidException("El dni introducido no pertenece al director");
                }
            }
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }

    public void consolaDirector() {
        try {
            Scanner director = new Scanner(System.in);
            int opcion = 0;
            while (opcion != 11) {
                System.out.println("*************************");
                System.out.println("*** MENÚ DEL DIRECTOR ***");
                System.out.println("*************************");
                System.out.println("1-MODIFICAR DIRECTOR");
                System.out.println("2-IMPRIMIR DATOS DEL DIRECTOR");
                System.out.println("3-CLIENTES");
                System.out.println("4-VENDEDORES");
                System.out.println("5-MECÁNICOS");
                System.out.println("6-VEHÍCULOS");
                System.out.println("7-EXPOSICIONES");
                System.out.println("8-VENTAS/RESERVAS");
                System.out.println("9-TALLER");
                System.out.println("10-INFORMES");
                System.out.println("11-MENU PRINCIPAL");
                System.out.print("Elija una de las opciones: ");
                opcion = director.nextInt();
                if (opcion < 1 || opcion > 11)
                    throw new InvalidException("Debe elegir entre una de las opciones disponibles");
                if (opcion == 1) agregarModificarDirector();
                if (opcion == 2) imprimirDatosDirector();
                if (opcion == 3) consultarClientes();
                if (opcion == 4) consultarVendedores();
                if (opcion == 5) consultarMecanicos();
                if (opcion == 6) scannerCoche.consolaCoches();
                if (opcion == 7) scannerExpo.consolaExposiciones();
                if (opcion == 8) gestionVentasReservas();
                if (opcion == 9) scannerReparacion.consolaTaller();
                if (opcion == 10) informes();
                if (opcion == 11) menu(concesionario);
            }
        } catch (InvalidException e) {
            System.out.println(e.getMessage());
            menu(concesionario);
        }
    }
}
