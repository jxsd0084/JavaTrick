package bj.JavaAlgorithm.basic02.ch02;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/*
  图解java数据结构
*/
public class ch2_1 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.print("请输入起始年份：");
		int year=input.nextInt();
		System.out.print("请输入打算输出未来几年：");
		int n=input.nextInt();
		getBlackFri(year,n);

	}
	
	//打印未来几年的黑色星期五，判断每个月的13号是否是星期五
	public static void getBlackFri(int year,int n)
	{
		//year为输入的年份，n为未来多少年
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E");
//		int years = Integer.parseInt(year);
		int k=0;
//		Calendar cal = new GregorianCalendar();
		Calendar cal = Calendar.getInstance();
		while(k<n)
		{
			for (int i = 0; i < 12; i++) 
			{
				cal.set(year, i,13);
				if(5==(cal.get(Calendar.DAY_OF_WEEK)-1))
				{
					System.out.println("黑色星期五："+sdf.format(cal.getTime()));
				}
			}
			year++;
			k++;
		}
	}
}


