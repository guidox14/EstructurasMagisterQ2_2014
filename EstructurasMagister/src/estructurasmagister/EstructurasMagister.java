/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package estructurasmagister;

/**
 * Universidad Magister
 * Curso Estructuras y Algoritmos
 * Código Listas Simples
 * @author Ing. Adrian Rodriguez Guido
 */
public class EstructurasMagister {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ListaEnlazada lista = new ListaEnlazada();
        lista.agregaNodoInicio("Nodo numero 1");
        lista.agregaNodoFinal("Nodo Final");
        lista.agregaNodoPos("Nodo numero 2", 2);
        lista.agregaNodoPos("Nodo numero 3", 3);
        lista.agregaNodoPos("Nodo numero 4", 4);
        lista.imprimeLista();
        lista.eliminarNodoPos(3);
        lista.imprimeLista();
    }
    
}

class Nodo {
    // Variables de clase
    private Nodo Siguiente;
    private Object Dato;
    
    // Constructores
    public Nodo() {}
    
    public Nodo(Object dato)
    {
        this.Dato = dato;
        this.Siguiente = null;
    }
    
    // Propiedades
    public Object getDato()
    {
        return Dato;
    }
    
    public void setDato(Object dato)
    {
        Dato = dato;
    }
    
    public Nodo getSiguiente()
    {
        return Siguiente;
    }
    
    public void setSiguiente(Nodo siguiente)
    {
        Siguiente = siguiente;
    }
    
}

class ListaEnlazada
{
    // Variables de clase
    private Nodo PrimerNodo;
    private int LargoLista;
    
    // Constructores
    public ListaEnlazada()
    {
        LargoLista = 0;
    }
    
    /// Métodos
    
    /*
     * Imprime la lista
     */
    public void imprimeLista()
    {
        if(this.PrimerNodo!=null)
        {
            Nodo nodoAct = this.PrimerNodo;
            while(nodoAct!=null)
            {
                System.out.println(nodoAct.getDato());
                nodoAct = nodoAct.getSiguiente();
            }
        }
        else
        {
            System.out.println("ERROR: La lista esta vacía");
        }
    }
    
    // Agrega un nodo al principio de la lista
    public void agregaNodoInicio(Object nodo)
    {
        Nodo nuevoNodo = new Nodo(nodo);
        if(this.PrimerNodo != null)
        {
            Nodo nodoTmp = this.PrimerNodo;
            this.PrimerNodo = nuevoNodo;
            this.PrimerNodo.setSiguiente(nodoTmp);
        }
        else
        {
            this.PrimerNodo = nuevoNodo;
        }
        this.LargoLista++;
    }
    
    // Agrega un nodo al final de la lista
    public void agregaNodoFinal(Object nodo)
    {
        if(this.PrimerNodo == null)
        {
           this.PrimerNodo = new Nodo(nodo);
        }
        else
        {
            Nodo newNodo = new Nodo(nodo);
            Nodo nodoAct = this.PrimerNodo;
            while(nodoAct.getSiguiente()!=null)
            {
                nodoAct = nodoAct.getSiguiente();
            }
            nodoAct.setSiguiente(newNodo);
        }
        this.LargoLista++;
    }
    
    /*
     * Agrega un nodo en una posición específica de la lista.
     * Las posiciones de la lista se empiezan a contar en 1
     */
    public void agregaNodoPos(Object nodo, int pos)
    {
        if(pos == 1)
        {
            this.agregaNodoInicio(nodo);
        }
        else
        {
            Nodo nuevoNodo = new Nodo(nodo);
            Nodo nodoAct = this.PrimerNodo;
            Nodo nodoAnt = new Nodo();
            for(int currentPos = 1; currentPos < pos; currentPos++)
            {
                nodoAnt = nodoAct;
                nodoAct = nodoAct.getSiguiente();
            }
            nodoAnt.setSiguiente(nuevoNodo);
            nuevoNodo.setSiguiente(nodoAct);
        }
        this.LargoLista++;
    }

    /*
     * Elimina el primer nodo de la lista
     */
    public boolean eliminarNodoInicio()
    {
        if(this.PrimerNodo != null)
        {
            this.PrimerNodo = this.PrimerNodo.getSiguiente();
            this.LargoLista--;
            return true;
        }
        else
        {
            System.out.println("ERROR: La lista está vacía");
            return false;
        }
    }
    
    /*
     * Elimina el último nodo de la lista
     */
    public boolean eliminarNodoFinal()
    {
        return this.eliminarNodoPos(this.LargoLista);
    }
    
    /*
     * Elimina un nodo en una posición dada. Las posiciones de la lista se
     * empiezan a contar en 1
     */
    public boolean eliminarNodoPos(int pos)
    {
        if(this.PrimerNodo != null)
        {
            if(pos==1) // Elimina el primer Nodo
            {
                this.PrimerNodo = this.PrimerNodo.getSiguiente();
            }
            else
            {
                Nodo nodoAct = this.PrimerNodo;
                Nodo nodoAnt = new Nodo();
                for(int currentPos = 1; currentPos < pos; currentPos++)
                {
                    nodoAnt = nodoAct;
                    nodoAct = nodoAct.getSiguiente();
                }
                nodoAnt.setSiguiente(nodoAct.getSiguiente());
            }
            this.LargoLista--;
            return true;
        }
        else
        {
            System.out.println("ERROR: La lista está vacía");
            return false;
        }
    }
}
