package ch12;

public class TargetThread extends Thread {
	@Override
	public void run() {
		for (long i = 0; i < 1000000000; i++) {

		}

		try {
			// 1.5초가 일시 정지
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (long i = 0; i < 1000000000; i++) {

		}
	}
}
