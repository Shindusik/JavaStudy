package ch13.ex02;

public class Container<T> {
	private T t;
	
	public void Set(T t) {
		this.t = t;
	}
	
	public T get() {
		return t;
	}
}
