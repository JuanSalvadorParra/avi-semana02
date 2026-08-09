package una.eif206.avi;
import una.eif206.avi.service.GeminiService;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        GeminiService geminiService = new GeminiService();
        Scanner lector = new Scanner(System.in);
        System.out.println("=== AVI - Agente Virtual Inteligente (consola) ===");
        System.out.println("Escriba su pregunta (o 'salir' para terminar).");
        System.out.print("\n> ");
        String pregunta = lector.nextLine();
        while (!pregunta.equalsIgnoreCase("salir")) {
            try {
                String respuesta = geminiService.enviarMensaje(pregunta);
                System.out.println("\nAVI responde:");
                System.out.println(respuesta);
            } catch (IOException | InterruptedException e) {
                System.out.println("\nOcurrio un error: " + e.getMessage());
            }
            System.out.print("\n> ");
            pregunta = lector.nextLine();
        }
        System.out.println("\nHasta luego!");
        lector.close();
    }
}
