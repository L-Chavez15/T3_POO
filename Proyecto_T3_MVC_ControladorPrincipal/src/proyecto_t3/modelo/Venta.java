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
public class Venta 
{
    private int idVenta;
    private String fecha;
    private double total;

    private ArrayList<Detalle> detalles = new ArrayList();

    public int getIdVenta() {
        return idVenta;
    }

    public boolean setIdVenta(int idVenta) 
    {
        if (idVenta > 0)
        {
            this.idVenta = idVenta;
            return true;
        }
        else
        {
            System.out.println("ERROR: ID DE VENTA INVALIDO");
            return false;
        }
    }

    public String getFecha() {
        return fecha;
    }

    public boolean setFecha(String fecha) 
    {
        if (fecha != null && fecha.length() > 0)
        {
            this.fecha = fecha;
            return true;
        }
        else
        {
            System.out.println("ERROR: INGRESE LA FECHA");
            return false;
        }
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    

    public Venta(int idVenta, String fecha, double total) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.total = 0;
    }
    
    public void agregarDetalle(Detalle detalle)
    {
        this.detalles.add(detalle);
        this.calcularTotal();
    }

    public double calcularTotal()
    {
        this.total = 0;

        for (int i = 0; i < this.detalles.size(); i++)
        {
            this.total = this.total +this.detalles.get(i).calcularTotal();
        }

        return this.total;
    }

    public void mostrar()
    {
        System.out.println("DATOS DE LA VENTA");
        System.out.println("ID VENTA: " + this.idVenta);
        System.out.println("FECHA: " + this.fecha);
        System.out.println("DETALLES:");

        for (int i = 0; i < this.detalles.size(); i++)
        {
            this.detalles.get(i).mostrar();
        }

        System.out.println("TOTAL DE LA VENTA: " + this.calcularTotal());
    }
    
}
