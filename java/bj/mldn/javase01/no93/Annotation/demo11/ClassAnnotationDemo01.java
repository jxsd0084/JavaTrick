package bj.mldn.javase01.no93.Annotation.demo11;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ClassAnnotationDemo01 {

	public static void main(String[] args) throws Exception {

		Class<?>   cls            = Class.forName("org.lxh.demo09.Info");
		Method     toStringMethod = cls.getMethod("toString");
		Annotation ans[]          = toStringMethod.getAnnotations();    // 取得全部的Annotation
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}

}
