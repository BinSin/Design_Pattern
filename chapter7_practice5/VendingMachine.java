package chapter7_practice5;

public class VendingMachine {
	private State noMoneyState; // 돈이 하나도 없는 상태
	private State noEnoughMoneyState; // 돈은 있으나 음료를 사기에 부족한 상태
	private State enoughMoneyState; // 음료 사기에 돈이 충분한 상태
	private State soldOutState; // 음료가 매진된 상태
	private State state;

	private MoneyBox moneyBox;
	private Drinking drinking;

	public VendingMachine(int stock, int price) {
		noMoneyState = new NoMoneyState(this);
		noEnoughMoneyState = new NoEnoughMoneyState(this);
		enoughMoneyState = new EnoughMoneyState(this);
		soldOutState = new SoldOutState(this);

		moneyBox = new MoneyBox();
		drinking = new Drinking(stock, price);

		if (drinking.getStock() > 0)
			state = noMoneyState;
		else
			state = soldOutState;
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	public void insertMoney(int money) {
		state.insertMoney(money);
	}
	
	public void pushButton() {
		int price = drinking.getPrice();
		state.pushButton(price);
	}
	
	public void returnMoney() {
		state.returnMoney();
	}

	public State getNoMoneyState() {
		return noMoneyState;
	}

	public State getNoEnoughMoneyState() {
		return noEnoughMoneyState;
	}

	public State getEnoughMoneyState() {
		return enoughMoneyState;
	}

	public State getSoldOutState() {
		return soldOutState;
	}

	public MoneyBox getMoneyBox() {
		return moneyBox;
	}

	public Drinking getDrinking() {
		return drinking;
	}
}
