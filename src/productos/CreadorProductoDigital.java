package productos;

import java.util.Map;

// Creator concreto B
public class CreadorProductoDigital extends CreadorProducto {

    @Override
    protected Producto crearProducto(Map<String, String> a) {
        return new ProductoDigital(texto(a, "id"), texto(a, "nombre"), decimal(a, "precio"),
                entero(a, "stock"), texto(a, "categoria"),
                decimal(a, "tamano"), texto(a, "formato"));
    }
}
