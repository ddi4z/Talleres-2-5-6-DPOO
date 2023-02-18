package interaccion;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import procesamiento.Ingrediente;
import procesamiento.Pedido;
import procesamiento.Producto;
import procesamiento.Restaurante;

public class Aplicación {
	public static void main (String[] args) {
		Aplicación consola = new Aplicación();
		consola.ejecutarOpcion();
	}
	public void mostrarMenu () {
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Cargar información Restaurante");
		System.out.println("2. Consultar ingredientes");
		System.out.println("3. Consultar menu base");
		System.out.println("4. Consultar pedido en curso");
		System.out.println("5. Cerrar y guardar pedido");
		System.out.println("6. Iniciar pedido");
		System.out.println("7. Salir de aplicacion");
	}
	public void ejecutarOpcion () {
		System.out.println("Aplicacion restuarantes\n");

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				Restaurante restaurante = new Restaurante();
				System.out.print("Por favor seleccione una opción" + ": ");
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				int opcion_seleccionada = Integer.parseInt(reader.readLine());
				reader.close();
				if (opcion_seleccionada == 1){

					System.out.println("\n" + "Cargar archivos del Restaurante" + "\n");
			
					File archivoMenu = new File("/Hamburguesas/data/menu.txt");
					File archivoIngrediente = new File("/Hamburguesas/data/ingredientes.txt");
					File archivoCombo = new File("/Hamburguesas/data/combos.txt");
					
					restaurante.cargarInformacionRestaurante(archivoMenu,archivoIngrediente,archivoCombo);
					System.out.println("Se cargó el archivo " + archivoMenu + " con información de los menus.");
					System.out.println("Se cargó el archivo " + archivoIngrediente + " con información de los ingredientes.");
					System.out.println("Se cargó el archivo " + archivoCombo + " con información de los combos.");

					
			
				}

				else if (opcion_seleccionada == 2 && restaurante != null){
					System.out.println("\n" + "Ingredientes" + "\n");
					ArrayList<Ingrediente> Ingredientes = restaurante.getIngredientes();
					System.out.println("Los ingredientes son: ");
					Ingredientes.forEach((ingrediente) -> System.out.println(ingrediente));
				}
				else if (opcion_seleccionada == 3 && restaurante != null){
					System.out.println("\n" + "Menu base" + "\n");
					ArrayList<Producto> menuBase = restaurante.getMenuBase();
					System.out.println("Los elementos en el menu son: ");
					menuBase.forEach((elementoMenu) -> System.out.println(elementoMenu));
				}
				else if (opcion_seleccionada == 4 && restaurante != null)
				{
					System.out.println("\n" + "Pedido en curso" + "\n");
					Pedido pedidoEnCurso = restaurante.getPedidoEnCurso();
					System.out.println("El pedido en curso es: "+ pedidoEnCurso);
				}
				else if (opcion_seleccionada == 5 && restaurante != null)
				{
					System.out.println("\n" + "Cerrar y guardar pedido" + "\n");
					restaurante.cerrarYGuardarPedido();
					System.out.println("Se ha cerrado y guardado el pedido");
				}
				else if (opcion_seleccionada == 6 && restaurante != null)
				{
					System.out.println("\n" + "Iniciar pedido" + "\n");
					
					System.out.print("Por favor digite el nombre del cliente" + ": ");
					BufferedReader nc = new BufferedReader(new InputStreamReader(System.in));
					String nombreCliente = nc.readLine();
					nc.close();

					System.out.print("Por favor digite la direccion del cliente");
					BufferedReader dc = new BufferedReader(new InputStreamReader(System.in));
					String direccionCliente = dc.readLine();
					dc.close();
					restaurante.iniciarPedido(nombreCliente, direccionCliente);
					System.out.println("Se ha iniciado el pedido para el cliente: "+ nombreCliente);
				}

				else if (opcion_seleccionada == 7)
				{
					System.out.println("Saliendo de la aplicación ...");
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
