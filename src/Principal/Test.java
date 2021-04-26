package Principal;

import TDAs.Entry;

public class Test 
{
	public static void main(String args[])
	{
		Structure myStructure = new Structure();
		Logic myLogic = new Logic(myStructure);

		
		myStructure.addDiamante(1);
		myStructure.addDiamante(3);
		myStructure.addDiamante(4);
		myStructure.addDiamante(9);

		myStructure.addMinero(4);
		myStructure.addMinero(9);
		myStructure.addMinero(10);
		myStructure.addMinero(12);

		Entry<Entry<Integer, String>, Entry<Integer, String>> S[] = myLogic.minerosDeDiamanteGreedy();
		System.out.println(solucionToString(S) + "\nEsfuerzo total: " + myLogic.esfuerzoTotal(S));
	}
	
	private static String solucionToString(Entry<Entry<Integer, String>, Entry<Integer, String>> S[]) 
	{
		String toRet = "";
		for (int i = 0; i < S.length; i++)
		{
			toRet = toRet + "(" + S[i].getKey().getValue() + " ," + S[i].getValue().getValue() + "), ";
		}
		return toRet;
	}
}
