package ch11;

import java.util.Arrays;
import java.util.Random;

public class RandomExample {

	public static void main(String[] args) {
		// 선택번호
		int[] selectNumber = new int[6];
		Random random = new Random(3);
		System.out.print("선택 번호: ");
		for (int i = 0; i < 6; i++) {
			selectNumber[i] = random.nextInt(45) + 1;
			System.out.print(selectNumber[i] + " ");
		}
		System.out.println();

		// 당첨번호
		int[] winningNumber = new int[6];
		random = new Random(3);
		System.out.print("당첨 번호: ");
		for (int i = 0; i < 6; i++) {
			winningNumber[i] = random.nextInt(45) + 1;
			System.out.print(winningNumber[i] + " ");
		}
		System.out.println();

		// 당첨여부
		Arrays.sort(selectNumber);
		// 정렬된 숫자를 표시
		System.out.print("선택 번호(정렬): ");
		for (int i = 0; i < selectNumber.length; i++) {
			System.out.print(selectNumber[i] + " ");
		}
		System.out.println();

		Arrays.sort(winningNumber);
		// 정렬된 숫자를 표시
		System.out.print("당첨 번호(정렬): ");
		for (int i = 0; i < winningNumber.length; i++) {
			System.out.print(winningNumber[i] + " ");
		}
		System.out.println();

		boolean result = Arrays.equals(selectNumber, winningNumber);
		System.out.print("당첨 여부: ");
		if (result) {
			System.out.println("1등에 당첨되었습니다.");
		} else {
			System.out.println("당첨되지 않았습니다.");
		}
	}

}
