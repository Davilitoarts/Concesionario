package Clases;

import Comprobaciones.Int.ComprobarNumExpo;
import Comprobaciones.Int.ComprobarTlf;
import Comprobaciones.String.ComprobarDireccion;
import Excepciones.InvalidException;

import java.util.ArrayList;

public class Exposicion {
    private int numExposicion;
    private int telefono;
    private String direccion;
    private ArrayList<Coche> coches;
    private ComprobarNumExpo comprobarNumExpo = new ComprobarNumExpo();
    private ComprobarDireccion comprobarDireccion = new ComprobarDireccion();
    private ComprobarTlf comprobarTlf = new ComprobarTlf();

    public Exposicion(int numExposicion, int telefono, String direccion) throws InvalidException {
        comprobarNumExpo.comprobacion(numExposicion);
        this.numExposicion = numExposicion;
        comprobarTlf.comprobacion(telefono);
        this.telefono = telefono;
        comprobarDireccion.comprobacion(direccion);
        this.direccion = direccion;
        coches = new ArrayList<>();

    }

    public int getNumExposicion() {
        return numExposicion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) throws InvalidException{
        comprobarTlf.comprobacion(telefono);
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) throws InvalidException{
        comprobarDireccion.comprobacion(direccion);
        this.direccion = direccion;
    }

    public ArrayList<Coche> getCoches() {
        return coches;
    }

    public void setCoches(ArrayList<Coche> coches) {
        this.coches = coches;
    }

    public void agregarCoche(Coche coche){
        coches.add(coche);
    }
    public void borrarCoche(Coche coche){
        coches.remove(coche);
    }
    public void imprimirCochesExpo () {
        for (Coche coche : coches) {
            System.out.println("Tipo: " + coche.getTipo());
            System.out.println("Marca: " + coche.getMarca());
            System.out.println("Modelo: " + coche.getModelo());
            System.out.println("Color: " + coche.getColor());
            System.out.println("Matricula: " + coche.getMatricula());
            System.out.println("Estado: " + coche.getEstado());
            System.out.println("Precio de venta: " + coche.getPrecioVenta());
            System.out.println("Precio de compra: " + coche.getPrecioCompra());
            System.out.println("------------------------------");
        }
    }


}