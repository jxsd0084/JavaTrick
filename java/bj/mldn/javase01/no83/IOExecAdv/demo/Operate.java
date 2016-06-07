package bj.mldn.javase01.no83.IOExecAdv.demo;

import java.util.Map;

public class Operate {

	private Student   stu[]    = null;
	private InputData input    = null;
	private String    fileName = null;

	public Operate(String fileName) {

		this.input = new InputData();
		this.fileName = fileName;
		FileOperate           file = new FileOperate(this.fileName);
		Map<Integer, Student> map  = null;
		try {
			map = (Map<Integer, Student>) file.load();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.stu = map.values().toArray(new Student[]{});
	}

	public Operate() {

	}

	public Operate(Student stu[]) {

		this.stu = stu;// 对象数组的内容由外部决定
		this.input = new InputData();
	}

	public void setStudent(Student stu[]) {

		this.stu = stu;
	}

	public Student[] getStudent() {

		return this.stu;
	}

	public void list() {

		for (int i = 0; i < this.stu.length; i++) {
			System.out.println(this.stu[i].getStuno() + "："
			                   + this.stu[i].getName() + "【" + this.stu[i].getCount()
			                   + "票】");
		}
	}

	public boolean vote() {// 完成具体的投票功能
		boolean flag = true;
		int stuno = this.input.getInt("请输入班长候选人代号（数字0结束）：",
		                              "此选票无效，请输入正确的候选人代号！");
		boolean temp = false;
		temp = false;
		if (stuno == 0) { // 程序退出
			flag = false;
		}
		for (int x = 0; x < this.stu.length; x++) {
			if (stuno == this.stu[x].getStuno()) {
				this.stu[x].setCount(this.stu[x].getCount() + 1);
				temp = true;
			}
		}
		if (temp == false) { // 无此选票
			System.out.println("此选票无效，请输入正确的候选人代号！");
		}
		return flag;
	}

	public void result() {

		java.util.Arrays.sort(this.stu);// 排序
		System.out.println("投票最终结果：" + this.stu[0].getName() + "同学，最后以"
		                   + this.stu[0].getCount() + "票当选班长！");
	}
}
