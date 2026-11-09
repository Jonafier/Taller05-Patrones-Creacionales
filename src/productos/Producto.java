package productos;

// Producto abstracto del Factory Method (rol: Product)
public abstract class Producto {

    private final String id;
    private final String nombre;
    private final double precio;
    private final int stock;
    private final String categoria;

    protected Producto(String id, String nombre, double precio, int stock, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }
    public String getCategoria() { return categoria; }

    // Cada subtipo describe sus atributos específicos
    public abstract String describir();

    protected String base() {
        return String.format("[%s] %s | $%.2f | stock=%d | cat=%s",
                id, nombre, precio, stock, categoria);
    }
}
