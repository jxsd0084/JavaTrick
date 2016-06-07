package bj.mldn.javase01.no83.IOExecAdv.demo;

import java.util.HashMap;
import java.util.Map;

public class StudentOperate {

	// 如果要在已有的基础上增加，则肯定要先从文件中搜索
	private String filePath = null;

	public StudentOperate(String filePath) {

		this.filePath = filePath;
	}

	public void add() { // 增加候选人
		Map<Integer, Student> map  = null;
		FileOperate           file = new FileOperate(this.filePath);
		try {
			map = (Map<Integer, Student>) file.load();
		} catch (Exception e) {
		}
		if (map == null) {
			map = new HashMap<Integer, Student>();
		}
		InputData input = new InputData();
		int       stuno = input.getInt("请输入候选人的编号：", "编号输入错误，");
		String    name  = input.getString("请输入候选人的姓名：");
		Student   stu   = new Student(stuno, name, 0);
		map.put(stuno, stu); // 增加数据
		try {
			file.save(map); // 更新
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update() { // 修改候选人
		InputData             input = new InputData();
		int                   stuno = input.getInt("请输入要更新的编号：", "输入的必须是整数，");
		Map<Integer, Student> map   = null;
		FileOperate           file  = new FileOperate(this.filePath);
		try {
			map = (Map<Integer, Student>) file.load();
		} catch (Exception e) {
		}
		if (map == null) {
			map = new HashMap<Integer, Student>();
		}
		Student stu  = map.get(stuno); // 取出内容v
		String  name = input.getString("请输入候选人的姓名：");
		Student stu1 = new Student(stuno, name, stu.getCount());
		map.put(stuno, stu1);
		try {
			file.save(map); // 更新
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete() {// 删除候选人
		InputData             input = new InputData();
		int                   stuno = input.getInt("请输入要删除的编号：", "输入的必须是整数，");
		Map<Integer, Student> map   = null;
		FileOperate           file  = new FileOperate(this.filePath);
		try {
			map = (Map<Integer, Student>) file.load();
		} catch (Exception e) {
		}
		if (map == null) {
			map = new HashMap<Integer, Student>();
		}
		map.remove(stuno);// 删除
		try {
			file.save(map); // 更新
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void show() {// 显示全部候选人
		Map<Integer, Student> map  = null;
		FileOperate           file = new FileOperate(this.filePath);
		try {
			map = (Map<Integer, Student>) file.load();
		} catch (Exception e) {
		}
		if (map != null && map.size() > 0) {// 有内容则显示全部的内容
			Operate o = new Operate();
			o.setStudent(map.values().toArray(new Student[]{}));
			o.list();
		} else {
			System.out.println("没有任何的候选人信息！");
		}
	}

	public void search() { // 查询

	}
}
