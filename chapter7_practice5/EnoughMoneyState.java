package chapter7_practice5;

public class EnoughMoneyState implements State {
	private VendingMachine machine;
	
	public EnoughMoneyState(VendingMachine machine) {
		this.machine = machine;
	}
	
	public void insertMoney(int money) {
		machine.getMoneyBox().insert(money);
		System.out.println(money + "���� �־����ϴ�.");
		System.out.println("���� �ݾ��� " + machine.getMoneyBox().getMoney() + "���Դϴ�.");
	}
	
	public void pushButton(int price) {
		machine.getMoneyBox().dispense(price);
		machine.getDrinking().dispense(); // ����� ����
		System.out.println("������� ���Խ��ϴ�.");
		
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
		System.out.println(tmp + "���� ��ȯ�Ǿ����ϴ�.");
		machine.setState(machine.getNoMoneyState());
	}
}