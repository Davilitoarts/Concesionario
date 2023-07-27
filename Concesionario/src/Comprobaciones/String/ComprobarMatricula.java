package Comprobaciones.String;

import Excepciones.InvalidException;

public class ComprobarMatricula extends ComprobacionString {
    @Override
    public void comprobacion(String matricula) throws InvalidException {

        if (matricula == null) throw new InvalidException("La matrícula no puede estar vacía");
        if (matricula.length() != 7 || !matricula.substring(4).matches("[A-Z]{3}")) throw new InvalidException("La matrícula introducida no es válida");
    }
}
