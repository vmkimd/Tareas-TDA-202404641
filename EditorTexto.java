import java.util.Scanner;
import java.util.Stack;

/**
 * Clase EditorTexto
 * Implementa un editor de texto con funcionalidades de deshacer y rehacer.
 */
public class EditorTexto {
    private Stack<String> texto;
    private Stack<String> deshechos;

    /**
     * Constructor que inicializa las pilas.
     */
    public EditorTexto() {
        texto = new Stack<>();
        deshechos = new Stack<>();
    }

    /**
     * Agrega una línea de texto al editor.
     * Precondición: La línea de texto no debe ser nula.
     * Postcondición: La línea se agrega a la pila de texto y se limpia la pila de deshechos.
     */
    public void agregarTexto(String linea) {
        texto.push(linea);
        deshechos.clear();
    }

    /**
     * Deshace la última acción realizada.
     * Precondición: Debe haber al menos una línea en el texto.
     * Postcondición: La última línea es eliminada de la pila de texto y almacenada en la pila de deshechos.
     */
    public void deshacer() {
        if (!texto.isEmpty()) {
            deshechos.push(texto.pop());
        } else {
            System.out.println("No hay nada para deshacer.");
        }
    }

    /**
     * Rehace la última acción deshecha.
     * Precondición: Debe haber al menos una línea en la pila de deshechos.
     * Postcondición: La última línea deshecha se devuelve a la pila de texto.
     */
    public void rehacer() {
        if (!deshechos.isEmpty()) {
            texto.push(deshechos.pop());
        } else {
            System.out.println("No hay nada para rehacer.");
        }
    }

    /**
     * Muestra el estado actual del texto.
     * Precondición: Ninguna.
     * Postcondición: Se imprimen las líneas del texto en orden de inserción.
     */
    public void mostrarTexto() {
        if (texto.isEmpty()) {
            System.out.println("Texto vacío.");
        } else {
            for (String linea : texto) {
                System.out.println(linea);
            }
        }
    }

    /**
     * Método principal para ejecutar el editor de texto.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EditorTexto editor = new EditorTexto();
        
        System.out.println("Editor de Texto - Ingrese líneas o comandos (DESHACER, REHACER, MOSTRAR, SALIR)");
        while (true) {
            String entrada = scanner.nextLine().trim();
            
            switch (entrada.toUpperCase()) {
                case "DESHACER":
                    editor.deshacer();
                    break;
                case "REHACER":
                    editor.rehacer();
                    break;
                case "MOSTRAR":
                    editor.mostrarTexto();
                    break;
                case "SALIR":
                    System.out.println("Saliendo del editor...");
                    scanner.close();
                    return;
                default:
                    editor.agregarTexto(entrada);
                    break;
            }
        }
    }
}
