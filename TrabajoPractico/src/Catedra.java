import java.util.ArrayList;

public class Catedra {
    private int codigo;
    private String denominacion;
    private DivisionCurso divisionCurso;
    private ArrayList<Nota> notas;
    private ArrayList<Alumno> alumnos;
    private static int contador=1;

    public Catedra(int codigo,String denominacion) {
        this.codigo = codigo;
        this.denominacion = denominacion;
        alumnos = new ArrayList<>();
        notas = new ArrayList<>();
    }

    public Catedra() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Nota> notas) {
        this.notas = notas;
    }

    public void agregarNota(Nota nota){
        notas.add(nota);
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public void agregarAlumno(Alumno alumno){ this.alumnos.add(alumno);}

    @Override
    public String toString() {
        return "Catedra{" +
                "codigo=" + codigo +
                ", denominacion='" + denominacion + '\'' +
                ", divisionCurso=" + divisionCurso +
                ", notas=" + notas +
                ", alumnos=" + alumnos +
                '}';
    }

    public Alumno mejorAlumnoCatedra(){
        Alumno mejorAlumno = alumnos.get(0);
        for (Alumno alumno:alumnos){
            if(alumno.promedioNotas((Integer) this.codigo) > mejorAlumno.promedioNotas((Integer) this.codigo)){
                mejorAlumno = alumno;
            }
        }
        return mejorAlumno;
    }
}
