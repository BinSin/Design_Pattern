package chapter7_1;

public class ON implements LightState {
	private static LightState instance = new ON();

	public static LightState getInstance() {
		return instance;
	}
	public void on_button_pushed(Light light) {
		System.out.println("��ħ�� ����");;
		light.setState(SLEEPING.getInstance());
	}
	public void off_button_pushed(Light light) {
		System.out.println("Light off!!");
		light.setState(OFF.getInstance());
	}
}