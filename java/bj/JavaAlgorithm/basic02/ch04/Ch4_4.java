package bj.JavaAlgorithm.basic02.ch04;

public class Ch4_4
{
	public static void main(String[] args) 
	{
	  
        int count=1;
        
        for (int i = 2; i < 1000; i++) 
        {   
         	/*i是素数，i的反序数也是素数，那么就是可逆素数
             *isSuShu()判断是不是素数
            *fanXuShu()求反序数
            */
            if (isSuShu(i) && isSuShu(fanXuShu(i)))   
            	System.out.printf(count++%7!=0? "%3d  ":"%3d \n",i);
        }   
  
    }   
  /**  
     * 是素数  
     */  
    public static boolean isSuShu(int n) 
    {   
        boolean isSuShu = true;   
        if (n == 1 || n == 2)   
            return true;   
        for (int i = 2; i < Math.sqrt(n) + 1; i += 1) 
        {   
            if (n % i == 0) 
            {   
                return false;   
            }   
        }   
        if (isSuShu == true)   
            return true;   
        else  
            return false;   
    }   
    /**  
     * 反序数  
     */  
    public static int fanXuShu(int n) 
    {   
        //getBitCount(n)求数n的长度
    	int len = getBitCount(n);   
        int s = 0;   
        for (int i = 1; i < len + 1; i++) 
        {   
        	//getBit(n,i)求数n的第i位上的数字
            s += Math.pow(10, len - i) * getBit(n, i);   
        }   
        return s;   
    }   
    
   /**  
     * 获取一个数的位数  
     */  
    public static int getBitCount(int n) 
    {   
        int i = 1;   
        while (n / 10 > 0) 
        {   
            i++;   
            n /= 10;   
        }   
        return i;   
    }   
  
   
    /**  
     * 获取N位数第i位  
     */  
    public static int getBit(int num, int i) 
    {   
        if (i > getBitCount(num) || i < 1)   
            return -1;   
        return (num % ((int) Math.pow(10, i))) / (int) Math.pow(10, i - 1);   
    }   
}
