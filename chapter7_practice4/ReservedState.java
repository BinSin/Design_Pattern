package chapter7_practice4;

public class ReservedState implements State {
	// å�� ����� ����
	private static State instance = new ReservedState();
	
	public static State getInstance() {
		return instance;
	}
	
	public void checkout(Reserve reserve) {}

	public void reserve(Reserve reserve) {}

	public void cancel(Reserve reserve) {
		// ������ ����� �� �ִ�.
		System.out.println("���� ����Ͽ����ϴ�.");
		reserve.setState(OnLoanState.getInstance());
	}

	public void timeout(Reserve reserve) {}

	public void bookReturn(Reserve reserve) {
		// å�� �ݳ��Ǹ� ���� ���°� �ȴ�.
		System.out.println("å�� �����Ͽ����ϴ�.");
		reserve.setState(KeptState.getInstance());
	}
}
