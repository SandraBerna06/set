package EjercicioSet;

import java.util.Set;

public class PlanetaEnano extends CuerpoCeleste{
    String nombrePlaneta;
    double periodoOrbital;

    public PlanetaEnano(String nombre, double periodoOrbital, TipoCuerpoCeleste tipoCuerpo) {
        super(nombre, periodoOrbital, tipoCuerpo);
        this.nombrePlaneta = nombrePlaneta;
    }
}
