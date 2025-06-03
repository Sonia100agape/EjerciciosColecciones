import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class RegistroEmpleados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Empleados> listaEmpleados = new LinkedList<>();
        Random random = new Random();

        boolean continuar = true;

        while (continuar) {
            System.out.println("=== Registro de Empleado ===");

            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();

            System.out.print("Departamento: ");
            String departamento = scanner.nextLine();

            System.out.print("Salario: ");
            double salario = Double.parseDouble(scanner.nextLine());

            // Generar código
            String parteApellido = apellido.length() >= 2 ? apellido.substring(0, 2).toUpperCase() : apellido.toUpperCase();
            String parteDepartamento = departamento.length() >= 3 ? departamento.substring(0, 3).toUpperCase() : departamento.toUpperCase();
            int numeroAleatorio = 100 + random.nextInt(900); // de 100 a 999
            String codigo = parteApellido + parteDepartamento + numeroAleatorio;

            // Crear y guardar el empleado
            Empleados empleado = new Empleados(id, codigo, nombre, apellido, departamento, salario);
            listaEmpleados.add(empleado);

            // Preguntar si desea continuar
            System.out.print("¿Desea registrar otro empleado? (s/n): ");
            String respuesta = scanner.nextLine().toLowerCase();
            if (!respuesta.equals("s")) {
                continuar = false;
            }
        }

        // Mostrar empleados usando for
        System.out.println("\n=== Lista de Empleados Registrados ===");
        for (int i = 0; i < listaEmpleados.size(); i++) {
            System.out.println(listaEmpleados.get(i));
        }

        scanner.close();
    }
}
