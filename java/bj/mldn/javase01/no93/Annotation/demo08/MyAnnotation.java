package bj.mldn.javase01.no93.Annotation.demo08;

public @interface MyAnnotation {

	public String key() default "LXH";

	public String value() default "HAHA";

	public Color color() default Color.RED;

	public String[] url();
}
