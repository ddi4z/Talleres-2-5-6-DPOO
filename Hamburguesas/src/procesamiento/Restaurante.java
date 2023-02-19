package procesamiento;

import java.util.ArrayList;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Restaurante {
	private ArrayList<Ingrediente> Ingredientes = new ArrayList<Ingrediente>();
	private ArrayList<ProductoMenu> menuBase = new ArrayList<ProductoMenu>();
	private ArrayList<Bebida> bebidas = new ArrayList<Bebida>();
	private ArrayList<Combo> combos = new ArrayList<Combo>();
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	private Pedido pedidoEnCurso;

	//Contructor
	public Restaurante () {}
	
	public void iniciarPedido (String nombreCliente, String direccionCliente) {
		pedidoEnCurso = new Pedido(nombreCliente, direccionCliente);


	}
	public void cerrarYGuardarPedido ()  throws IOException{
		File archivoAGuardar = new File("./Hamburguesas/data/" + pedidoEnCurso.getIdPedido()+".txt");
		
		
		pedidoEnCurso.guardarFactura(archivoAGuardar);

		
		pedidos.add(pedidoEnCurso);
		pedidoEnCurso = null;
		
	}



	//Getters
	public Pedido getPedidoEnCurso () {
		return this.pedidoEnCurso;
	}
	public ArrayList<Bebida> getBebidas () {
		return this.bebidas;
	}
	public ArrayList<ProductoMenu> getMenuBase () {
		return this.menuBase;
	}
	public ArrayList<Combo> getCombos () {
		return this.combos;
	}
	public ArrayList<Pedido> getPedidos () {
		return this.pedidos;
	}
	public ArrayList<Ingrediente> getIngredientes () {
		return this.Ingredientes;
	}



	//Cargar archivos
	public void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos, File archivoBebida) throws IOException {
		
		cargarIngredientes(archivoIngredientes);
		cargarMenu(archivoMenu);
		cargarCombos(archivoCombos);
		cargarBebidas(archivoBebida);
	}
	
	
		private void cargarBebidas (File archivoBebida) throws IOException {
	
	
		BufferedReader br = new BufferedReader(new FileReader(archivoBebida));
		String linea = br.readLine();
		while (linea!=null){
			String[] informacionLinea = linea.split(";"); 
			String nombre = informacionLinea[0]; 
			int precio = Integer.parseInt(informacionLinea[1]);
			Bebida bebida = new Bebida(nombre,precio);
			
			this.bebidas.add(bebida);
			linea = br.readLine();
		}
		br.close();
		}




		private void cargarIngredientes (File archivoIngredientes) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(archivoIngredientes));
		String linea = br.readLine();
		
		
		
		while (linea!=null){
			String[] informacionLinea = linea.split(";"); 
			String nombre = informacionLinea[0]; 
			int precio = Integer.parseInt(informacionLinea[1]);
			Ingrediente ingrediente = new Ingrediente(nombre,precio);
			
			this.Ingredientes.add(ingrediente);
			linea = br.readLine();
		}
		br.close();
		}
	private void cargarMenu (File archivoMenu) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(archivoMenu));
		String linea = br.readLine();
		while (linea!=null){
			String[] informacionLinea = linea.split(";"); 
			String nombre = informacionLinea[0]; 
			int precio = Integer.parseInt(informacionLinea[1]);
			ProductoMenu productoMenu = new ProductoMenu(nombre,precio);
			this.menuBase.add(productoMenu);
			linea = br.readLine();
		}
		br.close();
		}
	private void cargarCombos(File archivoCombos) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(archivoCombos));
		String linea = br.readLine();
		while (linea!=null){
			String[] datos = linea.split(";");
			String nombre = datos[0];
			int descuento = Integer.parseInt(datos[1].replaceAll("%", ""));
			String principal = datos[2];
			String extra = datos[3];
			String bebida = datos[4];
			Combo combo = new Combo(nombre,descuento);

			boolean forActivo =true;
			for (int i = 0; i < menuBase.size() && forActivo==true; i++)
			{
				if (menuBase.get(i).getNombre().equals(principal))
					forActivo=false;
					combo.agregarItemACombo(menuBase.get(i));
			}
			forActivo =true;
			for (int i = 0; i < menuBase.size()&& forActivo==true; i++)
			{
				if (menuBase.get(i).getNombre().equals(extra)){
					forActivo=false;
					combo.agregarItemACombo(menuBase.get(i));
				}
			}
			forActivo =true;
			for (int i = 0; i < menuBase.size()&& forActivo==true; i++)
			{
				if (menuBase.get(i).getNombre().equals(bebida)){
					forActivo=false;
					combo.agregarItemACombo(menuBase.get(i));
				}
					
			}
			this.combos.add(combo);
			linea = br.readLine();
		}
		br.close();
	}
}
