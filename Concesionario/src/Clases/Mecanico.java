package Clases;

import Excepciones.InvalidException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Mecanico extends Persona {
    private ArrayList<Coche> cochesReparados;

    public Mecanico(String nombre, String apellido, String direccion, String DNI, int telefono) throws InvalidException {
        super(nombre, apellido, direccion, DNI, telefono);
        cochesReparados = new ArrayList<>();
    }

    public ArrayList<Coche> getCochesReparados() {
        return cochesReparados;
    }

    public void setCochesReparados(ArrayList<Coche> cochesReparados) {
        this.cochesReparados = cochesReparados;
    }

    public void listarReparacionesOrdenadas() {
        ArrayList<Reparacion> todasLasReparaciones = new ArrayList<>();

        for (Coche coche : cochesReparados) {
            todasLasReparaciones.addAll(coche.getReparaciones());
        }

        // Ordenar las reparaciones por fecha de más reciente a más antigua usando un comparador
        Collections.sort(todasLasReparaciones, Comparator.comparing(Reparacion::getFecha).reversed());

        // Imprimir la información de las reparaciones ordenadas
        System.out.println("Reparaciones de los coches reparados por el mecánico " + getNombre() + " " + getApellido() + ":");
        for (Reparacion reparacion : todasLasReparaciones) {
            System.out.println("Fecha: " + reparacion.getFecha() + ", Tipo: " + reparacion.getTipo());
        }
    }
}