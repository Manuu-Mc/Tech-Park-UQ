package co.edu.uniquindio.poo.techparkuq.model.records;

import java.time.LocalDate;

public record TicketData(String id, String tipoTicket, float precioPagado, LocalDate fechaCompra) {
}
