package ch04;

public class Exercise06 {

	public static void main(String[] args) {
		System.out.println("[단일 루프를 이용하여 출력]\n");
		for (int i = 1; i <= 5; i++) {
			if (i == 1) {
				System.out.println("*");
			} else if (i == 2) {
				System.out.println("**");
			} else if (i == 3) {
				System.out.println("***");
			} else if (i == 4) {
				System.out.println("****");
			} else {
				System.out.println("*****");
			}
		}
		
		System.out.println("\n[이중 루프를 이용하여 출력]\n");		
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
				if (j == i) {
					System.out.println();
				}
			}
		}
	}

}
