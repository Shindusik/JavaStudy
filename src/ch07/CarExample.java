package ch07;

public class CarExample {

	public static void main(String[] args) {
		Car car = new Car();

		for (int i = 1; i <= 5; i++) {
			int problemLocation = car.run();
			if (problemLocation != 0) {
				if (problemLocation == 1 || problemLocation == 3) {
					System.out.println(car.tires[problemLocation - 1].location + " HankookTire로 교체");
					car.tires[problemLocation - 1] = new HankookTire(car.tires[problemLocation - 1].location, 15);
				} else {
					System.out.println(car.tires[problemLocation - 1].location + " KumhoTire로 교체");
					car.tires[problemLocation - 1] = new KumhoTire(car.tires[problemLocation - 1].location, 15);
				}
			}
			// 1회전 시 출력되는 내용을 구분
			System.out.println("-------------------------------");
		}
	}

}
