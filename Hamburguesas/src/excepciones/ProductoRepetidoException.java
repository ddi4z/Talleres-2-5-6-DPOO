package excepciones;

import procesamiento.Producto;

public class ProductoRepetidoException extends HamburguesaException {
    private Producto item;
    public ProductoRepetidoException(Producto item){
        this.item= item;
    }
    
    
    @Override
    public String getMessage(){
        return "El producto " +item.getNombre()+" ha aparecido al menos dos veces";
    }
}

