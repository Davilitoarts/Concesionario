import java.util.ArrayList;

public class Coche {
    private String marca;
    private String modelo;
    private String color; //he añadido este atributo
    private String tipo;
    private String estado;
    private String matricula;
    private float precioVenta;
    private float precioCompra;
    private Exposicion exposicion;
    private ArrayList<Reparacion> reparaciones;


    public Coche(String marca, String modelo, String color, String tipo, String estado, String matricula, float precioVenta, float precioCompra, ArrayList<Reparacion> reparaciones) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tipo = tipo;
        this.estado = estado;
        this.matricula = matricula;
        this.precioVenta = precioVenta;
        this.precioCompra = precioCompra;
        this.reparaciones = reparaciones;
    }

    public Coche(String marca, String modelo, String color, String tipo, String estado, String matricula, float precioVenta, float precioCompra, Exposicion exposicion, ArrayList<Reparacion> reparaciones) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tipo = tipo;
        this.estado = estado;
        this.matricula = matricula;
        this.precioVenta = precioVenta;
        this.precioCompra = precioCompra;
        this.exposicion = exposicion;
        this.reparaciones = reparaciones;
    }

    public Coche(String marca, String modelo, String color, String tipo, String estado, String matricula, float precioVenta, float precioCompra) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tipo = tipo;
        this.estado = estado;
        this.matricula = matricula;
        this.precioVenta = precioVenta;
        this.precioCompra = precioCompra;
    }

    public Coche(String marca, String modelo, String color, String tipo, String estado, String matricula, float precioVenta, float precioCompra, Exposicion exposicion) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tipo = tipo;
        this.estado = estado;
        this.matricula = matricula;
        this.precioVenta = precioVenta;
        this.precioCompra = precioCompra;
        this.exposicion = exposicion;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Exposicion getExposiciones() {
        return exposicion;
    }

    public void setExposiciones(Exposicion exposicion) {
        this.exposicion = exposicion;
    }

    public ArrayList<Reparacion> getReparaciones() {
        return reparaciones;
    }

    public void setReparaciones(ArrayList<Reparacion> reparaciones) {
        this.reparaciones = reparaciones;
    }

    public void comprar() {
    }

    public void reservar() {
    }

    public void cambiarExposicion() {
    }

}
