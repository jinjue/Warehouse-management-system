package w_m;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Link {//连接数据库，对登录的用户名和密码进行比较判断
	public int getConnectionSqlServer(String user,String password) {
		 
		String driverName =("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=WM"; // 1433是端口，"USCSecondhandMarketDB"是数据库名称
		String userName = "sa"; // 用户名
		String userPwd = "zj923326"; // 密码
 
		Connection dbConn = null;
		try {
			dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
			System.out.println("成功连接数据库！");
			String sql = "select * from Manager"; // 建立查询条件
			PreparedStatement pstm = dbConn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();// 执行查询
			
			int count = 0;// 计算有多少条记录
			while(rs.next()){
			   count++;
			}
			rs = pstm.executeQuery();
			Object[][] info  ;
			String s="Manager";
			
			if(s.equals("Manager")) {
				info=new Object[count][2];// 将查询获得的记录数据，转换成适合生成JTable的数据形式
				   count = 0;
					while(rs.next()){
						info[count][0] = rs.getString("Mname");
						info[count][1] = rs.getString("Mpassword");
						count++;
			        }
					int c=0;
					while(c!=count){
		                if(user.equals(info[c][0])&&password.equals(info[c][1])) {
		                	return 1;
		                }
		                c++;
					}
			}		
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
 
			try {
				if (dbConn != null)
					dbConn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
}
