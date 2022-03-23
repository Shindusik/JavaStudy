package ch14.test04;

import java.util.function.IntSupplier;

public class LamdaExample {

	public static void main(String[] args) {
		System.out.println(method(3, 5));
	}

	private static int method(int x, int y) {
		IntSupplier supplier = () -> {
//			x *= 10; // final 속성
			int result = x + y;
			return result;
		};
		int result = supplier.getAsInt();
		return result;
	}

}
