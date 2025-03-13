package EjercicioSet;

import java.util.Set;

public class Planeta extends CuerpoCeleste {
    String nombrePlaneta;
    double periodoOrbital;

    public Planeta(String nombre, double periodoOrbital, TipoCuerpoCeleste tipoCuerpo) {
        super(nombre, periodoOrbital, tipoCuerpo);
    }

    public boolean addSatelite(CuerpoCeleste satelites){
        if (satelites.getTipoCuerpo() == TipoCuerpoCeleste.LUNA) {
            return super.addSatelite(satelites);
        }
        return false;
    }
    }

