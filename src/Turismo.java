import java.util.ArrayList;

public class Turismo extends Coche{

    public Turismo(String marca, String modelo, String color, String tipo, String estado, String matricula, float precioVenta, float precioCompra, ArrayList<Reparacion> reparaciones) {
        super(marca, modelo, color, "turismo", estado, matricula, precioVenta, precioCompra, reparaciones);
    }

    public Turismo(String marca, String modelo, String color, String tipo, String estado, String matricula, float precioVenta, float precioCompra, Exposicion exposicion, ArrayList<Reparacion> reparaciones) {
        super(marca, modelo, color, "turismo", estado, matricula, precioVenta, precioCompra, exposicion, reparaciones);
    }

    public Turismo(String marca, String modelo, String color, String tipo, String estado, String matricula, float precioVenta, float precioCompra) {
        super(marca, modelo, color, "turismo", estado, matricula, precioVenta, precioCompra);
    }

    public Turismo(String marca, String modelo, String color, String tipo, String estado, String matricula, float precioVenta, float precioCompra, Exposicion exposicion) {
        super(marca, modelo, color, "turismo", estado, matricula, precioVenta, precioCompra, exposicion);
    }
}
