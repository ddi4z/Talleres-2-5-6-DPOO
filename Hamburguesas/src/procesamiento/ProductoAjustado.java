package procesamiento;

import java.util.ArrayList;
import java.util.Base64;

public class ProductoAjustado implements Producto{
	private ProductoMenu Base = new ProductoMenu(getNombre(), getPrecio());
	private ArrayList<Ingrediente> agregados = new ArrayList<Ingrediente>();
	private ArrayList<Ingrediente> eliminados = new ArrayList<Ingrediente>();
	
	
	
	public ProductoAjustado (ProductoMenu base) {
		System.out.println("Aplicacion");
	}
	@Override
	public String getNombre () {
		return "Aplicacion";
	}
	@Override
	public int getPrecio () {
		return 4;
	}
	@Override
	public String generarTextoFactura () {
		return "Aplicacion";
	}
}
