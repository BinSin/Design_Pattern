package chapter7_practice4;

public class ReservedState implements State {
	// 책이 예약된 상태
	private static State instance = new ReservedState();
	
	public static State getInstance() {
		return instance;
	}
	
	public void checkout(Reserve reserve) {}

	public void reserve(Reserve reserve) {}

	public void cancel(Reserve reserve) {
		// 예약을 취소할 수 있다.
		System.out.println("예약 취소하였습니다.");
		reserve.setState(OnLoanState.getInstance());
	}

	public void timeout(Reserve reserve) {}

	public void bookReturn(Reserve reserve) {
		// 책이 반납되면 보관 상태가 된다.
		System.out.println("책을 보관하였습니다.");
		reserve.setState(KeptState.getInstance());
	}
}
