package Comprobaciones.Int;

import Excepciones.InvalidException;

public class ComprobarNumExpo extends ComprobacionInt{
    @Override
    public void comprobacion(int numExpo) throws InvalidException {
        if(numExpo <=0) throw new InvalidException("El número de exposición no puede ser menor o igual que 0");
    }
}
