package Clases;

import Excepciones.InvalidException;

public class DirectorComercial extends Persona {
    public DirectorComercial(String nombre, String apellido, String direccion, String DNI, int telefono) throws InvalidException {
        super(nombre, apellido, direccion, DNI, telefono);
    }
    public void imprimirDatosDirector(){
        System.out.println("Datos del director: ");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Apellido: " + getApellido());
        System.out.println("Dirección: " + getDireccion());
        System.out.println("DNI: " + getDNI());
        System.out.println("Teléfono: " + getTelefono());
        System.out.println("------------------------");
    }
}
