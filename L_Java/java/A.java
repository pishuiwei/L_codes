import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class A extends  Thread{

    public static void main(String[] args) {
        Executor executor = Executors.newSingleThreadExecutor();

        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("start！");
            }
        });


    }


}
