package test;


import static org.junit.Assert.assertThrows;


import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import excepciones.PrecioPedidoException;
import junit.framework.TestCase;
import procesamiento.Pedido;
import procesamiento.Producto;
import procesamiento.ProductoMenu;

public class PedidoTest{
    private int precioNetoPedido;
    private int precioIVAPedido;
    private int precio;
    private ArrayList<Producto> itemsPedido = new ArrayList<Producto>();
    private static int numeroPedidos = 0;
    private String nombreCliente;
    private String direccionCliente;
    private Pedido pedido = new Pedido(nombreCliente, direccionCliente);


    private void getPrecioPedidoTest(){
        for (int i = 0; i<itemsPedido.size() ;i++){
            precioNetoPedido+=itemsPedido.get(i).getPrecio();
        }
        precioIVAPedido= (int)(precioNetoPedido*0.19);
        precio=precioNetoPedido+precioIVAPedido;
    }



    public void agregarProductoTest() throws PrecioPedidoException{
        Producto nuevoItem= new ProductoMenu("producto1", 1000);
        itemsPedido.add(nuevoItem); 
        pedido.agregarProducto(nuevoItem);
        if (precioNetoPedido>150000){
        	assertThrows(PrecioPedidoException.class, () -> pedido.agregarProducto(nuevoItem));
        }
        numeroPedidos=itemsPedido.size();
    }

    @Test
    public void comprobar () throws PrecioPedidoException{
    	agregarProductoTest();
    	getPrecioPedidoTest();
        StringBuilder sb = new StringBuilder();
        sb.append("nombre: "+nombreCliente);
        sb.append("\ndireccion: "+direccionCliente);
        sb.append("\nvalor neto: "+precioNetoPedido);
        sb.append("\nvalor IVA: "+precioIVAPedido);
        sb.append("\nvalor total: "+precio);
        
        for (int i = 0; i<itemsPedido.size() ;i++){
            sb.append("\n"+itemsPedido.get(i).generarTextoFactura());
        }
        Assertions.assertEquals(sb.toString(),this.pedido.generarTextoFactura());

    }
}


