package ch14.supplier;

import java.util.function.IntSupplier;

public class SupplierExample {

	public static void main(String[] args) {
		IntSupplier supplier = () -> {
			int num = (int) (Math.random() * 6) + 1;
			return num;
		};
		
		int num = supplier.getAsInt();
		System.out.println("눈의 수: " + num);
		
		IntSupplier supplier2 = () -> (int) (Math.random() * 6) + 1;
		System.out.println("눈의 수: " + supplier2.getAsInt());
	}

}
