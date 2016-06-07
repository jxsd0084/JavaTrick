package bj.powernode.basic.day13.innerClass.test4;

import java.util.Comparator;

public class PersonComparator implements Comparator< Person > {

	@Override
	public int compare( Person o1, Person o2 ) {

		if ( o1.getAge() == o2.getAge() ) {
			return 0;

		} else if ( o1.getAge() > o2.getAge() ) {
			return 1;

		} else {
			return -1;

		}

	}

}
