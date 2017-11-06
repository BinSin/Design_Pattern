package chapter7_practice5;

public class NoMoneyState implements State {
	private VendingMachine machine;
	
	public NoMoneyState(VendingMachine machine) {
		this.machine = machine;
	}
	
	public void insertMoney(int money) {
		machine.getMoneyBox().insert(money);;
		System.out.println(money + "원을 넣었습니다.");
		
		if(money >= machine.getDrinking().getPrice()) {
			machine.setState(machine.getEnoughMoneyState());
		}
		else {
			machine.setState(machine.getNoEnoughMoneyState());
		}
		System.out.println("현재 금액은 " + machine.getMoneyBox().getMoney() + "원입니다.");
	}
	
	public void pushButton(int price) {
		System.out.println("동전을 넣어주셍.");;
	}
	
	public void returnMoney() {
		System.out.println("반환할 동전이 없습니다.");
	}
}
