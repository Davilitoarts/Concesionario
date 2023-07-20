package Comprobaciones.Int;

import Excepciones.InvalidException;

public class ComprobarEdad extends ComprobacionInt{
    @Override
    public void comprobacion(int edad) throws InvalidException {
        if(edad < 18) throw new InvalidException("El cliente debe ser mayor de edad");
    }
}
