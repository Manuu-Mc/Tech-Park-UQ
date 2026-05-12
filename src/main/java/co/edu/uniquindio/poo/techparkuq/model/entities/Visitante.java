package co.edu.uniquindio.poo.techparkuq.model.entities;

import co.edu.uniquindio.poo.techparkuq.model.abstracts.Persona;

public class Visitante extends Persona {

    private float estatura;
    private float saldoVirtual;

    public Visitante(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
        this.estatura = estatura;
        this.saldoVirtual = saldoVirtual;
    }
}
