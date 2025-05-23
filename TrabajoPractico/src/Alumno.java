import java.util.ArrayList;
import java.util.Date;

public class Alumno {
    private long legajo;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private ArrayList<Nota> notas;
    private Catedra catedra;

    public Alumno(long legajo, String nombre, String apellido, Date fechaNacimiento, Catedra catedra) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.catedra = catedra;
        this.notas = new ArrayList<>();
    }

    public Alumno() {
    }

    public long getLegajo() {
        return legajo;
    }

    public void setLegajo(long legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Nota> notas) {
        this.notas = notas;
    }

    public void agregarNota(Nota nota){this.notas.add(nota);}

    public Catedra getCatedra() {
        return catedra;
    }

    public void setCatedra(Catedra catedra) {
        this.catedra = catedra;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "legajo=" + legajo +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", notas=" + notas +
                ", catedra=" + catedra +
                '}';
    }

    public Nota mejorNota(Integer codigoCatedra){
        Nota  max = new Nota();
        max.setValor(0);
        if (codigoCatedra == null){
            for(Nota nota:notas){
                if (nota.getValor() > max.getValor() && !nota.isEsRecuperatorio()){
                    max = nota;
                }
            }
        }else{
            for(Nota nota:notas){
                if (codigoCatedra == nota.getCatedra().getCodigo() && !nota.isEsRecuperatorio()){
                    if (nota.getValor() > max.getValor()){
                        max = nota;
                    }
                }
            }
        }
        return max;
    }

    public double promedioNotas(Integer codigoCatedra){
        double  promedio = 0;
        int contador = 0;
        if (codigoCatedra == null){
            for(Nota nota:notas){
                promedio += nota.getValor();
            }
            promedio = promedio/notas.size();
        }else{
            for(Nota nota:notas){
                if (codigoCatedra == nota.getCatedra().getCodigo() && !nota.isEsRecuperatorio()){
                    promedio += nota.getValor();
                    contador++;
                }
            }
            promedio = promedio/contador;
        }
        return promedio;
    }
}
