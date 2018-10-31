package jdbc;

import java.sql.*;

public class JDBCBean {
	
	public static void main(String[] args) {
		JDBCBean jdbcBean = new JDBCBean(); 
		jdbcBean.get();
	}

	/*JDBC 驱动名及数据库 URL*/
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/test";

	/*连接数据库时候需要额用户名以及密码*/
	private static final String USER = "root";
	private static final String PASS = "123456";

	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	public void get(){
		try {
			/*注册JDBC驱动*/
			Class.forName(JDBC_DRIVER);
			
			/*打开一个连接*/
			System.out.println("连接数据库...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);

            /*执行查询*/
            stmt = conn.createStatement();
            
            /*执行sql语句*/
            String sql;
            sql = "SELECT * FROM user";
            rs = stmt.executeQuery(sql);
            
            System.out.println("查询结果...");
            while(rs.next()){
            	int id = rs.getInt("id");
            	String name = rs.getString("name");
            	String pass = rs.getString("pass");
            	
            	System.out.print("id: "+id+"\t");
            	System.out.print("name: "+name+"\t");
            	System.out.print("pass: "+pass+"\n");
            }
            /*完成后关闭,先开后关闭*/
            rs.close();
            stmt.close();
            conn.close();
		} catch (SQLException e) {
			e.printStackTrace();//处理连接异常
		} catch (ClassNotFoundException e) {
			e.printStackTrace();//处理注册异常
		}finally {
			if (stmt!=null){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}







