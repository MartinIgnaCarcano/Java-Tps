public class Gallina {
    private int id;
    private static int contador=1;
    private int edad;
    private int huevosPuestos;

    public Gallina(int edad, int huevosPuestos) {
        this.id = contador;
        this.edad = edad;
        this.huevosPuestos = huevosPuestos;
        contador++;
    }

    public void ponerHuevo(){
        this.huevosPuestos +=1;
    }

    public void envejecer(){
        this.edad +=1;
    }

    public void mostrarEstado() {
        System.out.println("Gallina{" +
                "id=" + id +
                ", edad=" + edad +
                ", huevosPuestos=" + huevosPuestos +
                '}');
    }
}
