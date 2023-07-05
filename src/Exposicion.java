public class Exposicion {
    private int numeroExposicion;
    private String direccion;
    private String telefono;

    public Exposicion(int numeroExposicion, String direccion, String telefono) {
        this.numeroExposicion = numeroExposicion;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getNumeroExposicion() {
        return numeroExposicion;
    }

    public void setNumeroExposicion(int numeroExposicion) {
        this.numeroExposicion = numeroExposicion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
