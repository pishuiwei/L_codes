import java.util.ArrayList;
import java.util.List;

public class Thread {

    private boolean a;

    public static void main(String[] args) {
        int num = Runtime.getRuntime().availableProcessors();
        System.out.println(num);

        List<String> list = new ArrayList<>();
        list.iterator();

    }

    public void get() {
        while(!a) {
            System.out.println(a);
        }

    }
}
