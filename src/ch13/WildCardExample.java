package ch13;

import java.util.Arrays;

public class WildCardExample {

	public static class Person {
		public String name;

		public Person(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}
	}

	public static class Worker extends Person {
		public Worker(String name) {
			super(name);
		}
	}

	public static class Student extends Person {
		public Student(String name) {
			super(name);
		}
	}

	public static class HighStudent extends Student {
		public HighStudent(String name) {
			super(name);
		}
	}

	public static void main(String[] args) {
		Course<Person> personCourse = new Course<Person>("일반인과정", 5);
		personCourse.add(new Person("일반인"));
		personCourse.add(new Worker("직장인"));
		personCourse.add(new Student("학생"));
		personCourse.add(new HighStudent("고등학생"));

		Course<Worker> workerCourse = new Course<Worker>("직장인과정", 5);
		workerCourse.add(new Worker("직장인"));

		Course<Student> studentCourse = new Course<Student>("학생과정", 5);
		studentCourse.add(new Student("학생"));
		studentCourse.add(new HighStudent("고등학생"));

		Course<HighStudent> highStudentCourse = new Course<HighStudent>("고등학생", 5);
		highStudentCourse.add(new HighStudent("고등학생"));

		// 모든 과정 등록 가능
		registerCourse(personCourse);
		registerCourse(workerCourse);
		registerCourse(studentCourse);
		registerCourse(highStudentCourse);
		System.out.println();

		// 학생 과정만 등록 가능
		registerCourseStudent(studentCourse);
		registerCourseStudent(highStudentCourse);
		System.out.println();
		
		// 직장인과 일반인 과정만 등록 가능
		registerCourseWoker(personCourse);
		registerCourseWoker(workerCourse);
	}

	// 모든 과정
	private static void registerCourse(Course<?> course) {
		System.out.println(course.getName() + " 수강생: " + Arrays.toString(course.getStudents()));
	}

	// 학생 과정
	private static void registerCourseStudent(Course<? extends Student> course) {
		System.out.println(course.getName() + " 수강생: " + Arrays.toString(course.getStudents()));
	}

	// 직장인과 일반인 과정
	private static void registerCourseWoker(Course<? super Worker> course) {
		System.out.println(course.getName() + " 수강생: " + Arrays.toString(course.getStudents()));
	}

}
