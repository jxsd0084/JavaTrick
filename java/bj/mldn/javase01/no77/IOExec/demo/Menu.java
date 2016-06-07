package bj.mldn.javase01.no77.IOExec.demo;

// 循环选择\修改选票\显示全部的信息
public class Menu {

	private Student stu[] = {
			new Student( 1, "张三", 0 ), new Student( 2, "李四", 1 ),
			new Student( 3, "王五", 0 ), new Student( 4, "刘六", 0 )
	};

	public Menu() {

		Operate oper = new Operate( stu );
		// 1、显示出全部的数据
		oper.list();
		// 2、调用投票
		while ( oper.vote() ) {
			;
		}
		// 3、列出全部的票数
		oper.list();
		// 4、求出结果
		oper.result();
	}
}
