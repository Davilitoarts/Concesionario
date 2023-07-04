import java.time.LocalDate;

public class Reparacion {
    private Coche coche;
    private LocalDate fecha;
    private String descripcion;

    public Reparacion(Coche coche, LocalDate fecha, String descripcion) {
        this.coche = coche;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public Coche getCoche() {
        return coche;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}