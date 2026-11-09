package app;

import datos.GestorBaseDatos;
import productos.*;

import java.util.HashMap;
import java.util.Map;

public class Main {

    // Producto nuevo definido FUERA de los paquetes existentes: demuestra OCP
    static class ProductoServicio extends Producto {
        private final int horas;
        ProductoServicio(String id, String nombre, double precio, String cat, int horas) {
            super(id, nombre, precio, 0, cat);
            this.horas = horas;
        }
        @Override public String describir() { return "SERVICIO " + base() + " | horas=" + horas; }
    }

    static class CreadorProductoServicio extends CreadorProducto {
        @Override protected Producto crearProducto(Map<String, String> a) {
            return new ProductoServicio(texto(a, "id"), texto(a, "nombre"), decimal(a, "precio"),
                    texto(a, "categoria"), entero(a, "horas"));
        }
    }

    public static void main(String[] args) {
        // 1. Registro de creadores disponibles
        RegistroCreadores registro = new RegistroCreadores();
        registro.registrar("FISICO", new CreadorProductoFisico());
        registro.registrar("DIGITAL", new CreadorProductoDigital());

        // 2. Producto físico
        Map<String, String> laptop = new HashMap<>();
        laptop.put("id", "P001"); laptop.put("nombre", "Laptop"); laptop.put("precio", "850.00");
        laptop.put("stock", "10"); laptop.put("categoria", "Electrónica");
        laptop.put("peso", "1.8"); laptop.put("dimensiones", "35x24x2 cm");
        System.out.println(registro.obtener("fisico").registrarProducto(laptop).describir());

        // 3. Producto digital
        Map<String, String> ebook = new HashMap<>();
        ebook.put("id", "P002"); ebook.put("nombre", "Libro de Java"); ebook.put("precio", "15.50");
        ebook.put("stock", "999"); ebook.put("categoria", "Libros");
        ebook.put("tamano", "12.4"); ebook.put("formato", "PDF");
        System.out.println(registro.obtener("digital").registrarProducto(ebook).describir());

        // 4. Extensión: nuevo tipo sin tocar ninguna clase existente
        registro.registrar("SERVICIO", new CreadorProductoServicio());
        Map<String, String> soporte = new HashMap<>();
        soporte.put("id", "P003"); soporte.put("nombre", "Soporte técnico"); soporte.put("precio", "40.00");
        soporte.put("categoria", "Servicios"); soporte.put("horas", "2");
        System.out.println(registro.obtener("servicio").registrarProducto(soporte).describir());

        // 5. Singleton: ambas referencias son el mismo objeto
        GestorBaseDatos a = GestorBaseDatos.getInstancia();
        GestorBaseDatos b = GestorBaseDatos.getInstancia();
        System.out.println("¿Misma instancia? " + (a == b));
        System.out.println("Categorías: " + a.listarCategorias());
        System.out.println("Inventario total: " + a.consultarInventarioTotal());
        System.out.println("Buscar P002: " + b.buscarPorId("P002").getNombre());

        // 6. Tipo no soportado
        try {
            registro.obtener("HOLOGRAMA");
        } catch (IllegalArgumentException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }
    }
}
