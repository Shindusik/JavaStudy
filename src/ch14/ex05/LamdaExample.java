package ch14.ex05;

import java.util.function.IntBinaryOperator;

public class LamdaExample {

	private static int[] scores = { 10, 50, 3, 121, 0 };

	public static int maxOrMin(IntBinaryOperator operator) {
		int result = scores[0];
		for (int score : scores) {
			result = operator.applyAsInt(result, score);
		}
		return result;
	}

	public static void main(String[] args) {
		// 최대값 얻기
		/* 첫번째 방법
		int max = maxOrMin((a, b) -> {
			if (a <= b) {
				return b;
			} else {
				return a;
			}
		});
		*/
		
		// 두번째 방법
//		int max = maxOrMin(Math::max);
		
		// 세번째 방법
		int max = maxOrMin((a, b) -> (a >= b ? a : b));
		
		System.out.println("최대값: " + max);

		// 최소값 얻기
		/* 첫번째 방법
		int min = maxOrMin((a, b) -> {
			if (a <= b) {
				return a;
			} else {
				return b;
			}
		});
		*/
		
		// 두번째 방법
//		int min = maxOrMin(Math::min);
		
		// 세번째 방법
		int min = maxOrMin((a, b) -> (a >= b ? b : a));
		System.out.println("최소값: " + min);
	}

}
