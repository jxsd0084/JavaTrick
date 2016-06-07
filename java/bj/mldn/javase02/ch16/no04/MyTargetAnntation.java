package bj.mldn.javase02.ch16.no04;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE, ElementType.METHOD })        // 此注释只能用在类上
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MyTargetAnntation {

	public String key() default "LXH";

	public String value() default "李兴华";
}
