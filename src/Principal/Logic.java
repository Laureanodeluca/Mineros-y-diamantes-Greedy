package Principal;
import TDAs.DefaultComparator;
import TDAs.EmptyPriorityQueueException;
import TDAs.Entrada;
import TDAs.Entry;
import TDAs.Heap;
import TDAs.InvalidKeyException;
import TDAs.PriorityQueue;

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
	
	public void IngresoMyD(Integer num) {
		int numero=0;
		for(int i=0; i<num;i++) {
			numero=(int)(Math.random() * 25) + 1;
			if(entontre(myStructure.getColaDiamantes(),numero)) {
				numero=(int)(Math.random() * 25) + 1;
				i--;
			}
			else
				myStructure.addDiamante(numero);
		}
		for(int o=0;o<num;o++ ) {
			numero=(int)(Math.random() * 25) + 1;
			if(entontre(myStructure.getColaMineros(),numero)) {
				numero=(int)(Math.random() * 25) + 1;
				o--;
			}
			else
				myStructure.addMinero(numero);
		}
	}
	
private boolean entontre(PriorityQueue<Integer, String> cola, int i) {
		boolean encontre = false;
		Entry<Integer,String> auxx = new Entrada(null,null);
		PriorityQueue<Integer, String> aux=new Heap<Integer, String>(new DefaultComparator<Integer>());
		while(!cola.isEmpty()) {
			try {
				auxx=cola.removeMin();
				aux.insert(auxx.getKey(),auxx.getValue());
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EmptyPriorityQueueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(auxx.getKey()==i) {
				encontre=true;
			}
		}
		while(!aux.isEmpty()) {
			try {
				auxx=aux.removeMin();
				cola.insert(auxx.getKey(),auxx.getValue());
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EmptyPriorityQueueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(auxx.getKey()==i) {
				encontre=true;
			}
		}
		return encontre;
		
	}

//	public void IngresoMyD(Integer num) {
//		for(int i=0; i<num;i++) {
//			myStructure.addDiamante((int)(Math.random() * 4)==1 ? -1*(int)(Math.random() * 25) - 1 : (int)(Math.random() * 25) + 1);
//			myStructure.addMinero((int)(Math.random() * 4)==1 ? -1*(int)(Math.random() * 25) - 1 : (int)(Math.random() * 25) + 1);
//		}
//	}
//	
	public static String solucionToString(Entry<Entry<Integer, String>, Entry<Integer, String>> S[]) 
	{
		String toRet = "";
		for (int i = 0; i < S.length; i++)
		{
			toRet = toRet + "("+S[i].getKey().getValue()+":" + S[i].getKey().getKey() + " ,"+S[i].getValue().getValue()+":" + + S[i].getValue().getKey() + "), ";
		}
		return toRet;
	}
}
