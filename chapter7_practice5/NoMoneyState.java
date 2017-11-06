package chapter7_practice5;

public class NoMoneyState implements State {
	private VendingMachine machine;
	
	public NoMoneyState(VendingMachine machine) {
		this.machine = machine;
	}
	
	public void insertMoney(int money) {
		machine.getMoneyBox().insert(money);;
		System.out.println(money + "���� �־����ϴ�.");
		
		if(money >= machine.getDrinking().getPrice()) {
			machine.setState(machine.getEnoughMoneyState());
		}
		else {
			machine.setState(machine.getNoEnoughMoneyState());
		}
		System.out.println("���� �ݾ��� " + machine.getMoneyBox().getMoney() + "���Դϴ�.");
	}
	
	public void pushButton(int price) {
		System.out.println("������ �־��ּ�.");;
	}
	
	public void returnMoney() {
		System.out.println("��ȯ�� ������ �����ϴ�.");
	}
}
