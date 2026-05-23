package co.edu.uniquindio.poo.techparkuq.model.records;

public record BalanceDiario(
        float ingresoTotal,
        int totalVisitantes,
        String atraccionMasVisitada,
        int cantidadCierreClima
) {

    public double calcularPromedioIngresoPersona() {

        if(totalVisitantes == 0){
            return 0;
        }

        return ingresoTotal / totalVisitantes;
    }
}
