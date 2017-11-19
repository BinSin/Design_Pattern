package homework3;

public class IncrementalNumberGenerator extends NumberGenerator {
	private int number;
	private int end;

	public IncrementalNumberGenerator(int start, int end) {
		this.number = start;
		this.end = end;
	}

	public int getNumber() {
		return number;
	}

	public void execute() {
		while (number <= end) {
			notifyObservers();
			// ���� �Լ��� ���ϰ� ��
			number += (int) ((Math.random() + 0.1) * 5);
		}
	}
}
