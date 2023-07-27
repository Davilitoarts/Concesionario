package Comprobaciones.Float;

import Excepciones.InvalidException;

public class ComprobarPrecioVenta extends ComprobacionFloat{

    @Override
    public void comprobacion(float precioVenta) throws InvalidException {
        if(precioVenta <= 0) throw new InvalidException("El precio no puede ser menor o igual a 0");
    }
    public void compararPrecios(float precioVenta, float precioCompra) throws InvalidException {
        if(precioVenta <= precioCompra) throw new InvalidException("El precio de venta no puede ser menor o igual al precio de compra");

    }
}
