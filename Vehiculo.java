package oop.estacionamientogestion;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class Vehiculo implements Serializable {

    private Motor motor;
    private String marca;
    private String placas;
    /** No se persiste en inventario.dat; se regenera al deserializar o al cargar desde archivo. */
    private transient String token;
    private String color;
    private int anioFabricacion;

    public Vehiculo(Motor motor, String marca, String placas, String color, int anioFabricacion) {
        this.motor = motor;
        this.marca = marca;
        this.placas = placas;
        this.color = color;
        this.anioFabricacion = anioFabricacion;
        this.token = generarTokenTemporal();
    }

    private static String generarTokenTemporal() {
        //UUID es un identificador unico global
        //randomUUID() genera un UUID aleatorio que no se repite
        return UUID.randomUUID().toString();
    }

    /** Asigna un nuevo token temporal cuando leemos el archivo inventario.dat */
    public void asignarTokenTemporal() {
        this.token = generarTokenTemporal();
    }

    //necesita estar en la clase Vehiculo para poder ser llamada desde la clase administrarSerializacion
    // ya que el token es privado y no se asigna cuando se crea el objeto Vehiculo
    public static void asignarTokensTemporales(List<Vehiculo> vehiculos) {
        if (vehiculos == null) {
            return;
        }
        for (Vehiculo v : vehiculos) {
            v.asignarTokenTemporal();
        }
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

    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca='" + marca + '\'' +
                ", placas='" + placas + '\'' +
                ", color='" + color + '\'' +
                ", anioFabricacion=" + anioFabricacion +
                ", token='" + token + '\'' +
                ", motor=" + motor +
                '}';
    }
}
