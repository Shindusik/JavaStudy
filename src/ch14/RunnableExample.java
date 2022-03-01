package ch14;

public class RunnableExample {

	public static void main(String[] args) {
		Runnable runnable = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(i);
			}
		};

		Thread thread = new Thread(runnable);
		thread.start();
		
		System.out.println("--------------------");
		
		Thread thread2 = new Thread(() -> {
			for (int i = 40; i < 50; i++) {
				System.out.println(i);
			}
		});
		thread2.start();
	}

}
