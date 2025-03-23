import java.util.Stack;
import java.util.Scanner;

public class CaramelosPila {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> pilaCaramelos = new Stack<>();
        Stack<String> pilaTemporal = new Stack<>();
        
        System.out.println("Ingrese los colores de los caramelos separados por espacios:");
        String[] caramelos = scanner.nextLine().split(" ");

        // Apilar los caramelos en el orden ingresado
        for (String caramelo : caramelos) {
            pilaCaramelos.push(caramelo);
        }

        System.out.println("Procesando caramelos...");

        // Procesar los caramelos, comiendo los amarillos y guardando los otros en una pila temporal
        while (!pilaCaramelos.isEmpty()) {
            String caramelo = pilaCaramelos.pop();
            if (!caramelo.equalsIgnoreCase("amarillo")) {
                pilaTemporal.push(caramelo);
            } else {
                System.out.println("Comiendo caramelo amarillo.");
            }
        }

        // Devolver los caramelos no amarillos al paquete en su orden original
        while (!pilaTemporal.isEmpty()) {
            pilaCaramelos.push(pilaTemporal.pop());
        }

        // Mostrar el estado final del paquete
        System.out.println("Caramelos restantes en el paquete: " + pilaCaramelos);

        scanner.close();
    }
}
