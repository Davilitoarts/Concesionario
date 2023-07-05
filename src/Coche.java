import java.util.ArrayList;
import java.util.List;

public class Coche {
    private String marca;
    private String modelo;
    private String matricula;
    private double precioCompra;
    private double precioVenta;
    private EstadoCoche estado;
    private TipoCoche tipo;
    private List<Reparacion> reparaciones;

    public Coche(String marca, String modelo, String matricula, double precioCompra, double precioVenta, EstadoCoche estado, TipoCoche tipo) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.estado = estado;
        this.tipo = tipo;
        this.reparaciones = new ArrayList<>();
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public EstadoCoche getEstado() {
        return estado;
    }

    public void setEstado(EstadoCoche estado) {
        this.estado = estado;
    }

    public TipoCoche getTipo() {
        return tipo;
    }

    public void setTipo(TipoCoche tipo) {
        this.tipo = tipo;
    }

    public List<Reparacion> getReparaciones() {
        return reparaciones;
    }

    public void addReparacion(Reparacion reparacion) {
        reparaciones.add(reparacion);
    }

    public void removeReparacion(Reparacion reparacion) {
        reparaciones.remove(reparacion);
    }

    public void mostrarReparaciones() {
        if (reparaciones.isEmpty()) {
            System.out.println("No hay reparaciones para este coche.");
        } else {
            System.out.println("Reparaciones realizadas en el coche " + matricula + ":");
            for (Reparacion reparacion : reparaciones) {
                System.out.println("- " + reparacion.getTipo() + ", Fecha: " + reparacion.getFecha());
            }
        }
    }

    // Otros métodos relevantes para la gestión de coches

    @Override
    public String toString() {
        return "Coche{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", matricula='" + matricula + '\'' +
                ", precioCompra=" + precioCompra +
                ", precioVenta=" + precioVenta +
                ", estado=" + estado +
                ", tipo=" + tipo +
                '}';
    }

    public static enum EstadoCoche {
        REPARADO,
        EN_VENTA,
        RESERVADO,
        VENDIDO
    }

    public static enum TipoCoche {
        TURISMO,
        INDUSTRIAL,
        TODOTERRENO
    }
}