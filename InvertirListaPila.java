import java.util.Scanner;
import java.util.Stack;

public class InvertirListaPila {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> pila = new Stack<>();

        // Solicitar la lista de elementos al usuario
        System.out.println("Ingrese los elementos de la lista separados por espacios:");
        String[] elementos = scanner.nextLine().split(" ");
        int[] lista = new int[elementos.length];

        // Llenar la lista original y apilar los elementos
        for (int i = 0; i < elementos.length; i++) {
            lista[i] = Integer.parseInt(elementos[i]);
            pila.push(lista[i]); // Se empujan a la pila
        }

        // Extraer elementos de la pila e invertir la lista original
        for (int i = 0; i < lista.length; i++) {
            lista[i] = pila.pop();
        }

        // Mostrar la lista invertida
        System.out.println("Lista invertida:");
        for (int num : lista) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
