package bj.mldn.javase02.ch16.no04;

import java.lang.annotation.Documented;

@Documented
public @interface MyDocumentedAnntation {

	public String key() default "LXH";

	public String value() default "李兴华";
}
