package chapter7_practice4;

public class Client {
	public static void main(String[] args) {
		Reserve reserve = new Reserve();
		
		reserve.checkout();
		reserve.bookReturn();
		reserve.checkout();
		reserve.reserve();
		reserve.cancel();
		reserve.reserve();
		reserve.bookReturn();
		//reserve.cancel();
		//reserve.timeout();
		//reserve.checkout();
	}
}
