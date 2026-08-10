package una.eif206.avi;
import una.eif206.avi.service.GeminiService;
import una.eif206.avi.model.CaracteristicasDeJava;
import una.eif206.avi.model.ComparacionConC;
import una.eif206.avi.model.ConsultaTema;
import una.eif206.avi.model.HistoriaDeJava;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GeminiService geminiService = new GeminiService();
        Scanner lector = new Scanner(System.in);

        System.out.println("=== AVI - Agente Virtual Inteligente (consola) ===");
        System.out.println("Pregunta automatica de tres temas predefinidos: ");

        List<ConsultaTema> preguntas = new ArrayList<>();
        preguntas.add(new HistoriaDeJava());
        preguntas.add(new ComparacionConC());
        preguntas.add(new CaracteristicasDeJava());

        // Preguntas de los temas definidos en las clases
        for (ConsultaTema tema : preguntas) {
            System.out.println("Tema: " + tema.getNombre());
            try {
                String respuesta = geminiService.enviarMensaje(tema.getPrompt());
                System.out.println("\nAVI responde:");
                System.out.println(respuesta);
            } catch (IOException | InterruptedException e) {
                System.out.println("\nOcurrio un error: " + e.getMessage());
            }
            System.out.println("\n----------------------------------------");
            System.out.print("\nPresione enter para continuar");
            lector.nextLine();
            System.out.println();
        }
        System.out.println("\nConsultas automaticas finalizadas!");
        System.out.println("\nAhora puede escribir sus propias preguntas!");

        // Sistema de preguntas manual
        System.out.println("\nEscriba su pregunta (o 'salir' para terminar).");
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
