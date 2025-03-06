public class GestorTienda {
    
    public double calcularDescuento(double precio, int cantidadComprada) {
        if (cantidadComprada >= 10) {
            return precio * 0.1;
        } else if (cantidadComprada >= 5) {
            return precio * 0.05;
        }
        return 0;
    }
    
    public String categorizarProducto(double precio) {
        if (precio < 10) {
            return "Económico";
        } else if (precio < 50) {
            return "Estándar";
        } else {
            return "Premium";
        }
    }
    
    public String buscarProducto(String[] inventario, String producto) {
        for (String item : inventario) {
            if (item.equalsIgnoreCase(producto)) {
                return item;
            }
        }
        return null;
    }
}