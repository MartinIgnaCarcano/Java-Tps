import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DivisionCurso {
    private int codigo;
    private int anio;
    private int division;
    private Escuela escuela;
    private ArrayList<Catedra> catedras;

    public DivisionCurso(int codigo, int anio, int division, Escuela escuela) {
        this.codigo = codigo;
        this.anio = anio;
        this.division = division;
        this.escuela = escuela;
        this.catedras = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public Escuela getEscuela() {
        return escuela;
    }

    public void setEscuela(Escuela escuela) {
        this.escuela = escuela;
    }

    public ArrayList<Catedra> getCatedras() {
        return catedras;
    }

    public void setCatedras(ArrayList<Catedra> catedras) {
        this.catedras = catedras;
    }

    public void agregarCatedra(Catedra catedra){ this.catedras.add(catedra);}

    @Override
    public String toString() {
        return "DivisionCurso{" +
                "codigo=" + codigo +
                ", anio=" + anio +
                ", division=" + division +
                ", escuela=" + escuela +
                ", catedras=" + catedras +
                '}';
    }

    public Alumno mejorAlumnoDivisionCurso() {
        // Variable para guardar el mejor alumno de toda la división
        Alumno mejorAlumnoGlobal = null;
        double mejorPromedioGlobal = -1;

        // Recorro todas las cátedras de divisionCurso
        for (Catedra catedra : catedras) {
            List<Alumno> alumnosFiltrados = new ArrayList<>();

            // Filtro los alumnos que tengan al menos 5 exámenes sin recuperar ninguno
            for (Alumno alumno : catedra.getAlumnos()) {
                int countExamenes = 0;
                boolean recupero = false;

                // Recorro las notas del alumno para ver si recuperó y cuántos exámenes tiene
                for (Nota nota : alumno.getNotas()) {
                    if (!nota.isEsRecuperatorio()) {
                        countExamenes++;
                    } else {
                        // Si recuperó aunque sea una vez, ya no lo considero
                        recupero = true;
                        break;
                    }
                }

                // Si pasó el filtro, lo agrego a la lista de alumnos válidos de esta cátedra
                if (countExamenes >= 5 && !recupero) {
                    alumnosFiltrados.add(alumno);
                }
            }

            // Busco entre los alumnos válidos de esta cátedra quién tiene el mejor promedio
            for (Alumno alumno : alumnosFiltrados) {
                double promedio = alumno.promedioNotas(null); // uso null porque considera todas las notas

                // Si el promedio es mayor al mejor promedio global, actualizo el mejor alumno global
                if (promedio > mejorPromedioGlobal) {
                    mejorPromedioGlobal = promedio;
                    mejorAlumnoGlobal = alumno;
                }
            }
        }

        // Devuelvo el mejor alumno de toda la división (puede ser null si nadie cumplía con las condiciones)
        return mejorAlumnoGlobal;
    }




}
