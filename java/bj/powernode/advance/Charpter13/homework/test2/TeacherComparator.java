package bj.powernode.advance.Charpter13.homework.test2;

import java.util.Comparator;

/**
 * 实现一个比较器类,在比较其中将两个对象进行比较.
 */
public class TeacherComparator implements Comparator< Teacher > {

	// 根据第一个参数小于、等于或大于第二个参数分别返回负整数、零或正整数
	@Override
	public int compare( Teacher o1, Teacher o2 ) {

		if ( o1.getAge() < o2.getAge() ) {

			return - 1;
		}

		if ( o1.getAge() > o2.getAge() ) {

			return 1;
		}

		if ( o1.getSalary() < o2.getSalary() ) {

			return - 1;
		}

		if ( o1.getSalary() > o2.getSalary() ) {

			return 1;
		}

		return 0;
	}

}
