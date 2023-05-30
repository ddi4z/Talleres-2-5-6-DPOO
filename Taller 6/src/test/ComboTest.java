package test;

import java.util.ArrayList;

import procesamiento.Combo;
import procesamiento.ProductoMenu;

public class ComboTest {
        private String nombreCombo;
        private double descuento; 
        private ArrayList<ProductoMenu> itemsCombo = new ArrayList<ProductoMenu>();
        private Combo combo = new Combo(nombreCombo, descuento);
        double precio;


        public ComboTest(String nombreCombo, double descuento) {
            this.nombreCombo = nombreCombo;
            this.descuento = descuento;
        }
        public void agregarItemAComboTest() {
            for (int i=0;i<50;i++){
                itemsCombo.add(new ProductoMenu("producto"+1, i*1000));
                combo.agregarItemACombo(new ProductoMenu("producto"+1, i*1000));
                precio+=i*1000;
            }
            precio= (int) (precio-(precio*(descuento/100)));
        }


        public void generarTextoFacturaTest() {

            agregarItemAComboTest();
            StringBuilder sb = new StringBuilder();
            sb.append("\n----------------------------------");
            sb.append("\nnombre: "+nombreCombo+"\nPrecio Total: "+precio);
            for (int i = 0; i<itemsCombo.size() ;i++){
                sb.append("\n"+itemsCombo.get(i).getNombre());
                }
            String esperado = sb.toString();
            assertEquals(esperado,combo.generarTextoFactura());
	}
}
