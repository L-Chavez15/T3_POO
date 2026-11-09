/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_t3.modelo;

/**
 *
 * @author leoch
 */
public abstract class Persona 
{
    protected String tipoDoc;
    protected String nroDoc;
    protected String Nombre;
    protected String Apellido_pa;
    protected String Apellido_ma;

    //constructor es para inicializar 
    
    public Persona() 
    {
    }
    public Persona(String tipoDoc, String nroDoc, String Nombre, String Apellido_pa, String Apellido_ma) {
        this.tipoDoc = tipoDoc;
        this.nroDoc = nroDoc;
        this.Nombre = Nombre;
        this.Apellido_pa = Apellido_pa;
        this.Apellido_ma = Apellido_ma;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public boolean setTipoDoc(String tipoDoc) 
    {
        if(tipoDoc != null)
        {
            if(tipoDoc.equalsIgnoreCase("DNI"))
            {
                this.tipoDoc = "DNI";
                return true;
            }
            else if(tipoDoc.equalsIgnoreCase("CE"))
            {
                this.tipoDoc = "CE";
                return true;
            }
            else
            {
                System.out.println("ERROR: INGRESE NUEVAMENTE");
                return false;
            }   
        }
        else
        {
            System.out.println("ERROR: INGRESE EL TIPO DE DOCUMENTO (DNI/CE)");
            return false;
        }
    }

    public String getNroDoc() {
        return nroDoc;
    }

    public boolean setNroDoc(String nroDoc) 
    {
        if(nroDoc != null)
        {
            if(nroDoc.matches("[0-9]{8}"))
            {
                this.nroDoc = nroDoc;
                return true;
            }
            else if(nroDoc.matches("[0-9]{11}"))
            {
                this.nroDoc = nroDoc;
                return true;
            }
            else
            {
                System.out.println("ERROR, CANTIDAD DE CARACTERES INVALIDA O DNI REPETIDO");
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    public String getNombre() {
        return Nombre;
    }

    public boolean setNombre(String Nombre) 
    {
       if (Nombre != null)
        {
            if (Nombre.length() > 0 &&  Nombre.matches("[a-zA-Z]+"))
            {
                this.Nombre = Nombre;
                return true;
            }
            else
            {
                System.out.println("ERROR: INGRESE EL NOMBRE");
                return false;
            }
        }
        else
        {
            System.out.println("ERROR: EL NOMBRE ES OBLIGATORIO");
            return false;
        }
    }

    public String getApellido_pa() {
        return Apellido_pa;
    }

    public boolean setApellido_pa(String Apellido_pa) 
    {
        if (Apellido_pa != null)
        {
            if (Apellido_pa.length() > 0 &&  Apellido_pa.matches("[a-zA-Z]+"))
            {
                this.Apellido_pa = Apellido_pa;
                return true;
            }
            else
            {
                System.out.println("ERROR: INGRESE EL APELLIDO PATERNO");
                return false;
            }
        }
        else
        {
            System.out.println("ERROR: EL APELLIDO PATERNO ES OBLIGATORIO");
            return false;
        }
    }

    public String getApellido_ma() {
        return Apellido_ma;
    }

    public boolean setApellido_ma(String Apellido_ma) 
    {
         if (Apellido_ma != null)
        {
            if (Apellido_ma.length() > 0 &&  Apellido_ma.matches("[a-zA-Z]+"))
            {
                this.Apellido_ma = Apellido_ma;
                return true;
            }
            else
            {
                System.out.println("ERROR: INGRESE EL APELLIDO MATERNO");
                return false;
            }
        }
        else
        {
            System.out.println("ERROR: EL APELLIDO MATERNO ES OBLIGATORIO");
            return false;
        }
    }
    
    public abstract void  verDatos();
}
