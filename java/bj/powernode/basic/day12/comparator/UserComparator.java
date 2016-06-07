package bj.powernode.basic.day12.comparator;

import java.util.Comparator;

/*

	写一个用户比较器.专门用来比较两个用户的大小.

	规则:按照用户的年龄排序.
*/
public class UserComparator implements Comparator {

	// 重写.实现,复写.
	public int compare( Object o1, Object o2 ) {

		User u1 = (User) o1;
		User u2 = (User) o2;

		if ( u1.getAge() == u2.getAge() ) {

			return 0;
		}

		if ( u1.getAge() > u2.getAge() ) {

			return 1;
		}

		return -1;
	}

}
