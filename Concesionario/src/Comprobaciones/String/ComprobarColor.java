package Comprobaciones.String;

import Excepciones.InvalidException;

public class ComprobarColor extends ComprobacionString{
    @Override
    public void comprobacion(String color) throws InvalidException {
        if(color.matches(".*\\d.*")) throw new InvalidException("El color no puede contener números");
        if(color == null || color.trim().isEmpty()) throw new InvalidException("El color del coche no puede estar vacío");
    }
}
