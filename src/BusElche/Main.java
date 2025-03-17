package BusElche;

import java.util.*;

public class Main {
    static Map<Integer, ParadasBus> paradasMap = new HashMap<>();
    static RedTransporte redTransporte = new RedTransporte();
    static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {
        inicializarDatos();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Elige parada inicial: ");
        int inicio = scanner.nextInt();
        System.out.println("Has elegido " + paradasMap.get(inicio).getNombre());

        System.out.print("Bus Línea: ");
        String linea = scanner.next();

        System.out.print("Elige Parada final: ");
        int destino = scanner.nextInt();
        System.out.println("Has elegido " + paradasMap.get(destino).getNombre());

        calcularRuta(inicio, destino, linea);

    }
    private static void inicializarDatos() {
        paradasMap.put(1, new ParadasBus(1, "Centre-Doctor Caro", 1));
        paradasMap.put(2, new ParadasBus(2, "Vicente Blasco Ibáñez", 22));
        paradasMap.put(3, new ParadasBus(3, "Vicente Blasco Ibáñez", 80));
        paradasMap.put(4, new ParadasBus(4, "Inem Carrús", 3));
        paradasMap.put(5, new ParadasBus(5, "Pedro Moreno Sastre", 62));
        paradasMap.put(71, new ParadasBus(71, "Jorge Juan-Reina Victoria", 34));
        paradasMap.put(335, new ParadasBus(335, "Gabriel Miró", 3));
        paradasMap.put(346, new ParadasBus(346, "Passeig de Germanles", 45));
        paradasMap.put(347, new ParadasBus(347, "Passeig de Germanles", 67));
        paradasMap.put(115, new ParadasBus(115, "Centre-Avg. C.Valenciana", 34));
        paradasMap.put(89, new ParadasBus(89, "Avinguda Llibertat", 11));
        paradasMap.put(90, new ParadasBus(90, "Renfe-Parc Municipal", 90));
        paradasMap.put(117, new ParadasBus(117, "Virgen de la Cabeza-Ll. del Pensionista", 78));
        paradasMap.put(56, new ParadasBus(56, "Cristóbal Sanz", 78));

        LineasBus lineaA = new LineasBus("A");
        lineaA.agregarParada(paradasMap.get(1), 75);
        lineaA.agregarParada(paradasMap.get(2), 60);
        lineaA.agregarParada(paradasMap.get(3), 40);
        lineaA.agregarParada(paradasMap.get(4), 50);
        lineaA.agregarParada(paradasMap.get(5), 80);

        LineasBus lineaI = new LineasBus("I");
        lineaI.agregarParada(paradasMap.get(3), 50);
        lineaI.agregarParada(paradasMap.get(71), 100);
        lineaI.agregarParada(paradasMap.get(335), 70);
        lineaI.agregarParada(paradasMap.get(346), 50);
        lineaI.agregarParada(paradasMap.get(347), 120);

        LineasBus lineaJ = new LineasBus("J");
        lineaJ.agregarParada(paradasMap.get(115), 125);
        lineaJ.agregarParada(paradasMap.get(2), 75);
        lineaJ.agregarParada(paradasMap.get(89), 40);
        lineaJ.agregarParada(paradasMap.get(90), 80);
        lineaJ.agregarParada(paradasMap.get(117), 40);

        LineasBus lineaF = new LineasBus("F");
        lineaF.agregarParada(paradasMap.get(115), 125);
        lineaF.agregarParada(paradasMap.get(2), 45);
        lineaF.agregarParada(paradasMap.get(56), 40);
        lineaF.agregarParada(paradasMap.get(89), 75);
        lineaF.agregarParada(paradasMap.get(90), 70);

        redTransporte.agregarLinea(lineaA);
        redTransporte.agregarLinea(lineaI);
        redTransporte.agregarLinea(lineaJ);
        redTransporte.agregarLinea(lineaF);

    }
    private static void calcularRuta(int inicio, int destino, String linea) {
        LineasBus lineaBus = redTransporte.getLinea(linea);
        if (lineaBus == null) {
            System.out.println("La línea especificada no existe.");
            return;
        }

        int tiempoTotal = 0;
        boolean rutaEncontrada = false;
        for (ParadasBus parada : lineaBus.paradas) {
            if (parada.getNumero() == inicio) {
                rutaEncontrada = true;
            }
            if (rutaEncontrada) {
                tiempoTotal += lineaBus.tiempos.getOrDefault(parada, 0);
            }
            if (parada.getNumero() == destino) {
                break;
            }
        }

        if (rutaEncontrada) {
            System.out.println("Duración trayecto: " + tiempoTotal + " segundos.");
        } else {
            System.out.println("Ruta no encontrada en la línea especificada.");
        }
    }
}

