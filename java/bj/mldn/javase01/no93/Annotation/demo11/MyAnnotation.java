package bj.mldn.javase01.no93.Annotation.demo11;

import java.lang.annotation.*;

@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

	public String key() default "LXH";

	public String value() default "LXH";
}
 
