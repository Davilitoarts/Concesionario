package Comprobaciones.String;
import Excepciones.InvalidException;

public class ComprobarDNI extends ComprobacionString {

    @Override
    public void comprobacion(String DNI) throws InvalidException {
        if (DNI == null || DNI.trim().isEmpty()) throw new InvalidException("El DNI no puede estar vacío");
        if (DNI.length() != 9 || !Character.isUpperCase(DNI.charAt(8)))
            throw new InvalidException("El DNI ingresado es inválido");

    }
}
