package bj.JavaAlgorithm.basic02.ch02;

public class ch2_6
{ 
	/**  
     * 判断是否全相等,全相等返回true  
     */  
    public static boolean isSame(int[] a) { 
    	int n=0;
    	boolean b=false;
    	for(int i=0;i<a.length-1;i++) 
			{ 
				if(a[i]==a[i+1]) 
				{  
					n++; 
				} 
 	  
				if(n==a.length-1)  
					b=true; 
				} 
       return b;
    }   
    
    
    /**  
     * 显示数组的值  
     */  
    public static void show(int[] a) {   
        if (a == null)   
            System.out.println("Array = null");   
        for (int i = 0; i < a.length; i++) {   
            System.out.print(a[i] + " ");   
        }   
        System.out.println();   
    }   
	
	
	public static void main(String args[])
	{ 
		int tang[]={10,2,8,22,16,4,10,6,14,20};	
		int times=0; 
		boolean b=true; 

		while(isSame(tang)==false)
		{ 
//			int m=tang[0];//保存第一个小孩的糖果 并分糖果 
//			for(int i=0;i<9;i++) 
//			{ 
//				tang[i]=tang[i]/2+tang[i+1]/2; 
//				tang[9]=tang[9]/2+m/2; 
//				
//			} 
			
			int m=tang[9];
			for(int i=9;i>0;i--)
			{
				tang[i]=tang[i]/2+tang[i-1]/2;
			}
			tang[0]=tang[0]/2+m/2;
			//记录分糖果次数  
			times++; 
			 System.out.print("第" + times+ "次分之后结果： ");   
	         show(tang); 
			
			
			//糖果为奇数的向老师要糖果 
			for(int i=0;i<10;i++) 
				if(tang[i]%2!=0) 
					tang[i]+=1; 


		}	
 	
		System.out.println("分糖果次数："+times); 
		System.out.println("每个人最终的糖果个数："+tang[0]); 
	} 
}
