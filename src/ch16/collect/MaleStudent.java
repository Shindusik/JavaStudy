package ch16.collect;

import java.util.ArrayList;
import java.util.List;

public class MaleStudent {
	private List<Student> list; // 요소를 저장할 컬렉션

	public MaleStudent() {
		list = new ArrayList<>();
		System.out.println("[" + Thread.currentThread().getName() + "] MaleStudent()");
	}

	// 요소를 수집하는 메소드
	public void accumulate(Student student) {
		list.add(student);
		System.out.println("[" + Thread.currentThread().getName() + "] accumulate()");
	}

	// 두 MaleStudent를 결합하는 메소드(병렬 처리 시에만 호출)
	public void combine(MaleStudent other) {
		list.addAll(other.getList());
		System.out.println("[" + Thread.currentThread().getName() + "] combine()");
	}

	public List<Student> getList() {
		return list;
	}
}
