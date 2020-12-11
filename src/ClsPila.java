import javax.swing.DefaultListModel;

public class ClsPila
{
ClsNodo Top;
DefaultListModel<Integer>modelo;
		
/**
 * Inicializa una pila vacia.
 */
	public ClsPila()
	{
		Top=null;
	}
	
	/**
	 * Agrega un nuevo elemento a la pila.
	 * @param elemento es el numero que sera agregado a la pila.
	 */
	public void add(int elemento)
	{
		ClsNodo nuevo=new ClsNodo(elemento);
		if(vacia())
		Top=nuevo;
		else
		{
			
			nuevo.setSiguiente(Top);
			Top=nuevo;
		}
	}
	
	/**
	 * 
	 * @return <strong>True</strong> si la pila esta vacia.<br><strong>False</strong> en caso contrario.
	 */
	public boolean vacia()
	{
		return Top==null;
	}
	
	/**
	 * 
	 * @return Valor que se encuentra en la cima de la pila.<br>Solo muestra el valor, no lo elimina.
	 */
	public int peek()
	{
		return Top.getValor();
	}
	
	/**
	 * 
	 * @return Muestra el valor en la cima de la pila.<br>Despues lo elimina.
	 */
	public int pop()
	{
		int num=Top.getValor();
		
		Top=Top.getSiguiente();
		return num;
	}
	
	/**
	 * vacia la Pila.
	 */
	public void Clear()
	{
		Top=null;
	}
	
	/**
	 * 
	 * @param elemento es el valor que sera buscado en la pila.
	 * @return indice en la que se encuentra un elemento.
	 */
	public int buscar(int elemento)
	{
		int index=-1;
		int i=0;
		if(!vacia())
		{
			ClsNodo aux=Top;
			while(aux!=null)
			{
				if(aux.getValor()==elemento)
				{
				index=i;
				break;
				}
				aux=aux.getSiguiente();
				i++;
			}
		}		
		return index;
	}
	
	/**
	 * Recorre la pila de manera secuencial.
	 * @return DefaulListModel con los valores de la pila.
	 */
	public DefaultListModel<Integer> Imprimir()
	{
		modelo=new DefaultListModel<Integer>();
		ClsNodo aux=Top;
		while(aux!=null)
		{
			modelo.addElement(aux.getValor());
			aux=aux.getSiguiente();
		}
		return modelo;
	}
 
}
