package productos;

import datos.GestorBaseDatos;

import java.util.Map;

// Creator del Factory Method: declara el método fábrica y usa su resultado
public abstract class CreadorProducto {

    // Factory Method: cada subclase decide qué Producto concreto construir
    protected abstract Producto crearProducto(Map<String, String> atributos);

    // Operación común: crea el producto y lo persiste vía el Singleton
    public Producto registrarProducto(Map<String, String> atributos) {
        Producto producto = crearProducto(atributos);
        GestorBaseDatos bd = GestorBaseDatos.getInstancia();
        bd.registrarCategoria(producto.getCategoria());
        bd.guardarProducto(producto);
        return producto;
    }

    // Utilidades para leer atributos
    protected static String texto(Map<String, String> a, String clave) {
        return a.get(clave);
    }

    protected static double decimal(Map<String, String> a, String clave) {
        return Double.parseDouble(a.get(clave));
    }

    protected static int entero(Map<String, String> a, String clave) {
        return Integer.parseInt(a.get(clave));
    }
}
