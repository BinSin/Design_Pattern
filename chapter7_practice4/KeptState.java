package chapter7_practice4;

public class KeptState implements State {
	// 책이 보관중인 상태
	private static State instance = new KeptState();
	
	public static State getInstance() {
		return instance;
	}
	public void checkout(Reserve reserve) {
		// 책을 대출할 수 있다.
		System.out.println("책을 대출하였습니다.");
		reserve.setState(OnLoanState.getInstance());
	}

	public void reserve(Reserve reserve) {}

	public void cancel(Reserve reserve) {
		// 책 보관을 취소할 수 있다.
		System.out.println("책 보관을 취소하였습니다.");
		reserve.setState(AvailableState.getInstance());
	}

	public void timeout(Reserve reserve) {
		// 책 보관 기간이 지났다.
		System.out.println("책 보관 기간이 지났습니다.");
		reserve.setState(AvailableState.getInstance());
	}

	public void bookReturn(Reserve reserve) {}
}
