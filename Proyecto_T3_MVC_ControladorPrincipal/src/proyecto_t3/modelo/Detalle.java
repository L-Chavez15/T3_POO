/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_t3.modelo;

/**
 *
 * @author leoch
 */
public class Detalle 
{
    private int cantidad;
    private double precio;
    private double total;

    private Producto producto;


    public int getCantidad() {
        return cantidad;
    }

    public boolean setCantidad(int cantidad) 
    {
        if (cantidad > 0)
        {
            this.cantidad = cantidad;
            return true;
        }
        else
        {
            System.out.println("ERROR: CANTIDAD INVALIDA");
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public Detalle(Producto producto, int cantidad)
    {
        this.producto = producto;
        this.cantidad = cantidad;
        if (producto != null)
        {
            this.setPrecio(producto.getPrecio());
        }
        this.total = 0;
    }

    public Producto getProducto() {
        return producto;
    }

    public boolean setProducto(Producto producto) 
    {
        if (producto != null)
        {
            this.producto = producto;
            return true;
        }
        else
        {
            System.out.println("ERROR: DEBE SELECCIONAR UN PRODUCTO");
            return false;
        }
    }
    

    public double calcularTotal()
    {
        this.total = this.cantidad * this.precio;
        return this.total;
    }

    public void mostrar()
    {
        System.out.println("");
        System.out.println("DETALLE DE VENTA");
        this.producto.mostrar();
        System.out.println("CANTIDAD: " + this.cantidad);
        System.out.println("PRECIO: " + this.precio);
        System.out.println("TOTAL: " + this.calcularTotal());
    }
    
    

}
