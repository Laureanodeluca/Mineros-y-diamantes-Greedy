package Principal;

import TDAs.InvalidKeyException;
import TDAs.PriorityQueue;
import TDAs.EmptyPriorityQueueException;
import TDAs.Entry;
import TDAs.Heap;
import TDAs.DefaultComparator;

/**
 * Estructura general del problema. 
 * @author Laureano De Luca
 */
public class Structure 
{
	private PriorityQueue<Integer, String> colaDiamantes;
	private PriorityQueue<Integer, String> colaMineros;
	
	/**
	 * Constructor de la estructura. 
	 */
	public Structure()
	{
		colaDiamantes = new Heap<Integer, String>(new DefaultComparator<Integer>());
		colaMineros = new Heap<Integer, String>(new DefaultComparator<Integer>());
	}
	
	/**
	 * Retorna la cola de diamantes.
	 * @return Cola de diamantes.
	 */
	public PriorityQueue<Integer, String> getColaDiamantes()
	{
		return colaDiamantes;
	}
	
	/**
	 * Retorna la cola de mineros.
	 * @return Cola de mineros.
	 */
	public PriorityQueue<Integer, String> getColaMineros()
	{
		return colaMineros;
	}
	 
	/**
	 * Inserta un diamante en la colaDiamantes.
	 * @param dist Distancia del diamante al origen.
	 */
	public void addDiamante(int dist) 
	{
		 try
		 {
			 colaDiamantes.insert(dist, "Diamante" + colaDiamantes.size());
		 }
		 catch (InvalidKeyException ex) 
		 {
			 System.out.println(ex.getMessage());
		 }
	 }
	 
	 /**
	  * Inserta un minero en la colaMineros.
	  * @param dist Distancia del minero al origen
	  */
	 public void addMinero(int dist) 
	 {
		 try
		 {
			 colaMineros.insert(dist, "Minero" + colaMineros.size());
		 }
		 catch (InvalidKeyException ex) 
		 {
			 System.out.println(ex.getMessage());
		 }
	 }
 
	 /**
	  * Quita el minero con mayor prioridad de la cola.
	  * @return
	  */
	 public Entry<Integer, String> quitarMinero()
	 {
		 try 
		 {
			return colaMineros.removeMin();
		 } 
		 catch (EmptyPriorityQueueException e) 
		 {
			System.out.println(e.getMessage());
			return null;

		 }
	 }
	 
	 /**
	  * Quita el diamante con mayor prioridad de la cola.
	  * @return
	  */
	 public Entry<Integer, String> quitarDiamante()
	 {
		 try 
		 {
			return colaDiamantes.removeMin();
		 } 
		 catch (EmptyPriorityQueueException e) 
		 {
			System.out.println(e.getMessage());
			return null;

		 }
	 }
}
