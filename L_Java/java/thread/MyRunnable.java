package thread;

public class MyRunnable implements Runnable{

	public static void main(String[] args) {
		Thread myrunnable1 = new Thread(new MyRunnable());
		Thread myrunnable2 = new Thread(new MyRunnable());
		Thread myrunnable3 = new Thread(new MyRunnable());
		myrunnable1.start();
		myrunnable2.start();
		myrunnable3.start();
		System.out.println("s");
	}
	
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + "," + i);
		}		
	}

}
