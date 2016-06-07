package bj.mldn.javase01.no83.Collection.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo02 {

	public static void main(String[] args) {

		List<String> allList = new ArrayList<String>();
		allList.add("B、hello");
		allList.add("C、hello");
		allList.add("A、hello");
		Collections.addAll(allList, "E、hello", "D、hello");
		System.out.println(allList);
	}
}
