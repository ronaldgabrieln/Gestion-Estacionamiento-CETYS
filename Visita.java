package oop.estacionamientogestion;
import java.time.LocalDateTime;

public class Visita {
    
    private Vehiculo vehiculo;
    private LocalDateTime fechaYHora;

    public Visita(Vehiculo vehiculo, LocalDateTime fechaYHora) {
        this.vehiculo = vehiculo;
        this.fechaYHora = fechaYHora;
    }
}
