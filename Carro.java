package oop.estacionamientogestion;

import java.io.Serializable;

public class Carro extends Vehiculo implements Serializable {
    
    private int puertas;

    public Carro(Motor motor, String marca, String placas, String token, String color, int anioFabricacion, int puertas) {
        super(motor, marca, placas, token, color, anioFabricacion);
        this.puertas = puertas;
    }
}
