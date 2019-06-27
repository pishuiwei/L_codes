import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Demo {

        public static void main(String[] args) throws AWTException {
            Robot robot = new Robot();
            robot.setAutoDelay(300);

            robot.keyPress(KeyEvent.VK_WINDOWS);
            robot.keyPress(KeyEvent.VK_D);

            robot.keyRelease(KeyEvent.VK_D);
            robot.keyRelease(KeyEvent.VK_WINDOWS);

            robot.keyPress(KeyEvent.VK_WINDOWS);
            robot.keyPress(KeyEvent.VK_R);

            robot.keyRelease(KeyEvent.VK_R);
            robot.keyRelease(KeyEvent.VK_WINDOWS);

            robot.keyPress(KeyEvent.VK_C);
            robot.keyPress(KeyEvent.VK_M);
            robot.keyPress(KeyEvent.VK_D);
            robot.keyRelease(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_M);
            robot.keyRelease(KeyEvent.VK_D);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            robot.setAutoDelay(30);
         // shutdown -sources -target xx
            robot.keyPress(KeyEvent.VK_S);
            robot.keyPress(KeyEvent.VK_H);
            robot.keyPress(KeyEvent.VK_U);
            robot.keyPress(KeyEvent.VK_T);
            robot.keyPress(KeyEvent.VK_D);
            robot.keyPress(KeyEvent.VK_O);
            robot.keyPress(KeyEvent.VK_W);
            robot.keyPress(KeyEvent.VK_N);
            robot.keyRelease(KeyEvent.VK_S);
            robot.keyRelease(KeyEvent.VK_H);
            robot.keyRelease(KeyEvent.VK_U);
            robot.keyRelease(KeyEvent.VK_T);
            robot.keyRelease(KeyEvent.VK_D);
            robot.keyRelease(KeyEvent.VK_O);
            robot.keyRelease(KeyEvent.VK_W);
            robot.keyRelease(KeyEvent.VK_N);

            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyPress(KeyEvent.VK_MINUS);

            robot.keyRelease(KeyEvent.VK_SPACE);
            robot.keyRelease(KeyEvent.VK_SPACE);
            robot.keyRelease(KeyEvent.VK_MINUS);

            robot.keyPress(KeyEvent.VK_S);
            robot.keyRelease(KeyEvent.VK_S);

            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyPress(KeyEvent.VK_MINUS);

            robot.keyRelease(KeyEvent.VK_SPACE);
            robot.keyRelease(KeyEvent.VK_SPACE);
            robot.keyRelease(KeyEvent.VK_MINUS);

            robot.keyPress(KeyEvent.VK_T);
            robot.keyRelease(KeyEvent.VK_T);

            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyRelease(KeyEvent.VK_SPACE);
            robot.keyRelease(KeyEvent.VK_SPACE);

            robot.keyPress(KeyEvent.VK_1);
            robot.keyRelease(KeyEvent.VK_1);
//            robot.keyPress(KeyEvent.VK_X);
//            robot.keyRelease(KeyEvent.VK_X);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            System.out.println("A");

        }
        public static int[] getNumberFormKeyboardArray(int[] arr){
            //参数合法性判断
            if (null == arr || arr.length == 0) {
                System.out.println("传入参数不合法");
                return null;
            }
            Scanner sc = new Scanner(System.in);
            for (int i = 0 ; i < arr.length ; i++) {
                arr[i] = sc.nextInt();
            }
            return arr;

    }
}
