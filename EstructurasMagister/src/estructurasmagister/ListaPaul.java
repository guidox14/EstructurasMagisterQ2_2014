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
public class ListaPaul {
    
     public static void main(String [] args)
    {
        ListaDobleEnlazada listaDobleEnlazadaPrueba = new ListaDobleEnlazada();
        listaDobleEnlazadaPrueba.ImprimirListaDobleEnlazada();
        listaDobleEnlazadaPrueba.AgregarNodoInicio("4");
        listaDobleEnlazadaPrueba.AgregarNodoInicio("3");
        listaDobleEnlazadaPrueba.AgregarNodoInicio("2");
        listaDobleEnlazadaPrueba.AgregarNodoInicio("1");
        listaDobleEnlazadaPrueba.eliminarNodoInicio();
        //listaDobleEnlazadaPrueba.ImprimirListaDobleEnlazada();
        
        ListaDobleEnlazada lista2 = new ListaDobleEnlazada();
        lista2.AgregarNodoFinal("1");
        lista2.AgregarNodoFinal("2");
        lista2.AgregarNodoFinal("3");
        lista2.AgregarNodoFinal("4");
    }
     }
    
    class NodoDobleEnlazada {
    public NodoDoble Siguiente;
    public NodoDoble Anterior;
    public Object Dato;
    
    //Constructor vacío
    public NodoDobleEnlazada()
    {
        Siguiente = null;
        Anterior = null;
        Dato = null;
    }
    
    //Constructor que define el objecto del nodo solamente
    public NodoDobleEnlazada(Object dato)
    {
        Dato = dato;
        Siguiente = null;
        Anterior = null;
    }

    //Constructor que define el objetodel nodo y el nodo siguiente
    public NodoDobleEnlazada(Object dato, NodoDoble siguiente)
    {
        Siguiente = siguiente;
        Dato = dato;
        Anterior = null;
    }
    
    //Constructor que define el objeto del nodo y el nodo anterior
    public NodoDobleEnlazada(Object dato, NodoDoble anterior, NodoDoble siguiente)
    {
        Siguiente = siguiente;
        Dato = dato;
        Anterior = anterior;
    }
    }

/*
 * Clase que tiene los métodos de la lista doble
*/
class ListaDobleEnlazada {
    
    public NodoDoble PrimerNodo;
    
    //Constructor Vacío
    public ListaDobleEnlazada()
    {
        PrimerNodo = null;
    }
    
    //Imprime toda la lista
    public void ImprimirListaDobleEnlazada()
    {
        //ESTE IMPRIMIR TODAVÍA ESTÁ HECHO PARA LISTAS DOBLES NO CIRCULARES
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
            //¿Qué pasa con .siguiente y .anterior?
        }
        else
        {
            NodoDoble tmp = new NodoDoble(dato);
            tmp.Siguiente = PrimerNodo;
            PrimerNodo.Anterior = tmp;
            PrimerNodo.Siguiente=tmp; //AQUI ESTÁ ASUMIENDO QUE LA LISTA SOLO TIENE DOS VALORES
            tmp.Anterior= PrimerNodo; //AQUÍ TAMBIEN
            PrimerNodo = tmp;
        }
    }
    
     //Elimina un nodo al inicio de la lista
    
   public void eliminarNodoInicio()
    {
        if(PrimerNodo != null)
        {
            PrimerNodo = PrimerNodo.Siguiente;
            PrimerNodo.Siguiente = PrimerNodo; //Esta línea está asumiendo que la lista va a quedar solo con un valor, ¿cierto?
            PrimerNodo.Anterior= PrimerNodo; //¿Está también?
            
        }
        else
        {
            System.out.println("ERROR: La lista está vacía");
           
        }
    }
    
    //Agrega un nodo al final de la lista
   
    public void AgregarNodoFinal(Object dato)
    {
        if(PrimerNodo == null) //PREGUNTAR
        {
            PrimerNodo = new NodoDoble(dato); //¿QUÉ PASA CON .SIGUIENTE Y .ANTERIOR
        }
        else
        {
            NodoDoble tmp = PrimerNodo;
            while(tmp.Siguiente!=dato) //¿POR QUÉ PREGUNTA SI .SIGUIENTE ES != DE DATO, NO DEBERÍA PREGUNTAR MEJOR POR NULL?
            {
                tmp = tmp.Siguiente;
            }
            NodoDoble nuevoNodo = new NodoDoble(dato);
            tmp.Siguiente = nuevoNodo;
            nuevoNodo.Anterior = tmp;
            tmp.Anterior= nuevoNodo; //¿POR QUÉ TMP.ANTERIOR VA HACIA NUEVONODO?
            nuevoNodo.Siguiente=tmp; //¿POR QUÉ NUEVONODO.SIGUIENTE VA HACIA TMP? ME PARECE QUE AQUÍ VA A CREAR UNA REFERENCIA CIRCULAR ENTRE LOS DOS ÚLTIMOS NODOS
        }
    }
    
     //Elimina un nodo al final de la lista
       
       public boolean eliminarNodoFinal(Object dato)
    {
         if(PrimerNodo == null){
            
            System.out.println("ERROR. La lista se encuentra vacia");
            return false;
            
        }
        else{
            
            NodoDoble tmp = PrimerNodo;
            while(tmp.Siguiente != null){
                tmp = tmp.Siguiente;
            }
            NodoDoble nuevoNodoFinal = tmp.Anterior;
            nuevoNodoFinal.Siguiente = null;
            return true;
        }
    }
    
    
    /*
     * Agrega un dato en una posición de la lista.
     * Las posiciones se cuentan empezando en 1
    */
   /* public void AgregarNodoPos(Object dato, int pos)
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
                    NodoDoble tmpNuevo = tmp.Anterior;//Preguntar posición tmpNuevo creo que es tmp.siguiente
                    tmpNuevo.Siguiente = nuevoNodo;
                    nuevoNodo.Siguiente = tmp;
                    nuevoNodo.Anterior = tmpNuevo;
                    tmp.Anterior = nuevoNodo;
                    tmp.Siguiente = tmpNuevo;
                    tmpNuevo.Anterior = tmp;
                }
                posTmp++;
                tmp = tmp.Siguiente;
            }
        }
    }
    
     /* public boolean eliminarNodoPos(int pos)
    {
        if(PrimerNodo != null)
        {
            if(pos==1) // Elimina el primer Nodo
            {
                PrimerNodo = PrimerNodo.Siguiente;
            }
            else
            {
                NodoDoble nodoAct = PrimerNodo;
                NodoDoble nodoAnt = new NodoDoble();
                for(int currentPos = 1; currentPos < pos; currentPos++)
                {
                    nodoAnt = nodoAct;
                    nodoAct = nodoAct.Siguiente;
                }
                nodoAnt.Siguiente = nodoAct.Siguiente;
            }
            
            return true;
        }
        else
        {
            System.out.println("ERROR: La lista está vacía");
            return false;
        }
    }*/

   
    

 }
