package productos;

import java.util.Map;

// Creator concreto A
public class CreadorProductoFisico extends CreadorProducto {

    @Override
    protected Producto crearProducto(Map<String, String> a) {
        return new ProductoFisico(texto(a, "id"), texto(a, "nombre"), decimal(a, "precio"),
                entero(a, "stock"), texto(a, "categoria"),
                decimal(a, "peso"), texto(a, "dimensiones"));
    }
}
