package chapter7_practice5;

public class SoldOutState implements State {
	private VendingMachine machine;
	
	public SoldOutState(VendingMachine machine) {
		this.machine = machine;
	}
	
	public void insertMoney(int money) {
		System.out.println("��� �����ϴ�.");
	}
	
	public void pushButton(int price) { } // ���� ���¿��� ���� x
	
	public void returnMoney() {
		int tmp = machine.getMoneyBox().returnMoney();
		System.out.println(tmp + "���� ��ȯ�Ǿ����ϴ�.");
		machine.setState(machine.getNoEnoughMoneyState());
	}
}
