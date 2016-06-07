package bj.mldn.javase01.no93.Annotation.demo09;

import java.lang.annotation.*;

@Retention(value = RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

	public String key() default "LXH";

	public String value();
}
 
