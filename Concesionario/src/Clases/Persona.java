package Clases;
import Comprobaciones.String.ComprobarDNI;
import Comprobaciones.String.ComprobarDireccion;
import Comprobaciones.String.ComprobarNombre;
import Comprobaciones.Int.ComprobarTlf;
import Excepciones.InvalidException;

public class Persona {
    private String nombre;
    private String apellido;
    private String direccion;
    private String DNI;
    private int telefono;
    private ComprobarNombre comprobarNombre = new ComprobarNombre();
    private ComprobarDireccion comprobarDireccion = new ComprobarDireccion();
    private ComprobarDNI comprobarDNI = new ComprobarDNI();
    private ComprobarTlf comprobarTlf = new ComprobarTlf();


    public Persona(String nombre, String apellido, String direccion, String DNI, int telefono) throws InvalidException {
        comprobarNombre.comprobacion(nombre);
        this.nombre = nombre;

        comprobarNombre.comprobacion(apellido);
        this.apellido = apellido;

        comprobarDireccion.comprobacion(direccion);
        this.direccion = direccion;

        comprobarDNI.comprobacion(DNI);
        this.DNI = DNI;

        comprobarTlf.comprobacion(telefono);
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws InvalidException{
        comprobarNombre.comprobacion(nombre);
        this.nombre = nombre;
    }

    public String getApellido() {

        return apellido;
    }

    public void setApellido(String apellido) throws InvalidException{
        comprobarNombre.comprobacion(apellido);
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) throws InvalidException{
        comprobarDireccion.comprobacion(direccion);
        this.direccion = direccion;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) throws InvalidException{
        comprobarDNI.comprobacion(DNI);
        this.DNI = DNI;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) throws InvalidException{
        comprobarTlf.comprobacion(telefono);
        this.telefono = telefono;
    }
}
