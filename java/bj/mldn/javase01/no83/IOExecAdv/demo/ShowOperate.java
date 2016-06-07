package bj.mldn.javase01.no83.IOExecAdv.demo;

import java.util.Map;

public class ShowOperate {

	private Student   stu[]    = null;
	private InputData input    = null;
	private String    fileName = null;

	public ShowOperate() {

		this.input = new InputData();

		this.fileName = this.input.getString("请输入操作的文件名称：");
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

	public void list() {

		for (int i = 0; i < this.stu.length; i++) {
			System.out.println(this.stu[i].getStuno() + "："
			                   + this.stu[i].getName() + "【" + this.stu[i].getCount()
			                   + "票】");
		}
	}
}
