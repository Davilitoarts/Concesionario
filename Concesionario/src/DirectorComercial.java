import java.util.Scanner;

public class DirectorComercial extends Persona{
    public DirectorComercial(String nombre, String direccion, String DNI, int telefono) {
        super(nombre, direccion, DNI, telefono);
    }
    public void modificarDirector(){
        Scanner director = new Scanner(System.in);
        System.out.println("Introduzca los nuevos datos para el cliente con DNI " + getDNI() + ": ");
        System.out.println("Introduzca su nuevo nombre: ");
        String nuevoNombre = director.nextLine();
        setNombre(nuevoNombre);
        System.out.println("Introduzca su nueva dirección: ");
        String nuevaDireccion = director.nextLine();
        setDireccion(nuevaDireccion);
        System.out.println("Introduzca su nuevo teléfono: ");
        int nuevoTeléfono = director.nextInt();
        // if(nuevoTeléfono < 99999999 && nuevoTeléfono > 999999999) throw new Exception("El nuevo teléfono no puede ser menor ni mayor a 9 cifras");
        setTelefono(nuevoTeléfono);


    }
    public void imprimirDatosDirector(){
        System.out.println("Datos del director: ");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Dirección: " + getDireccion());
        System.out.println("DNI: " + getDNI());
        System.out.println("Teléfono: " + getTelefono());
        System.out.println("------------------------");
    }
}
