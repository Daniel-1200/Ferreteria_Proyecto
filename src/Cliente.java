import java.util.ArrayList;
import java.util.List;

public class Cliente implements Mostrable{
    private String nombre;
    private String cedula;
    private String telefono;
    private List<Pedido> pedidos;

    public Cliente(String nombre, String cedula, String telefono) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.pedidos = new ArrayList<>();
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Cliente: " + nombre + " | Cédula: " + cedula + " | Teléfono: " + telefono);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
