package bj.mldn.javase02.ch16.no04;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value = RetentionPolicy.RUNTIME)    // 此Annotation在类执行时依然有效
public @interface MyDefaultAnnotationReflect {

	public String key() default "LXH";

	public String value() default "李兴华";

}
