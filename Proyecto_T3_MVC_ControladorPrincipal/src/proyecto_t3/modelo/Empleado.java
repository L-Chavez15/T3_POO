/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_t3.modelo;

/**
 *
 * @author leoch
 */
public class Empleado extends Persona
{
    private String usuario;

    public Empleado(String tipoDoc, String nroDoc, String Nombre, String Apellido_pa, String Apellido_ma) {
        super(tipoDoc, nroDoc, Nombre, Apellido_pa, Apellido_ma);
    }

    public String getUsuario() {
        return usuario;
    }

    public boolean setUsuario(String usuario) 
    {
        if (usuario != null)
        {
            if (usuario.length() > 0)
            {
                this.usuario = usuario;
                return true;
            }
            else
            {
                System.out.println("ERROR: INGRESE EL USUARIO");
                return false;
            }
        }
        else
        {
            System.out.println("ERROR: EL USUARIO ES OBLIGATORIO");
            return false;
        }
    }
    
    public void registrarVenta(Venta venta)
    {
        if (venta != null)
        {
            System.out.println("EL EMPLEADO REGISTRO LA VENTA");
            venta.mostrar();
        }
        else
        {
            System.out.println("NO EXISTE UNA VENTA");
        }
    }

    @Override
    public void verDatos() 
    {
        System.out.println("");
        System.out.println("::::::EMPLEADO::::::");
        System.out.println("USUARIO: "+ this.usuario);
        System.out.println("TIPO DOC: " + this.tipoDoc+ " NRO DOC: " + this.nroDoc);
        System.out.println("NOMBRE: " + this.Nombre+ " " + this.Apellido_pa+ " " + this.Apellido_ma);
    }
    
}
