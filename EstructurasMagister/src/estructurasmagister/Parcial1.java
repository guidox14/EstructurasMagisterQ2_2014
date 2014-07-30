/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package estructurasmagister;

/**
 *
 * @author Adrian
 */
public class Parcial1 {
    public static void main(String [] args) {
        
        
    }
}

class NodoSimple {
    public NodoSimple Siguiente;
    public Object Dato;
    
    public NodoSimple() {
        Dato = null;
        Siguiente = null;
    }
    
    public NodoSimple(Object dato)
    {
        Dato = dato;
    }
}

class ListaSimple {
    public NodoSimple PrimerNodo;
    
    public ListaSimple()
    {
        PrimerNodo = new NodoSimple();
    }
    
    public void InsertarInicioListaSimple(Object dato)
    {
        NodoSimple nuevoNodo = new NodoSimple(dato);
        if(PrimerNodo==null)
        {
            PrimerNodo = nuevoNodo;
        }
        else
        {
            nuevoNodo.Siguiente = PrimerNodo;
            PrimerNodo = nuevoNodo;
        }
    }
}

class NodoCircular
{
    public NodoCircular Siguiente;
    public NodoCircular Anterior;
    public Object Dato;
    
    public NodoCircular()
    {
        Siguiente = null;
        Anterior = null;
        Dato = null;
    }
    
    public NodoCircular(Object dato)
    {
        Siguiente = null;
        Anterior = null;
        Dato = dato;
    }
}

class ListaCircular {
    NodoCircular PrimerNodo;
    
    public ListaCircular()
    {
        PrimerNodo = new NodoCircular();
    }
    
    public boolean EliminarFinalListaCircular()
    {
        if(PrimerNodo==null)
        {
            System.out.println("ERROR: La lista ya se encuentra vacía");
        }
        else
        {
            NodoCircular ultimoNodoTmp = PrimerNodo.Anterior;
            ultimoNodoTmp.Anterior.Siguiente = PrimerNodo;
            PrimerNodo.Anterior = ultimoNodoTmp.Anterior;
        }
        return true;
    }
}
