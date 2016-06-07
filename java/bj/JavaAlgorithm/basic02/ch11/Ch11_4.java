package bj.JavaAlgorithm.basic02.ch11;

import java.util.Scanner;


public class Ch11_4 
{
	public static void main(String[] args)
	{
        
		Scanner input=new Scanner(System.in);
		System.out.print("请输入第一个加数：");
		String addA=input.next();
		System.out.print("请输入第二个加数：");
		String addB=input.next();
//		String addA="30812111123";
//        String addB="298";
        //调用方法计算结果，输出
        System.out.println(addA+"+"+addB+"="+strvalue(addA,addB));
    }
    
    public static String strvalue(String addA,String addB)
    {
        String strvalue="";
        int lenA=addA.length();
        int lenB=addB.length();
 
        int templen=0;
        //调整长度相同
        if(lenA>=lenB)
        {
            templen=lenA-lenB;
            addB=maxlen(addB,templen);//调整长度，使其跟大数长度一致
        }else{
            templen=lenB-lenA;
            addA=maxlen(addA,templen);
        }
        char addcharA[]=addA.toCharArray();
        char addcharB[]=addB.toCharArray();
 
        int len=addcharA.length;
        int valueC[]=new int[len];
        for(int i=0;i<len;i++)
        {
            //取出字符串中的数转换为数字
        	int a=Integer.parseInt(String.valueOf(addcharA[i]));
            int b=Integer.parseInt(String.valueOf(addcharB[i]));
            valueC[i]=a+b;//每项相加存储
        }
        int tmp=0;//代表进位
        //处理进位
        for(int i=valueC.length-1;i>=0;i--)
        {
            if(valueC[i]>=10)
            {
                strvalue=String.valueOf(valueC[i]+tmp-10)+strvalue;
                tmp=valueC[i]/10;
            }else{
                strvalue=String.valueOf(valueC[i]+tmp)+strvalue;
                tmp=0;
            }
        }
        return strvalue;
    }
    
    //调整长度，使其长度一样
    private static String maxlen(String str,int templen)
    {
        String strmax=null;
        StringBuffer buff=new StringBuffer();
        for(int i=0;i<templen;i++)
        {
            buff.append("0");
        }
        strmax=buff.toString()+str;
        return strmax;
    }
} 
