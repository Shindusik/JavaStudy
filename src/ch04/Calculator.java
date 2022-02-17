package ch04;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		boolean run = true;

		Scanner scanner = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#,###.##");

		while (run) {
			System.out.println("-------------------------------------------");
			System.out.println("1. 더하기 | 2. 빼기 | 3. 곱하기 | 4. 나누기 | 5. 종료");
			System.out.println("-------------------------------------------");
			System.out.print("선택> ");

			try {
				int selNo = scanner.nextInt();
				if (selNo > 5) {
					System.out.println("숫자 1~5 값 중에 한 개의 값을 입력해 주세요.");
					continue;
				}
				switch (selNo) {
				case 1:
					System.out.print("더하기 할 첫번째 값: ");
					double a = scanner.nextDouble();
					System.out.print("더하기 할 두번째 값: ");
					double b = scanner.nextDouble();
					System.out.print("더하기 결과 : " + df.format(a + b) + "\n\n");
					break;
				case 2:
					System.out.print("빼기 할 첫번째 값: ");
					a = scanner.nextDouble();
					System.out.print("빼기 할 두번째 값: ");
					b = scanner.nextDouble();
					System.out.print("빼기 결과 : " + df.format(a - b) + "\n\n");
					break;
				case 3:
					System.out.print("곱 할 첫번째 값: ");
					a = scanner.nextDouble();
					System.out.print("곱 할 두번째 값: ");
					b = scanner.nextDouble();
					System.out.print("곱하기 결과 : " + df.format(a * b) + "\n\n");
					break;
				case 4:
					System.out.print("나누기 할 첫번째 값: ");
					a = scanner.nextDouble();
					System.out.print("나누기 할 두번째 값: ");
					b = scanner.nextDouble();
					System.out.print("곱하기 결과 : " + df.format(a / b) + "\n\n");
					break;
				case 5:
					run = false;
				}
			} catch (Exception e) {
				System.out.println("숫자 1~5 값 중에 한 개의 값을 입력해 주세요.\n프로그램을 다시 실행해 주세요.");
				break;
			}
		}

		System.out.println("\n프로그램 종료");
		scanner.close();
	}

}
