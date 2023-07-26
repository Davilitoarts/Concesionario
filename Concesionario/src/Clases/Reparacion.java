package Clases;


public class Reparacion {
    private TipoReparacion tipo;
    private String fecha;
    private boolean resuelta;



    public Reparacion(TipoReparacion tipo, String fecha, boolean resuelta) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.resuelta = resuelta;

    }

    public TipoReparacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoReparacion tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isResuelta() {
        return resuelta;
    }

    public void setResuelta(boolean resuelta) {
        this.resuelta = resuelta;
    }

    @Override
    public String toString() {
        return "Reparacion{" +
                "tipo=" + tipo +
                ", fecha='" + fecha + '\'' +
                ", resuelta=" + resuelta +
                '}';
    }
}