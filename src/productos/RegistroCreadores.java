package productos;

import java.util.HashMap;
import java.util.Map;

// Elige dinámicamente el Creator según el pedido
public class RegistroCreadores {

    private final Map<String, CreadorProducto> creadores = new HashMap<>();

    public void registrar(String tipo, CreadorProducto creador) {
        creadores.put(tipo.toUpperCase(), creador);
    }

    public CreadorProducto obtener(String tipo) {
        CreadorProducto c = creadores.get(tipo.toUpperCase());
        if (c == null) {
            throw new IllegalArgumentException("Tipo de producto no soportado: " + tipo);
        }
        return c;
    }
}
