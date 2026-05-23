package co.edu.uniquindio.poo.techparkuq.model.records;

import java.time.LocalDateTime;
import co.edu.uniquindio.poo.techparkuq.model.enums.TipoNotificacion;

public record Notificacion(
        String mensaje,
        LocalDateTime fechaHora,
        TipoNotificacion formatoNotificacion
) {
}
