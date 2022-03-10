package ch12.$6_4;

public class WorkObject {
	public synchronized void methodA(int no) {
		System.out.println(no + ") ThreadA의 methodA() 작업 실행");
		notify(); // 일시 정지 상태에 있는 ThreadB를 실행 대기 상태로 만듦
		try {
			wait(); // ThreadA를 일시 정지 상태로 만듦
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void methodB(int no) {
		System.out.println(no + ") ThreadB의 methodB() 작업 실행");
		notify(); // 일시 정지 상태에 있는 ThreadA를 실행 대기 상태로 만듦
		try {
			wait(); // ThreadB를 일시 정지 상태로 만듦
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
