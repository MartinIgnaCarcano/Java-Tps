public class Mascota {
    private String nombre;
    private String especie;
    private int edad;

    public Mascota() {
    }

    public Mascota(String nombre, String especie, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }

    public void mostrarInfo(){
        System.out.println(
                "Mascota{" +
                "nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", edad=" + edad +
                '}');
    }

    public void cumpirAnios(){
        this.edad += 1;
    }
}
