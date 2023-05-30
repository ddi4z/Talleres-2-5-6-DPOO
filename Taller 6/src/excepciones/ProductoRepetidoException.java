package excepciones;



public class ProductoRepetidoException extends HamburguesaException{
    private String repetido;

    public ProductoRepetidoException(String repetido) {
        super("Fallo: El producto '" + repetido+ "' aparece al menos dos veces.");
        this.repetido = repetido;
    }

    public String getRepetido() {
        return this.repetido;
    }
}

