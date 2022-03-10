package ch12;

public class StatePrintThread extends Thread {
	private Thread targetThread;

	public StatePrintThread(Thread targetThread) {
		this.targetThread = targetThread;
	}

	@Override
	public void run() {
		while (true) {
			Thread.State state = targetThread.getState();
			System.out.println("타켓 스레드 상태: " + state);

			// 객체 생성 상태일 경우 실행 대기 상태로 만듦
			if (state == Thread.State.NEW) {
				targetThread.start();
			}

			// 종료 상태일 경우 while문을 종료함
			if (state == Thread.State.TERMINATED) {
				break;
			}
			try {
				// 0.5초가 일시 정지
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
