import java.io.Serializable;

public class Moto extends Vehiculo implements Serializable {
    
    private boolean sidecar;

    public Moto(Motor motor, String marca, String placas, String token, String color, int anioFabricacion, boolean sidecar) {
        super(motor, marca, placas, token, color, anioFabricacion);
        this.sidecar = sidecar;
    }
    
}
