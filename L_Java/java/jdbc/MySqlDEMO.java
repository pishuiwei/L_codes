package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlDEMO {
	// JDBC 椹卞姩鍚嶅強鏁版嵁搴� URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/test";
 
    // 鏁版嵁搴撶殑鐢ㄦ埛鍚嶄笌瀵嗙爜锛岄渶瑕佹牴鎹嚜宸辩殑璁剧疆
    static final String USER = "root";
    static final String PASS = "123456";
 
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            // 娉ㄥ唽 JDBC 椹卞姩
            Class.forName("com.mysql.jdbc.Driver");
        
            // 鎵撳紑閾炬帴
            System.out.println("杩炴帴鏁版嵁搴�...");
            conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
        
            // 鎵ц鏌ヨ
            System.out.println(" 瀹炰緥鍖朥ser瀵�...");
            stmt = (Statement) conn.createStatement();
            String sql;
            sql = "SELECT id, name FROM user";
            ResultSet rs = stmt.executeQuery(sql);
        
            // 灞曞紑缁撴灉闆嗘暟鎹簱
            while(rs.next()){
                // 閫氳繃瀛楁妫�绱�
                int id  = rs.getInt("id");
                String name = rs.getString("name");
    
                // 杈撳嚭鏁版嵁
                System.out.print("ID: " + id);
                System.out.print(", 绔欑偣鍚嶇О: " + name);
                System.out.print("\n");
            }
            // 瀹屾垚鍚庡叧闂�
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 澶勭悊 JDBC 閿欒
            se.printStackTrace();
        }catch(Exception e){
            // 澶勭悊 Class.forName 閿欒
            e.printStackTrace();
        }finally{
            // 鍏抽棴璧勬簮
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 浠�涔堥兘涓嶅仛
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
