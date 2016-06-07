package bj.mldn.javase01.no93.Annotation.demo09;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ClassAnnotationDemo02 {

	public static void main(String[] args) throws Exception {

		Class<?>   cls            = Class.forName("org.lxh.demo09.Info");
		Method     toStringMethod = cls.getMethod("toString");
		Annotation ans[]          = toStringMethod.getAnnotations();// 取得全部的Annotation
		for (int i = 0; i < ans.length; i++) {
			if (toStringMethod.isAnnotationPresent(MyAnnotation.class)) {
				MyAnnotation my = null; // 声明Annotation的对象
				my = toStringMethod.getAnnotation(MyAnnotation.class);
				String key   = my.key();
				String value = my.value();
				System.out.println(key + " --> " + value);
			}
		}
	}
}
