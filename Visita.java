package oop.estacionamientogestion;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Visita implements Serializable {
    
    private Vehiculo vehiculo;
    private LocalDateTime fechaYHora;

    public Visita(Vehiculo vehiculo, LocalDateTime fechaYHora) {
        this.vehiculo = vehiculo;
        this.fechaYHora = fechaYHora;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    @Override
    public String toString() {
        return "Visita{" +
                "vehiculo=" + vehiculo +
                ", fechaYHora=" + fechaYHora +
                '}';
    }
}
