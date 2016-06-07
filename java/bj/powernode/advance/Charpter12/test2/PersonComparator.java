package bj.powernode.advance.Charpter12.test2;

import java.util.Comparator;


// 实现一个比较器类,在比较器中将两个对象进行比较
public class PersonComparator implements Comparator< Person > {

	@Override
	// 根据第一个参数小于、等于或大于第二个参数分别返回负整数、零或正整数
	public int compare( Person o1, Person o2 ) {

		if ( o1.getAge() < o2.getAge() ) {

			return - 1;
		}

		if ( o1.getAge() > o2.getAge() ) {

			return 1;
		}

		if ( o1.getName().compareTo( o2.getName() ) > 0 ) {

			return 1;
		}

		if ( o1.getName().compareTo( o2.getName() ) < 0 ) {

			return - 1;
		}

		return 0;
	}

}
