package bj.jakeChen.Guava;

import com.google.common.io.Files;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static com.google.common.base.Predicates.equalTo;
import static com.google.common.base.Predicates.or;
import static com.google.common.collect.Iterables.filter;

/**
 * Created by chenlong on 2016/4/25.
 */
public class BasicGuava {

	public static void main( String[] args ) {


	}

	class Man {

		private String firstName;
		private String lastName;

		public Man( String firstName,
		            String lastName ) {

			this.firstName = firstName;
			this.lastName = lastName;
		}

		public String getFirstName() {

			return firstName;
		}

		public void setFirstName( String firstName ) {

			this.firstName = firstName;
		}

		public String getLastName() {

			return lastName;
		}

		public void setLastName( String lastName ) {

			this.lastName = lastName;
		}
	}

	public void testMan() {

		// 对计划排序，并生成排序后的集合拷贝视图
		Man                  man1 = new Man( "Alexis", "Drazen" );
		Man                  man2 = new Man( "Bob", "Lee" );
		Man                  man3 = new Man( "Vince", "Carter" );
		ImmutableList< Man > men  = ImmutableList.of( man1, man2, man3 );

		Comparator< Man > byLastName = new Comparator< Man >() {
			public int compare( final Man p1,
			                    final Man p2 ) {
				return p1.getLastName().compareTo( p2.getLastName() );
			}
		};

		Comparator< Man > byFirstName = new Comparator< Man >() {
			public int compare( final Man p1,
			                    final Man p2 ) {
				return p1.getFirstName().compareTo( p2.getFirstName() );
			}
		};

		// 先按 lastName 再按 firstName 排序，最后倒序
		List< Man > sortedCopy = Ordering.from( byLastName ).compound( byFirstName ).reverse().sortedCopy( men );
		System.out.println( sortedCopy );
	}

	public void testNormalCollection() {

		// 普通Collection的创建
		List< String >        list = Lists.newArrayList();
		Set< String >         set  = Sets.newHashSet();
		Map< String, String > map  = Maps.newHashMap();
	}

	public void testImmutableCollection() {

		// 不变Collection的创建
		ImmutableList< String >        iList = ImmutableList.of( "a", "b", "c" );
		ImmutableSet< String >         iSet  = ImmutableSet.of( "e1", "e2" );
		ImmutableMap< String, String > iMap  = ImmutableMap.of( "k1", "v1", "k2", "v2" );

	}

	public void testReadFile() {

		// 文件读取演示
		File           file    = new File( "D:\\git_Prj\\JavaTrick\\src\\main\\java\\bj\\jakeChen\\Guava\\Data\\test.txt" );
		List< String > content = null;
		try {
			content = Files.readLines( file, Charsets.UTF_8 );
		} catch ( IOException ex ) {
			ex.printStackTrace();
		}
		for ( String line : content ) {
			System.out.println( line );
		}
	}

	public void testBasicType() {

		// 基本类型操作
		int[]   arr       = { 1, 2, 3 };
		int[]   arr2      = { 1, 2, 3 };
		int     intCmp    = Ints.compare( 1, 2 );
		int     doubleCmp = Doubles.compare( 1.1, 1.2 );
		int     index     = Ints.indexOf( arr, 1 );
		boolean contains  = Ints.contains( arr, 1 );
		int     max       = Ints.max( arr );
		int     min       = Ints.min( arr );
		int[]   arr3      = Ints.concat( arr, arr2 );
	}

	public void testCharMatcher() {

		// 便利字符匹配类 CharMatcher

		// 判断匹配结果
		boolean result = CharMatcher.inRange( 'a', 'z' ).or( CharMatcher.inRange( 'A', 'Z' ) ).matches( 'K' );

		// 保留数字文本
		String s1 = CharMatcher.DIGIT.retainFrom( "abc 123 efg" );

		// 删除数字文本
		String s2 = CharMatcher.DIGIT.removeFrom( "abc 123 efg" );
		// 更多方法参见 http://docs.guava-libraries.googlecode.com/git/javadoc/com/google/common/base/CharMatcher.html
	}

	public void testMap() {

		// Map 的更多操作
		Map< String, String >           mapA          = ImmutableMap.of( "k1", "v1", "k2", "v2", "k3", "v3" );
		Map< String, String >           mapB          = ImmutableMap.of( "k2", "v2", "k3", "v3", "k4", "v4" );
		MapDifference< String, String > differenceMap = Maps.difference( mapA, mapB );
		differenceMap.areEqual();
		Map entriesDiffering   = differenceMap.entriesDiffering();
		Map entriesOnlyOnLeft  = differenceMap.entriesOnlyOnLeft();
		Map entriesOnlyOnRight = differenceMap.entriesOnlyOnRight();
		Map entriesInCommon    = differenceMap.entriesInCommon();
		System.out.println( entriesDiffering );
		System.out.println( entriesOnlyOnLeft );
		System.out.println( entriesOnlyOnRight );
		System.out.println( entriesInCommon );
	}

	// Joiner 与 Splitter
	public void testJoiner() {
		// 使用 "/" 串联字符串
		String[] subdirs = { "usr", "local", "lib" };
		String   path    = Joiner.on( "/" ).join( subdirs );
		System.out.println( path );
	}

	// Joiner 与 Splitter
	public void testSplitter() {
		// 使用 "," 切分字符串并去除空串与空格
		String             s = "dog ,,, cat,fish,";
		Iterable< String > i = Splitter.on( ',' ).omitEmptyStrings().trimResults().split( s );
		for ( String ss : i ) {
			System.out.println( ss );
		}
	}

	public void testList() {
		// List转数组
		List< Integer > intList = Lists.newArrayList( 1, 2, 3 );
		int[]           intArr  = Ints.toArray( intList );
	}

	public void testCollectionFilter() {
		// 集合过滤器
		// 使用自定义回调方法对Map的每个Value进行操作
		ImmutableMap< String, Double > m = ImmutableMap.of( "a", 1.1, "b", 1.2 );
		// Function<F, T> F表示apply()方法input的类型，T表示apply()方法返回类型
		Map< String, Double > m2 = Maps.transformValues( m, new Function< Double, Double >() {

			double e = 1.2;

			@Override
			public Double apply( Double input ) {

				return input * e;
			}
		} );
		System.out.println( m2 );
	}

	public void testConditionFilter() {
		// 条件过滤集合
		// 方法来自 com.google.common.collect.Iterables 以及 com.google.common.base.Predicates
		ImmutableList< String > names   = ImmutableList.of( "Aleksander", "Jaran", "Integrasco", "Guava", "Java" );
		Iterable< String >      fitered = filter( names, or( equalTo( "Aleksander" ), equalTo( "Jaran" ) ) );
		System.out.println( fitered );

	}

	// Multimap的使用，Multimap<T1, T2>,T1表示Map的键，T2表示Value集合的集合元素类型
	Map< String, List< Man > > map = new HashMap< String, List< Man > >();

	public void addMan1( String author,
	                     Man Man ) {

		List< Man > Mans = map.get( author );
		if ( Mans == null ) {
			Mans = new ArrayList< Man >();
			map.put( author, Mans );
		}
		Mans.add( Man );
	}

	// 使用Multimap替代以上代码
	Multimap< String, Man > multimap = ArrayListMultimap.create();

	public void addMan2( String name,
	                     Man man ) {

		multimap.put( name, man );
	}

	// Multimap的高级应用
	// listOfMaps代表一个List中包含多个这种 mapOf("type", "blog", "id", "292", "author", "john"); 类型的Map
	// 现在需要根据type将这些map放在不同的list中
	List                                      listOfMaps     = null; // 这里省略 listOfMaps 的初始化
	Multimap< String, Map< String, String > > partitionedMap = Multimaps.index(
			listOfMaps,
			new Function< Map< String, String >, String >() {
				public String apply( final Map< String, String > from ) {
					return from.get( "type" );
				}
			} );

	class Test {

		private String title;
		private Date   date;
		private String author;

		// 使用Preconditions进行校验
		public Test( String title,
		             Date date,
		             String author ) {

			this.title = Preconditions.checkNotNull( title );
			this.date = Preconditions.checkNotNull( date );
			this.author = Preconditions.checkNotNull( author );
		}

		public String getTitle() {

			return title;
		}

		public void setTitle( String title ) {

			this.title = title;
		}

		public Date getDate() {

			return date;
		}

		public void setDate( Date date ) {

			this.date = date;
		}

		public String getAuthor() {

			return author;
		}

		public void setAuthor( String author ) {

			this.author = author;
		}

	}

	public void test() {
		// 使用Preconditions进行校验，校验不通过会抛出相应的异常
		Test t = new Test( "Tite", new Date(), "Author" );
	}

}
