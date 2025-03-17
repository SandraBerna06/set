package BusElche;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RedTransporte {
    Map<String, LineasBus> lineas;

    public RedTransporte() {
        this.lineas = new HashMap<>();
    }

    public void agregarLinea(LineasBus linea) {
        lineas.put(linea.linea, linea);
    }

    public LineasBus getLinea(String nombre) {
        return lineas.get(nombre);
    }
}
