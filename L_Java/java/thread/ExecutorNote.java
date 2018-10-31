package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 管理线程
 * 
 * @author PW 2018/01/03
 *
 */
public class ExecutorNote {
	
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5 ; i++) {
			exec.execute(new MyRunnable());
		}
		exec.shutdown();
	}

}
