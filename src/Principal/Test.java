package Principal;

import TDAs.Entry;

public class Test 
{
	public static void main(String args[])
	{
		Structure myStructure = new Structure();
		Logic myLogic = new Logic(myStructure);

		int num =0;
		//myLogic.IngresoMyD(15);
		
		Entry<Entry<Integer, String>, Entry<Integer, String>> S[] = myLogic.minerosDeDiamanteGreedy();
		System.out.println(solucionToString(S) + "\nEsfuerzo total: " + myLogic.esfuerzoTotal(S));
	}
	
	private static String solucionToString(Entry<Entry<Integer, String>, Entry<Integer, String>> S[]) 
	{
		String toRet = "";
		for (int i = 0; i < S.length; i++)
		{
			toRet = toRet + "("+S[i].getKey().getValue()+":" + S[i].getKey().getKey() + " ,"+S[i].getValue().getValue()+":" + + S[i].getValue().getKey() + "), ";
		}
		return toRet;
	}
}
