package ch12.ex08;

public class MovieThread extends Thread {
	@Override
	public void run() {
		while (true) {
			System.out.println("동영상을 재생합니다.");
			// 1번째 방법
//			if (Thread.interrupted()) {
//				System.out.println("동영상을 멈춥니다.");
//				break;
//			}

			// 2번째 방법
			if (this.isInterrupted()) {
				System.out.println("동영상을 멈춥니다.");
				break;
			}
		}
	}
}
