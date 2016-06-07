package bj.mldn.javase01.no55.comparesdemo;

import java.util.Comparator;

public class StudentComparator implements Comparator< Student > {

	public int compare( Student stu1, Student stu2 ) {

		if ( stu1.getScore() > stu2.getScore() ) {
			return - 1;

		} else if ( stu1.getScore() < stu2.getScore() ) {
			return 1;

		} else {
			if ( stu1.getAge() > stu2.getAge() ) {
				return 1;

			} else if ( stu1.getAge() < stu2.getAge() ) {
				return - 1;

			} else {
				return 0;
			}
		}
	}

	public boolean equals( Object obj ) {

		return this.equals( obj );
	}

}
