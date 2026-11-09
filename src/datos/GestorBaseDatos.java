package datos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import productos.Producto;

// Patrón Singleton: única puerta de acceso a la base de datos central.
public final class GestorBaseDatos {

    // Simulacion de base de datos
    private final Map<String, Producto> productos = new LinkedHashMap<>();
    private final Set<String> categorias = new LinkedHashSet<>();

    // Se hace privado el constructor para que nadie fuera de la clase pueda hacer new
    private GestorBaseDatos() {
        System.out.println("[DB] Conexión creada");
    }

    // Holder: instancia thread-safe y perezosa (lazy) al primer uso
    private static final class Holder {
        private static final GestorBaseDatos INSTANCIA = new GestorBaseDatos();
    }

    public static GestorBaseDatos getInstancia() {
        return Holder.INSTANCIA;
    }

    public synchronized void registrarCategoria(String categoria) {
        categorias.add(categoria);
    }

    public synchronized List<String> listarCategorias() {
        return new ArrayList<>(categorias);
    }

    public synchronized void guardarProducto(Producto producto) {
        productos.put(producto.getId(), producto);
    }

    public synchronized Producto buscarPorId(String id) {
        return productos.get(id);
    }

    public synchronized List<Producto> listarProductos() {
        return Collections.unmodifiableList(new ArrayList<>(productos.values()));
    }

    // Consulta de inventario: cantidad total de unidades registradas
    public synchronized int consultarInventarioTotal() {
        return productos.values().stream().mapToInt(Producto::getStock).sum();
    }
}
