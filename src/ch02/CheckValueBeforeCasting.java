package ch02;

public class CheckValueBeforeCasting {

	public static void main(String[] args) {
		int i = 128;
		
		System.out.println("Byte.MIN_VALUE: " + Byte.MIN_VALUE);
		System.out.println("Byte.MAX_VALUE: " + Byte.MAX_VALUE);
		
		if (i < Byte.MIN_VALUE || i > Byte.MAX_VALUE) {
			System.out.println("byte 타입으로 변환 할 수 없습니다.");
			System.out.println("값을 다시 확인해 주세요.");
		} else {
			byte b = (byte) i;
			System.out.println(b);
		}
	}

}
