package jdbc;

/**
 * 连接数据库的常量
 * @author Pw
 * 2017-10-15
 *
 */
public final class JDBCConstant {
	/** */
	public static String JDBC_DRIVE = "com.mysql.jdbc.Driver";
	public static String URL = "jdbc:mysql://localhost:3306/test";
	public static String USER = "root";
	public static String PASS = "123456";
	
	/**
	 * 连接池初始连接个数
	 */
	public static int INIT_SIZE = 5;
	
	/**
	 * 连接池最大连接个数
	 */
	public static int MAX_SIZE = 8;
}
