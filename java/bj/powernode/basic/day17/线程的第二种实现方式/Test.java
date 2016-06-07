package bj.powernode.basic.day17.线程的第二种实现方式;

public class Test{
	
	// 主线程
	public static void main(String[] args){
	
		Thread t1 = new Thread(new Runnable(){
			
			public void run(){
				for(int i=0;i<100;i++){
					System.out.println(i);
				}
			}
		});
		
		t1.start();  // 启动线程
		
		
		// 不推荐使用匿名内部类,因为代码无法得到重用.
		/*
			Thread t2 = new Thread(new Runnable(){
				public void run(){
					for(int i=0;i<100;i++){
						System.out.println(i);
					}
				}
			});

			t2.start();
		*/
		
		
		
		for(int i=0;i<100;i++){

			System.out.println("*********");
		}

	}

}
