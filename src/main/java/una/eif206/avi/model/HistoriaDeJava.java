package una.eif206.avi.model;

public class HistoriaDeJava extends ConsultaTema {

    public HistoriaDeJava() {
        super("Historia de Java");
    }

    @Override
    public String getPrompt() {
        return "Explica la historia de Java resumidamente";
    }

}
