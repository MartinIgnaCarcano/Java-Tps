
import java.sql.SQLOutput;
import java.util.*;

public class Escuela {
    private int numero;
    private String denominacion;
    private List<DivisionCurso> divisionCursos;

    public Escuela(int numero, String denominacion) {
        this.numero = numero;
        this.denominacion = denominacion;
        this.divisionCursos = new ArrayList<>();
    }

    public Escuela() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public List<DivisionCurso> getDivisionesCursos() {
        return divisionCursos;
    }

    public void setDivisionesCursos(List<DivisionCurso> divisionesCursos) {
        this.divisionCursos = divisionesCursos;
    }

    public void agregarDivision(DivisionCurso divisionCurso){ this.divisionCursos.add(divisionCurso);}

    @Override
    public String toString() {
        return "Escuela{" +
                "numero=" + numero +
                ", denominacion='" + denominacion + '\'' +
                ", divisionesCursos=" + divisionCursos +
                '}';
    }

    public Alumno getMejorAlumnoEscuela(int anioNacimientoAlumno) {
        Alumno mejorAlumno = null;
        double mejorPromedio = -1;

        // Recorro todas las divisiones de curso de la escuela
        for (DivisionCurso divisionCurso : divisionCursos) {
            // Recorro todas las cátedras de la división
            for (Catedra catedra : divisionCurso.getCatedras()) {
                // Recorro los alumnos de la cátedra
                for (Alumno alumno : catedra.getAlumnos()) {
                    // Filtro por año de nacimiento
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(alumno.getFechaNacimiento());
                    int anioNacimiento = cal.get(Calendar.YEAR);
                    if (anioNacimiento == anioNacimientoAlumno) {
                        boolean recupero = false;

                        // Verifico si recuperó alguna vez
                        for (Nota nota : alumno.getNotas()) {
                            if (nota.isEsRecuperatorio()) {
                                recupero = true;
                                break;
                            }
                        }

                        // Si nunca recuperó, lo considero para mejor alumno
                        if (!recupero) {
                            double promedio = alumno.promedioNotas(null); // uso null para todas las notas
                            // Si es el primer alumno o tiene mejor promedio, lo guardo
                            if (promedio > mejorPromedio) {
                                mejorPromedio = promedio;
                                mejorAlumno = alumno;
                            }
                        }
                    }
                }
            }
        }

        // Devuelvo el mejor alumno que cumple con las condiciones, o null si no hay ninguno
        return mejorAlumno;
    }


    public List<Alumno> getMejoresAlumnos(int anioNacimientoAlumno) {
        // Mapa para guardar a los alumnos válidos junto con su promedio
        Map<Alumno, Double> alumnosFiltrados = new HashMap<>();

        // Recorro todas las divisiones de la escuela
        for (DivisionCurso divisionCurso : divisionCursos) {
            for (Catedra catedra : divisionCurso.getCatedras()) {
                for (Alumno alumno : catedra.getAlumnos()) {
                    // Filtro por año de nacimiento
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(alumno.getFechaNacimiento());
                    int anioNacimiento = cal.get(Calendar.YEAR);
                    if (anioNacimiento == anioNacimientoAlumno) {
                        // Verifico si recuperó algún examen
                        boolean recupero = alumno.getNotas().stream()
                                .anyMatch(Nota::isEsRecuperatorio);

                        // Si nunca recuperó, lo considero válido y calculo su promedio
                        if (!recupero) {
                            double promedio = alumno.promedioNotas(null); // uso null para incluir todas las notas
                            alumnosFiltrados.put(alumno, promedio);
                        }
                    }
                }
            }
        }

        // Si no hay alumnos que cumplan la condición, devuelvo lista vacía
        if (alumnosFiltrados.isEmpty()) {
            return List.of();
        }

        // Ordeno por promedio descendente, me quedo con los 3 mejores y devuelvo solo los alumnos
        return alumnosFiltrados.entrySet().stream()
                .sorted(Map.Entry.<Alumno, Double>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

}
