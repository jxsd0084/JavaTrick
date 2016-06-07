package bj.mldn.javase01.no83.IOExecAdv.demo;

import java.util.HashMap;
import java.util.Map;

// 循环选择\修改选票\显示全部的信息
public class VoteMenu {

	private String fileName;

	public VoteMenu() {

		Student   stu[] = null;
		InputData input = new InputData();
		this.fileName = input.getString("请输入操作的文件名称：");
		Operate oper = new Operate(fileName);
		// 1、显示出全部的数据
		oper.list();
		// 2、调用投票
		while (oper.vote()) {
			;
		}
		// 3、列出全部的票数
		oper.list();
		// 4、求出结果
		oper.result();
		this.save(oper.getStudent());
	}

	public void save(Student stu[]) {// 把所有的投票结果保存
		Map<Integer, Student> map = new HashMap<Integer, Student>();
		for (int x = 0; x < stu.length; x++) {
			map.put(stu[x].getStuno(), stu[x]);
		}
		// 把内容重新保存
		FileOperate file = new FileOperate(fileName);
		try {
			file.save(map); // 保存数据
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
