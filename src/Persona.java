public class Persona {
    private String nombre;
    private String direccion;
    private String DNI;
    private int telefono;

    public Persona(String nombre, String direccion, String DNI, int telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.DNI = DNI;
        this.telefono = telefono;
    }

    public Persona(String nombre, String direccion) {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
