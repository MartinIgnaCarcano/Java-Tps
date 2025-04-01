//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Empleado emp1 = new Empleado(1, "Juan Pérez", "Desarrollador", 50000);
        Empleado emp2 = new Empleado("María Gómez", "Diseñadora");
        Empleado emp3 = new Empleado("Carlos López", "Analista");
        Empleado emp4 = new Empleado("Carlos L", "Analisasdta");
        Empleado emp5 = new Empleado("Carlqdqos López", "Anaasdlista");

        emp1.actualizarSalario(10.0); // Aumento del 10%
        emp2.actualizarSalario(5000); // Aumento de $5000

        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println(emp3);
        System.out.println(emp4);
        System.out.println(emp5);

        System.out.println("Total de empleados: " + Empleado.mostrarTotalEmpleados());
    }
}