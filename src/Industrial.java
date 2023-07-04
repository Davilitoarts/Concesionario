import java.util.ArrayList;

public class Industrial extends Coche {
    public Industrial(String marca, String modelo, String color, String matricula, double precioVenta, double precioCompra, ArrayList<Reparacion> reparaciones) {
        super(marca, modelo, color, matricula, precioCompra, precioVenta, null);
        this.setReparaciones(reparaciones);
    }

    public Industrial(String marca, String modelo, String color, String matricula, double precioVenta, double precioCompra, Exposicion exposicion, ArrayList<Reparacion> reparaciones) {
        super(marca, modelo, color, matricula, precioCompra, precioVenta, exposicion);
        this.setReparaciones(reparaciones);
    }

    public Industrial(String marca, String modelo, String color, String matricula, double precioVenta, double precioCompra) {
        super(marca, modelo, color, matricula, precioCompra, precioVenta, null);
    }

    public Industrial(String marca, String modelo, String color, String matricula, double precioVenta, double precioCompra, Exposicion exposicion) {
        super(marca, modelo, color, matricula, precioCompra, precioVenta, exposicion);
    }
}
