package ch14.test05;

import java.util.function.IntBinaryOperator;

public class LamdaExample {
	private static int[] scores = { 10, 50, 3 };

	public static int maxOrMin(IntBinaryOperator operator) {
		int result = scores[0];
		for (int score : scores) {
			result = operator.applyAsInt(result, score);
		}
		return result;
	}

	public static void main(String[] args) {
		// 최대값 얻기
//		int max = maxOrMin((left, right) -> Math.max(left, right));
//		int max = maxOrMin(Math::max);
//		int max = maxOrMin((a, b) -> {
//			if (a >= b) {
//				return a;
//			} else {
//				return b;
//			}
//		});
		int max = maxOrMin((a, b) -> (a >= b ? a : b));
		System.out.println("최대값: " + max);

		// 최소값 얻기
//		int min = maxOrMin((left, right) -> Math.min(left, right));
//		int min = maxOrMin(Math::min);
//		int min = maxOrMin((a, b) -> {
//			if (a <= b) {
//				return a;
//			} else {
//				return b;
//			}
//		});
		int min = maxOrMin((a, b) -> (a <= b ? a : b));
		System.out.println("최소값: " + min);
	}

}
