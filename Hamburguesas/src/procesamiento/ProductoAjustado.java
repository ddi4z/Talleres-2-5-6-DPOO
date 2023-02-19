package procesamiento;

import java.util.ArrayList;


public class ProductoAjustado implements Producto{
	private Producto base;
	private ArrayList<Ingrediente> agregados = new ArrayList<Ingrediente>();
	private ArrayList<Ingrediente> eliminados = new ArrayList<Ingrediente>();
	
	
	
	public ProductoAjustado (Producto base) {
		this.base=base;

	}
	public void agregarIngrediente(Ingrediente nuevoItem){
        agregados.add(nuevoItem);
    }
	public void eliminarIngrediente(Ingrediente nuevoItem){
        eliminados.add(nuevoItem);
        
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
		StringBuilder sb = new StringBuilder();
        sb.append("\n----------------------------------");
		sb.append("\nnombre: "+"ajustado"+base.getNombre());
		sb.append("\n\nIngredientes añadidos:");
		for (int i = 0; i<agregados.size() ;i++){
            sb.append("\nnombre: "+ agregados.get(i).getNombre()+" valor: "+ agregados.get(i).getCostoAdicional());
            }
		sb.append("\n\nIngredientes eliminados:");
		for (int i = 0; i<eliminados.size() ;i++){
			sb.append("\nnombre: "+ eliminados.get(i).getNombre()+" valor: "+ 0);
			}

		
		return sb.toString();
		
	}
}
