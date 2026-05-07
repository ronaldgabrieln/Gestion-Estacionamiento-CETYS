package oop.estacionamientogestion;
import java.io.Serializable;

public class Motor implements Serializable {
    private boolean esAutomatico;

    public Motor(boolean esAutomatico) {
        this.esAutomatico = esAutomatico;
    }

    public void acelerar() {
        System.out.println("El motor está acelerando.");
    }
}
