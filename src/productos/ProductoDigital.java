package productos;

// Producto concreto B: producto digital (tamaño y formato)
public class ProductoDigital extends Producto {

    private final double tamanoMb;
    private final String formato;

    public ProductoDigital(String id, String nombre, double precio, int stock,
                           String categoria, double tamanoMb, String formato) {
        super(id, nombre, precio, stock, categoria);
        this.tamanoMb = tamanoMb;
        this.formato = formato;
    }

    public double getTamanoMb() { return tamanoMb; }
    public String getFormato() { return formato; }

    @Override
    public String describir() {
        return "DIGITAL " + base() + " | tamaño=" + tamanoMb + "MB | formato=" + formato;
    }
}
