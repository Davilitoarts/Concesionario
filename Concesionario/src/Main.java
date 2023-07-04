import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Concesionario concesionario = new Concesionario(new HashMap(), new HashMap(), new HashMap(), new ArrayList());
        concesionario.vendedores();
        concesionario.imprimirDatosVendedor();
        concesionario.removeVendedor();
    }
}