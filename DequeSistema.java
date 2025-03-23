import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class DequeSistema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<String> deque = new LinkedList<>();

        while (true) {
            System.out.println("Ingrese un comando (INSERTAR_FRENTE, INSERTAR_FINAL, ELIMINAR_FRENTE, ELIMINAR_FINAL, MOSTRAR, SALIR):");
            String input = scanner.nextLine().trim();
            String[] partes = input.split(" ", 2); // Dividir el input en 2 partes
            String comando = partes[0].toUpperCase(); // Convertir a mayúsculas para evitar errores

            switch (comando) {
                case "INSERTAR_FRENTE":
                    if (partes.length < 2) {
                        System.out.println("Error: Debes ingresar un valor después de INSERTAR_FRENTE.");
                    } else {
                        deque.addFirst(partes[1]); // Agregar el segundo argumento como el valor
                        System.out.println(partes[1] + " agregado al frente.");
                    }
                    break;

                case "INSERTAR_FINAL":
                    if (partes.length < 2) {
                        System.out.println("Error: Debes ingresar un valor después de INSERTAR_FINAL.");
                    } else {
                        deque.addLast(partes[1]);
                        System.out.println(partes[1] + " agregado al final.");
                    }
                    break;

                case "ELIMINAR_FRENTE":
                    if (deque.isEmpty()) {
                        System.out.println("La deque está vacía.");
                    } else {
                        System.out.println("Eliminando del frente: " + deque.removeFirst());
                    }
                    break;

                case "ELIMINAR_FINAL":
                    if (deque.isEmpty()) {
                        System.out.println("La deque está vacía.");
                    } else {
                        System.out.println("Eliminando del final: " + deque.removeLast());
                    }
                    break;

                case "MOSTRAR":
                    System.out.println("Estado actual de la deque: " + deque);
                    break;

                case "SALIR":
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Comando no reconocido. Intente nuevamente.");
            }
        }
    }
}
