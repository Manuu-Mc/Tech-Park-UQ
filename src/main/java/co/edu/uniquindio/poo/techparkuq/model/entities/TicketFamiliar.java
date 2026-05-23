package co.edu.uniquindio.poo.techparkuq.model.entities;

import co.edu.uniquindio.poo.techparkuq.model.abstracts.Ticket;

public class TicketFamiliar extends Ticket {

    private static final long serialVersionUID = 1L;

    private float descuentoCondiciones;

    public TicketFamiliar(float valor, float descuento) {
        super(valor, false);
        this.descuentoCondiciones = descuento;
    }

    public float calcularDescuento() {
        return valor - (valor * descuentoCondiciones);
    }
}
