package chapter1_1_14;

import java.util.Vector;

public class Main {
	public static void main(String[] args) {
		Student s1 = new Student("manSup");
		Student s2 = new Student("gilDong");
		Course se = new Course("Software Engineering");
		Course designPattern = new Course("Design Pattern");
		// manSup은 소프트웨어 공학 수강
		Transcript t1 = new Transcript(s1, se);
		// manSup은 디자인 패턴 수강
		Transcript t2 = new Transcript(s1, designPattern);
		// gilDong은 디자인 패턴 수강
		Transcript t3 = new Transcript(s2, designPattern);
		
		// manSup은 2012년에 소프트웨어 공학에서 B0
		// 디자인 패턴에서 D+ 학점 취득
		t1.setDate("2012");;
		t1.setGrade("B0");
		t2.setDate("2012");
		t2.setGrade("D+");
		// gilDong은 2013년에 디자인 패턴에서 C+학점 취득
		t3.setDate("2013");
		t3.setGrade("C+");
		
		Vector<Course> courses;
		courses = s1.getCourses();
		System.out.println(s1.getName() + " transcript");
		for(int i=0; i<courses.size(); i++) {
			System.out.println(courses.get(i).getName());
		}
		System.out.println();
		
		System.out.println(s2.getName() + " transcript");
		courses = s2.getCourses();
		for(int i=0; i<courses.size(); i++) {
			System.out.println(courses.get(i).getName());
		}
		System.out.println();
		
		Vector<Student> students;
		System.out.println(se.getName() + " class have");
		students = se.getStudents();
		for(int i=0; i<students.size(); i++) {
			System.out.println(students.get(i).getName());
		}
		System.out.println();
		
		System.out.println(designPattern.getName() + " class have");
		students = designPattern.getStudents();
		for(int i=0; i<students.size(); i++) {
			System.out.println(students.get(i).getName());
		}
		System.out.println();
	}
}
