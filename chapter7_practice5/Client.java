package chapter7_practice5;

public class Client {
	public static void main(String[] args) {
		VendingMachine machine = new VendingMachine(5, 1000);
		
		machine.insertMoney(1000);
		machine.insertMoney(500);
		machine.pushButton();
		machine.returnMoney();
		machine.insertMoney(3000);
		machine.insertMoney(1000);
		machine.pushButton();
		machine.pushButton();
		machine.pushButton();
		machine.pushButton();
		machine.pushButton(); // ��� ���� �� ���� ����
		machine.insertMoney(1000);
	}
}
