package procesamiento;

public class Bebida implements Producto{
	private String nombre;
	private int precioBase ;

    public Bebida(String nombre, int precioBase){

		this.nombre=nombre;
		this.precioBase=precioBase;
    }
    
	@Override
	public String getNombre() {
		return this.nombre;
	}
	@Override
	public int getPrecio() {
		return this.precioBase;
	}
	@Override
	public String generarTextoFactura() {
		
		
		
		return "\n----------------------------------"+ "\nnombre: "+nombre+" precioBase: "+precioBase;
	}
}
