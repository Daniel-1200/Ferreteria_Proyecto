import java.util.HashMap;
import java.util.Map;

public class Pedido implements Mostrable{

    private Cliente cliente;
    private Map<Producto, Integer> productos;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.productos = new HashMap<>();
    }

    public void agregarProducto(Producto producto, int cantidad) {
        productos.put(producto, cantidad);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("\tPEDIDO");
        cliente.mostrarInformacion();
        for (Map.Entry<Producto, Integer> entry : productos.entrySet()) {
            System.out.println(entry.getKey().nombre + " x" + entry.getValue());
        }
    }
}
