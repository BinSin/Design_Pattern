package homework3;

public class Main {

	public static void main(String[] args) {
		// 0 ~ 36 까지 수 출력
		NumberGenerator generator = new IncrementalNumberGenerator(0, 36);
		Observer observer1 = new DigitObserver();
		Observer observer2 = new GraphObserver();
		Observer observer3 = new DrawObserver();
		generator.addObserver(observer1);
		generator.addObserver(observer2);
		generator.addObserver(observer3);
		
		generator.execute();
	}
}
