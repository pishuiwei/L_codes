package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * MySQL连接池
 * @author Pw
 * 2017-10-15
 *
 */
public class MyPool {

	/**
	 * 用于保存连接
	 */
	private LinkedList<Connection> connList = new LinkedList<Connection>();
	
	/**
	 * 计算连接对象的数量
	 */
	private int currentSize = 0;
	
	/**
	 * 声明MyPool对象时候自动注册驱动
	 */
	static {
		try {
			Class.forName(JDBCConstant.JDBC_DRIVE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 连接数据库
	 * @return Connection
	 */
	private Connection getConnection() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(JDBCConstant.URL, JDBCConstant.USER, JDBCConstant.PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public MyPool() {
		for(int i = 0; i < JDBCConstant.INIT_SIZE; i ++) {
			Connection connection = getConnection();
			connList.add(connection);
			currentSize++;
		}
	}
	
	/**
	 * 获取连接池中的一个连接对象 
	 * @return
	 */
	public Connection getConnFromPool() {
		//当连接还没空的时候就获取
		if (connList.size()!=0) {
			Connection connection = connList.getFirst();
			connList.removeFirst();
			return connection;
		} else if (connList.size() == 0 && currentSize < 8) {
			//当连接池被拿空,且连接数没有到达上限,创建新的连接
			currentSize++;
			connList.addLast(getConnection());
			Connection connection = connList.getFirst();
			connList.removeFirst();
			return connection;
		} 
		throw new RuntimeException("连接数达到上限，请等待");
	}
	
	/**
	 * 把用完的连接返回连接池
	 * @param connection
	 */
	public void releaseConnection(Connection connection) {
		connList.addLast(connection);
	}
}
