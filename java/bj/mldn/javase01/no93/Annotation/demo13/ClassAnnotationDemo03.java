package bj.mldn.javase01.no93.Annotation.demo13;

import java.lang.annotation.Annotation;

public class ClassAnnotationDemo03 {

	public static void main(String[] args) throws Exception {

		Class<?>   cls   = Class.forName("org.lxh.demo13.PersonInfo");
		Annotation ans[] = cls.getAnnotations();    // 取得全部的Annotation
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}

}
