package oop.estacionamientogestion;

public class FueraDeRangoException extends Exception {

    public FueraDeRangoException() {
        super("Valor fuera de rango permitido.");
    }

    public FueraDeRangoException(String message) {
        super(message);
    }

    public FueraDeRangoException(String message, Throwable cause) {
        super(message, cause);
    }

    public FueraDeRangoException(Throwable cause) {
        super(cause);
    }
}
