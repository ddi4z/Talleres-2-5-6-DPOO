package excepciones;

import procesamiento.Producto;

public class PrecioPedidoException extends Exception{
    Producto excede;
    
    public PrecioPedidoException(int precio, Producto excede){
            super("\nFallo: El pedido excede el maximo permitido, con un total de '" + precio+ "' pesos." + obtenerInformacion(excede));
            this.excede = excede;
            
        }

    public static String obtenerInformacion(Producto excede){
        return "\n\nINFORMACION PRODUCTO QUE EXCEDE:\nProducto:  " + excede.getNombre() + " \nPrecio: " + excede.getPrecio()+"\n";
    }

}

