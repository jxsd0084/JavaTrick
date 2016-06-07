package bj.JavaAlgorithm.basic02.ch10;

import java.util.Scanner;

public class Ch10_3 
{
	static char op[]={'#','+','-','*','/'};
	
	/*计算x op y 表达式的值*/
	static float cal(float x,float y,int op)
	{
		float result=0;
		switch(op)
		{
			case 1:
				result=x+y;
				break;
			case 2:
				result=x-y;
				break;
			case 3: 
				result=x*y;
				break;
			case 4:
				result=x/y;
				break;
		}
		return result;
	}

	/*计算((a①b)②c)③d形式的表达式*/
	static float cal_expression1(float i,float j,float k,float t,int op1,int op2,int op3)
	{
		float r1,r2,r3;
		r1 = cal(i,j,op1);//调用计算表达式方法
		r2 = cal(r1,k,op2);
		r3 = cal(r2,t,op3);
		return r3;
	}

	/*计算(a①(b②c))③d形式的表达式*/
	static float cal_expression2(float i,float j,float k,float t,int op1,int op2,int op3)
	{
		float r1,r2,r3;
		r1 = cal(j,k,op2);
		r2 = cal(i,r1,op1);
		r3 = cal(r2,t,op3);
		return r3;
	}
	
	/*计算a①(b②(c③d))形式的表达式*/
	static float cal_expression3(float i,float j,float k,float t,int op1,int op2,int op3)
	{
		float r1,r2,r3 ;
		r1 = cal(k,t,op3);
		r2 = cal(j,r1,op2);
		r3 = cal(i,r2,op1);
		return r3;
	}

	/*计算a①((b②c)③d) 形式的表达式*/
	static float cal_expression4(float i,float j,float k,float t,int op1,int op2,int op3)
	{
		float r1,r2,r3;
		r1 = cal(j,k,op2);
		r2 = cal(r1,t,op3);
		r3 = cal(i,r2,op1);
		return r3;
	}

	/*计算(a①b)②(c③d) 形式的表达式*/
	static float cal_expression5(float i,float j,float k,float t,int op1,int op2,int op3)
	{
		float r1,r2,r3 ;
		r1 = cal(i,j,op1);
		r2 = cal(k,t,op3);
		r3 = cal(r1,r2,op2);
		return r3;
	}

	/*求24点，参数为接收的4个数字*/
	static int get24(int i,int j,int k,int t)
	{
		int op1,op2,op3;
	    int flag=0;//是否得到24标识，0，未得到
	    
	    /*穷举出64个未加括号的表达式*/
	    for(op1=1;op1<=4;op1++)
	        for(op2=1;op2<=4;op2++)
	            for(op3=1;op3<=4;op3++)
	            {
	            	//调用表达式1计算方法
	            	if(cal_expression1(i,j,k,t,op1,op2,op3)==24)
	               {
	            	   System.out.printf("((%d%c%d)%c%d)%c%d=24\n",i,op[op1],j,op[op2],k,op[op3],t);
	            	   flag = 1;
	               }
	            	//调用表达式2计算方法
	               if(cal_expression2(i,j,k,t,op1,op2,op3)==24)
	               {
	            	   System.out.printf("(%d%c(%d%c%d))%c%d=24\n",i,op[op1],j,op[op2],k,op[op3],t);
	            	   flag = 1;
	               }
	               //调用表达式3计算方法
	               if(cal_expression3(i,j,k,t,op1,op2,op3)==24)
	               {
	            	   System.out.printf("%d%c(%d%c(%d%c%d))=24\n",i,op[op1],j,op[op2],k,op[op3],t);
	            	   flag = 1;
	               }
	               //调用表达式4计算方法
	               if(cal_expression4(i,j,k,t,op1,op2,op3)==24)
	               {
	            	   System.out.printf("%d%c((%d%c%d)%c%d)=24\n",i,op[op1],j,op[op2],k,op[op3],t);
	            	   flag = 1;
	               }
	               //调用表达式5计算方法
	               if(cal_expression5(i,j,k,t,op1,op2,op3)==24)
	               {
	            	   System.out.printf("(%d%c%d)%c(%d%c%d)=24\n",i,op[op1],j,op[op2],k,op[op3],t);
	            	   flag = 1;
	               }
	            }
	    return flag;
	}

	public static void main(String[] args)
	{
		int i,j,k,t;
		Scanner in=new Scanner(System.in);
		System.out.printf("请输入4个数(1~13)：");
		do
		{
			i=in.nextInt();
			j=in.nextInt();
			k=in.nextInt();
			t=in.nextInt();
			if(i<1||i>13 || j<1||j>13 || k<1||k>13 || t<1||t>13)
				System.out.printf("输入错误，请重新输入：");
			
		}while(i<1||i>13 || j<1||j>13 || k<1||k>13 || t<1||t>13);
		//调用求24点方法
		if(get24(i,j,k,t)==1)
			;
		else 
			System.out.printf("对不起，这4个数运算得不到24\n");
	}
}
	


