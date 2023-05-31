package test;



import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import junit.framework.TestCase;
import procesamiento.Combo;
import procesamiento.ProductoMenu;

public class ComboTest{
        private String nombreCombo="combo";
        private double descuento=20; 
        private ArrayList<ProductoMenu> itemsCombo = new ArrayList<ProductoMenu>();
        private Combo combo = new Combo(nombreCombo, descuento);
        double precio;


        public void agregarItemAComboTest() {
            for (int i=0;i<50;i++){
                itemsCombo.add(new ProductoMenu("producto"+i, i*1000));
                combo.agregarItemACombo(new ProductoMenu("producto"+i, i*1000));
                precio+=i*1000;
            }
            precio= (int) (precio-(precio*(descuento/100)));
        }

        @Test
        public void generarTextoFacturaTest() {

            agregarItemAComboTest();
            StringBuilder sb = new StringBuilder();
            sb.append("\n----------------------------------");
            sb.append("\nnombre: "+nombreCombo+"\nPrecio Total: "+(int)precio);
            for (int i = 0; i<itemsCombo.size() ;i++){
                sb.append("\n"+itemsCombo.get(i).getNombre());
                }
            String esperado = sb.toString();            
            Assertions.assertEquals(esperado,combo.generarTextoFactura());
	}
}