package bj.mldn.javase02.ch16.no02;

public @interface MyDefaultAnnotationValue {

	public String key() default "MLDN";    // 指定好了默认值

	public String value() default "李兴华";    // 指定好了默认值
}
