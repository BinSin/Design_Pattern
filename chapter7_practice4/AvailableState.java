package chapter7_practice4;

public class AvailableState implements State {
	// 책을 빌릴 수 있는 상태
	private static State instance = new AvailableState();
	
	public static State getInstance() {
		return instance;
	}
	
	public void checkout(Reserve reserve) {
		// 책을 대출 할 수 있다.
		System.out.println("책을 대출하였습니다.");
		reserve.setState(OnLoanState.getInstance());
	}

	public void reserve(Reserve reserve) {}

	public void cancel(Reserve reserve) {}

	public void timeout(Reserve reserve) {}

	public void bookReturn(Reserve reserve) {}
}
