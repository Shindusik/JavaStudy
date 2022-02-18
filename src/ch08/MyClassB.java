package ch08;

public class MyClassB implements MyInterface {

	@Override
	public void method1() {
		System.out.println("MyClassB-method1() 실행");
	}

	// MyInterface default 메소드 재정의
	@Override
	public void method2() {
		System.out.println("MyClassB-method2() 실행");
	}
	
}
