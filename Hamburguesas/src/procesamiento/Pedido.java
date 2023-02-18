package procesamiento;

import java.io.File;
import java.util.ArrayList;

public class Pedido {
    private int numeroPedidos;
    private int idPedido;
    private String nombreCliente;
    private String direccionCliente;
    private ArrayList<Producto> itemsPedido = new ArrayList<Producto>();

    public Pedido(String nombreCliente, String direccionCliente){
        this.nombreCliente = nombreCliente;
        this.direccionCliente = direccionCliente;
    }

    public int getIdPedido(){
        return this.idPedido;
    }
    public void agregarProducto(Producto nuevoItem){
        itemsPedido.add(nuevoItem);
        numeroPedidos=itemsPedido.size();
    }

    private int getPrecioNetoPedido(){
        int precio =0;
        for(int i=0 ; i<itemsPedido.size(); i++){
            Producto item = itemsPedido.get(i);
            precio+=item.getPrecio();
        }
        return precio;
    }
    private int getPrecioTotalPedido(){
        return getPrecioNetoPedido()+getPrecioIVAPedido();
    }
    private int getPrecioIVAPedido(){
        return (int)(getPrecioNetoPedido()*0.19);
    }
    private String generarTextoFactura(){
        return "5";
    }
    private void guardarFactura(File archivo){
        return ;
    }


}
