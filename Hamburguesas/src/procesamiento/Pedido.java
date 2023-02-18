package procesamiento;

import java.io.File;

public class Pedido {
    private int numeroPedidos;
    private int idPedido;
    private String nombreCliente;
    private String direccionCliente;

    public Pedido(String nombreCliente, String direccionCliente){
        this.nombreCliente = nombreCliente;
        this.direccionCliente = direccionCliente;
    }

    public int getIdPedido(){
        return this.idPedido;
    }
    public void agregarProducto(Producto nuevoItem){
        return ;
    }

    private int getPrecioNetoPedido(){
        return 5;
    }
    private int getPrecioTotalPedido(){
        return 5;
    }
    private int getPrecioIVAPedido(){
        return 5;
    }
    private String generarTextoFactura(){
        return "5";
    }
    private void guardarFactura(File archivo){
        return ;
    }


}
