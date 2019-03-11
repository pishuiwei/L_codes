//import java.awt.*;
//
//
///**
// * 用于临时书写
// *
// * @author PW 2018/03/18
// *
// */
//public class Test {
//	public final int x, y;
//
//	public Test(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//
//	public static void main(String[] args) throws AWTException {
//
//		Throwable d;
//
////        // 创建机器人
////        Robot robot = new Robot();
////        // 设置默认休眠时间
////        robot.setAutoDelay(300);
////        robot.mouseMove(400, 100);
////        robot.mousePress(MouseEvent.BUTTON2_MASK);
////        robot.delay(20);
////        robot.mouseRelease(MouseEvent.BUTTON2_MASK);
//
//	/*	BigInteger p = BigInteger.ONE;
//
//		System.out.println(p.nextProbablePrime());*/
//
//	}
//
//	public static void t(int[] data) {
//		int temp;
//		int i;
//		for (i = 0; i < data.length; i++) {
//			for (int j = 0; j < data.length - i - 1; j++) {
//				if (data[j] > data[j+1]) {
//					temp = data[j+1];
//					data[j+1] = data[j];
//					data[j] = temp;
//				}
//			}
//		}
//	}
//
//	/**
//	 * 一瓶啤酒2元，4个瓶盖可以换1瓶啤酒，2两个瓶盖也可以换1瓶啤酒，问10元可以喝多少瓶啤酒？
//	 * @param money
//	 */
//	public static void drink(int money) {
//		int sum = money / 2;
//		int cup = sum; // 瓶盖
//		int bottle = sum; // 空瓶
//
//		while(cup >= 4 || bottle >= 2) {
//			int i = cup;
//			sum = sum + (i / 4); // 买来的加上兑换的啤酒
//			cup = (i / 4) + (i % 4); // 瓶盖等于 剩余的加上兑换的啤酒中的瓶盖
//			bottle = bottle +  (i / 4); // 空瓶等于买来喝完的加上兑换喝完的
//
//			int b = bottle;
//			sum = sum + (b /2); // 总数等于前面剩下的加上空瓶兑换的
//			bottle = (b / 2) + (b % 2); // 空瓶等于剩下的加上兑换的
//			cup = cup + (b / 2); // 瓶盖等于剩下的加上空瓶兑换的
//		}
//		System.out.println(money+ "元"+"能喝" + sum +"瓶啤酒");
//		System.out.println("剩余"+cup+"个瓶盖," + bottle + "个空瓶");
//
//	}
//
//}
//
//
//
//
