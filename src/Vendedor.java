public class Vendedor {
    private String nombre;
    private String apellido;
    private double comision;

    public Vendedor(String nombre, String apellido, double comision) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.comision = comision;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }
}