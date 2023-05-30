package procesamiento;

import java.io.File;
import java.util.ArrayList;

import excepciones.PrecioPedidoException;

import java.io.FileWriter;
import java.io.IOException;


public class Pedido {
    private static int numeroPedidos = 0;
    private int idPedido;
    private String nombreCliente;
    private String direccionCliente;
    private ArrayList<Producto> itemsPedido = new ArrayList<Producto>();

    public Pedido(String nombreCliente, String direccionCliente){
        numeroPedidos++;
        this.idPedido = numeroPedidos;
        this.nombreCliente = nombreCliente;
        this.direccionCliente = direccionCliente;
    }

    public int getIdPedido(){
        return this.idPedido;
    }
    public void agregarProducto(Producto nuevoItem) throws PrecioPedidoException{
        itemsPedido.add(nuevoItem);
        if (getPrecioNetoPedido()>150000){
            throw new PrecioPedidoException(getPrecioNetoPedido());
        }
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
        
        StringBuilder sb = new StringBuilder();
        sb.append("nombre: "+nombreCliente);
        sb.append("\ndireccion: "+direccionCliente);
        sb.append("\nvalor neto: "+getPrecioNetoPedido());
        sb.append("\nvalor IVA: "+getPrecioIVAPedido());
        sb.append("\nvalor total: "+getPrecioTotalPedido());
        
        for (int i = 0; i<itemsPedido.size() ;i++){
            sb.append("\n"+itemsPedido.get(i).generarTextoFactura());
            }


        return sb.toString();
    }
    public void guardarFactura(File archivo) throws IOException{
        FileWriter fileWriter = new FileWriter(archivo);
        fileWriter.write(generarTextoFactura());
        fileWriter.close();
    }


}
