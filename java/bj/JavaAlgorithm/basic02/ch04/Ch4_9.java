package bj.JavaAlgorithm.basic02.ch04;

import java.util.ArrayList;

public class Ch4_9 
{
	public static void main(String[] args) 
	{
		//得到100以内的素数，放到数组列表中
		ArrayList pn=getPrimes(100);
		
		//求等差素数数列，每个等差素数数列保存到数组列表中一项，数组列表中每一项又是数组列表
		ArrayList alArNumRngs=getArithmeticalNumRanges(pn);
		
		ArrayList alArNumRng = new ArrayList();
        int intTolerace = 0;

        //循环输出等差素数数列
        for (int i = 0; i < alArNumRngs.size(); i++) 
        {
            alArNumRng = (ArrayList) alArNumRngs.get(i);
            for (int j = 0; j < alArNumRng.size(); j++) 
            {
                System.out.print(alArNumRng.get(j) + " ");
            }
            intTolerace = ((Integer) alArNumRng.get(alArNumRng.size()-1))
                    .intValue()
                    - ((Integer) alArNumRng.get(alArNumRng.size()-2))
                            .intValue();
            System.out.print("公差是 ：" + String.valueOf(intTolerace));

            System.out.println();
        }

	}
	
	//得到num以内的素数，保存在数组列表中
	public static  ArrayList getPrimes(int num) 
	{
        ArrayList allPrimeNum = new ArrayList();
        for (int i = 1; i <= num; i++) 
        {
            if (isPrimeNum(i)) 
            {
                allPrimeNum.add(new Integer(i));
            }
        }
        return allPrimeNum;
    }

    public static  boolean isPrimeNum(int num) 
    {
        if (num == 1) 
        {
            return false;
        }
        for (int i = 2; i <= ((int) Math.sqrt(num)); i++) 
        {
            if (num % i == 0) 
            {
                return false;
            }
        }
        return true;
    }

  //求等差素数数列，每个等差素数数列保存到数组列表中一项，数组列表中每一项又是数组列表
    public static ArrayList getArithmeticalNumRanges(ArrayList alNums) 
    {
        Integer thirdNum = new Integer(0);
        int tolerance = 0;
        int diff = 0;
        
        //alAriNumRng用来保存找到的等差素数数列
        ArrayList alAriNumRng = null;

        //alAriNumRngs用来保存alAriNumRng
        ArrayList alAriNumRngs = new ArrayList();
       
        for (int i = 0; i < alNums.size(); i++) 
        {
            for (int j = i + 1; j < alNums.size(); j++) 
            {
                //根据后一个数，计算出公差
            	tolerance = ((Integer) alNums.get(j)).intValue()
                        - ((Integer) alNums.get(i)).intValue();
      
            	//根据公差，计算下一个数，即第3个数
                thirdNum = new Integer(((Integer) alNums.get(j)).intValue()
                        + tolerance);
                //判断第3个数是不是在素数列表里，如果找到，就把这3个数存入alAriNumRng数组列表
                if (alNums.contains(thirdNum)) 
                {
                    alAriNumRng = new ArrayList();
                    //等差数列至少3项
                    alAriNumRng.add(alNums.get(i));
                    alAriNumRng.add(alNums.get(j));
                    alAriNumRng.add(thirdNum);

                    
                    int intEndNum = thirdNum.intValue();
                   
                    /*
                     * 继续判断后面的项能不能与前面的3项构成更长的等差数列
                     * 从第3个数的下一个数开始，依次计算与alAriNumRng数组列表尾部的数的差，如果差等于公差，就加入alAriNumRng数组列表
                     */
                   for (int k = alNums.indexOf(thirdNum) + 1; k < alNums
                            .size(); k++) 
                    {
                        diff = ((Integer) alNums.get(k)).intValue()
                                - intEndNum;
                        if (diff == tolerance) 
                        {
                            alAriNumRng.add(alNums.get(k));
                            intEndNum = ((Integer) alNums.get(k)).intValue();
                        }
                    }
                    //把alAriNumRng数组列表加入alAriNumRngs数组列表中
                    alAriNumRngs.add(alAriNumRng);
                }
            }
        }
        return alAriNumRngs;
    }

}
