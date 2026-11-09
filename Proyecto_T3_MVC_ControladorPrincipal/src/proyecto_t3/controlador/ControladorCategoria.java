package proyecto_t3.controlador;

import java.util.ArrayList;
import proyecto_t3.modelo.Categoria;

public class ControladorCategoria
{
    private ArrayList<Categoria> lista_categorias = new ArrayList();

    public boolean agregar(Categoria categoria_nueva)
    {
        if (categoria_nueva != null)
        {
            if (this.buscar(categoria_nueva.getNombre()) == null)
            {
                lista_categorias.add(categoria_nueva);
                return true;
            }
            else
            {
                System.out.println("ERROR: CATEGORIA YA REGISTRADA");
                return false;
            }
        }
        else
        {
            System.out.println("ERROR: CATEGORIA NO VALIDA");
            return false;
        }
    }

    public Categoria buscar(String nombre)
    {
        for (Categoria c : lista_categorias)
        {
            if (c.getNombre().equalsIgnoreCase(nombre))
            {
                return c;
            }
        }
        return null;
    }

    // Se utiliza para mostrar los registros en las tablas de la vista.
    public ArrayList<Categoria> obtenerTodos()
    {
        return new ArrayList<Categoria>(lista_categorias);
    }

    public void listar()
    {
        System.out.println("::::::::LISTA DE CATEGORIAS::::::::");
        for (Categoria c : lista_categorias)
        {
            c.mostrar();
            System.out.println("----------------------------");
        }
    }
}
