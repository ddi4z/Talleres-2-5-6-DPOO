package excepciones;

public class PrecioPedidoException extends Exception{
    public PrecioPedidoException(int precio){
            super("Fallo: El pedido excede el maximo permitido, con un total de '" + precio+ "' pesos.");
            
        }
    }
    

