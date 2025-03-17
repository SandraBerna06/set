package BusElche;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LineasBus {
    String linea;
    List<ParadasBus> paradas;
    Map<ParadasBus, Integer> tiempos;

    public LineasBus(String linea) {
        this.linea = linea;
        this.paradas = new ArrayList<>();
        this.tiempos = new HashMap<>();
    }

    public String getLinea() {
        return linea;
    }
    public void agregarParada(ParadasBus parada, int tiempo) {
        paradas.add(parada);
        tiempos.put(parada, tiempo);
    }
}
