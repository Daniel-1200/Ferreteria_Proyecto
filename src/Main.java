import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, Producto> inventario = new HashMap<>();
    private static Map<String, Cliente> clientes = new HashMap<>();
    private static List<Pedido> pedidos = new ArrayList<>();


    public static void main(String[] args) {
        inicializarInventario();

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    registrarCliente();
                    break;
                case 2:
                    crearPedido();
                    break;
                case 3:
                    mostrarInventario();
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 0);


    }
    private static void inicializarInventario() {

        inventario.put("H1", new Herramienta("H1", "Martillo", 15.99));
        inventario.put("H2", new Herramienta("H2", "Destornillador", 8.99));


        inventario.put("M1", new MaterialConstruccion("M1", "Cemento", 12.50));
        inventario.put("M2", new MaterialConstruccion("M2", "Arena", 5.99));
    }

    private static void mostrarMenu() {
        System.out.println("\n--- FERRETERÍA ---");
        System.out.println("1. Registrar Cliente");
        System.out.println("2. Crear Pedido");
        System.out.println("3. Mostrar Inventario");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void registrarCliente() {
        System.out.println("\n--- REGISTRO DE CLIENTE ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Cédula: ");
        String cedula = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        Cliente cliente = new Cliente(nombre, cedula, telefono);
        clientes.put(cedula, cliente);
        System.out.println("Cliente registrado con éxito");
    }

    private static void crearPedido() {
        System.out.println("\n--- CREAR PEDIDO ---");
        System.out.print("Cédula del cliente: ");
        String cedula = scanner.nextLine();

        Cliente cliente = clientes.get(cedula);
        if (cliente == null) {
            System.out.println("Cliente no encontrado");
            return;
        }

        Pedido pedido = new Pedido(cliente);
        String codigo;

        do {
            mostrarInventario();
            System.out.print("\nIngrese código del producto (0 para terminar): ");
            codigo = scanner.nextLine();

            if (!codigo.equals("0")) {
                Producto producto = inventario.get(codigo);
                if (producto != null) {
                    System.out.print("Cantidad: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    pedido.agregarProducto(producto, cantidad);
                } else {
                    System.out.println("Producto no encontrado");
                }
            }
        } while (!codigo.equals("0"));

        pedidos.add(pedido);
        pedido.mostrarInformacion();
    }

    private static void mostrarInventario() {
        System.out.println("\n--- INVENTARIO ---");
        for (Producto producto : inventario.values()) {
            producto.mostrarInformacion();
        }

    }

}