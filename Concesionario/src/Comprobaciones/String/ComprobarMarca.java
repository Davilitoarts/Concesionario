package Comprobaciones.String;

import Comprobaciones.Int.ComprobarEdad;
import Excepciones.InvalidException;

public class ComprobarMarca extends ComprobacionString {
    @Override
    public void comprobacion(String marca) throws InvalidException {
        if(marca.matches(".*\\d.*")) throw new InvalidException("La marca no puede contener números");
        if(marca == null || marca.trim().isEmpty()) throw new InvalidException("La marca del coche no puede estar vacía");
    }
}
