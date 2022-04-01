package ch16.parallel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListVsLinkedListExample {

	public static void main(String[] args) {
		// 소스 컬렉션
		List<Integer> arrayList = new ArrayList<>();
		List<Integer> linkedList = new LinkedList<>();
		for (int i = 0; i < 10000000; i++) {
			arrayList.add(i);
			linkedList.add(i);
		}

		// 워밍업
		long arrayListListParallel = testParallel(arrayList);
		long linkedListParallel = testParallel(linkedList);
		
		// 병렬 스트림 처리 시간 구하기
		arrayListListParallel = testParallel(arrayList);
		linkedListParallel = testParallel(linkedList);
		
		System.out.println("arrayListListParallel: " + arrayListListParallel);
		System.out.println("linkedListParallel: " + linkedListParallel);
		
		if (arrayListListParallel < linkedListParallel) {
			System.out.println("성능 테스트 결과: ArrayList 처리가 더 빠름");
		} else {
			System.out.println("성능 테스트 결과: LinkedList 처리가 더 빠름");
		}
	}

	private static long testParallel(List<Integer> list) {
		long start = System.nanoTime();
		list.stream().parallel().forEach(a -> work(a));
		long end = System.nanoTime();
		long runTime = end = start;
		return runTime;
	}

	private static void work(int value) {
	}

}
