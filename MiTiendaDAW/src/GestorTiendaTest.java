import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GestorTiendaTest {

    static GestorTienda gestor;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        gestor = new GestorTienda(); // Inicializa el objeto antes de todas las pruebas
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
        gestor = null; // Limpia el objeto después de todas las pruebas
    }

    @BeforeEach
    void setUp() throws Exception {
        // Método opcional para configurar antes de cada prueba
    }

    @AfterEach
    void tearDown() throws Exception {
        // Método opcional para limpiar después de cada prueba
    }

    // Test para calcularDescuento
    @Test
    void testCalcularDescuentoConCantidadMayorIgual10() {
        double descuento = gestor.calcularDescuento(100, 10);
        assertEquals(10, descuento, "El descuento debería ser del 10% para 10 o más unidades.");
    }

    @Test
    void testCalcularDescuentoConCantidadMayorIgual5() {
        double descuento = gestor.calcularDescuento(100, 5);
        assertEquals(5, descuento, "El descuento debería ser del 5% para 5 a 9 unidades.");
    }

    @Test
    void testCalcularDescuentoConCantidadMenor5() {
        double descuento = gestor.calcularDescuento(100, 3);
        assertEquals(0, descuento, "No debería aplicarse descuento para menos de 5 unidades.");
    }

    // Test para categorizarProducto
    @Test
    void testCategorizarProductoEconomico() {
        String categoria = gestor.categorizarProducto(5);
        assertEquals("Económico", categoria, "Los productos con precio menor a 10 deberían ser Económicos.");
    }

    @Test
    void testCategorizarProductoEstandar() {
        String categoria = gestor.categorizarProducto(25);
        assertEquals("Estándar", categoria, "Los productos con precio entre 10 y 49.99 deberían ser Estándar.");
    }

    @Test
    void testCategorizarProductoPremium() {
        String categoria = gestor.categorizarProducto(75);
        assertEquals("Premium", categoria, "Los productos con precio 50 o más deberían ser Premium.");
    }

    // Test para buscarProducto
    @Test
    void testBuscarProductoExistente() {
        String[] inventario = {"Manzana", "Pera", "Plátano"};
        String producto = gestor.buscarProducto(inventario, "Pera");
        assertEquals("Pera", producto, "El producto debería encontrarse en el inventario.");
    }

    @Test
    void testBuscarProductoNoExistente() {
        String[] inventario = {"Manzana", "Pera", "Plátano"};
        String producto = gestor.buscarProducto(inventario, "Melocotón");
        assertNull(producto, "Si el producto no está en el inventario, debería devolver null.");
    }

    @Test
    void testBuscarProductoCriterioInsensibleAMayusculas() {
        String[] inventario = {"Manzana", "Pera", "Plátano"};
        String producto = gestor.buscarProducto(inventario, "pera");
        assertEquals("Pera", producto, "La búsqueda debería ser insensible a mayúsculas/minúsculas.");
    }
}