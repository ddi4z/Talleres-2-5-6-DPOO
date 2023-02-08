package procesamiento;

public class ProductoMenu {
	private String nombre;
	private int precioBase ;
	
	public ProductoMenu (ProductoMenu base) {
		System.out.println("Aplicacion");
	}
	public String getNombre() {
		return "Aplicacion";
	}
	public int getPrecio() {
		return 4;
	}
	public String generarTextoFactura() {
		return "Aplicacion";
	}
}
