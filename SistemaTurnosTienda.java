import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SistemaTurnosTienda {
    public static void main(String[] args) {
        Queue<String> filaClientes = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        String comando;

        System.out.println("Sistema de turnos iniciado. Ingrese un comando:");

        while (true) {
            comando = scanner.nextLine().trim();
            String[] partes = comando.split(" ", 2);
            String accion = partes[0];

            switch (accion.toUpperCase()) {
                case "LLEGAR":
                    if (partes.length > 1) {
                        filaClientes.add(partes[1]);
                        System.out.println(partes[1] + " ha sido agregado a la fila.");
                    } else {
                        System.out.println("Error: Debes ingresar un nombre.");
                    }
                    break;

                case "ATENDER":
                    if (!filaClientes.isEmpty()) {
                        System.out.println("Atendiendo a: " + filaClientes.poll());
                    } else {
                        System.out.println("No hay clientes en la fila.");
                    }
                    break;

                case "MOSTRAR":
                    if (!filaClientes.isEmpty()) {
                        System.out.println("Fila actual: " + String.join(", ", filaClientes));
                    } else {
                        System.out.println("La fila está vacía.");
                    }
                    break;

                case "SALIR":
                    System.out.println("Saliendo del sistema.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Comando no reconocido. Usa LLEGAR [nombre], ATENDER, MOSTRAR o SALIR.");
            }
        }
    }
}
