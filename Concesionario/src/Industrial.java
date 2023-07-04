import java.util.ArrayList;

public class Industrial extends Coche{
    public Industrial(String marca, String modelo, String color, String tipo, String estado, String matricula, float precioVenta, float precioCompra, ArrayList<Reparacion> reparaciones) {
        super(marca, modelo, color, "industrial", estado, matricula, precioVenta, precioCompra, reparaciones);
    }

    public Industrial(String marca, String modelo, String color, String tipo, String estado, String matricula, float precioVenta, float precioCompra, Exposicion exposicion, ArrayList<Reparacion> reparaciones) {
        super(marca, modelo, color, "industrial", estado, matricula, precioVenta, precioCompra, exposicion, reparaciones);
    }

    public Industrial(String marca, String modelo, String color, String tipo, String estado, String matricula, float precioVenta, float precioCompra) {
        super(marca, modelo, color, "industrial", estado, matricula, precioVenta, precioCompra);
    }

    public Industrial(String marca, String modelo, String color, String tipo, String estado, String matricula, float precioVenta, float precioCompra, Exposicion exposicion) {
        super(marca, modelo, color, "industrial", estado, matricula, precioVenta, precioCompra, exposicion);
    }
}