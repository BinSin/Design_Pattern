package chapter2_2_check;

class A {
	public static void doIt() {
	System.out.println("doIt: A class method");
	}
	
	public void doThat() {
		System.out.println("doThat: A class method");
	}
}

class A1 extends A {
	public static void doIt() {
		System.out.println("doIt: A1 class method");
	}
	
	public void doThat() {
		System.out.println("doThat: A1 method");
	}
}

public class Main {
	public static void main(String[] args) {
		A a1 = new A1();
		A1 a2 = new A1();
		
		/*
		 * 정적 메소드는 상속을 통해 오버라이드되지 않는다.
		 * 컴파일할 때 결정된 객체의 타입에 따라 실행될 메서드가 결정된다.
		 */
		a1.doIt();
		a1.doThat();
		a2.doIt();
	}
	
}
