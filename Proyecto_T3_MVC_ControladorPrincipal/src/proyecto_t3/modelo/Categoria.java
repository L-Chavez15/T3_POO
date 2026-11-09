/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_t3.modelo;

import java.util.ArrayList;

/**
 *
 * @author leoch
 */
public class Categoria 
{
    private String nombre;
    private String descripcion;

    private ArrayList<Producto> productos = new ArrayList();

    public Categoria(String nombre, String descripcion) 
    {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean setNombre(String nombre) 
    {
       if (nombre != null && nombre.length() > 0) 
       {
        if (nombre.matches("[A-Z-a-z]+")) 
        {
            this.nombre = nombre;
            return true;
        } else {
            System.out.println("ERROR: EL NOMBRE SOLO DEBE CONTENER LETRAS");
            return false;
        }
    } else 
       {
        System.out.println("ERROR: INGRESE EL NOMBRE");
        return false;
       }
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean setDescripcion(String descripcion) 
    {
        if (descripcion != null && descripcion.length() > 0) 
       {
        if (descripcion.matches("[A-Z-a-z ]+")) 
        {
            this.descripcion = descripcion;
            return true;
        } else {
            System.out.println("ERROR: LA DESCRIPCION SOLO DEBE CONTENER LETRAS");
            return false;
        }
    } else 
       {
        System.out.println("ERROR: INGRESE DESCRIPCION");
        return false;
       }
    }

    public void agregarProducto(Producto producto)
    {
        if (producto != null)
        {
            this.productos.add(producto);
        }
        else
        {
            System.out.println("ERROR: PRODUCTO NO VALIDO");
        }
    }

    public void mostrar()
    {
        System.out.println("CATEGORIA: " + this.nombre);
        System.out.println("DESCRIPCION: " + this.descripcion);
        System.out.println("PRODUCTOS DE LA CATEGORIA:");

        for (int i = 0; i < this.productos.size(); i++)
        {
            this.productos.get(i).mostrar();
        }
    }
}
