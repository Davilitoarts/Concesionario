package Comprobaciones.String;
import Excepciones.InvalidException;

public class ComprobarNombre extends ComprobacionString {
    public ComprobarNombre() {
    }

    @Override
    public void comprobacion(String nombre) throws InvalidException{
        if(nombre.matches(".*\\d.*")) throw new InvalidException("El nombre y el apellido no puede contener números");
        if (nombre == null || nombre.trim().isEmpty()) throw new InvalidException("El nombre y el apellido no puede estar vacío");
    }
}
