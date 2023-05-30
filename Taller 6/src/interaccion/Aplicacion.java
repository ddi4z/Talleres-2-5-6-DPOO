package interaccion;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import excepciones.IngredienteRepetidoException;
import excepciones.PrecioPedidoException;
import excepciones.ProductoRepetidoException;

import java.awt.Desktop;

import procesamiento.Ingrediente;
import procesamiento.Pedido;
import procesamiento.ProductoMenu;
import procesamiento.ProductoAjustado;
import procesamiento.Bebida;
import procesamiento.Combo;
import procesamiento.Restaurante;

public class Aplicacion {
	private Restaurante restaurante = new Restaurante();
	
	public static void main (String[] args) throws IngredienteRepetidoException, ProductoRepetidoException, PrecioPedidoException {
		Aplicacion consola = new Aplicacion();
		consola.ejecutarOpcion();
	}
	public void mostrarMenu () {
		System.out.println("\nOpciones de la Aplicacion\n");
		System.out.println("1. Cargar información Restaurante");
		System.out.println("2. Consultar ingredientes");
		System.out.println("3. Consultar menu base");
		System.out.println("4. Consultar pedido en curso");
		System.out.println("5. Cerrar y guardar pedido");
		System.out.println("6. Iniciar pedido");
		System.out.println("7. Modificar pedido actual");
		System.out.println("8. Buscar por ID");
		System.out.println("9. Salir de aplicacion");
		}
	public void ejecutarOpcion () throws IngredienteRepetidoException, ProductoRepetidoException, PrecioPedidoException {
		System.out.println("Aplicacion restuarantes\n");

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				
				System.out.print("Por favor seleccione una opción" + ": ");
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				int opcion_seleccionada = Integer.parseInt(reader.readLine());

				if (opcion_seleccionada == 1){

					System.out.println("\n" + "Cargar archivos del Restaurante" + "\n");
			
					File archivoMenu = new File("./Taller 6/data/menu.txt");
					File archivoIngrediente = new File("./Taller 6/data/ingredientes.txt");
					File archivoCombo = new File("./Taller 6/data/combos.txt");
					File archivoBebida = new File("./Taller 6/data/bebidas.txt");
					restaurante.cargarInformacionRestaurante(archivoIngrediente,archivoMenu,archivoCombo,archivoBebida);
					
					System.out.println("Se cargó el archivo " + archivoMenu + " con información de los menus.");
					System.out.println("Se cargó el archivo " + archivoIngrediente + " con información de los ingredientes.");
					System.out.println("Se cargó el archivo " + archivoCombo + " con información de los combos.");
					System.out.println("Se cargó el archivo " + archivoBebida + " con información de las bebidas.");
					
			
				}

				else if (opcion_seleccionada == 2){
					System.out.println("\n" + "Ingredientes" + "\n");
					ArrayList<Ingrediente> Ingredientes = restaurante.getIngredientes();
					System.out.println("Los ingredientes son: ");
				
					for (int i=0;i<Ingredientes.size();i++){
						System.out.print(i+1);
						System.out.print(") ");
						System.out.println(Ingredientes.get(i).getNombre());
					}
				}
				else if (opcion_seleccionada == 3){
					System.out.println("\n" + "Menu base" + "\n");
					ArrayList<ProductoMenu> menuBase = restaurante.getMenuBase();
					System.out.println("Los elementos en el menu son: ");
					for (int i=0;i<menuBase.size();i++){
						System.out.print(i+1);
						System.out.print(") ");
						System.out.println(menuBase.get(i).getNombre());
					}
				}

				else if (opcion_seleccionada == 4)
				{
					System.out.println("\n" + "Pedido en curso" + "\n");
					Pedido pedidoEnCurso = restaurante.getPedidoEnCurso();
					System.out.println("El pedido en curso es: "+ pedidoEnCurso.getIdPedido());
					

				}
				else if (opcion_seleccionada == 5)
				{
					System.out.println("\n" + "Cerrar y guardar pedido" + "\n");
					restaurante.cerrarYGuardarPedido();
					System.out.println("Se ha cerrado y guardado el pedido");
				}
				else if (opcion_seleccionada == 6)
				{
					System.out.println("\n" + "Iniciar pedido" + "\n");
					
					System.out.print("Por favor digite el nombre del cliente" + ": ");
					String nombreCliente = reader.readLine();
					

					System.out.print("Por favor digite la direccion del cliente");
					String direccionCliente = reader.readLine();
					
					restaurante.iniciarPedido(nombreCliente, direccionCliente);
					
					




					System.out.println("Se ha iniciado el pedido para el cliente: "+ nombreCliente);
				}


				else if (opcion_seleccionada == 7){
					Pedido pedidoEnCurso = restaurante.getPedidoEnCurso();
					boolean activo=true;
						
					while (activo==true){
						System.out.println("Seleccione una opcion: ");
						System.out.println("1: Combo ");
						System.out.println("2: producto menu");
						System.out.println("3: bebidas menu");
						System.out.println("4: Producto ajustado");
						System.out.println("5: Salir");
						int opcion_pedido = Integer.parseInt(reader.readLine());

						if (opcion_pedido==1){
							ArrayList<Combo> combos = restaurante.getCombos();
							for (int i=0;i<combos.size();i++){
								System.out.print(i+1);
								System.out.print(") ");
								System.out.println(combos.get(i).getNombre());
							}
							
							int comboIndex = Integer.parseInt(reader.readLine());
							Combo combo = restaurante.getCombos().get(comboIndex-1);
							
							pedidoEnCurso.agregarProducto(combo);
						}
						else if (opcion_pedido==2){
							ArrayList<ProductoMenu> menus = restaurante.getMenuBase();
							for (int i=0;i<menus.size();i++){
								System.out.print(i+1);
								System.out.print(") ");
								System.out.println(menus.get(i).getNombre());
							}
							int productoIndex = Integer.parseInt(reader.readLine());
							ProductoMenu producto = restaurante.getMenuBase().get(productoIndex-1);
							pedidoEnCurso.agregarProducto(producto);
						}
						else if (opcion_pedido==3){
							ArrayList<Bebida> bebidas = restaurante.getBebidas();
							for (int i=0;i<bebidas.size();i++){
								System.out.print(i+1);
								System.out.print(") ");
								System.out.println(bebidas.get(i).getNombre());
							}
							int productoIndex = Integer.parseInt(reader.readLine());
							Bebida producto = restaurante.getBebidas().get(productoIndex-1);
							pedidoEnCurso.agregarProducto(producto);
						}

						else if (opcion_pedido==4){
							ArrayList<ProductoMenu> menus = restaurante.getMenuBase();
							for (int i=0;i<menus.size();i++){
								System.out.print(i+1);
								System.out.print(") ");
								System.out.println(menus.get(i).getNombre());
							}
							int productoIndex = Integer.parseInt(reader.readLine());
							ProductoMenu productoBase = restaurante.getMenuBase().get(productoIndex-1);
							ProductoAjustado productoAjuste = new ProductoAjustado(productoBase);
							
							
							boolean activoAjustes=true;
							while (activoAjustes==true){

								
								System.out.println("Seleccione una opcion: ");
								System.out.println("1: Añadir ");
								System.out.println("2: Quitar");
								System.out.println("3: Salir");


								int opcionAjuste = Integer.parseInt(reader.readLine());
								if (opcionAjuste==1){
									ArrayList<Ingrediente> ingredientes = restaurante.getIngredientes();
									for (int i=0;i<ingredientes.size();i++){
										System.out.print(i+1);
										System.out.print(") ");
										System.out.println(ingredientes.get(i).getNombre());
									}
									int IngredienteIndex = Integer.parseInt(reader.readLine());
									Ingrediente ingrediente = restaurante.getIngredientes().get(IngredienteIndex-1);
									productoAjuste.agregarIngrediente(ingrediente);
									
								}
								else if (opcionAjuste==2){
									ArrayList<Ingrediente> ingredientes = restaurante.getIngredientes();
									for (int i=0;i<ingredientes.size();i++){
										System.out.print(i+1);
										System.out.print(") ");
										System.out.println(ingredientes.get(i).getNombre());
									}
									int IngredienteIndex = Integer.parseInt(reader.readLine());
									Ingrediente ingrediente = restaurante.getIngredientes().get(IngredienteIndex-1);
									productoAjuste.eliminarIngrediente(ingrediente);
								}
								else if (opcionAjuste==3) activoAjustes=false;
							pedidoEnCurso.agregarProducto(productoAjuste);
							}
							

							
						}

						else if (opcion_pedido==5) activo=false;


					

				}}
				else if (opcion_seleccionada == 8){
					
					System.out.println("Ingrese el id a consultar: ");
					int id = Integer.parseInt(reader.readLine());
					ArrayList<Pedido> pedidos = restaurante.getPedidos();

					boolean forActivo=true;
					for (int i=0; i<pedidos.size() && forActivo==true;i++){
						
							if (pedidos.get(i).getIdPedido()== (id)){
								forActivo=false;
								File archivo = new File("./Taller 6/data/" + id+".txt");
								try {
									Desktop.getDesktop().open(archivo);
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
					}

				}

				else if (opcion_seleccionada == 9)
				{
					System.out.println("Saliendo de la Aplicacion ...");
					continuar = false;
				}

				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}