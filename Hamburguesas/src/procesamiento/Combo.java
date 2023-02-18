package procesamiento;

import java.util.ArrayList;

public class Combo implements Producto{
	private String nombreCombo;
	private double descuento; 
	private ArrayList<ProductoMenu> itemsCombo = new ArrayList<ProductoMenu>();
	
	
	public Combo (String nombre, double descuento) {
		this.nombreCombo= nombre;
		this.descuento=descuento;
	}
	public void agregarItemACombo (Producto itemCombo) {
		this.itemsCombo.add(itemCombo);
	}


	//Getters

	@Override
	public int getPrecio() {
		int precio = 0;
		for( int i=0;i<itemsCombo.size();i++){
			precio+=itemsCombo.get(i).getPrecio();
		}
		return precio;
	}
	@Override
	public String generarTextoFactura() {
		
		return "Aplicacion";
	}
	@Override
	public String getNombre () {
		return this.nombreCombo;
	}
}
