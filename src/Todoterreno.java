import java.util.ArrayList;

public class Todoterreno extends Coche{


    public Todoterreno(String tipo, String marca, String modelo, String color, String estado, String matricula, float precioVenta, float precioCompra) {
        super(tipo, marca, modelo, color, estado, matricula, precioVenta, precioCompra);
    }

    @Override
    public String getTipo() {
        return super.getTipo();
    }

    @Override
    public void setTipo(String tipo) {
        super.setTipo(tipo);
    }

    @Override
    public String getMarca() {
        return super.getMarca();
    }

    @Override
    public void setMarca(String marca) {
        super.setMarca(marca);
    }

    @Override
    public String getModelo() {
        return super.getModelo();
    }

    @Override
    public void setModelo(String modelo) {
        super.setModelo(modelo);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public void setColor(String color) {
        super.setColor(color);
    }

    @Override
    public String getEstado() {
        return super.getEstado();
    }

    @Override
    public void setEstado(String estado) {
        super.setEstado(estado);
    }

    @Override
    public String getMatricula() {
        return super.getMatricula();
    }

    @Override
    public void setMatricula(String matricula) {
        super.setMatricula(matricula);
    }

    @Override
    public float getPrecioVenta() {
        return super.getPrecioVenta();
    }

    @Override
    public void setPrecioVenta(float precioVenta) {
        super.setPrecioVenta(precioVenta);
    }

    @Override
    public float getPrecioCompra() {
        return super.getPrecioCompra();
    }

    @Override
    public void setPrecioCompra(float precioCompra) {
        super.setPrecioCompra(precioCompra);
    }

    @Override
    public Exposicion getExposiciones() {
        return super.getExposiciones();
    }

    @Override
    public void setExposiciones(Exposicion exposicion) {
        super.setExposiciones(exposicion);
    }

    @Override
    public ArrayList<Reparacion> getReparaciones() {
        return super.getReparaciones();
    }

    @Override
    public void setReparaciones(ArrayList<Reparacion> reparaciones) {
        super.setReparaciones(reparaciones);
    }


    @Override
    public void cambiarExposicion() {
        super.cambiarExposicion();
    }
}

