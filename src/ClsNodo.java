
public class ClsNodo
{
	  private String valor;
	    private ClsNodo siguiente;

	    /**
	     * 
	     * Crea un nuevo nodo.
	     * @param valor el dato que se guardara en el nodo.
	     */
	    public ClsNodo(String valor)
	    {
	        this.valor = valor;
	        this.siguiente = null;
	    }

	    /**
	     * Apunta hacia un nuevo nodo.
	     * @param nodoSiguiente es el nodo al que se va a apuntar.
	     */
	    public void setSiguiente(ClsNodo nodoSiguiente){
	        siguiente = nodoSiguiente;
	    }
	    /**
	     * 
	     * @return valor guardado en el nodo.
	     */
	    public String getValor(){
	        return valor;
	    }
	    /**
	     * Devuelve el nodo siguiente al nodo que invoca al metodo.
	     * @return nodo siguiente
	     */
	    public ClsNodo getSiguiente(){
	        return siguiente;
	    }
}
