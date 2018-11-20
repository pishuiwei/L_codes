public class A extends  Thread{

    public static void main(String[] args) {
    int i = 100;
        if(i > 0) {
            throw new RuntimeException();
        }
    }

}
