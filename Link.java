package w_m;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Link {//�������ݿ⣬�Ե�¼���û�����������бȽ��ж�
	public int getConnectionSqlServer(String user,String password) {
		 
		String driverName =("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=WM"; // 1433�Ƕ˿ڣ�"USCSecondhandMarketDB"�����ݿ�����
		String userName = "sa"; // �û���
		String userPwd = "zj923326"; // ����
 
		Connection dbConn = null;
		try {
			dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
			System.out.println("�ɹ��������ݿ⣡");
			String sql = "select * from Manager"; // ������ѯ����
			PreparedStatement pstm = dbConn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();// ִ�в�ѯ
			
			int count = 0;// �����ж�������¼
			while(rs.next()){
			   count++;
			}
			rs = pstm.executeQuery();
			Object[][] info  ;
			String s="Manager";
			
			if(s.equals("Manager")) {
				info=new Object[count][2];// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
