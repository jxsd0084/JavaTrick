//package bj.jakeChen.Guava.Collection;
//
//import com.google.common.collect.Sets;
//
//import java.util.Set;
//
//
///**
// * Created by chenlong on 2016/4/25.
// */
//public class TestSets {
//
//	public static void main( String[] args ) {
//
//		Set< Integer > setA = Sets.newHashSet();
//		setA.add( 1 );
//		setA.add( 2 );
//		setA.add( 3 );
//		setA.add( 4 );
//		setA.add( 5 );
//		setA.forEach( x -> System.out.print( " " + x ) );
//
//		System.out.println();
//
//		Set< Integer > setB = Sets.newHashSet();
//		setB.add( 4 );
//		setB.add( 5 );
//		setB.add( 6 );
//		setB.add( 7 );
//		setB.add( 8 );
//		setB.forEach( x -> System.out.print( " " + x ) );
//
//		System.out.println();
//
//		Sets.SetView union = Sets.union( setA, setB );
//		System.out.print( "union:" );
//		union.forEach( x -> System.out.print( " " + x ) );
//
//		System.out.println();
//
//		Sets.SetView difference = Sets.difference( setA, setB );
//		System.out.print( "difference:" );
//		difference.forEach( x -> System.out.print( " " + x ) );
//
//		System.out.println();
//
//		Sets.SetView intersection = Sets.intersection( setA, setB );
//		System.out.print( "intersection:" );
//		intersection.forEach( x -> System.out.print( " " + x ) );
//	}
//
//}
