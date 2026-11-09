package productos;

// Producto concreto A: artículo físico (peso y dimensiones)
public class ProductoFisico extends Producto {

    private final double pesoKg;
    private final String dimensiones;

    public ProductoFisico(String id, String nombre, double precio, int stock,
                          String categoria, double pesoKg, String dimensiones) {
        super(id, nombre, precio, stock, categoria);
        this.pesoKg = pesoKg;
        this.dimensiones = dimensiones;
    }

    public double getPesoKg() { return pesoKg; }
    public String getDimensiones() { return dimensiones; }

    @Override
    public String describir() {
        return "FISICO  " + base() + " | peso=" + pesoKg + "kg | dim=" + dimensiones;
    }
}
