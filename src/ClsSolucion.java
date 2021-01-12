import java.util.ArrayList;
import java.util.List;
/**
 * @since 02 de enero de 2021.
 *@author Bryan Enrique
 *@version 1.0
 */
public class ClsSolucion
{
	//EJEMPLOS:
	
	//Expresion infija: (6+2)*3/2^2-4+(4/2)
	//Expresion posfija: 62+3*22^/4-42/+
	//REsultado: 4.0
	
	
	//Expresion infija: (((6+2)*3/2^2-4+(4/2))*3)/0.5
	//Expresion posfija: 62+3*22^/4-42/+3*0.5/
	//Resultado: 24.0
	
	
	//Expresion infija: (5*8)/(20/10)
	//Expresion posfija:58*2010//
	//Resultado: 20.0
	
	
	/**
	 * Metodo que devuelve un numero entero para determinar la prioridad de los operadores.<br>Los operadores con menor prioridad devuelven 1.<br>
	 * Operadores con mayor prioridad devuelven 3.
	 * @param operador es el operador a evaluar.
	 * @return Entero entre 1 y 3; Segun la prioridad del operador.<br>Devuelve <Strong>-1</Strong> si  ocurre un error al revisar la jerarquia del operador.
	 */
	 private int revisarJerarquia(char operador)
	 {
	        if(operador=='+'|| operador=='-')
	        	return 1;
	        else if(operador=='*' || operador=='/')
	        	return 2;
	        else if(operador=='^')
	        	return 3;
	        else return -1;
	    }
	 
	 /**
	  * 
	  * @param listaPosfijo es la lista que almacena a la expresion posfija.
	  * @return Resultado de aplicar las operaciones en la expresion posfija
	  */
	    private String evaluarPosfijo(List<String> listaPosfijo)
	    {
	        ClsPila pilaResultado = new ClsPila();//pila que almacenara los operandos y los resultados parciales de las operaciones.
	        
	        for(int i=0;i<listaPosfijo.size();i++)
	        {
	            String termino = listaPosfijo.get(i);
	            if(termino.length()==1 && esOperador(termino.charAt(0)))
	            {
	                double segundoOperando = Double.parseDouble(pilaResultado.pop());
	                double primerOperando = Double.parseDouble(pilaResultado.pop());
	                if(termino.charAt(0)=='+')
	                {
	                    double resultado = primerOperando+segundoOperando;
	                    pilaResultado.add(resultado+"");
	                }
	                else if(termino.charAt(0)=='-')
	                {
	                    double resultado = primerOperando-segundoOperando;
	                    pilaResultado.add(resultado+"");
	                }
	                else if(termino.charAt(0)=='*')
	                {
	                    double resultado = primerOperando*segundoOperando;
	                    pilaResultado.add(resultado+"");
	                }else if(termino.charAt(0)=='/')
	                {
	                    double resultado = primerOperando/segundoOperando;
	                    pilaResultado.add(resultado+"");
	                }
	                else if(termino.charAt(0)=='^')
	                {
	                	double resultado=Math.pow(primerOperando, segundoOperando);
	                	pilaResultado.add(resultado+"");
	                }
	            }
	            else
	            {
	                double resultado = Double.parseDouble(termino);
	                pilaResultado.add(resultado+"");
	            }
	        }
	        return pilaResultado.pop();
	    }
	   
	    /**
	     * Metodo que convierte una expresion en notacion infija a una expresion en notacion Posfija.
	     * @param expresionInfija es la expresion que posteriormente se convertira a notacion posfija.
	     * @return Lista que contiene los terminos de la expresion Posfija.
	     */
	    public List<String> generarPosfijo(String expresionInfija)
	    {
	        ClsPila pila = new ClsPila();//Pila para guardar los operadores
	        List<String> listaPosfijo = new ArrayList<>(); //Lista para guardar la expresion posfija (Digitos y operadores)
	        boolean auxiliar = false;
	        
	        for(int i=0;i<expresionInfija.length();i++)
	        {
	            char caracterActual = expresionInfija.charAt(i);
	            if(caracterActual==' ')
	            {
	                continue;
	            }
	            if(caracterActual=='(')
	            {
	                pila.add(caracterActual+"");
	                auxiliar = false;
	            }
	            else if(caracterActual==')')
	            {
	                auxiliar = false;
	                //Se vacia la pila
	                while(!pila.vacia())
	                {
	                    if(pila.peek().charAt(0)=='(')
	                    {
	                        pila.pop();
	                        break;
	                    }
	                    else
	                    {
	                        listaPosfijo.add(pila.pop()+"");
	                    }
	                }
	            }
	            else if(esOperador(caracterActual))
	            {
	                auxiliar = false;
	                if(pila.vacia())
	                {
	                    pila.add(caracterActual+"");
	                }
	                else
	                {
	                	//Vacia la pila hasta que el operador a insertar tenga mayor jerarquia que el ultimo operador agregado en la pila.
	                    while(!pila.vacia() && revisarJerarquia(pila.peek().charAt(0))>=revisarJerarquia(caracterActual))
	                    {
	                        listaPosfijo.add(pila.pop()+"");
	                    }
	                    pila.add(caracterActual+"");
	                }
	            }
	            else
	            {
	                if(auxiliar)
	                {
	                    String digito = listaPosfijo.get(listaPosfijo.size()-1);
	                    digito+=caracterActual;
	                    listaPosfijo.set(listaPosfijo.size()-1, digito);
	                }
	                else
	                listaPosfijo.add(caracterActual+"");
	                auxiliar = true;
	            }
	        }
	        //Despues de recorrer la expresion Infija se vuelve a vaciar la pila para agregar los operadores restantes a la expresion posfija
	        while(!pila.vacia())
	        {
	            listaPosfijo.add(pila.pop()+"");
	        }
	         return listaPosfijo;
	    }
	    
	    
	    public String calcular(String expresionInfija)
	    {
	        List<String> listaPosfijo = generarPosfijo(expresionInfija);
	        return evaluarPosfijo(listaPosfijo);
	    }
	    
	    /**
	     * 
	     * @param op es el caracter a evaluar.
	     * @return <strong>True</strong> si el caracter es un operador.<br><strong>False</strong> en caso contrario.
	     */
	    public boolean esOperador(char op)
		{
			boolean operador=false;
			switch (op) 
			{
			case '^': 
			case '*': 
			case '/': 
			case '+': 
			case '-':
				operador=true;
				break;
			}
			return operador;
		}
}
