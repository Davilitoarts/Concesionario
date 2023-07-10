public class Exposicion {
    private String tipo;
    private int numExposicion;
    private int telefono;
    private String direccion;

    public Exposicion(String tipo, int numExposicion, int telefono, String direccion) {
        this.tipo = tipo;
        this.numExposicion = numExposicion;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumExposicion() {
        return numExposicion;
    }

    public void setNumExposicion(int numExposicion) {
        this.numExposicion = numExposicion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void añadirCoche(Coche coche){}
    public void borrarCoche(Coche coche){}
}
