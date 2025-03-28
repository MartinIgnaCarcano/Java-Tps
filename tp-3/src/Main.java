//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("--------------ESTUDIANTE------------");
        Estudiante estud1 = new Estudiante("Martin","Carcano","PROG3",7.5);
        estud1.mostrarInfo();
        estud1.subirCalificacion(2.3);
        estud1.bajarCalificacion(5.0);
        System.out.println(" ");
        System.out.println("---------------MASCOTA---------------");
        Mascota masco = new Mascota("Porota","Callejera",14);
        masco.mostrarInfo();
        masco.cumpirAnios();
        masco.mostrarInfo();
        System.out.println(" ");
        System.out.println("---------------LIBRO---------------");
        Libro lib = new Libro("Las huellas del mar","Federico Andahazi",2022);
        lib.setAñoPublicacion(1800);
        lib.setAñoPublicacion(2023);
        System.out.println(lib);
        System.out.println(" ");
        System.out.println("---------------GALLINA---------------");
        Gallina gall1 = new Gallina(1,12);
        Gallina gall2 = new Gallina(1,7);
        gall1.ponerHuevo();
        gall1.ponerHuevo();
        gall2.ponerHuevo();
        gall1.envejecer();
        gall2.envejecer();
        gall1.mostrarEstado();
        gall2.mostrarEstado();
        System.out.println(" ");
        System.out.println("---------------NAVE ESPACIAL---------------");
        NaveEspacial nave = new NaveEspacial("Halcón Milenario",50);
        nave.avanzar(60);
        nave.recargarCombustible(40);
        nave.avanzar(60);
        nave.mostrarEstado();

        System.out.println("Segunda nave");
        NaveEspacial nave1 = new NaveEspacial("Enterprise",70);
        nave1.avanzar(60);
        nave1.recargarCombustible(200);
        nave1.avanzar(110);
        nave1.mostrarEstado();



    }
}