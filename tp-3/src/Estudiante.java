
public class Estudiante {
    private String nombre;
    private String apellido;
    private String curso;
    private double calificacion;

    public Estudiante() {
    }

    public Estudiante(String nombre, String apellido, String curso, double calificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
        this.calificacion = calificacion;
    }

    public void mostrarInfo(){
        System.out.println(
                "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", curso='" + curso + '\'' +
                ", calificacion=" + calificacion +
                '}');
    }

    public void subirCalificacion(double puntos){
        if(puntos+this.calificacion >= 10){
            this.calificacion=10;
        }else{
            this.calificacion += puntos;
        }
    }

    public void bajarCalificacion(double puntos){
        if(this.calificacion - puntos <= 0){
            this.calificacion=0;
        }else{
            this.calificacion -= puntos;
        }
    }
}
