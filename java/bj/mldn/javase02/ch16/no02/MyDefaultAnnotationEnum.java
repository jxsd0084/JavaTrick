package bj.mldn.javase02.ch16.no02;

public @interface MyDefaultAnnotationEnum {

	public MyName name() default MyName.LXH;    // 指定默认值
}
