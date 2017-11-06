package chapter7_practice5;

public class EnoughMoneyState implements State {
	private VendingMachine machine;
	
	public EnoughMoneyState(VendingMachine machine) {
		this.machine = machine;
	}
	
	public void insertMoney(int money) {
		machine.getMoneyBox().insert(money);
		System.out.println(money + "원을 넣었습니다.");
		System.out.println("현재 금액은 " + machine.getMoneyBox().getMoney() + "원입니다.");
	}
	
	public void pushButton(int price) {
		machine.getMoneyBox().dispense(price);
		machine.getDrinking().dispense(); // 음료수 구입
		System.out.println("음료수가 나왔습니다.");
		
		if(machine.getDrinking().getStock() == 0) {
			machine.setState(machine.getSoldOutState());
		}
		else if(machine.getMoneyBox().getMoney() < machine.getDrinking().getPrice()) {
			machine.setState(machine.getNoEnoughMoneyState());
		}
		else if(machine.getMoneyBox().getMoney() == 0) {
			machine.setState(machine.getNoMoneyState());
		}
	}
	
	public void returnMoney() {
		int tmp = machine.getMoneyBox().returnMoney();
		System.out.println(tmp + "원이 반환되었습니다.");
		machine.setState(machine.getNoMoneyState());
	}
}