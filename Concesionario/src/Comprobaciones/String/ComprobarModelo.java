package Comprobaciones.String;

import Excepciones.InvalidException;

public class ComprobarModelo extends ComprobacionString{
    @Override
    public void comprobacion(String modelo) throws InvalidException {
        if(modelo == null || modelo.trim().isEmpty()) throw new InvalidException("El modelo del coche no puede estar vacío");
    }
}
