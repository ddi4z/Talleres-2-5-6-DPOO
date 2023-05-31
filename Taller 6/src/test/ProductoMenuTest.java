package test;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.Assertions;



import procesamiento.ProductoMenu;

public class ProductoMenuTest {
    @ParameterizedTest
    @MethodSource("parametrosGenerarTextoFactura")
    public void generarTextoFacturaText(String nombre, int precio, String resultadoEsperado) {
    ProductoMenu producto= new ProductoMenu(nombre, precio);
	Assertions.assertEquals( resultadoEsperado,producto.generarTextoFactura());
    }

    private static Stream<Object[]> parametrosGenerarTextoFactura() {
      return Stream.of(
              new Object[]{"Producto1", 0, "\n----------------------------------"+ "\nnombre: "+"Producto1 "+ "precioBase: "+"0"},
              new Object[]{"Producto2", 12000, "\n----------------------------------"+ "\nnombre: "+"Producto2"+" precioBase: "+"12000"},
              new Object[]{"Producto3", 21000, "\n----------------------------------"+ "\nnombre: "+"Producto3"+" precioBase: "+"21000"},
              new Object[]{"Producto4", 1000, "\n----------------------------------"+ "\nnombre: "+"Producto4"+" precioBase: "+"1000"});
  }
}
