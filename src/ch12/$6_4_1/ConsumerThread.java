package ch12.$6_4_1;

public class ConsumerThread extends Thread {
	private DataBox dataBox;

	public ConsumerThread(DataBox dataBox) {
		this.dataBox = dataBox;
	}

	@Override
	public void run() {
		for (int i = 0; i <= 3; i++) {
			String data = dataBox.getData();
		}
	}
}
