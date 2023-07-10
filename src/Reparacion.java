import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Reparacion {
    private TipoReparacion tipo;
    private Date fecha;
    private String descripcion;
    private Coche coche;

    private static List<Reparacion> reparacionesReparadas = new ArrayList<>(); // Lista para almacenar las reparaciones reparadas

    public Reparacion(TipoReparacion tipo, Date fecha, String descripcion, Coche coche) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.coche = coche;
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

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    // Método para cambiar el estado de un coche a "En reparación"
    public void cambiarEstadoCocheEnReparacion() {
        coche.setEstado("En reparación");
    }

    // Método para reparar un coche y cambiar su estado a "Reparado"
    public void repararCoche() {
        coche.setEstado("Reparado");
        reparacionesReparadas.add(this); // Agregamos la reparación a la lista de reparaciones reparadas
    }

    // Método para consultar las reparaciones de un coche y mostrarlas ordenadas por fecha (de la más reciente a la más antigua)
    public List<Reparacion> consultarReparacionesDeCoche(Coche coche) {
        List<Reparacion> reparaciones = new ArrayList<>();
        for (Reparacion reparacion : reparacionesReparadas) {
            if (reparacion.getCoche().equals(coche)) {
                reparaciones.add(reparacion);
            }
        }
        reparaciones.sort((r1, r2) -> r2.getFecha().compareTo(r1.getFecha()));
        return reparaciones;
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