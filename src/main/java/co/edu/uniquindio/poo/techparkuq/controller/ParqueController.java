package co.edu.uniquindio.poo.techparkuq.controller;

public class ParqueController {

    private String nombre;
    private String direccion;
    private String nit;
    private int aforoMaximo;

    public ParqueController(String nombre, String direccion, String nit, int aforoMaximo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.nit = nit;
        this.aforoMaximo = aforoMaximo;
    }
}
