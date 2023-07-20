package Clases;

import Excepciones.InvalidException;

import java.util.ArrayList;

public class VendedorAComision extends Persona {
    private int sueldo;
    private ArrayList<Coche> cochesVendidos;

    public VendedorAComision(String nombre, String apellido, String direccion, String DNI, int telefono) throws InvalidException {
        super(nombre, apellido, direccion, DNI, telefono);
        cochesVendidos = new ArrayList<>();
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public ArrayList<Coche> getCochesVendidos() {
        return cochesVendidos;
    }

    public void setCochesVendidos(ArrayList<Coche> cochesVendidos) {
        this.cochesVendidos = cochesVendidos;
    }

    public void imprimirDatosVendedor(){
        System.out.println("Nombre del vendedor: " + getNombre());
        System.out.println("Dirección del vendedor: " + getDireccion());
        System.out.println("DNI del vendedor: " + getDNI());
        System.out.println("Teléfono del vendedor: " + getTelefono());
        System.out.println("El sueldo es de: " + sueldoAComision());
        System.out.println("------------------------");
    }
    public void imprimirCochesVendidos(){
        if(!cochesVendidos.isEmpty()){
            System.out.println("Coches vendidos: ");
            for (Coche coche : cochesVendidos){
                System.out.println("Marca: " + coche.getMarca());
                System.out.println("Modelo: " + coche.getModelo());
                System.out.println("Color: " + coche.getColor());
                System.out.println("Matrícula: " + coche.getMatricula());
                System.out.println("Precio de compra: " + coche.getPrecioCompra());
                System.out.println("Precio de venta: " + coche.getPrecioVenta());
                System.out.println();
            }
        }
        System.out.println("Este vendedor no ha vendido ningún coche");
    }
    public void agregarCocheVendido(Coche coche) {
        cochesVendidos.add(coche);
    }


    public int sueldoAComision(){
        return cochesVendidos.size() * 200;
    }

}
