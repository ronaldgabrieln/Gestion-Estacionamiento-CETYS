import java.io.Serializable;

public class Vehiculo implements Serializable {

    private Motor motor;
    private String marca;
    private String placas;
    private String token;
    private String color;
    private int anioFabricacion;

    public Vehiculo(Motor motor, String marca, String placas, String token, String color, int anioFabricacion) {
        this.motor = motor;
        this.marca = marca;
        this.placas = placas;
        this.token = token;
        this.color = color;
        this.anioFabricacion = anioFabricacion;
    }

    //Getters de atributos
    public Motor getMotor() {
        return motor;
    }

    public String getMarca() {
        return marca;
    }

    public String getPlacas() {
        return placas;
    }

    public String getToken() {
        return token;
    }

    public String getColor() {
        return color;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    //Setters de atributos
    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    
}
