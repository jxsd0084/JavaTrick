package bj.JavaAlgorithm.basic02.ch03;

public class Ch3_7
{
	public static void main(String[] args) 
	{
		for(int i = 1; i < 10000; i++)
		{
//			String strI = String.valueOf(i);
//			String multiStr = String.valueOf(i*i);
//			String last = multiStr.substring(multiStr.length() - strI.length());
//			if(last.equals(strI))
//			{
//				System.out.println(i + "*" + i + "=" + multiStr + "--> " + i + " 是自守数");
//			}
			ziShouShu(i);
		}
	}
	
	public static void ziShouShu(int n)
	{
		String strI = String.valueOf(n);
		String multiStr = String.valueOf(n*n);
		String last = multiStr.substring(multiStr.length() - strI.length());
		if(last.equals(strI))
		{
			System.out.println(n + "*" + n + "=" + multiStr + "--> " + n + " 是自守数");
		}
	}
}
