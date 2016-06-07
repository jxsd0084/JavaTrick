package bj.mldn.javase01.no83.IOExecAdv.demo;

public class MainMenu {

	public MainMenu() {

		while (true) {
			this.show();
		}
	}

	public void show() {

		System.out.println("========= XXX 投票系统  =============");
		System.out.println("      1、	候选人管理		");
		System.out.println("      2、	投票		        ");
		System.out.println("      3、	查看历史结果		");
		System.out.println("      4、	程序退出		");
		InputData input = new InputData();
		int       ch    = input.getInt("请选择：", "请输入正确的选项，");
		switch (ch) {
			case 1: {
				new StudentManagerMenu();// 调用候选人管理
				break;
			}
			case 2: {
				new VoteMenu();
				break;
			}
			case 3: {
				new ShowOperate().list();
				break;
			}
			case 4: {
				System.exit(1);
				break;
			}
		}
	}
}
