package ch03;

import java.lang.Character.UnicodeBlock;

public class CharOperationExample {

	public static void main(String[] args) {
		char c1 = 'A' + 'B';
		char c2 = 'A';
		char c3 = (char) (c2 + 1);
		System.out.println("c1: " + c1);
		System.out.println("c2: " + c2);
		System.out.println("c3: " + c3);
		
		int c4 = 'A' + 'B';
		System.out.println(c4);
		System.out.println(Integer.toBinaryString(c1));
		System.out.println(UnicodeBlock.of(c1));
	}

}
