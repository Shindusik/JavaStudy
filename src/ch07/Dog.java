package ch07;

public class Dog extends Animal {
	
	public Dog() {
		this.kind = "포유류";
	}

	// 추상메소드 재정의
	@Override
	public void sound() {
		System.out.println("멍멍");
	}

}
