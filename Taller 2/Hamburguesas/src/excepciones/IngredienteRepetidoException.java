package excepciones;


public class IngredienteRepetidoException extends HamburguesaException{
    private String repetido;

    public IngredienteRepetidoException(String repetido) {
        super("Fallo: El ingrediente '" + repetido+ "' aparece al menos dos veces.");
        this.repetido = repetido;
    }

    public String getIngredienteRepetido() {
        return repetido;
    }
}

