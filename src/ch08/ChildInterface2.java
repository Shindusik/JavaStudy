package ch08;

public interface ChildInterface2 extends ParentInterface {

	@Override
	default void method2() {
		// 실행문
	}
	
	public void method3();
	
}
