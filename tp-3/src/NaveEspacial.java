public class NaveEspacial {
    private String nombre;
    private int combustible;

    public NaveEspacial(String nombre, int combustible) {
        this.nombre = nombre;
        this.combustible = combustible;
    }

    public void despegar(){
        if(this.combustible<10){
            System.out.println("Despegando.......");
            this.combustible -= 10;
        }else{
            System.out.println("No se puede despegar por falta de combustible");
        }
    }
    public void avanzar(int distancia){
        if(this.combustible-distancia < 0){
            System.out.println("No se puede avanzar por falta de combustible");
        }else{
            System.out.println("Avanzando "+distancia+" unidades de distancia");
            this.combustible -= distancia;
        }
    }
    public void recargarCombustible(int cantidad){
        if(this.combustible+cantidad>=100){
            this.combustible=100;
        }else{
            this.combustible += cantidad;
        }
    }

    public void mostrarEstado(){
        System.out.println("NaveEspacial{" +
                "nombre='" + nombre + '\'' +
                ", combustible=" + combustible +
                '}');
    }

}
