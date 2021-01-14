package Arboles;
public class ClsNodo 
{
	private Integer dato;
	private ClsNodo izquierdo;
	private ClsNodo derecho;
	public ClsNodo()
	{
		dato=null;
		izquierdo=null;
		derecho=null;
	}
	
	public ClsNodo(Integer dato)
	{
		this.dato=dato;
	}
	
	public Integer getDato()
	{
		return dato;
	}
	
	public ClsNodo getNodoIzquierdo()
	{
		return izquierdo;
	}
	
	public ClsNodo getNodoDerecho()
	{
		return derecho;
	}
	public void setDato(Integer dato)
	{
		this.dato=dato;
	}
	public void setNodoIzquierdo(ClsNodo nodoNuevo)
	{
		izquierdo=nodoNuevo;
	}
	
	public void setNodoDerecho(ClsNodo nodoNuevo)
	{
		derecho=nodoNuevo;
	}
	
	public void insertar( Integer valorInsertar )
	{
	 // inserta en el subárbol izquierdo
	 if ( valorInsertar < dato )
	 {
	 if ( izquierdo == null )
	 izquierdo = new ClsNodo( valorInsertar );
	 else // continúa recorriendo el subárbol izquierdo
	 izquierdo.insertar( valorInsertar );
	 } 
	 else if ( valorInsertar > dato ) // inserta en el subárbol derecho
	 {
	 // inserta nuevo NodoArbol
	 if ( derecho == null )
	 derecho = new ClsNodo( valorInsertar );
	 else // continúa recorriendo el subárbol derecho
	 derecho.insertar( valorInsertar );
	 }
	 } // fin del método insertar
}
