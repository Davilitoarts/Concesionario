import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DirectorComercial extends Persona {
    private List<VendedorAComision> vendedoresComision;
    private List<Exposicion> exposiciones;

    public DirectorComercial(String nombre, String direccion) {
        super(nombre, direccion);
        vendedoresComision = new ArrayList<>();
        exposiciones = new ArrayList<>();
    }

    public void gestionarVendedoresComision() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Dar de alta vendedor");
        System.out.println("2. Dar de baja vendedor");
        System.out.println("3. Modificar vendedor");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después de leer el entero

        switch (opcion) {
            case 1:
                darDeAltaVendedor(scanner);
                break;
            case 2:
                darDeBajaVendedor(scanner);
                break;
            case 3:
                modificarVendedor(scanner);
                break;
            default:
                System.out.println("Opción inválida");
                break;
        }
    }

    private void darDeAltaVendedor(Scanner scanner) {
        System.out.println("Ingrese el nombre del vendedor:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la dirección del vendedor:");
        String direccion = scanner.nextLine();
        System.out.println("Ingrese el número de identificación del vendedor:");
        int identificacion = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después de leer el entero

        VendedorAComision vendedor = new VendedorAComision(nombre, direccion, identificacion);
        vendedoresComision.add(vendedor);

        System.out.println("Vendedor agregado con éxito.");
    }

    private void darDeBajaVendedor(Scanner scanner) {
        System.out.println("Ingrese el número de identificación del vendedor a dar de baja:");
        int identificacion = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después de leer el entero

        VendedorAComision vendedor = buscarVendedor(identificacion);
        if (vendedor != null) {
            vendedoresComision.remove(vendedor);
            System.out.println("Vendedor dado de baja con éxito.");
        } else {
            System.out.println("No se encontró ningún vendedor con el número de identificación especificado.");
        }
    }

    private void modificarVendedor(Scanner scanner) {
        System.out.println("Ingrese el número de identificación del vendedor a modificar:");
        int identificacion = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después de leer el entero

        VendedorAComision vendedor = buscarVendedor(identificacion);
        if (vendedor != null) {
            System.out.println("Ingrese el nuevo nombre del vendedor:");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese la nueva dirección del vendedor:");
            String direccion = scanner.nextLine();
            vendedor.setNombre(nombre);
            vendedor.setDireccion(direccion);
            System.out.println("Vendedor modificado con éxito.");
        } else {
            System.out.println("No se encontró ningún vendedor con el número de identificación especificado.");
        }
    }

    public VendedorAComision buscarVendedor(int identificacion) {
        for (VendedorAComision vendedor : vendedoresComision) {
            if (!(vendedor.getDireccion() = identificacion)) {
                return vendedor;
            }
        }
        return null;
    }

    public void gestionarExposiciones() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Agregar exposición");
        System.out.println("2. Eliminar exposición");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después de leer el entero

        switch (opcion) {
            case 1:
                agregarExposicion(scanner);
                break;
            case 2:
                eliminarExposicion(scanner);
                break;
            default:
                System.out.println("Opción inválida");
                break;
        }
    }

    private void agregarExposicion(Scanner scanner) {
        System.out.println("Ingrese el nombre de la exposición:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la dirección de la exposición:");
        String direccion = scanner.nextLine();

        Exposicion exposicion = new Exposicion(nombre, direccion);
        exposiciones.add(exposicion);

        System.out.println("Exposición agregada con éxito.");
    }

    private void eliminarExposicion(Scanner scanner) {
        System.out.println("Ingrese el nombre de la exposición a eliminar:");
        String nombre = scanner.nextLine();

        Exposicion exposicion = buscarExposicion(nombre);
        if (exposicion != null) {
            exposiciones.remove(exposicion);
            System.out.println("Exposición eliminada con éxito.");
        } else {
            System.out.println("No se encontró ninguna exposición con el nombre especificado.");
        }
    }

    private Exposicion buscarExposicion(String nombre) {
        for (Exposicion exposicion : exposiciones) {
            if (exposicion.getNombre().equals(nombre)) {
                return exposicion;
            }
        }
        return null;
    }
}