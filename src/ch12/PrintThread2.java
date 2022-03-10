package ch12;

public class PrintThread2 extends Thread {
	@Override
	public void run() {
		/*
		try {
			while (true) {
				System.out.println("실행 중");
				Thread.sleep(1);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		*/
		// Thread.sleep(1)을 사용하지 않고 처리
		while (true) {
			System.out.println("실행 중");
			if (Thread.interrupted()) {
				break;
			}
		}
		
		System.out.println("자원 정리");
		System.out.println("실행 종료");
	}
}
