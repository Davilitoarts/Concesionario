import java.util.ArrayList;

public class Todoterreno extends Coche{
    public Todoterreno(String marca, String modelo, String color, String tipo, String estado, String matricula, float precioVenta, float precioCompra, ArrayList<Reparacion> reparaciones) {
        super(marca, modelo, color, "todoterreno", estado, matricula, precioVenta, precioCompra, reparaciones);
    }

    public Todoterreno(String marca, String modelo, String color, String tipo, String estado, String matricula, float precioVenta, float precioCompra, Exposicion exposicion, ArrayList<Reparacion> reparaciones) {
        super(marca, modelo, color, "todoterreno", estado, matricula, precioVenta, precioCompra, exposicion, reparaciones);
    }

    public Todoterreno(String marca, String modelo, String color, String tipo, String estado, String matricula, float precioVenta, float precioCompra) {
        super(marca, modelo, color, "todoterreno", estado, matricula, precioVenta, precioCompra);
    }

    public Todoterreno(String marca, String modelo, String color, String tipo, String estado, String matricula, float precioVenta, float precioCompra, Exposicion exposicion) {
        super(marca, modelo, color, "todoterreno", estado, matricula, precioVenta, precioCompra, exposicion);
    }
}
