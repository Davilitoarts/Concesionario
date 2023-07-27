package Clases;

import Excepciones.InvalidException;

import java.util.ArrayList;

public class VendedorAComision extends Persona {
    private int sueldo;
    private double volumenVentas;
    private int numeroVentas;
    private ArrayList<Coche> cochesVendidos;

    public VendedorAComision(String nombre, String apellido, String direccion, String DNI, int telefono) throws InvalidException {
        super(nombre, apellido, direccion, DNI, telefono);
        cochesVendidos = new ArrayList<>();
    }

    public ArrayList<Coche> getCochesVendidos() {
        return cochesVendidos;
    }

    public int getSueldo() throws InvalidException {
        return (int) getVolumenVentas() + sueldoAComision();
    }

    public double getVolumenVentas() {
        for (Coche coche : getCochesVendidos()) {
            volumenVentas += coche.getPrecioVenta();
        }
        return volumenVentas;
    }

    public int getNumeroVentas() {
        return getCochesVendidos().size();
    }

    public void setCochesVendidos(ArrayList<Coche> cochesVendidos) {
        this.cochesVendidos = cochesVendidos;
    }

    public void imprimirDatosVendedor(){
        System.out.println("Nombre: " + getNombre());
        System.out.println("Dirección: " + getDireccion());
        System.out.println("DNI del: " + getDNI());
        System.out.println("Teléfono: " + getTelefono());
        System.out.println("------------------------");
    }
    public void imprimirCochesVendidos() throws InvalidException {
        if(!cochesVendidos.isEmpty()){
            System.out.println("Coches vendidos: ");
            for (Coche coche : cochesVendidos){
                System.out.println("Marca: " + coche.getMarca());
                System.out.println("Modelo: " + coche.getModelo());
                System.out.println("Color: " + coche.getColor());
                System.out.println("Matrícula: " + coche.getMatricula());
                System.out.println("Precio de compra: " + coche.getPrecioCompra());
                System.out.println("Precio de venta: " + coche.getPrecioVenta());
                System.out.println("----------------------------------------------------");
            }
        }
        else System.out.println("Este vendedor no ha vendido ningún coche");
    }
    public void agregarCocheVendido(Coche coche) {
        cochesVendidos.add(coche);
    }
    public int sueldoAComision(){
        return getNumeroVentas() * 200;
    }

}
