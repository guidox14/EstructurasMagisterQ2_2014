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
public class ListaDobleMain
{
    public static void main(String [] args)
    {
        ListaDoble listaDoblePrueba = new ListaDoble();
        //listaDoblePrueba.ImprimirListaDoble();
        listaDoblePrueba.AgregarNodoInicio("2");
        listaDoblePrueba.AgregarNodoInicio("1");
        listaDoblePrueba.AgregarNodoFinal("5");
        /*listaDoblePrueba.AgregarNodoPos("2", 2);
        listaDoblePrueba.AgregarNodoPos("4", 3);*/
        //listaDoblePrueba.ImprimirListaDoble();
        listaDoblePrueba.EliminarNodoPos(3);
    }
}

/*
 * Crea un nodo doble
*/
class NodoDoble {
    public NodoDoble Siguiente;
    public NodoDoble Anterior;
    public Object Dato;
    
    //Constructor vacío
    public NodoDoble()
    {
        Siguiente = null;
        Anterior = null;
        Dato = null;
    }
    
    //Constructor que define el objecto del nodo solamente
    public NodoDoble(Object dato)
    {
        Dato = dato;
        Siguiente = null;
        Anterior = null;
    }

    //Constructor que define el objetodel nodo y el nodo siguiente
    public NodoDoble(Object dato, NodoDoble siguiente)
    {
        Siguiente = siguiente;
        Dato = dato;
        Anterior = null;
    }
}

/*
 * Clase que tiene los métodos de la lista doble
*/
class ListaDoble {
    public NodoDoble PrimerNodo;
    
    //Constructor Vacío
    public ListaDoble()
    {
        PrimerNodo = null;
    }
    
    //Imprime toda la lista
    public void ImprimirListaDoble()
    {
        if(PrimerNodo == null)
        {
            System.out.println("La lista está vacía");
        }
        else
        {
            NodoDoble tmp = PrimerNodo;
            while(tmp!=null)
            {
                System.out.println(tmp.Dato);
                tmp = tmp.Siguiente;
            }
        }
    }
    
    //Agrega un nodo al inicio de la lista
    public void AgregarNodoInicio(Object dato)
    {
        if(PrimerNodo == null)
        {
            PrimerNodo = new NodoDoble(dato);
        }
        else
        {
            NodoDoble tmp = new NodoDoble(dato);
            tmp.Siguiente = PrimerNodo;
            PrimerNodo.Anterior = tmp;
            PrimerNodo = tmp;
        }
    }
    
    //Agrega un nodo al final de la lista
    public void AgregarNodoFinal(Object dato)
    {
        if(PrimerNodo == null)
        {
            PrimerNodo = new NodoDoble(dato);
        }
        else
        {
            NodoDoble tmp = PrimerNodo;
            while(tmp.Siguiente!=null)
            {
                tmp = tmp.Siguiente;
            }
            NodoDoble nuevoNodo = new NodoDoble(dato);
            tmp.Siguiente = nuevoNodo;
            nuevoNodo.Anterior = tmp;
        }
    }
    
    /*
     * Agrega un dato en una posición de la lista.
     * Las posiciones se cuentan empezando en 1
    */
    public void AgregarNodoPos(Object dato, int pos)
    {
        if(pos <= 0)
        {
            System.out.println("El valor de la posición es invalido");
        }
        else
        {
            int posTmp = 1;
            NodoDoble tmp = PrimerNodo;
            NodoDoble nuevoNodo = new NodoDoble(dato);
            while(tmp!=null)
            {
                if(pos==posTmp)
                {
                    NodoDoble tmpAnterior = tmp.Anterior;
                    tmpAnterior.Siguiente = nuevoNodo;
                    nuevoNodo.Siguiente = tmp;
                    nuevoNodo.Anterior = tmpAnterior;
                    tmp.Anterior = nuevoNodo;
                }
                posTmp++;
                tmp = tmp.Siguiente;
            }
        }
    }
    
    public boolean EliminarNodoInicio()
    {
        if(PrimerNodo == null)
        {
            System.out.println("Error: La lista ya se encuentra vacía!!!");
            return false;
        }
        else
        {
            NodoDoble tmp = PrimerNodo.Siguiente;
            tmp.Anterior = null;
            PrimerNodo = tmp;
            return true;
        }
    }
    
    public boolean EliminarNodoFinal()
    {
        if(PrimerNodo == null)
        {
            System.out.println("Error: La lista ya se encuentra vacía");
            return false;
        }
        else
        {
            NodoDoble tmp = PrimerNodo;
            while(tmp.Siguiente != null)
            {
                tmp = tmp.Siguiente;
            }
            NodoDoble nuevoNodoFinal = tmp.Anterior;
            nuevoNodoFinal.Siguiente = null;
            return true;
        }
    }
    
    public void EliminarNodoPos(int pos)
    {
        if(PrimerNodo == null)
        {
            System.out.println("Error: La lista ya se encuentra vacía");
        }
        else if(pos==1)
            EliminarNodoInicio();
        else
        {
            NodoDoble tmp = PrimerNodo;
            for(int i = 1; i < pos; i++)
            {
                if(tmp.Siguiente==null)
                    i = pos+1;
                else
                    tmp = tmp.Siguiente;
            }
            NodoDoble nodoAnterior = tmp.Anterior;
            NodoDoble nodoSiguiente = tmp.Siguiente;
            nodoAnterior.Siguiente = nodoSiguiente;
            if(nodoSiguiente!=null)
                nodoSiguiente.Anterior = nodoAnterior;
        }
        
    }
    //Hacer los códigos de eliminar inicio, final y pos
}
