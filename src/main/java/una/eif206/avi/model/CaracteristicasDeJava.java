package una.eif206.avi.model;

public class CaracteristicasDeJava extends ConsultaTema {

    public CaracteristicasDeJava() {
        super("Caracteristicas de Java");
    }

    @Override
    public String getPrompt() {
        return "Explica las caracteristicas de Java resumidamente";
    }
}
