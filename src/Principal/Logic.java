package Principal;
import TDAs.EmptyPriorityQueueException;
import TDAs.Entrada;
import TDAs.Entry;

import java.lang.Math;

/**
 * Logica del programa completo.
 * @author Laureano De Luca
 */
public class Logic 
{
	private Structure myStructure;
	
	/**
	 * Constructor de la logica del programa.
	 */
	public Logic(Structure s)
	{
		myStructure = s;
	}
	
	/**
	 * Retorna la lista de pares (Mi, Di). 
	 * @return Lista de pares minero-diamante.
	 */
	public Entry<Entry<Integer, String>, Entry<Integer, String>>[] minerosDeDiamanteGreedy() {
		
		@SuppressWarnings("unchecked")
		Entry<Entry<Integer, String>, Entry<Integer, String>> S[] = (Entry<Entry<Integer, String>, Entry<Integer, String>> []) new Entrada[myStructure.getColaDiamantes().size()];
		int i = 0;
				
		while (!myStructure.getColaDiamantes().isEmpty() && !myStructure.getColaMineros().isEmpty())
		{
			try 
			{
				Entry<Integer, String> myDiamond = myStructure.getColaDiamantes().removeMin();
				Entry<Integer, String> myMiner = myStructure.getColaMineros().removeMin();
				
				S[i] = new Entrada<Entry<Integer, String>, Entry<Integer, String>>(myMiner, myDiamond);
				i++;
				
			} 
			catch (EmptyPriorityQueueException e) 
			{
				System.out.println(e.getMessage());
			}
		}
		return S;
	}
	
	/**
	 * Calcula el esfuerzo total de una solucion. 
	 * @param S Solucion presentada.
	 * @return Esfuerzo total. 
	 */
	public double esfuerzoTotal(Entry<Entry<Integer, String>, Entry<Integer, String>>[] S)
	{
		double res = 0;
		for (int i = 0; i < S.length; i++)
			res = res + Math.sqrt(Math.pow(S[i].getKey().getKey(), 2) + Math.pow(S[i].getValue().getKey(), 2));
		
		return res;
	}
}
