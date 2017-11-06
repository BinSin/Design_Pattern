package chapter7_practice4;

public class KeptState implements State {
	// å�� �������� ����
	private static State instance = new KeptState();
	
	public static State getInstance() {
		return instance;
	}
	public void checkout(Reserve reserve) {
		// å�� ������ �� �ִ�.
		System.out.println("å�� �����Ͽ����ϴ�.");
		reserve.setState(OnLoanState.getInstance());
	}

	public void reserve(Reserve reserve) {}

	public void cancel(Reserve reserve) {
		// å ������ ����� �� �ִ�.
		System.out.println("å ������ ����Ͽ����ϴ�.");
		reserve.setState(AvailableState.getInstance());
	}

	public void timeout(Reserve reserve) {
		// å ���� �Ⱓ�� ������.
		System.out.println("å ���� �Ⱓ�� �������ϴ�.");
		reserve.setState(AvailableState.getInstance());
	}

	public void bookReturn(Reserve reserve) {}
}
