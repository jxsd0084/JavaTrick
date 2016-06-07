package bj.sxt.generic.gen03;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 泛型嵌套 -->由外到内拆分
 *
 * @author com.bj.com.bj
 */
public class StudentApp {

	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {

		Student<String> stu = new Student<String>();
		stu.setScore("优秀");
		System.out.println(stu.getScore());

		// 泛型嵌套
		Bjsxt<Student<String>> bjsxt = new Bjsxt<Student<String>>();
		bjsxt.setStu(stu);

		stu = bjsxt.getStu();
		String score = stu.getScore();
		System.out.println(score);


		// HashMap --> 使用泛型嵌套
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "java300");
		map.put("b", "马士兵javase");

		Set<Entry<String, String>> entrySet = map.entrySet();
		for (Entry<String, String> entry : entrySet) {
			String key   = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + "-->" + value);
		}

	}

}
