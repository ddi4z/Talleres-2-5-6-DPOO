package interaccion;

public class Aplicación {
	public static void main (String[] args) {
		ConsolaRestaurante consola = new ConsolaRestaurante();
		consola.ejecutarAplicacion();
	}
	public void mostrarMenu (String[] args) {
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Cargar información restaurante");
		System.out.println("2. Consultar ingredientes");
		System.out.println("3. Consultar menu base");
		System.out.println("4. Consultar pedido en curso");
		System.out.println("5. Cerrar y guardar pedido");
		System.out.println("6. Iniciar pedido");
		System.out.println("7. Salir de aplicacion");
	}
	public void ejecutarOpcion (int opcionSeleccionada) {
		System.out.println("Aplicacion restuarantes\n");

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion_seleccionada == 1){

					System.out.println("\n" + "Cargar archivos del restaurante" + "\n");
			
					String archivoMenu = input("Por favor ingrese el nombre del archivo CSV con los atletas");
					String archivoIngrediente = input("Por favor ingrese el nombre del archivo CSV con los atletas");
					String archivoCombo = input("Por favor ingrese el nombre del archivo CSV con los atletas");
					try
					{
						restaurante = Restaurante.cargarArchivo(archivo);
						System.out.println("Se cargó el archivo " + archivoMenu + " con información de los menus.");
						System.out.println("Se cargó el archivo " + archivoIngrediente + " con información de los ingredientes.");
						System.out.println("Se cargó el archivo " + archivoCombo + " con información de los combos.");
						Collection<String> eventos = restaurante.darNombresDeportes();
						
						/*  System.out.println("Los deportes para los que se tiene información son:");
						for (String dep : eventos)
						{
							System.out.println(" - " + dep);
						} */
					}
					catch (FileNotFoundException e)
					{
						System.out.println("ERROR: el archivo indicado no se encontró.");
					}
					catch (IOException e)
					{
						System.out.println("ERROR: hubo un problema leyendo el archivo.");
						System.out.println(e.getMessage());
					}
			
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
					menuBase.forEach(elementoMenu)> System.out.println(elementoMenu);
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
					void cerrarYGuardarPedido = restaurante.cerrarYGuardarPedido();
					System.out.println("Se ha cerrado y guardado el pedido");
				}
				else if (opcion_seleccionada == 6 && restaurante != null)
				{
					System.out.println("\n" + "Iniciar pedido" + "\n");
					String nombreCliente = input("Por favor digite el nombre del cliente");
					String direccionCliente = input("Por favor digite la direccion del cliente");
					void iniciarPedido = restaurante.iniciarPedido(nombreCliente, direccionCliente);
					System.out.println("Se ha iniciado el pedido para el cliente: "+ nombreCliente);
				}

				else if (opcion_seleccionada == 7)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				else if (restaurante == null)
				{
					System.out.println("Para poder ejecutar esta opción primero debe cargar un archivo de atletas.");
				}
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}
}
