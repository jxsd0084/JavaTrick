package bj.powernode.basic.day09.exercise;

public class Exercise03 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		// "1,2;3,56,89,90;3,5,2"

		String s = "1,2;3,56,89,90;3,5,2";

		String[] strs1 = s.split( ";" );

		double[][] ds = new double[ strs1.length ][];


		for ( int i = 0; i < strs1.length; i++ ) {

			String[] strs2 = strs1[ i ].split( "," );

			ds[ i ] = new double[ strs2.length ];

			for ( int j = 0; j < strs2.length; j++ ) {

				double d = Double.parseDouble( strs2[ j ] );  //"1" "2"

				ds[ i ][ j ] = d;
			}
		}


		//遍历二维数组
		for ( int i = 0; i < ds.length; i++ ) {

			for ( int j = 0; j < ds[ i ].length; j++ ) {

				System.out.println( ds[ i ][ j ] );
			}
		}

	}

}
