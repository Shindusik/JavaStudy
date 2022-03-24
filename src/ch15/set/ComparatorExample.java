package ch15.set;

import java.util.Iterator;
import java.util.TreeSet;

public class ComparatorExample {

	public static void main(String[] args) {
		/*
		TreeSet<Fruit> treeSet = new TreeSet<>();
		// Furit이 Comparable을 구현하지 않았기 때문에 예외 발생
		treeSet.add(new Fruit("포도", 3000));
		treeSet.add(new Fruit("수박", 10000));
		treeSet.add(new Fruit("딸기", 6000));
		*/
		
		TreeSet<Fruit> descTreeSet = new TreeSet<>(new DescendingComparator());
		descTreeSet.add(new Fruit("포도", 3000));
		descTreeSet.add(new Fruit("수박", 10000));
		descTreeSet.add(new Fruit("딸기", 6000));
		
		System.out.println("[내림차순 정렬]");
		Iterator<Fruit> descIterator = descTreeSet.iterator();
		while (descIterator.hasNext()) {
			Fruit fruit = descIterator.next();
			System.out.println(fruit.name + ":" + fruit.price);
		}
		System.out.println();
		
		TreeSet<Fruit> ascTreeSet = new TreeSet<>(new AscendingComparator());
		ascTreeSet.add(new Fruit("포도", 3000));
		ascTreeSet.add(new Fruit("수박", 10000));
		ascTreeSet.add(new Fruit("딸기", 6000));
		
		System.out.println("[오름차순 정렬]");
		Iterator<Fruit> ascIterator = ascTreeSet.iterator();
		while (ascIterator.hasNext()) {
			Fruit fruit = ascIterator.next();
			System.out.println(fruit.name + ":" + fruit.price);
		}
	}

}
