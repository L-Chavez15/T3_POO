package proyecto_t3.vista;

import proyecto_t3.modelo.Categoria;
import proyecto_t3.modelo.Persona;
import proyecto_t3.modelo.Producto;
import proyecto_t3.modelo.Venta;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

/** Formulario principal. Presenta los datos que recibe del controlador. */
public class FrmPrincipal extends JFrame {

    private String rol;

    private DefaultTableModel modeloProductos;
    private DefaultTableModel modeloCategorias;
    private DefaultTableModel modeloClientes;
    private DefaultTableModel modeloVentas;

    public FrmPrincipal(String rol) {
        this.rol = rol;
        initComponents();
        configurarTablas();
        configurarPestanas();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        tabDatos = new javax.swing.JTabbedPane();
        pnlProductos = new javax.swing.JPanel();
        scrProductos = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        pnlCategorias = new javax.swing.JPanel();
        scrCategorias = new javax.swing.JScrollPane();
        tblCategorias = new javax.swing.JTable();
        pnlClientes = new javax.swing.JPanel();
        scrClientes = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        pnlVentas = new javax.swing.JPanel();
        scrVentas = new javax.swing.JScrollPane();
        tblVentas = new javax.swing.JTable();
        btnNuevoProducto = new javax.swing.JButton();
        btnNuevaCategoria = new javax.swing.JButton();
        btnRegistrarCliente = new javax.swing.JButton();
        btnRegistrarEmpleado = new javax.swing.JButton();
        btnRegistrarVenta = new javax.swing.JButton();
        btnComprar = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tienda - Panel principal");

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Panel principal");

        pnlProductos.setLayout(new java.awt.BorderLayout());

        scrProductos.setViewportView(tblProductos);

        pnlProductos.add(scrProductos);

        tabDatos.addTab("PRODUCTOS", pnlProductos);

        pnlCategorias.setLayout(new java.awt.BorderLayout());

        scrCategorias.setViewportView(tblCategorias);

        pnlCategorias.add(scrCategorias);

        tabDatos.addTab("CATEGORIA", pnlCategorias);

        pnlClientes.setLayout(new java.awt.BorderLayout());

        scrClientes.setViewportView(tblClientes);

        pnlClientes.add(scrClientes);

        tabDatos.addTab("CLIENTE", pnlClientes);

        pnlVentas.setLayout(new java.awt.BorderLayout());

        scrVentas.setViewportView(tblVentas);

        pnlVentas.add(scrVentas);

        tabDatos.addTab("VENTA", pnlVentas);

        btnNuevoProducto.setText("Nuevo producto");

        btnNuevaCategoria.setText("Nueva categoría");

        btnRegistrarCliente.setText("Registrar cliente");

        btnRegistrarEmpleado.setText("Registrar empleado");

        btnRegistrarVenta.setText("Registrar venta");

        btnComprar.setText("Comprar por ID");

        btnCerrarSesion.setText("Cerrar sesión");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnNuevoProducto)
                        .addGap(18, 18, 18)
                        .addComponent(btnNuevaCategoria)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegistrarCliente)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegistrarEmpleado)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegistrarVenta)
                        .addGap(18, 18, 18)
                        .addComponent(btnComprar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrarSesion))
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tabDatos))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblTitulo)
                .addGap(12, 12, 12)
                .addComponent(tabDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 400, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNuevoProducto)
                            .addComponent(btnNuevaCategoria)
                            .addComponent(btnRegistrarCliente)
                            .addComponent(btnRegistrarEmpleado)
                            .addComponent(btnRegistrarVenta)
                            .addComponent(btnComprar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnCerrarSesion)))
                .addGap(16, 16, 16))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void configurarTablas() {
        modeloProductos = crearModelo("ID", "Producto", "Talla", "Color", "Precio", "Stock");
        modeloCategorias = crearModelo("Categoria", "Descripcion");
        modeloClientes = crearModelo("Documento", "Nombre", "Apellido");
        modeloVentas = crearModelo("ID Venta", "Fecha", "Total");

        tblProductos.setModel(modeloProductos);
        tblCategorias.setModel(modeloCategorias);
        tblClientes.setModel(modeloClientes);
        tblVentas.setModel(modeloVentas);
    }

    private DefaultTableModel crearModelo(String... columnas) {
        return new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
    }

    private void configurarPestanas() {
        boolean esEncargado = rol.equals("Encargado");

        if (!esEncargado) {
            tabDatos.removeTabAt(3);
            tabDatos.removeTabAt(2);
            tabDatos.removeTabAt(1);
        }

        btnNuevoProducto.setVisible(esEncargado);
        btnNuevaCategoria.setVisible(esEncargado);
        btnRegistrarCliente.setVisible(esEncargado);
        btnRegistrarEmpleado.setVisible(esEncargado);
        btnRegistrarVenta.setVisible(esEncargado);
        btnComprar.setVisible(!esEncargado);
    }

    public void mostrarProductos(ArrayList<Producto> productos) {
        modeloProductos.setRowCount(0);

        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            modeloProductos.addRow(new Object[]{
                producto.getIdProducto(),
                producto.getNombre(),
                producto.getTalla(),
                producto.getColor(),
                String.format("S/ %.2f", producto.getPrecio()),
                producto.getStock()
            });
        }
    }

    public void mostrarCategorias(ArrayList<Categoria> categorias) {
        modeloCategorias.setRowCount(0);

        for (int i = 0; i < categorias.size(); i++) {
            Categoria categoria = categorias.get(i);
            modeloCategorias.addRow(new Object[]{
                categoria.getNombre(), categoria.getDescripcion()
            });
        }
    }

    public void mostrarClientes(ArrayList<Persona> personas) {
        modeloClientes.setRowCount(0);

        for (int i = 0; i < personas.size(); i++) {
            Persona persona = personas.get(i);
            modeloClientes.addRow(new Object[]{
                persona.getNroDoc(), persona.getNombre(), persona.getApellido_pa()
            });
        }
    }

    public void mostrarVentas(ArrayList<Venta> ventas) {
        modeloVentas.setRowCount(0);

        for (int i = 0; i < ventas.size(); i++) {
            Venta venta = ventas.get(i);
            modeloVentas.addRow(new Object[]{
                venta.getIdVenta(), venta.getFecha(),
                String.format("S/ %.2f", venta.getTotal())
            });
        }
    }

    public JButton getBtnNuevoProducto() {
        return btnNuevoProducto;
    }

    public JButton getBtnNuevaCategoria() {
        return btnNuevaCategoria;
    }

    public JButton getBtnRegistrarCliente() {
        return btnRegistrarCliente;
    }

    public JButton getBtnRegistrarEmpleado() {
        return btnRegistrarEmpleado;
    }

    public JButton getBtnRegistrarVenta() {
        return btnRegistrarVenta;
    }

    public JButton getBtnComprar() {
        return btnComprar;
    }

    public JButton getBtnCerrarSesion() {
        return btnCerrarSesion;
    }

    /** Métodos de presentación para solicitar y mostrar información. */
    public String solicitarTexto(String mensaje) {
        return JOptionPane.showInputDialog(this, mensaje);
    }

    public boolean confirmar(String mensaje) {
        return JOptionPane.showConfirmDialog(this, mensaje, "Confirmar",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Tienda de ropa",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "No se pudo completar",
                JOptionPane.ERROR_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnNuevaCategoria;
    private javax.swing.JButton btnNuevoProducto;
    private javax.swing.JButton btnRegistrarCliente;
    private javax.swing.JButton btnRegistrarEmpleado;
    private javax.swing.JButton btnRegistrarVenta;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlCategorias;
    private javax.swing.JPanel pnlClientes;
    private javax.swing.JPanel pnlProductos;
    private javax.swing.JPanel pnlVentas;
    private javax.swing.JScrollPane scrCategorias;
    private javax.swing.JScrollPane scrClientes;
    private javax.swing.JScrollPane scrProductos;
    private javax.swing.JScrollPane scrVentas;
    private javax.swing.JTabbedPane tabDatos;
    private javax.swing.JTable tblCategorias;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTable tblVentas;
    // End of variables declaration//GEN-END:variables
}
