package BusElche;

public class ParadasBus {
    int numero;
    String nombre;
    int dirección;

    public ParadasBus(int numero, String nombre, int dirección) {
        this.numero = numero;
        this.nombre = nombre;
        this.dirección = dirección;
    }

    public int getDirección() {
        return dirección;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }
}
