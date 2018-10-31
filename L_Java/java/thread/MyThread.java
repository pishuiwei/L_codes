package thread;

public class MyThread extends Thread{
	
	public static void main(String[] args) {
		Thread mythread1 = new MyThread();
		Thread mythread2 = new MyThread();
		mythread1.start();
		mythread2.start();
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "," + i);
		}
	}

}
