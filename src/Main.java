import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Crear un concesionario
        Concesionario concesionario = new Concesionario("Concesionario XYZ", "Calle Principal 123");

        // Crear algunos coches
        Coche coche1 = new Coche("Ford", "Focus", "ABC123", 15000.0, 18000.0, Coche.EstadoCoche.EN_VENTA, Coche.TipoCoche.TURISMO);
        Coche coche2 = new Coche("Toyota", "Corolla", "DEF456", 20000.0, 22000.0, Coche.EstadoCoche.EN_VENTA, Coche.TipoCoche.TURISMO);
        Coche coche3 = new Coche("Honda", "Civic", "GHI789", 18000.0, 20000.0, Coche.EstadoCoche.EN_VENTA, Coche.TipoCoche.TURISMO);

        // Agregar los coches al concesionario
        concesionario.agregarCocheDisponible(coche1);
        concesionario.agregarCocheDisponible(coche2);
        concesionario.agregarCocheDisponible(coche3);

        // Crear un cliente
        Cliente cliente1 = new Cliente("Juan Pérez", "Calle Principal 456", "12345678A", "123456789");

        // Realizar una venta de coche
        concesionario.venderCoche("ABC123", cliente1);

        // Mostrar los coches disponibles en el concesionario
        concesionario.imprimirCochesDisponibles();

        // Mostrar los coches comprados por el cliente
        cliente1.imprimirCochesComprados();
    }
}