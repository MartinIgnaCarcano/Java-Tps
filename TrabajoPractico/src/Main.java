import java.util.Calendar;
import java.util.Date;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Escuela escuela = new Escuela(1, "Escuela Nacional");
        DivisionCurso division = new DivisionCurso(1, 2025, 6, escuela);

        Catedra matematica = new Catedra(1, "Matemática");
        Catedra literatura = new Catedra(2, "Literatura");

        // Todos nacidos en 2001
        Alumno a1 = new Alumno(1001, "Sofía", "Gómez", new Date(102, Calendar.JANUARY, 10), matematica);
        Alumno a2 = new Alumno(1002, "Diego", "Martínez", new Date(101, Calendar.MARCH, 5), matematica);
        Alumno a3 = new Alumno(1003, "Valentina", "López", new Date(101, Calendar.MAY, 20), matematica);
        Alumno a4 = new Alumno(1004, "Nicolás", "Fernández", new Date(101, Calendar.JULY, 15), matematica);

        // ---- Sofía (promedio 9.0)
        for (int i = 0; i < 5; i++) {
            a1.agregarNota(new Nota(9, new Date(), false, a1, matematica));
            a1.agregarNota(new Nota(9, new Date(), false, a1, literatura));
        }

        // ---- Diego (promedio 7.5)
        for (int i = 0; i < 5; i++) {
            a2.agregarNota(new Nota(8, new Date(), false, a2, matematica));
            a2.agregarNota(new Nota(7, new Date(), false, a2, literatura));
        }

        // ---- Valentina (promedio 10)
        for (int i = 0; i < 5; i++) {
            a3.agregarNota(new Nota(10, new Date(), false, a3, matematica));
            a3.agregarNota(new Nota(10, new Date(), false, a3, literatura));
        }

        // ---- Nicolás (tiene un recuperatorio, queda descalificado)
        for (int i = 0; i < 5; i++) {
            a4.agregarNota(new Nota(9, new Date(), false, a4, matematica));
            a4.agregarNota(new Nota(9, new Date(), i == 2, a4, literatura)); // en la 3º nota, hay recuperatorio
        }

        // Armado
        escuela.agregarDivision(division);
        division.agregarCatedra(matematica);
        division.agregarCatedra(literatura);

        for (Alumno a : List.of(a1, a2, a3, a4)) {
            matematica.agregarAlumno(a);
            literatura.agregarAlumno(a);

            for (Nota n : a.getNotas()) {
                if (n.getCatedra().equals(matematica)) matematica.agregarNota(n);
                if (n.getCatedra().equals(literatura)) literatura.agregarNota(n);
            }
        }


        // Mostrar todos los mejores alumnos de 2001
        List<Alumno> mejores = escuela.getMejoresAlumnos(2001);
        System.out.println("Mejores alumnos que cumplen con las condiciones (sin recuperatorios, con 5 notas por cátedra, categoria 2001):");
        for (Alumno a : mejores) {
            System.out.printf("- %s %s | Promedio: %.2f%n", a.getNombre(), a.getApellido(), a.promedioNotas(null));
        }

        // Mostrar el mejor del año
        Alumno mejor = escuela.getMejorAlumnoEscuela(2001);
        System.out.println("\n► Mejor alumno del año 2001:");
        System.out.printf("%s %s | Promedio: %.2f%n", mejor.getNombre(), mejor.getApellido(), mejor.promedioNotas(null));
    }



}
