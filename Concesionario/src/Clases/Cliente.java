package Clases;

import Comprobaciones.Int.ComprobarEdad;
import Excepciones.InvalidException;

import java.util.ArrayList;

public class Cliente extends Persona {
    private int edad;
    private ArrayList<Coche> cochesComprados;
    private ArrayList<Coche> cochesReservados;
    private ComprobarEdad comprobarEdad = new ComprobarEdad();

    public Cliente(String nombre, String apellido,  int edad, String direccion, String DNI, int telefono) throws InvalidException {
        super(nombre, apellido, direccion, DNI, telefono);
        comprobarEdad.comprobacion(edad);
        this.edad = edad;
        cochesComprados = new ArrayList<>();
        cochesReservados = new ArrayList<>();
    }

    public ArrayList<Coche> getCochesComprados() {
        return cochesComprados;
    }
    public ArrayList<Coche> getCochesReservados() {
        return cochesReservados;
    }

    public void agregarCocheComprado(Coche coche) {
        cochesComprados.add(coche);

    }
    public void agregarCocheReservado(Coche coche) {
        cochesReservados.add(coche);
    }
    public void removeCocheReservado(Coche coche){
        cochesReservados.remove(coche);

    }
}
