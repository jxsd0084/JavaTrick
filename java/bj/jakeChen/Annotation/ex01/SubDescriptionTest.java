package bj.jakeChen.Annotation.ex01;

/**
 * Created by chenlong on 2016/5/23.
 */
public class SubDescriptionTest extends DescriptionTest {

	/**
	 * 测试
	 */
	public static void main( String[] args ) {
		Class< DescriptionTest > clazz = DescriptionTest.class;
		if ( clazz.isAnnotationPresent( Description.class ) ) {
			Description desc = clazz.getAnnotation( Description.class );
			System.out.println( "desc.author:" + desc.author() );
			System.out.println( "desc.size:" + desc.size() );

		} else {
			System.out.println( "没有在SubDescriptionTest上使用注解!" );

		}

	}

}


/*

URL:    http://blog.sina.com.cn/s/blog_69a4df530100p8w3.html

我想说有三点：

（１）   java　annotation的基础语法
（２）   java　annotation的继承
（３）   关于对基于annotation框架的思考

第一点，    在源码里面，都说得十分简明了。更详尽的信息，请google一下。

第二点，    想的话就是“annotation与annotation之间没有继承关系”，只能用在类或接口里，由于在annotation类Description里面增加了@Inherited，因此，SubDescriptionTest直接拥有DescriptionTest其注解。

第三点，    在我古老的做法里，都用xml配置文件来让框架加载信息的，现在人们已经慢慢转向基于annotation方式来开发项目了，个人认为，利用java反射api，从注解处获得足够信息后，即可生成对象，与基于xml的配置效果是一样的。

*/
