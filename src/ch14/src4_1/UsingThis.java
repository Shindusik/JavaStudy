package ch14.src4_1;

public class UsingThis {
	public int outterField = 10;
	
	class Inner {
		int innerField = 20;
		
		void method() {
			// 람다식
			MyFunctionalInterface fi = () -> {
				System.out.println("outterField: " + outterField);
				System.out.println("outterField: " + UsingThis.this.outterField + "\n");
				
				System.out.println("innerField: " + innerField);
				// 람다식 내부에서 this는 Inner 객체를 참조
				System.out.println("innerField: " + this.innerField + "\n");
			};
			fi.method();
		}
	}
}
