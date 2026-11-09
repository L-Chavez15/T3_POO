/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_t3.modelo;

/**
 *
 * @author leoch
 */
public class Cliente extends Persona
{
    private int idCliente;

    public int getIdCliente() {
        return idCliente;
    }

    public boolean setIdCliente(int idCliente) 
    {
        if (idCliente > 0)
        {
            this.idCliente = idCliente;
            return true;
        }
        else
        {
            System.out.println("ERROR: ID DE CLIENTE INVALIDO");
            return false;
        }
    }

    public Cliente(int idCliente, String tipoDoc, String nroDoc, String Nombre, String Apellido_pa, String Apellido_ma) {
        super(tipoDoc, nroDoc, Nombre, Apellido_pa, Apellido_ma);
        this.idCliente = idCliente;
    }
    public void realizarCompra()
    {
        System.out.println("EL CLIENTE ESTA REALIZANDO UNA COMPRA");
    }
    @Override
    public void verDatos() 
    {
        System.out.println("");
        System.out.println("ID CLIENTE: "+ this.idCliente);
        System.out.println("TIPO DOC: " + this.tipoDoc+ " NRO DOC: " + this.nroDoc);
        System.out.println("NOMBRE: " + this.Nombre+ " " + this.Apellido_pa+ " " + this.Apellido_ma);
    }
}
