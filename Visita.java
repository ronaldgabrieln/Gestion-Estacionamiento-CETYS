import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Visita {
    
    private Vehiculo vehiculo;
    private LocalDateTime fechaYHora;

    public Visita(Vehiculo vehiculo, LocalDateTime fechaYHora) {
        this.vehiculo = vehiculo;
        this.fechaYHora = fechaYHora;
    }
}
