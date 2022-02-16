package ch07;

public class Car {
	// 필드 (자동차는 4개의 타이어를 가진다.)
	Tire[] tires = { new Tire("앞왼쪽", 6), new Tire("앞오른쪽", 2), new Tire("뒤왼쪽", 3), new Tire("뒤오른쪽", 4) };

	// 생성자

	// 메소드
	int run() {
		System.out.println("[자동차가 달립니다.]");
		for (int i = 0; i < tires.length; i++) {
			if (!tires[i].roll()) {
				stop();
				return (i + 1);
			}
		}
		return 0;
	}

	void stop() {
		System.out.println("[자동차가 멈춥니다.]");
	}
}
