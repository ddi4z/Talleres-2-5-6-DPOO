package procesamiento;

import java.util.ArrayList;

import javax.swing.plaf.basic.BasicListUI.ListSelectionHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Restaurante {
	public ArrayList<Ingrediente> Ingredientes = new ArrayList<Ingrediente>();
	public ArrayList<ProductoMenu> menuBase = new ArrayList<ProductoMenu>();
	public ArrayList<Combo> combos = new ArrayList<Combo>();
	public ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	public Pedido pedidoEnCurso = new Pedido("hola","s");

	//Contructor
	public Restaurante () {}
	
	public void iniciarPedido () {
		System.out.println("Aplicacion");
	}
	public void cerrarYGuardarPedido () {
		System.out.println("Aplicacion");
	}



	//Getters
	public Pedido getPedidoEnCurso () {
		return this.pedidoEnCurso;
	}
	public ArrayList<Producto> getMenuBase () {
		return getMenuBase();
	}
	public ArrayList<Ingrediente> getIngredientes () {
		return getIngredientes();
	}
	public void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos) {
		System.out.println("Aplicacion");
	}
	
	
	
	//Cargar archivos
	private void cargarIngredientes (File archivoIngredientes) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(archivoIngredientes));
		String linea = br.readLine();
		while (linea!=null){

			Ingrediente ingrediente = new Ingrediente("hola",5);
			this.Ingredientes.add(ingrediente);
			linea = br.readLine();
		}
		br.close();
	}
	private void cargarMenu (File archivoMenu) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(archivoMenu));
		String linea = br.readLine();
		while (linea!=null){

			ProductoMenu productoMenu = new ProductoMenu("hola",5);
			this.menuBase.add(productoMenu);
			linea = br.readLine();
		}
		br.close();
	}
	private void cargarCombos(File archivoCombos) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(archivoCombos));
		String linea = br.readLine();
		while (linea!=null){

			Combo combo = new Combo("hola",5);
			this.combos.add(combo);
			linea = br.readLine();
		}
		br.close();
	}
}
