package bj.mldn.javase02.ch16.no02;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value = RetentionPolicy.RUNTIME)    // 表示此Annotation在运行时有效
public @interface MyDefaultRententionAnnotation {

	public String name() default "李兴华";
}
