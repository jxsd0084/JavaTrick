package bj.Java1200.col01.ch05_面向对象技术应用.ch05_7_接口与内部类._122_静态内部类的简单应用;

public class MaxMin {

	public static class Result {

		private double max;
		private double min;

		public Result( double max, double min ) {

			this.max = max;
			this.min = min;
		}

		public double getMax() {

			return max;
		}

		public double getMin() {

			return min;
		}
	}

	public static Result getResult( double[] array ) {

		double max = Double.MIN_VALUE;
		double min = Double.MAX_VALUE;
		for ( double i : array ) {
			if ( i > max ) {
				max = i;
			}
			if ( i < min ) {
				min = i;
			}
		}
		return new Result( max, min );
	}
}
