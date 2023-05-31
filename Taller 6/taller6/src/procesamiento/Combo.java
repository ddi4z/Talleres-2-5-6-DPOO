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
	public void agregarItemACombo (ProductoMenu itemCombo) {
		this.itemsCombo.add(itemCombo);
	}


	//Getters

	@Override
	public int getPrecio() {
		int precio = 0;
		for( int i=0;i<itemsCombo.size();i++){
			precio+=itemsCombo.get(i).getPrecio();
		}
		return (int) (precio-(precio*(descuento/100)));
	}
	@Override
	public String generarTextoFactura() {
		
		StringBuilder sb = new StringBuilder();
        sb.append("\n----------------------------------");
		sb.append("\nnombre: "+nombreCombo+"\nPrecio Total: "+getPrecio());
        for (int i = 0; i<itemsCombo.size() ;i++){
            sb.append("\n"+itemsCombo.get(i).getNombre());
            }


        return sb.toString();
		
	}
	@Override
	public String getNombre () {
		return this.nombreCombo;
	}
}
