package thread;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author PW 2018/01/03
 *
 */
public class CallableNote implements Callable<String>{
	private int id;
	public CallableNote(int id) {
		this.id = id;
	}
	
	public String call() throws Exception {
		return "result of CallbaleNot " + id;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = new ArrayList<Future<String>>();
		for (int i = 0; i < 10; i++) {
			results.add(exec.submit(new CallableNote(i)));
		}
		for(Future<String> fs : results) {
			System.out.println(fs.get());
		}
	}
}
