/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_t3.modelo;

/**
 *
 * @author leoch
 */
public class Producto 
{
    private int idProducto;
    private String nombre;
    private String talla;
    private String color;
    private double precio;
    private int stock;

    public Producto(int idProducto, String nombre, String talla, String color, double precio, int stock) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.talla = talla;
        this.color = color;
        this.precio = precio;
        this.stock = stock;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public boolean setIdProducto(int idProducto) 
    {
        if (idProducto > 0)
        {
            this.idProducto = idProducto;
            return true;
        }
        else
        {
            System.out.println("ERROR: ID DE PRODUCTO INVALIDO");
            return false;
        }
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

    public String getTalla() {
        return talla;
    }

    public boolean setTalla(String talla) 
    {
        if (talla != null && talla.length() > 0)
        {
            this.talla = talla;
            return true;
        }
        else
        {
            System.out.println("ERROR: INGRESE LA TALLA");
            return false;
        }
    }

    public String getColor() {
        return color;
    }

    public boolean setColor(String color) 
    {
       if (color != null && color.length() > 0) 
       {
        if (color.matches("[A-Z-a-z]+")) 
        { 
            this.color = color;
            return true;
        } else {
            System.out.println("ERROR: EL COLOR SOLO DEBE CONTENER LETRAS");
            return false;
        }
    } else 
       {
        System.out.println("ERROR: INGRESE COLOR");
        return false;
       }
    }

    public double getPrecio() {
        return precio;
    }

    public boolean setPrecio(double precio) 
    {
        if (precio > 0)
        {
            this.precio = precio;
            return true;
        }
        else
        {
            System.out.println("ERROR: PRECIO INVALIDO");
            return false;
        }
    }

    public int getStock() {
        return stock;
    }

    public boolean setStock(int stock) 
    {
        if (stock >= 0)
        {
            this.stock = stock;
            return true;
        }
        else
        {
            System.out.println("ERROR: STOCK INVALIDO");
            return false;
        }
    }
    
    public boolean actualizarStock(int cantidad)
    {
        if (cantidad > 0 && cantidad <= this.stock)
        {
            this.stock = this.stock - cantidad;
            return true;
        }
        else
        {
            System.out.println("CANTIDAD NO VALIDA PARA ACTUALIZAR EL STOCK");
            return false;
        }
    }

    public double calcularPrecioFinal()
    {
        return this.precio;
    }

    public void mostrar()
    {
        System.out.println("");
        System.out.println("::::::PRODUCTO::::::");
        System.out.println("PRODUCTO: " + this.nombre);
        System.out.println("ID PRODUCTO: " + this.idProducto);
        System.out.println("TALLA: " + this.talla);
        System.out.println("COLOR: " + this.color);
        System.out.println("PRECIO: " + this.precio);
        System.out.println("STOCK: " + this.stock);
    }
    
}
