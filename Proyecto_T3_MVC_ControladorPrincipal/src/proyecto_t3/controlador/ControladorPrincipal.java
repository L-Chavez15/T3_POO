package proyecto_t3.controlador;

import proyecto_t3.modelo.*;
import proyecto_t3.vista.FrmPrincipal;
import proyecto_t3.vista.Ventana_Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controlador principal: recibe los datos de la vista,
 * ejecuta las validaciones y utiliza los controladores originales.
 */
public class ControladorPrincipal implements ActionListener {

    private ControladorPersona cp;
    private ControladorProducto cpro;
    private ControladorCategoria cca;
    private ControladorVenta cv;

    private Ventana_Login vistaLogin;
    private FrmPrincipal vistaPrincipal;
    private String rolActual;

    public ControladorPrincipal() 
    {
        //creamos un objeto de clase y asignamos a un atributo 
        cp = new ControladorPersona();
        cpro = new ControladorProducto();
        cca = new ControladorCategoria();
        cv = new ControladorVenta();
    }

    public void iniciarAplicacion() 
    {
        vistaLogin = new Ventana_Login();//Crea un nuevo objeto de la clase y se asigna a un atributo
        vistaLogin.getBtnIngresar().addActionListener(this);
        vistaLogin.setLocationRelativeTo(null);//Centra la ventana en la pantalla
        vistaLogin.setVisible(true);//Hace visible la ventana.
    }

    //sobrescribiendo un método de la interfaz ActionListener
    @Override
    public void actionPerformed(ActionEvent e)//recibe los eventos producidos por los botones. 
    {
        if (vistaLogin != null && e.getSource() == vistaLogin.getBtnIngresar()) 
        {
            iniciarSesion();
        }

        if (vistaPrincipal != null) 
        {
            if (e.getSource() == vistaPrincipal.getBtnNuevoProducto()) 
            {
                registrarProducto();
            } 
            else if (e.getSource() == vistaPrincipal.getBtnNuevaCategoria()) 
            {
                registrarCategoria();
            } 
            else if (e.getSource() == vistaPrincipal.getBtnRegistrarCliente()) 
            {
                registrarPersona(false);
            } 
            else if (e.getSource() == vistaPrincipal.getBtnRegistrarEmpleado()) 
            {
                registrarPersona(true);
            } 
            else if (e.getSource() == vistaPrincipal.getBtnRegistrarVenta()) 
            {
                registrarVenta();
            } 
            else if (e.getSource() == vistaPrincipal.getBtnComprar()) 
            {
                comprarProducto();
            } 
            else if (e.getSource() == vistaPrincipal.getBtnCerrarSesion()) 
            {
                cerrarSesion();
            }
        }
    }

    private void iniciarSesion() {
        String usuario = vistaLogin.getUsuario();
        String clave = vistaLogin.getClave();
        String rol = vistaLogin.getRolSeleccionado();

        boolean acceso = false;

        if (rol.equals("Encargado")) 
        {
            acceso = usuario.equalsIgnoreCase("encargado")&& clave.equals("Tienda2026!");
        } else if (rol.equals("Cliente")) 
        {
            acceso = usuario.equalsIgnoreCase("cliente")&& clave.equals("Cliente2026!");
        }

        if (acceso) {
            rolActual = rol;
            vistaLogin.dispose();
            abrirVentanaPrincipal();
        } else {
            vistaLogin.mostrarError("Credenciales incorrectas.");
            vistaLogin.limpiarClave();
        }
    }

    private void abrirVentanaPrincipal() {
        vistaPrincipal = new FrmPrincipal(rolActual);

        vistaPrincipal.getBtnNuevoProducto().addActionListener(this);
        vistaPrincipal.getBtnNuevaCategoria().addActionListener(this);
        vistaPrincipal.getBtnRegistrarCliente().addActionListener(this);
        vistaPrincipal.getBtnRegistrarEmpleado().addActionListener(this);
        vistaPrincipal.getBtnRegistrarVenta().addActionListener(this);
        vistaPrincipal.getBtnComprar().addActionListener(this);
        vistaPrincipal.getBtnCerrarSesion().addActionListener(this);

        actualizarTablas();
        vistaPrincipal.setVisible(true);
    }

    private void cerrarSesion() {
        vistaPrincipal.dispose();
        vistaPrincipal = null;
        rolActual = null;

        vistaLogin = new Ventana_Login();
        vistaLogin.getBtnIngresar().addActionListener(this);
        vistaLogin.setLocationRelativeTo(null);
        vistaLogin.setVisible(true);
    }

    // REGISTRAR CLIENTE O EMPLEADO

    private void registrarPersona(boolean esEmpleado) {
        Persona p;

        if (esEmpleado) {
            p = new Empleado("DNI", "00000000", "Nombre", "Apellido", "Materno");
        } else {
            p = new Cliente(1, "DNI", "00000000", "Nombre", "Apellido", "Materno");
        }

        if (!ingresarDatosPersona(p)) {
            return;
        }

        if (esEmpleado) {
            Empleado e = (Empleado) p;
            boolean aux = false;

            while (!aux) {
                String usuario = vistaPrincipal.solicitarTexto("Usuario:");
                if (usuario == null) return;
                aux = e.setUsuario(usuario);

                if (!aux) {
                    vistaPrincipal.mostrarError("Ingrese un usuario válido.");
                }
            }
        } else {
            Cliente c = (Cliente) p;
            boolean aux = false;

            while (!aux) {
                Integer id = solicitarEntero("ID del cliente:");
                if (id == null) return;
                aux = c.setIdCliente(id);

                if (!aux) {
                    vistaPrincipal.mostrarError("ID de cliente inválido.");
                }
            }
        }

        if (cp.agregar(p)) {
            actualizarTablas();
            vistaPrincipal.mostrarMensaje(esEmpleado
                    ? "EMPLEADO REGISTRADO CORRECTAMENTE"
                    : "CLIENTE REGISTRADO CORRECTAMENTE");
        } else {
            vistaPrincipal.mostrarError("EL DOCUMENTO YA ESTA REGISTRADO");
        }
    }

    private boolean ingresarDatosPersona(Persona p) {
        boolean aux = false;
        String dato;

        while (!aux) {
            dato = vistaPrincipal.solicitarTexto("Tipo de documento (DNI/CE):");
            if (dato == null) return false;
            aux = p.setTipoDoc(dato);
            if (!aux) vistaPrincipal.mostrarError("Tipo de documento no válido.");
        }

        aux = false;
        while (!aux) {
            dato = vistaPrincipal.solicitarTexto("Número de documento:");
            if (dato == null) return false;
            aux = p.setNroDoc(dato);
            if (!aux) vistaPrincipal.mostrarError("Número de documento no válido.");
        }

        aux = false;
        while (!aux) {
            dato = vistaPrincipal.solicitarTexto("Nombre:");
            if (dato == null) return false;
            aux = p.setNombre(dato);
           if (!aux) vistaPrincipal.mostrarError("El nombre contiene caracteres inválidos.");
        }

        aux = false;
        while (!aux) {
            dato = vistaPrincipal.solicitarTexto("Apellido paterno:");
            if (dato == null) return false;
            aux = p.setApellido_pa(dato);
            if (!aux) vistaPrincipal.mostrarError("Ingrese el apellido paterno.");
        }

        aux = false;
        while (!aux) {
            dato = vistaPrincipal.solicitarTexto("Apellido materno:");
            if (dato == null) return false;
            aux = p.setApellido_ma(dato);
            if (!aux) vistaPrincipal.mostrarError("Ingrese el apellido materno.");
        }

        return true;
    }

    // REGISTRAR PRODUCTO

    private void registrarProducto() {
        Producto p = new Producto(1, "Nombre", "Talla", "Color", 1, 0);
        boolean aux = false;

        while (!aux) {
            Integer id = solicitarEntero("ID del producto:");
            if (id == null) return;
            aux = p.setIdProducto(id);
            if (!aux) vistaPrincipal.mostrarError("ID de producto inválido.");
        }

        aux = false;
        while (!aux) {
            String dato = vistaPrincipal.solicitarTexto("Nombre:");
            if (dato == null) return;
            aux = p.setNombre(dato);
            if (!aux) vistaPrincipal.mostrarError("Ingrese el nombre.");
        }

        aux = false;
        while (!aux) {
            String dato = vistaPrincipal.solicitarTexto("Talla:");
            if (dato == null) return;
            aux = p.setTalla(dato);
            if (!aux) vistaPrincipal.mostrarError("Ingrese la talla.");
        }

        aux = false;
        while (!aux) {
            String dato = vistaPrincipal.solicitarTexto("Color:");
            if (dato == null) return;
            aux = p.setColor(dato);
            if (!aux) vistaPrincipal.mostrarError("Ingrese el color.");
        }

        aux = false;
        while (!aux) {
            Double precio = solicitarDecimal("Precio:");
            if (precio == null) return;
            aux = p.setPrecio(precio);
            if (!aux) vistaPrincipal.mostrarError("Precio inválido.");
        }

        aux = false;
        while (!aux) {
            Integer stock = solicitarEntero("Stock:");
            if (stock == null) return;
            aux = p.setStock(stock);
            if (!aux) vistaPrincipal.mostrarError("Stock inválido.");
        }

        if (cpro.agregar(p)) {
            actualizarTablas();
            vistaPrincipal.mostrarMensaje("PRODUCTO REGISTRADO CORRECTAMENTE");
        } else {
            vistaPrincipal.mostrarError("EL ID DEL PRODUCTO YA ESTA REGISTRADO");
        }
    }

    // REGISTRAR CATEGORIA

    private void registrarCategoria() {
        Categoria c = new Categoria("Nombre", "Descripcion");
        boolean aux = false;

        while (!aux) {
            String nombre = vistaPrincipal.solicitarTexto("Nombre:");
            if (nombre == null) return;
            aux = c.setNombre(nombre);
            if (!aux) vistaPrincipal.mostrarError("Ingrese el nombre de la categoría.");
        }

        aux = false;
        while (!aux) {
            String descripcion = vistaPrincipal.solicitarTexto("Descripción:");
            if (descripcion == null) return;
            aux = c.setDescripcion(descripcion);
            if (!aux) vistaPrincipal.mostrarError("Ingrese la descripción.");
        }

        String respuesta = "S";

        while (respuesta.equalsIgnoreCase("S")) {
            if (vistaPrincipal.confirmar("¿Desea agregar un producto a la categoría?")) {
                Integer idProducto = solicitarEntero("ID del producto:");
                if (idProducto == null) return;

                Producto p = cpro.buscar(idProducto);

                if (p != null) {
                    c.agregarProducto(p);
                    vistaPrincipal.mostrarMensaje("PRODUCTO AGREGADO A LA CATEGORIA");
                } else {
                    vistaPrincipal.mostrarError("PRODUCTO NO ENCONTRADO");
                }
            } else {
                respuesta = "N";
            }
        }

        if (cca.agregar(c)) {
            actualizarTablas();
            vistaPrincipal.mostrarMensaje("CATEGORIA REGISTRADA CORRECTAMENTE");
        } else {
            vistaPrincipal.mostrarError("CATEGORIA YA REGISTRADA");
        }
    }

    // REGISTRAR VENTA (misma secuencia del proyecto inicial)

    private void registrarVenta() {
        // La vista de Cliente utiliza la misma secuencia de venta del proyecto inicial.
        registrarVentaOriginal();
    }

    private void comprarProducto() {
        registrarVentaOriginal();
    }

    private void registrarVentaOriginal() {
        Integer idVenta = solicitarEntero("ID de la venta:");
        if (idVenta == null) return;

        Venta v = new Venta(idVenta, "", 0);

        boolean aux = v.setIdVenta(idVenta);
        while (!aux) {
            idVenta = solicitarEntero("ID de la venta:");
            if (idVenta == null) return;
            aux = v.setIdVenta(idVenta);
        }

        aux = false;
        while (!aux) {
            String fecha = vistaPrincipal.solicitarTexto("Fecha de la venta:");
            if (fecha == null) return;
            aux = v.setFecha(fecha);
            if (!aux) vistaPrincipal.mostrarError("Ingrese la fecha de la venta.");
        }

        String respuesta = "S";

        while (respuesta.equalsIgnoreCase("S")) {
            Integer idProducto = solicitarEntero("ID del producto:");
            if (idProducto == null) return;

            Producto p = cpro.buscar(idProducto);

            if (p != null) {
                Integer cantidad = solicitarEntero("Cantidad:");
                if (cantidad == null) return;

                if (cantidad > 0 && cantidad <= p.getStock() ) {
                    if (p.actualizarStock(cantidad)) 
                    {
                        Detalle d = new Detalle(p, cantidad);
                        v.agregarDetalle(d);
                        vistaPrincipal.mostrarMensaje("PRODUCTO AGREGADO A LA VENTA");
                    }
                } else {
                    vistaPrincipal.mostrarError("CANTIDAD INVALIDA");
                }
            } else {
                vistaPrincipal.mostrarError("PRODUCTO NO ENCONTRADO");
            }

            respuesta = vistaPrincipal.confirmar("¿Desea agregar otro producto?") ? "S" : "N";
        }

        v.calcularTotal();

        if (cv.agregar(v)) {
            actualizarTablas();
            vistaPrincipal.mostrarMensaje("VENTA REGISTRADA CORRECTAMENTE. Total: S/ "
                    + String.format("%.2f", v.getTotal()));
        } else {
            vistaPrincipal.mostrarError("EL ID DE VENTA YA ESTA REGISTRADO");
        }
    }

    // Conversión de datos de entrada: responsabilidad del controlador.

    private Integer solicitarEntero(String mensaje) {
        while (true) {
            String dato = vistaPrincipal.solicitarTexto(mensaje);
            if (dato == null) return null;

            try {
                return Integer.parseInt(dato);
            } catch (NumberFormatException e) {
                vistaPrincipal.mostrarError("DEBE INGRESAR UN NUMERO VALIDO");
            }
        }
    }

    private Double solicitarDecimal(String mensaje) {
        while (true) {
            String dato = vistaPrincipal.solicitarTexto(mensaje);
            if (dato == null) return null;

            try {
                return Double.parseDouble(dato);
            } catch (NumberFormatException e) {
                vistaPrincipal.mostrarError("DEBE INGRESAR UN NUMERO VALIDO");
            }
        }
    }

    private void actualizarTablas() {
        vistaPrincipal.mostrarProductos(cpro.obtenerTodos());

        if (rolActual.equals("Encargado")) {
            vistaPrincipal.mostrarCategorias(cca.obtenerTodos());
            vistaPrincipal.mostrarClientes(cp.obtenerTodos());
            vistaPrincipal.mostrarVentas(cv.obtenerTodos());
        }
    }
}
