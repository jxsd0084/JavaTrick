package bj.sxt.collection.map;

import java.util.*;

/**
 * 思考: 定义一个Student类,
 * 属性:name 姓名,no班号,score 成绩   现在将若干Student对象放入List,请统计出每个班级的总分和平均分
 * 方案: 面向对象+分拣存储(1:N)
 *
 * @author com.bj.com.bj
 */
public class MapDemo03 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {
		// 1、考试
		List< Student > stuList = exam();
		// 2、分析成绩
		Map< String, ClassRoom > map = count( stuList );
		// 3、查看成绩(总分 平均分)
		view( map );
	}

	/**
	 * 查看每个班的总分和平均分  -->遍历 map
	 */
	public static void view( Map< String, ClassRoom > map ) {
		Set< String > keys = map.keySet();
		// 获取迭代器对象
		Iterator< String > keysIt = keys.iterator();
		// 先判断
		while ( keysIt.hasNext() ) {
			// 再获取
			String    no   = keysIt.next();
			ClassRoom room = map.get( no );
			// 查看总分  计算平均分
			double total = room.getTotal();
			double avg   = total / room.getStuList().size();
			System.out.println( no + "-->" + total + "-->" + avg );
		}


	}

	/**
	 * 统计分析
	 * 1、面向对象
	 * 2、分拣存储
	 */
	public static Map< String, ClassRoom > count( List< Student > list ) {
		Map< String, ClassRoom > map = new HashMap< String, ClassRoom >();
		// 1、遍历List
		for ( Student stu : list ) {
			String no    = stu.getNo();    // 班级编号
			double score = stu.getScore(); // 学号
			// 2、分拣 查看是否存在 该 编号的班级
			// 如果不存在，创建班级
			ClassRoom room = map.get( no );
			if ( null == room ) {
				room = new ClassRoom( no );
				map.put( no, room );
			}
			// 存在，放入学生
			room.getStuList().add( stu );             // 放入学生
			room.setTotal( room.getTotal() + score ); // 计算总分
		}

		return map;
	}

	/**
	 * 模拟考试  测试数据 到List中
	 */
	public static List< Student > exam() {
		List< Student > list = new ArrayList< Student >();
		// 存放学生成绩
		list.add( new Student( "老裴", "a", 85 ) );
		list.add( new Student( "裴兜兜", "a", 86 ) );
		list.add( new Student( "裴裴", "a", 89 ) );
		list.add( new Student( "高小三", "b", 80 ) );
		list.add( new Student( "高高", "b", 80 ) );
		return list;
	}

}
