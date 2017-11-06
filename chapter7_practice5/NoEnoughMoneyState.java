package chapter7_practice5;

public class NoEnoughMoneyState implements State {
	private VendingMachine machine;
	
	public NoEnoughMoneyState(VendingMachine machine) {
		this.machine = machine;
	}
	
	public void insertMoney(int money) {
		machine.getMoneyBox().insert(money);
		System.out.println(money + "���� �־����ϴ�.");
		
		if(machine.getMoneyBox().getMoney() >= machine.getDrinking().getPrice()) {
			machine.setState(machine.getEnoughMoneyState());
		}
		
		else {
			machine.setState(machine.getNoEnoughMoneyState());
		}
		System.out.println("���� �ݾ��� " + machine.getMoneyBox().getMoney() + "���Դϴ�.");
	}
	
	public void pushButton(int price) {
		System.out.println("������ �����մϴ�.");
	}
	
	public void returnMoney() {
		int tmp = machine.getMoneyBox().returnMoney();
		System.out.println(tmp + "���� ��ȯ�Ǿ����ϴ�.");
		machine.setState(machine.getNoMoneyState());
	}
}
