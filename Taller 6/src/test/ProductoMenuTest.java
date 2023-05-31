package test;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;



import procesamiento.ProductoMenu;

public class ProductoMenuTest extends TestCase {
    @ParameterizedTest
    @MethodSource("parametrosGenerarTextoFactura")
	@Test
    public void generarTextoFacturaText(String nombre, int precio, String resultadoEsperado) {
    ProductoMenu producto= new ProductoMenu(nombre, precio);
		assertEquals( resultadoEsperado,producto.generarTextoFactura());
    }

    private static Stream<Object[]> parametrosGenerarTextoFactura() {
      return Stream.of(
              new Object[]{"Producto1", 0, "\n----------------------------------"+ "\nnombre: "+"Producto1"+ "precioBase:"+"0"},
              new Object[]{"Producto2", 12000, "\n----------------------------------"+ "\nnombre: "+"Producto2"+" precioBase: "+"12000"},
              new Object[]{"Producto3", 30000.25, "\n----------------------------------"+ "\nnombre: "+"Producto3"+" precioBase: "+"30000.25"}
      );
  }
}
