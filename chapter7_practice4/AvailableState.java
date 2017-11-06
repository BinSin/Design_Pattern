package chapter7_practice4;

public class AvailableState implements State {
	// å�� ���� �� �ִ� ����
	private static State instance = new AvailableState();
	
	public static State getInstance() {
		return instance;
	}
	
	public void checkout(Reserve reserve) {
		// å�� ���� �� �� �ִ�.
		System.out.println("å�� �����Ͽ����ϴ�.");
		reserve.setState(OnLoanState.getInstance());
	}

	public void reserve(Reserve reserve) {}

	public void cancel(Reserve reserve) {}

	public void timeout(Reserve reserve) {}

	public void bookReturn(Reserve reserve) {}
}
