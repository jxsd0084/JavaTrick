package bj.JavaAlgorithm.basic02.ch04;

import java.util.ArrayList;
import java.util.List;

public class Ch4_1_2
{
	public static void main(String[] args) 
	{// 姹傜礌鏁�   
//		long time1=new Date().getTime();
		List<Integer> primes = getPrimes(100);
		System.out.println("100浠ュ唴绱犳暟濡備笅锛�");
		for (int i = 0; i < primes.size(); i++) 
		{   
            Integer prime = primes.get(i);   
//            System.out.printf("%8d", prime);   
            System.out.print(prime+" ");
            if (i % 10 == 9) 
            {   
                System.out.println();   
            }   
        } 
//		long time=new Date().getTime()-time1;
//		System.out.println("\n"+time+"姣");
    }   

    /**  
     * 姹� n 浠ュ唴鐨勬墍鏈夌礌鏁�  
     * @param n 鑼冨洿  
     * @return n 浠ュ唴鐨勬墍鏈夌礌鏁�  
     */  

    private static List<Integer> getPrimes(int n) 
    {   
        List<Integer> result = new ArrayList<Integer>();   
        result.add(2);   
        for (int i = 3; i <= n; i += 2) 
        {   
            if (!divisible(i, result)) 
            {   
                result.add(i);   
            }   
        }   
      return result;   
    }   
   /**  
     * 鍒ゆ柇 n 鏄惁鑳借鏁撮櫎  
     * @param n      瑕佸垽鏂殑鏁板瓧  
     * @param primes 鍖呭惈绱犳暟鐨勫垪琛�  
     * @return 濡傛灉 n 鑳借 primes 涓换浣曚竴涓暣闄わ紝鍒欒繑鍥� true銆�  
     */  

    private static boolean divisible(int n, List<Integer> primes) 
    {   
        for (Integer prime : primes) 
        {   
            if (n % prime == 0) 
            {   
                return true;  
            }  
            if(prime>=Math.sqrt(n))
            	break;
        }   
        return false;   
    }   
} 
