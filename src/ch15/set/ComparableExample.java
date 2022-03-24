package ch15.set;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class ComparableExample {

	public static void main(String[] args) {
		TreeSet<Person> treeSet = new TreeSet<>();

		treeSet.add(new Person("홍길동", 45));
		treeSet.add(new Person("감자바", 25));
		treeSet.add(new Person("박지원", 31));

		System.out.println("[오름차순 정렬]");
		Iterator<Person> iterator = treeSet.iterator();
		while (iterator.hasNext()) {
			Person person = iterator.next();
			System.out.println(person.name + ":" + person.age);
		}
		System.out.println();

		System.out.println("[내림차순 정렬]");
		NavigableSet<Person> descendingSet = treeSet.descendingSet();
		for (Person person : descendingSet) {
			System.out.println(person.name + ":" + person.age);
		}
	}

}
