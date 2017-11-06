package chapter7_practice5;

public class SoldOutState implements State {
	private VendingMachine machine;
	
	public SoldOutState(VendingMachine machine) {
		this.machine = machine;
	}
	
	public void insertMoney(int money) {
		System.out.println("재고가 없습니다.");
	}
	
	public void pushButton(int price) { } // 매진 상태에는 동작 x
	
	public void returnMoney() {
		int tmp = machine.getMoneyBox().returnMoney();
		System.out.println(tmp + "원이 반환되었습니다.");
		machine.setState(machine.getNoEnoughMoneyState());
	}
}
