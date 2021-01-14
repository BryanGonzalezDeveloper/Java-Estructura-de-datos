package Arboles;

import javax.swing.DefaultListModel;

public class ClsArbolBinario 
{
	ClsNodo raiz;	
	Integer dato;
	Integer menor=Integer.MAX_VALUE;
	Integer mayor=Integer.MIN_VALUE;
	public ClsArbolBinario()
	{
		raiz=null;
	}
	
	public void insertar(Integer numero)
	{
		if(raiz==null)
		{
			raiz=new ClsNodo(numero);
		}
			
		else
		raiz.insertar(numero);
	}
	
	DefaultListModel<Integer>modeloPreorden=new DefaultListModel<Integer>();
	public DefaultListModel<Integer> preorden(ClsNodo nodoRaiz)
	{
		if(nodoRaiz!=null)
		{
			if(nodoRaiz.getDato()>mayor)
				mayor=nodoRaiz.getDato();
			else if(nodoRaiz.getDato()<menor)
				menor=nodoRaiz.getDato();
				
			modeloPreorden.addElement(nodoRaiz.getDato());
			preorden(nodoRaiz.getNodoIzquierdo());
			preorden(nodoRaiz.getNodoDerecho());
		}
		return modeloPreorden;
	}
	
	
	DefaultListModel<Integer>modeloInorden=new DefaultListModel<Integer>();
	public DefaultListModel<Integer> inorden(ClsNodo nodoRaiz)
	{
		if(nodoRaiz!=null)
		{
			inorden(nodoRaiz.getNodoIzquierdo());
			modeloInorden.addElement(nodoRaiz.getDato());
			inorden(nodoRaiz.getNodoDerecho());
		}
		return modeloInorden;
	}
	
	DefaultListModel<Integer>modeloPosorden=new DefaultListModel<Integer>();
	public DefaultListModel<Integer> posorden(ClsNodo nodoRaiz)
	{
		if(nodoRaiz!=null)
		{
			posorden(nodoRaiz.getNodoIzquierdo());
			posorden(nodoRaiz.getNodoDerecho());
			modeloPosorden.addElement(nodoRaiz.getDato());
		}
		return modeloPosorden;
	}
	public ClsNodo getRaiz()
	{
		return raiz;
	}
	public void setDato(Integer dato)
	{
		this.dato=dato;
	}
	
	
	public boolean buscar(Integer dato)
	{
		ClsNodo nodoPrincipal =raiz;
		boolean encontrado=false;
		while(nodoPrincipal!=null)
		{
			
			if(nodoPrincipal.getDato()==dato)
			{
				encontrado=true;
				break;
			}
			else
			{
				if(dato>nodoPrincipal.getDato())
					nodoPrincipal=nodoPrincipal.getNodoDerecho();
				
				else if(dato<nodoPrincipal.getDato())
					nodoPrincipal=nodoPrincipal.getNodoIzquierdo();
			}
		}
		return encontrado;
	}
	
	public Integer getMayor()
	{
		return mayor;
	}
	
	public Integer getMenor()
	{
		return menor;
	}
	
}
