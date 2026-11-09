package proyecto_t3.controlador;

import java.util.ArrayList;
import proyecto_t3.modelo.Producto;

public class ControladorProducto
{
    private ArrayList<Producto> lista_productos = new ArrayList();

    public boolean agregar(Producto producto_nuevo)
    {
        if (producto_nuevo != null)
        {
            if (this.buscar(producto_nuevo.getIdProducto()) == null)
            {
                lista_productos.add(producto_nuevo);
                return true;
            }
            else
            {
                System.out.println("ERROR: EL ID DEL PRODUCTO YA ESTA REGISTRADO");
                return false;
            }
        }
        else
        {
            System.out.println("ERROR: PRODUCTO NO VALIDO");
            return false;
        }
    }

    public Producto buscar(int idProducto)
    {
        for (Producto p : lista_productos)
        {
            if (p.getIdProducto() == idProducto)
            {
                return p;
            }
        }
        return null;
    }

    // Se utiliza para mostrar los registros en las tablas de la vista.
    public ArrayList<Producto> obtenerTodos()
    {
        return new ArrayList<Producto>(lista_productos);
    }

    public void listar()
    {
        System.out.println("::::::::LISTA DE PRODUCTOS::::::::");
        for (Producto p : lista_productos)
        {
            p.mostrar();
            System.out.println("----------------------------");
        }
    }
}
