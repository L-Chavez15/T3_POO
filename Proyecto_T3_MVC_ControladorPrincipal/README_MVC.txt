PROYECTO T3 - MVC USANDO LAS CLASES DEL PROYECTO INICIAL

Abrir la carpeta del proyecto desde Apache NetBeans y ejecutar Clean and Build.

La aplicación inicia desde proyecto_t3.Proyecto_T3.

ESTRUCTURA:
- modelo: Persona, Cliente, Empleado, Producto, Categoria, Detalle y Venta.
- controlador: ControladorPersona, ControladorProducto, ControladorCategoria y ControladorVenta.
- vista: Ventana_Login y FrmPrincipal.
- Proyecto_T3: clase que ya existía en el proyecto inicial; ahora conecta los formularios con los cuatro controladores existentes y contiene el main de inicio.

No existe TiendaController ni Lanzador.
No se creó una clase Tienda.
El modelo conserva el código original, salvo el cambio de paquete requerido para separar MVC.
Los cuatro controladores originales mantienen agregar, buscar y listar; obtenerTodos permite llenar las tablas de la vista.
Las validaciones de ingreso y conversiones se ejecutan en métodos del controlador Proyecto_T3, no en el método main ni en los formularios.
Los datos se mantienen en memoria.
