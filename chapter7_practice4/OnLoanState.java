package chapter7_practice4;

public class OnLoanState implements State {
	// å�� ���� ���� ����
	private static State instance = new OnLoanState();
	
	public static State getInstance() {
		return instance;
	}
	
	public void checkout(Reserve reserve) {}

	public void reserve(Reserve reserve) {
		// å�� ������ �� �ִ�.
		System.out.println("����Ǿ����ϴ�.");
		reserve.setState(ReservedState.getInstance());
	}

	public void cancel(Reserve reserve) {}

	public void timeout(Reserve reserve) {}

	public void bookReturn(Reserve reserve) {
		// ������ ����� �� �ִ�.
		System.out.println("������ ����Ͽ����ϴ�.");
		reserve.setState(AvailableState.getInstance());
	}
}
