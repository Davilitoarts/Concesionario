import java.time.LocalDate;
import java.util.ArrayList;

public class Coche {
    private String marca;
    private String modelo;
    private String color;
    private String matricula;
    private double precioCompra;
    private double precioVenta;
    private LocalDate fechaCompra;
    private EstadoCoche estado;
    private ArrayList<Reparacion> reparaciones;

    public Coche(String marca, String modelo, String color, String matricula, double precioCompra, double precioVenta, LocalDate fechaCompra) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.matricula = matricula;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.fechaCompra = fechaCompra;
        this.estado = EstadoCoche.EN_VENTA;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public EstadoCoche getEstado() {
        return estado;
    }

    public void setEstado(EstadoCoche estado) {
        this.estado = estado;
    }

    public void cambiarEstado(EstadoCoche nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public void agregarReparacion(Reparacion reparacion) {
        reparaciones.add(reparacion);
    }

    public ArrayList<Reparacion> obtenerReparaciones() {
        return reparaciones;
    }

    public Coche(String marca, String modelo, String color, String matricula, double precioCompra, double precioVenta, LocalDate fechaCompra, EstadoCoche estado, ArrayList<Reparacion> reparaciones) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.matricula = matricula;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.fechaCompra = fechaCompra;
        this.estado = estado;
        this.reparaciones = reparaciones;
    }

    public int getIdentificacion() {
        return 0;
    }

    public void setReparaciones(ArrayList<Reparacion> reparaciones) {
        this.reparaciones = reparaciones;
    }

    public ArrayList<Reparacion> getReparaciones() {
        return reparaciones;
    }
}