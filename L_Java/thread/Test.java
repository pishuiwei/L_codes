import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("a");
            }
        });


    }
}
