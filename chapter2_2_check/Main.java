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
		 * ���� �޼ҵ�� ����� ���� �������̵���� �ʴ´�.
		 * �������� �� ������ ��ü�� Ÿ�Կ� ���� ����� �޼��尡 �����ȴ�.
		 */
		a1.doIt();
		a1.doThat();
		a2.doIt();
	}
	
}
