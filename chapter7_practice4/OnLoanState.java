package chapter7_practice4;

public class OnLoanState implements State {
	// 책이 대출 중인 상태
	private static State instance = new OnLoanState();
	
	public static State getInstance() {
		return instance;
	}
	
	public void checkout(Reserve reserve) {}

	public void reserve(Reserve reserve) {
		// 책을 예약할 수 있다.
		System.out.println("예약되었습니다.");
		reserve.setState(ReservedState.getInstance());
	}

	public void cancel(Reserve reserve) {}

	public void timeout(Reserve reserve) {}

	public void bookReturn(Reserve reserve) {
		// 대출을 취소할 수 있다.
		System.out.println("대출을 취소하였습니다.");
		reserve.setState(AvailableState.getInstance());
	}
}
