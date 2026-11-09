package proyecto_t3.controlador;

import java.util.ArrayList;
import proyecto_t3.modelo.Persona;

public class ControladorPersona
{
    private ArrayList<Persona> lista_personas = new ArrayList();

    public boolean agregar(Persona persona_nueva)
    {
        if (persona_nueva != null)
        {
            if (this.buscar(persona_nueva.getNroDoc()) == null)
            {
                lista_personas.add(persona_nueva);
                return true;
            }
            else
            {
                System.out.println("ERROR: EL DOCUMENTO YA ESTA REGISTRADO");
                return false;
            }
        }
        else
        {
            System.out.println("ERROR: PERSONA NO VALIDA");
            return false;
        }
    }

    public Persona buscar(String dni)
    {
        for (Persona p : lista_personas)
        {
            if (p.getNroDoc().equals(dni))
            {
                return p;
            }
        }
        return null;
    }

    // Se utiliza para mostrar los registros en las tablas de la vista.
    public ArrayList<Persona> obtenerTodos()
    {
        return new ArrayList<Persona>(lista_personas);
    }

    public void listar()
    {
        if (lista_personas.isEmpty())
        {
            System.out.println("NO HAY PERSONAS REGISTRADAS");
        }
        else
        {
            for (Persona p : lista_personas)
            {
                p.verDatos();
                System.out.println("--------------------------");
            }
        }
    }
}
