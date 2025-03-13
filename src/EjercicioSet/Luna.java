package EjercicioSet;

import java.util.Set;

public class Luna extends CuerpoCeleste {
    String nombreLuna;
    double periodoOrbital;

    public Luna(String nombre, double periodoOrbital, TipoCuerpoCeleste tipoCuerpo) {
        super(nombre, periodoOrbital, tipoCuerpo);
    }
}
