package bj.mldn.javase01.no69.persondemo;

public class Menu { // 显示菜单

	public Menu() {

		while ( true ) {
			this.show();
		}
	}

	public void show() {

		System.out.println( "====== Xxx 系统 ========" );
		System.out.println( "    [1]、增加数据   " );
		System.out.println( "    [2]、查看数据   " );
		System.out.println( "    [3]、修改数据   " );
		System.out.println( "    [4]、删除数据   " );
		System.out.println( "    [0]、退出系统   " );
		InputData input  = new InputData();
		int       choose = input.getInt( "\n\n请选择：", "输入错误，重新输入，" );
		switch ( choose ) {
			case 1: {
				Operate.add();
				break;
			}
			case 2: {
				Operate.find();
				break;
			}
			case 3: {
				Operate.update();
				break;
			}
			case 4: {
				Operate.delete();
				break;
			}
			case 0: {
				System.exit( 1 );
			}
			default: {
				System.out.println( "无效的选项" );
			}
		}
	}
}
