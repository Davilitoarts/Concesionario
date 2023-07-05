import java.util.Date;

public class Reparacion {
    private TipoReparacion tipo;
    private Date fecha;
    private String descripcion;

    public Reparacion(TipoReparacion tipo, Date fecha, String descripcion) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public TipoReparacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoReparacion tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Otros métodos relevantes para la gestión de reparaciones

    @Override
    public String toString() {
        return "Reparacion{" +
                "tipo=" + tipo +
                ", fecha=" + fecha +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}

// Enumeración para representar los tipos de reparación
enum TipoReparacion {
    MECANICA,
    ELECTRICA,
    CHAPA,
    REVISION
}