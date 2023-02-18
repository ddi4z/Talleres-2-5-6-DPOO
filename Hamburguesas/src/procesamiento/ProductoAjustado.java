package procesamiento;

import java.util.ArrayList;
import java.util.Base64;

public class ProductoAjustado implements Producto{
	private ProductoMenu base;
	private ArrayList<Ingrediente> agregados = new ArrayList<Ingrediente>();
	private ArrayList<Ingrediente> eliminados = new ArrayList<Ingrediente>();
	
	
	
	public ProductoAjustado (ProductoMenu base) {
		this.base=base;
	}
	@Override
	public String getNombre () {
		return base.getNombre();
	}
	@Override
	public int getPrecio () {
		int total = 0;
		for(int i=0; i<agregados.size();i++){
			total+=agregados.get(i).getCostoAdicional();
		}
		
		return base.getPrecio()+total;
	}
	@Override
	public String generarTextoFactura () {
		return "Aplicacion";
	}
}
