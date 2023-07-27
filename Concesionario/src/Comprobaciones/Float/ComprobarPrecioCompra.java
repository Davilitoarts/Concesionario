package Comprobaciones.Float;

import Excepciones.InvalidException;

public class ComprobarPrecioCompra extends ComprobacionFloat{
    @Override
    public void comprobacion(float precioCompra) throws InvalidException {
        if(precioCompra <= 0) throw new InvalidException("El precio no puede ser menor o igual a 0");
    }
}
