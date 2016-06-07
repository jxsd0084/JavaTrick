package bj.JavaAlgorithm.basic02.ch11;

import java.util.Scanner;

public class Ch11_8 
{
	//建立对照表
	static String a[][]={{"","I","II","III","IV","V","VI","VII","VIII","IX"},
        {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
        {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"}};
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		System.out.print("请输入一个阿拉伯数字：");
		int n=in.nextInt();
		int t=0;
		System.out.printf("%d=",n);
		
		int i=1000;
		int fz;//分子
		int fm;//分母
		int row;
		int col;
		for(int m=0;m<3;m++)
		{
			fz=n%i;
			fm=i/10;
			t=fz/fm;//从高位向低位依次取出各位数字
			
			row=2-m;
			col=t;
			System.out.printf("%s",a[row][col]);//对照表翻译输出
			i=i/10;
		}
		System.out.printf("\n");
	}
}
