package chapter7_practice4;

public interface State {
	public void checkout(Reserve reserve);
	public void reserve(Reserve reserve);
	public void cancel(Reserve reserve);
	public void timeout(Reserve reserve);
	public void bookReturn(Reserve reserve);
}
