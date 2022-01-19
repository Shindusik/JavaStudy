package ch02;

public class PromotionExample {

	public static void main(String[] args) {
		byte byteValue = 10;
		int intValue = byteValue; // 자동타입변환
		System.out.println(intValue);

		char charValue = '가';
		intValue = charValue; // 자동타입변환
		System.out.println("\'가\'의 유니코드=" + intValue);

		intValue = 500;
		long longValue = intValue; // 자동타입변환
		System.out.println(longValue);

		intValue = 200;
		double doubleValue = intValue; // 자동타입변환
		System.out.println(doubleValue);
	}

}
