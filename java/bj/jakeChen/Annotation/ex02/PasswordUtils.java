package bj.jakeChen.Annotation.ex02;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by chenlong on 2016/5/23.
 */
public class PasswordUtils {

	@UseCase(id = "47", description = "Password must contain at least one numeric")
	public boolean validatePassword( String password ) {

		return password.matches( "\\w*\\d\\w*" );
	}

	@UseCase(id = "48")
	public String entryptPassword( String password ) {

		return new StringBuilder( password ).reverse().toString();
	}

	/**
	 * 测试
	 */
	public static void main( String[] args ) {

		List< Integer > useCases = new ArrayList< Integer >();
		Collections.addAll( useCases, 47, 48, 49, 50 );
		trackUseCase( useCases, PasswordUtils.class );
	}

	public static void trackUseCase( List< Integer > useCases, Class< ? > c1 ) {

		for ( Method m : c1.getDeclaredMethods() ) {
			UseCase uc = m.getAnnotation( UseCase.class );
			if ( uc != null ) {
				System.out.println( "Found Use Case: " + uc.id() + " " + uc.description() );
				useCases.remove( new Integer( uc.id() ) );
			}
		}
		for ( int i : useCases ) {
			System.out.println( "Warning: Missing use case-" + i );
		}
	}

}

/*

URL:    http://www.cnblogs.com/pepcod/archive/2013/02/16/2913474.html


@Target
			表示该注解可以用于什么地方，可能的ElementType参数有：

			CONSTRUCTOR：构造器的声明

			FIELD：域声明（包括enum实例）

			LOCAL_VARIABLE：局部变量声明

			METHOD：方法声明

			PACKAGE：包声明

			PARAMETER：参数声明

			TYPE：类、接口（包括注解类型）或enum声明

@Retention

			表示需要在什么级别保存该注解信息。可选的RetentionPolicy参数包括：

			SOURCE：注解将被编译器丢弃

			CLASS：注解在class文件中可用，但会被VM丢弃

			RUNTIME：VM将在运行期间保留注解，因此可以通过反射机制读取注解的信息。

@Document

			将注解包含在Javadoc中

			@Inherited

			允许子类继承父类中的注解

*/
