package EjercicioSet;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class Main {

    static Map<String, CuerpoCeleste> sistemaSolar=new HashMap<>();
    static Set<CuerpoCeleste> planetas=new HashSet<>();
    static Set<CuerpoCeleste> lunas=new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        CuerpoCeleste Mercurio = new Planeta("Mercurio", 88, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        sistemaSolar.put("Mercurio", Mercurio);
        planetas.add(Mercurio);

        CuerpoCeleste Venus = new Planeta("Venus", 225, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        sistemaSolar.put("Venus", Venus);
        planetas.add(Venus);

        CuerpoCeleste LaTierra = new Planeta("La Tierra", 365, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        sistemaSolar.put("La Tierra", LaTierra);
        planetas.add(LaTierra);

        CuerpoCeleste Marte = new Planeta("Marte", 687, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        sistemaSolar.put("Marte", Marte);
        planetas.add(Marte);

        CuerpoCeleste Jupiter = new Planeta("Júpiter", 4332, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        sistemaSolar.put("Jupiter", Jupiter);
        planetas.add(Jupiter);

        CuerpoCeleste Saturno = new Planeta("Saturno", 10759, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        sistemaSolar.put("Saturno", Saturno);
        planetas.add(Saturno);

        CuerpoCeleste Urano = new Planeta("Urano", 30660, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        sistemaSolar.put("Urano", Urano);
        planetas.add(Urano);

        CuerpoCeleste Neptuno = new Planeta("Neptuno", 165, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        sistemaSolar.put("Neptuno", Neptuno);
        planetas.add(Neptuno);

        CuerpoCeleste Pluton = new Planeta("Plutón", 248, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        sistemaSolar.put("Plutón", Pluton);
        planetas.add(Pluton);

        CuerpoCeleste Pluton2=new Planeta("Plutón",884, CuerpoCeleste.TipoCuerpoCeleste.PLANETA);
        sistemaSolar.put("Plutón", Pluton);
        planetas.add(Pluton2);

        CuerpoCeleste Pluton3=new PlanetaEnano("Plutón",884, CuerpoCeleste.TipoCuerpoCeleste.PLANETA_ENANO);
        sistemaSolar.put("Plutón ", Pluton);
        planetas.add(Pluton3);

        CuerpoCeleste Luna = new Luna("La Luna", 27, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        sistemaSolar.put("La Luna", Luna);
        LaTierra.addSatelite(Luna);

        CuerpoCeleste Luna2 = new Luna("Deimos", 1.3, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        sistemaSolar.put("Deimos", Luna2);
        Marte.addSatelite(Luna2);

        CuerpoCeleste Luna3 = new Luna("Phobos", 0.3, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        sistemaSolar.put("Phobos", Luna3);
        Marte.addSatelite(Luna3);

        CuerpoCeleste Luna4 = new Luna("lo", 1.8, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        sistemaSolar.put("lo", Luna4);
        Jupiter.addSatelite(Luna4);

        CuerpoCeleste Luna5 = new Luna("Europa", 3.5, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        sistemaSolar.put("Europa", Luna5);
        Jupiter.addSatelite(Luna5);

        CuerpoCeleste Luna6 = new Luna("Ganymede", 7.1, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        sistemaSolar.put("Ganymede", Luna6);
        Jupiter.addSatelite(Luna6);

        CuerpoCeleste Luna7 = new Luna("Callisto", 16.7, CuerpoCeleste.TipoCuerpoCeleste.LUNA);
        sistemaSolar.put("Callisto", Luna7);
        Jupiter.addSatelite(Luna7);


        System.out.println("Nombre de los planetas almacenados:");
        for (CuerpoCeleste planetas : planetas) {
            System.out.println("-" + planetas.getNombre());
        }
        System.out.println("---------------------------");

        Marte.getSatelites();
        System.out.println("Lunas de Marte");
        for (CuerpoCeleste lunas : Marte.getSatelites()) {
            System.out.println("-" + lunas.getNombre());
        }
        System.out.println("---------------------------");
            for(CuerpoCeleste planeta:planetas){
                System.out.println("Nombre planeta "+planeta.getNombre());
                System.out.println("Nombre satelites " +planeta.getSatelites());

            }

        System.out.println("---------------------------");

        System.out.println("Nombre de las lunas");
            for(CuerpoCeleste luna:planetas){
                lunas.addAll(luna.getSatelites());
            }
            for(CuerpoCeleste luna:lunas) {
                System.out.println("Lunas" +
                        "-" + luna.getNombre());
            }
        System.out.println("---------------------------");

        System.out.println("Imprimir planetas");
            for(CuerpoCeleste imprimirPlaneta: planetas){
                System.out.println( "-" +imprimirPlaneta.toString());
            }
        System.out.println("----------------------------------");
            unionLunas();
        System.out.println("---------------------------------------");
        System.out.println("Introduce el nombre del planeta");
        String nombre=scanner.nextLine();
        interseccionLunas(nombre);
        
        System.out.println("Introduce el nombre");
        String nombre2=scanner.nextLine();
        diferenciaLunas(nombre2);
        }
    public static void unionLunas(){
        System.out.println("Unión de todas las lunas: ");
        Set<CuerpoCeleste> lunas=new HashSet<>();
        for (CuerpoCeleste cuerpo: planetas){
            lunas.addAll(cuerpo.getSatelites());
        }
        System.out.println(lunas);
    }

    public static void interseccionLunas(String nombre){
        if(!sistemaSolar.containsKey(nombre)){
            System.out.println("No esxiste ese planeta");
            System.out.println("---------------------------");
            return;
        }
        System.out.println("Intersección con las lunas de " +nombre.toUpperCase()+ ":");
        Set<CuerpoCeleste> lunas=new HashSet<>();
        Set <CuerpoCeleste> lunasResto=new HashSet<>();

        for(CuerpoCeleste cuerpo:planetas){
            lunas.addAll(cuerpo.getSatelites());
        }

        lunasResto.addAll(sistemaSolar.get(nombre).getSatelites());
        lunas.retainAll(lunasResto);

        if(lunas.isEmpty()){
            System.out.println("No hay lunas en común");
        }else{
            System.out.println(lunas);
        }
        System.out.println("----------------------");
    }

    public static void diferenciaLunas(String nombre){
        if(!sistemaSolar.containsKey(nombre)){
            System.out.println("No esxiste ese planeta");
            System.out.println("---------------------------");
            return;
        }
        System.out.println("Intersección con las lunas de " +nombre.toUpperCase()+ ":");
        Set<CuerpoCeleste> lunas=new HashSet<>();
        Set <CuerpoCeleste> lunasResto=new HashSet<>();

        for(CuerpoCeleste cuerpo:planetas){
            lunas.addAll(cuerpo.getSatelites());
        }

        lunasResto.addAll(sistemaSolar.get(nombre).getSatelites());
        lunas.removeAll(lunasResto);

        System.out.println(lunas);
        System.out.println("------------------------");
    }
    }


