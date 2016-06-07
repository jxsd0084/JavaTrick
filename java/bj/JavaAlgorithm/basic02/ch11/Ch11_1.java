package bj.JavaAlgorithm.basic02.ch11;

import java.util.Scanner;

/*
  图解java数据结构
*/
public class Ch11_1 
{
	 /** 
     * 判断是否匹配 
     * @param target 目标文本串 
     * @param mode 模式串 
     * @return 匹配结果 
     */  
    public static boolean matchString(String target, String mode) 
    {  
        //为了和算法保持一致，使index从1开始，增加一前缀   
        String newTarget = "x" + target;   
        String newMode = 'x' + mode;  
          
        int[] K = calculateK(mode);//求模式串各字符的k值  
          
        int i = 1;  //目标串下标
        int j = 1; //模式串下标
 
        while(i <= target.length() && j <= mode.length()) //下标没有到达串结尾，循环处理
        {  
        	//如果模式串下标回溯到串首，或目标串与模式串当前比较字符相同，继续比较下一个字符
        	if (j == 0 || newTarget.charAt(i) == newMode.charAt(j)) 
            {  
                i++;  
                j++;  
            } 
            else //否则，模式串回溯到K[j]处继续比较
            {  
                j = K[j];  
            }  
        }  
          
        if (j > mode.length()) //全部比较一遍，说明匹配成功，打印匹配开始下标
        {  
        	System.out.println("下标："+(i-mode.length()));
        	return true;  
           
        }  
        return false;  
    }  
      
    /**
    *计算K值 
    *KMP算法的关键在于求算next[]数组的值，即求算模式串每个位置处的最长后缀与前缀相同的长度， 而求算next[]数组的值有两种思路，第一种思路是用递推的思想去求算，还有一种就是直接去求解。
  	*1.按照递推的思想：
   	*根据定义next[0]=-1，假设next[j]=k, 即P[0...k-1]==P[j-k,j-1]
   	*1)若P[j]==P[k]，则有P[0..k]==P[j-k+1,j]，很显然，next[j+1]=next[j]+1=k+1;
   	*2)若P[j]!=P[k]，则可以把其看做模式匹配的问题，即匹配失败的时候，k值如何移动，显然k=next[k]。
    */  
    private static int[] calculateK(String mode) 
    {  
        //为了和算法保持一致，使index从1开始，增加一前缀   
        String newMode = "x" + mode;  
        int[] K = new int[newMode.length()];  
        int i = 1;  
        K[1] = 0;  //第一个元素K值为0
        int j = 0;  
          
        while(i < mode.length()) //遍历串
        {  
          	if (j == 0 || newMode.charAt(i) == newMode.charAt(j)) //匹配的情况下,p[j]==p[k]
            {  
                i++;  
                j++;  
                K[i] = j;  
            } 
            else //p[j]!=p[k]
            {  
                j = K[j];  //回溯
            }  
        }  
          
        return K;  
	} 
	 
    /** 
     * @param args 
     */  
    public static void main(String[] args) 
    {
    	String s1,s2;
        boolean b;
    	Scanner input=new Scanner(System.in);
        
    	System.out.println("请输入目标串：");
    	s1=input.next();
    	System.out.println("请输入模式串：");
    	s2=input.next();
        
    	b=matchString(s1, s2);//调用字符串匹配方法

    	System.out.println("匹配成功？"+b); 
 
	} 
	 
}  
