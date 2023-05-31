package test;



import java.util.ArrayList;



import org.junit.Test;

import junit.framework.TestCase;
import procesamiento.Ingrediente;
import procesamiento.ProductoAjustado;
import procesamiento.ProductoMenu;

public class ProductoAjustadoTest extends TestCase {
    public ArrayList<Ingrediente> agregados = new ArrayList<Ingrediente>();
	public ArrayList<Ingrediente> eliminados = new ArrayList<Ingrediente>();
    public ArrayList<String> listaIngredientes = new ArrayList<String>();
    public String nombre = "hamburguesa";
    public ProductoAjustado productoAjustado = new ProductoAjustado(new ProductoMenu(nombre, 10000));
    
    public void agregarIngredienteTest(){

        

        for (String elemento: listaIngredientes){
            int numero = (int)(Math.random()*1000+1);
            eliminados.add(new Ingrediente(elemento, numero));
            productoAjustado.eliminarIngrediente(new Ingrediente(elemento, numero));
        }
    }
	public void eliminarIngrediente(){
        for (String elemento: listaIngredientes){
            int numero = (int)(Math.random()*1000+1);
            agregados.add(new Ingrediente(elemento, numero));
            productoAjustado.agregarIngrediente(new Ingrediente(elemento, numero));
        }
        
    }

	@Test
    public void generarTextoFacturaTest () {
        listaIngredientes.add("lechuga");
        listaIngredientes.add("tomate");
        listaIngredientes.add("cebolla");
        listaIngredientes.add("queso mozzarella");
        listaIngredientes.add("huevo");
        listaIngredientes.add("tocineta express");
        agregarIngredienteTest();
        eliminarIngrediente();
		StringBuilder sb = new StringBuilder();
        sb.append("\n----------------------------------");
		sb.append("\nnombre: "+"ajustado"+nombre);
		sb.append("\n\nIngredientes añadidos:");
		for (int i = 0; i<agregados.size() ;i++){
            sb.append("\nnombre: "+ agregados.get(i).getNombre()+" valor: "+ agregados.get(i).getCostoAdicional());
            }
		sb.append("\n\nIngredientes eliminados:");
		for (int i = 0; i<eliminados.size() ;i++){
			sb.append("\nnombre: "+ eliminados.get(i).getNombre()+" valor: "+ 0);
		}
        assertEquals( sb.toString(),productoAjustado.generarTextoFactura());
	}
}