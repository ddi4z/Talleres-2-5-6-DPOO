package procesamiento;

public class Combo {
	private double descuento; 
	private String nombreCommbo;
	
	public Combo (String nombre, double descuento) {
		System.out.println("Aplicacion");
	}
	public void agregarItemACombo (Producto itemCombo) {
		System.out.println("Aplicacion");
	}
	public int getPrecio() {
		return 4;
	}
	public String generarTextoFactura() {
		return "Aplicacion";
	}
	public String getNombre () {
		return "Aplicacion";
	}
}
