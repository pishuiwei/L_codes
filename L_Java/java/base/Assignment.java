package base;

/**
 * <p>显示了'别名'问题,类中的
 * <p>在对象tank2赋值给tank1时相当于给tank2创建了一个别名tank1,对象tank1的值改变这tank2的值也会改变;
 * <p>tank1.level = tank2.level,这样直接使用对象可以避免别名问题
 * @author PP 
 *
 */
public class Assignment {
	
	public static void main(String[] args) {
		Tank tank1 = new Tank();
		Tank tank2 = new Tank();
		tank1.level = 13;
		tank2.level = 47;
		
		System.out.println("1: tank1.level: " + tank1.level + "\t" +"tank2.level: " + tank2.level);
		
		tank1 = tank2;
		System.out.println("2: tank1.level: " + tank1.level + "\t" +"tank2.level: " + tank2.level);
		
		tank1.level = 27;
		System.out.println("3: tank1.level: " + tank1.level + "\t" +"tank2.level: " + tank2.level);
	
	}
}

class Tank{
	int level;
}