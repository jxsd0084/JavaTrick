package bj.jakeChen.Annotation.ex01;

import java.lang.annotation.*;

/**
 * Created by chenlong on 2016/5/23.
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Description {

	String author() default "william";  // 定义"作者"参数

	int size();                         // 定义"大小"参数
}
