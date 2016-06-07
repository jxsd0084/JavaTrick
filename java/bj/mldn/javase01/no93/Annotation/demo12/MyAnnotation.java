package bj.mldn.javase01.no93.Annotation.demo12;

import java.lang.annotation.*;

@Documented
@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

	public String key() default "LXH";

	public String value() default "LXH";
}
 
