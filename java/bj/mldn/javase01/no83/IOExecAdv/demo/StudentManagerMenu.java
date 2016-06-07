package bj.mldn.javase01.no83.IOExecAdv.demo;

public class StudentManagerMenu {

	private boolean flag = true;

	public StudentManagerMenu() {

		while (flag) {
			this.show();
		}
	}

	public void show() {

		System.out.println("=========== 候选人管理 =============");
		System.out.println("   [1]、增加候选人 ");
		System.out.println("   [2]、修改候选人 ");
		System.out.println("   [3]、删除候选人 ");
		System.out.println("   [4]、查询候选人 ");
		System.out.println("   [5]、退出 ");
		InputData input = new InputData();
		int       ch    = input.getInt("请选择：", "输入的的内容错误，");
		switch (ch) {
			case 1: { // 增加候选人
				String         file = input.getString("请输入要操作的文件名称：");
				StudentOperate so   = new StudentOperate(file);
				so.add();
				break;
			}
			case 2: {
				String         file = input.getString("请输入要操作的文件名称：");
				StudentOperate so   = new StudentOperate(file);
				so.update();
				break;
			}
			case 3: {
				String         file = input.getString("请输入要操作的文件名称：");
				StudentOperate so   = new StudentOperate(file);
				so.delete();
				break;
			}
			case 4: {
				String         file = input.getString("请输入要操作的文件名称：");
				StudentOperate so   = new StudentOperate(file);
				so.show();
				break;
			}
			case 5: {
				this.flag = false;// 退出循环
			}
		}
	}
}
