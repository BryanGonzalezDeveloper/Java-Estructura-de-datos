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
	 // inserta en el sub�rbol izquierdo
	 if ( valorInsertar < dato )
	 {
	 if ( izquierdo == null )
	 izquierdo = new ClsNodo( valorInsertar );
	 else // contin�a recorriendo el sub�rbol izquierdo
	 izquierdo.insertar( valorInsertar );
	 } 
	 else if ( valorInsertar > dato ) // inserta en el sub�rbol derecho
	 {
	 // inserta nuevo NodoArbol
	 if ( derecho == null )
	 derecho = new ClsNodo( valorInsertar );
	 else // contin�a recorriendo el sub�rbol derecho
	 derecho.insertar( valorInsertar );
	 }
	 } // fin del m�todo insertar
}
