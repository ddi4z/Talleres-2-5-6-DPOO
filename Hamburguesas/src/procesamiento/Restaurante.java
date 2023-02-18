package procesamiento;

import java.util.ArrayList;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Restaurante {
	public ArrayList<Ingrediente> Ingredientes = new ArrayList<Ingrediente>();
	public ArrayList<ProductoMenu> menuBase = new ArrayList<ProductoMenu>();
	public ArrayList<Combo> combos = new ArrayList<Combo>();
	public ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	public Pedido pedidoEnCurso;

	//Contructor
	public Restaurante () {}
	
	public void iniciarPedido (String nombreCliente, String direccionCliente) {
		pedidoEnCurso = new Pedido(nombreCliente, direccionCliente);
	}
	public void cerrarYGuardarPedido () {
		pedidos.add(pedidoEnCurso);
		pedidoEnCurso = null;
		return ;
	}



	//Getters
	public Pedido getPedidoEnCurso () {
		return this.pedidoEnCurso;
	}
	public ArrayList<ProductoMenu> getMenuBase () {
		return this.menuBase;
	}
	public ArrayList<Ingrediente> getIngredientes () {
		return this.Ingredientes;
	}



	//Cargar archivos
	public void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos) throws IOException {
		
		cargarIngredientes(archivoIngredientes);
		cargarMenu(archivoMenu);
		cargarCombos(archivoCombos);
	}
	
	
	
	
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
