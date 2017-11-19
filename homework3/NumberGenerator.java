package homework3;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class NumberGenerator {
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
	
	public void eleteObserver(Observer observer) {
		observers.remove(observer);
	}
	
	public void notifyObservers() {
		Iterator<Observer> it = observers.iterator();
		while(it.hasNext()) {
			Observer o = it.next();
			o.update(this);
		}
	}
	
	public abstract int getNumber();
	
	public abstract void execute();
}
