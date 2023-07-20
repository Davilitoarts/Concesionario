package Clases;
import Comprobaciones.Float.ComprobarPrecioCompra;
import Comprobaciones.Float.ComprobarPrecioVenta;
import Comprobaciones.String.*;
import Excepciones.InvalidException;

import java.util.ArrayList;

public class Coche {
    private TipoCoche tipo;
    private String marca;
    private String modelo;
    private String color; //he añadido este atributo
    private EstadoCoche estado;
    private String matricula;
    private float precioVenta;
    private float precioCompra;

    private ArrayList<Reparacion> reparaciones;
    private ComprobarMarca comprobarMarca = new ComprobarMarca();
    private ComprobarModelo comprobarModelo = new ComprobarModelo();
    private ComprobarColor comprobarColor = new ComprobarColor();
    private ComprobarMatricula comprobarMatricula = new ComprobarMatricula();
    private ComprobarPrecioVenta comprobarPrecioVenta = new ComprobarPrecioVenta();
    private ComprobarPrecioCompra comprobarPrecioCompra = new ComprobarPrecioCompra();

    public Coche(TipoCoche tipo, String marca, String modelo, String color, EstadoCoche estado, String matricula, float precioVenta, float precioCompra) throws InvalidException {
        this.tipo = tipo;
        comprobarMarca.comprobacion(marca);
        this.marca = marca;
        comprobarModelo.comprobacion(modelo);
        this.modelo = modelo;
        comprobarColor.comprobacion(color);
        this.color = color;
        this.estado = estado;
        comprobarMatricula.comprobacion(matricula);
        this.matricula = matricula;
        comprobarPrecioVenta.comprobacion(precioVenta);
        this.precioVenta = precioVenta;
        comprobarPrecioCompra.comprobacion(precioCompra);
        this.precioCompra = precioCompra;

        this.reparaciones = new ArrayList<>();
    }

    public TipoCoche getTipo() {
        return tipo;
    }

    public void setTipo(TipoCoche tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public EstadoCoche getEstado() {
        return estado;
    }

    public void setEstado(EstadoCoche estado) {
        this.estado = estado;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public ArrayList<Reparacion> getReparaciones() {
        return reparaciones;
    }

    public void setReparaciones(ArrayList<Reparacion> reparaciones) {
        this.reparaciones = reparaciones;
    }


    public void agregarCocheAReparar(Reparacion reparacion) {
        reparaciones.add(reparacion);
    }

    public void agregarCochesReparados(Reparacion reparacion) {
        if (reparacion.isResuelta()) {
            reparaciones.add(reparacion); // Agregamos la reparación a la lista de reparaciones reparadas
        }
    }

    public void imprimirReparaciones() {
        reparaciones.sort((r1, r2) -> r2.getFecha().compareTo(r1.getFecha()));
        System.out.println("Reparaciones del coche: " + matricula);
        for (Reparacion reparacion : reparaciones) {
            System.out.println("Tipo de reparación: " + reparacion.getTipo());
            if(reparacion.isResuelta() == true) System.out.println("Estado: resuelta");
            else System.out.println("Estado: no resuelta");
            System.out.println("Fecha: " + reparacion.getFecha());
            System.out.println("--------------------------");
        }
    }

}

