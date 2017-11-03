/*
 * 다대다 관계
 */

package chapter1_1_12;

import java.util.Vector;

public class Student {
	private String name;
	private Vector<Course> courses;
	
	public Student(String name) {
		this.name = name;
		courses = new Vector<Course>();
	}
	
	public void registerCourse(Course course) {
		courses.add(course);
		course.addStudent(this);
	}
	
	public void dropCourse(Course course) {
		if(courses.contains(course)) {
			courses.remove(course);
			course.removeStudent(this);
		}
	}
	
	public Vector<Course> getCourses() {
		return courses;
	}
}


