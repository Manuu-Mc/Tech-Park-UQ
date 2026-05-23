package co.edu.uniquindio.poo.techparkuq.model.records;

import co.edu.uniquindio.poo.techparkuq.model.enums.EstadoAcceso;
import java.time.LocalDateTime;

public record RegistroAcceso(
    String nombreAtraccion,
    EstadoAcceso estado,
    String motivo,
    LocalDateTime fechaHora,
    int puntosUsados
) {
}
