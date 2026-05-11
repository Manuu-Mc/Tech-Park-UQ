package co.edu.uniquindio.poo.techparkuq.model;

public enum TipiAtraccion {
    ACUATICA,
    MECANICA_ALTURA,
    INFANTIL,
    OTRO;

    public boolean esSensibleAlClima() {
        return this == ACUATICA || this == MECANICA_ALTURA;
    }
}
