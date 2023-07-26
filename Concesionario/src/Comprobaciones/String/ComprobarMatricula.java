package Comprobaciones.String;

import Excepciones.InvalidException;

public class ComprobarMatricula extends ComprobacionString{
    @Override
    public void comprobacion(String matricula) throws InvalidException {
        String ultimasTresLetras = matricula.substring(4);
        if(matricula == null) throw new InvalidException("La matrícula no puede estar vacía");
        if(matricula.matches(".*\\d.*")) throw new InvalidException("La matricula no puede contener solo números");
        if(matricula.length() !=7 && ultimasTresLetras.matches("[A-Z]{3}")) throw new InvalidException("La matrícula introducida no es válida");
    }
}
