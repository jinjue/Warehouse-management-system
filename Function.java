package w_m;


import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Function {

	public static Connection fun1() {//�������ݿ�
    	Connection conn = null;
    	try {
    		String driverName =("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=WM"; // 1433�Ƕ˿ڣ�"USCSecondhandMarketDB"�����ݿ�����
    		String userName = "sa"; // �û���
    		String userPwd = "zj923326"; // ����
    		
            conn=DriverManager.getConnection(dbURL, userName, userPwd);
            System.out.println("�������ݿ�ɹ�");
    	} 
    	catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }	
    	return conn;
    }
	public static int i=1;
	public static void fun2(Connection conn,String Hno,int Onum,String Cno) {//����
		try
		{
		    Statement s = conn.createStatement();//����һ��Statement����
			
			String sql="insert into O values('O'+replace(replace(replace(convert(nvarchar,getdate(),120),'-',''),' ',''),':',''),'"+Hno+"','"+Cno+"',"+Onum+",'A917181103','K4362612',GETDATE())" ;
			
			s.executeUpdate(sql);//ִ��sql���
		} catch (SQLException e)
		{
			e.printStackTrace();
			
		}
		System.out.println("����ɹ�");
	}
	public static void fun3(Connection conn,String Hno,int Inum,String Cno,String Mno) {
		try
		{
		    Statement s = conn.createStatement();//����һ��Statement����
			
			String sql="insert into I values('I'+replace(replace(replace(convert(nvarchar,getdate(),120),'-',''),' ',''),':',''),'"+Hno+"','"+Cno+"',"+Inum+",'"+Mno+"',GETDATE())" ;
			
			s.executeUpdate(sql);//ִ��sql���
		} catch (SQLException e)
		{
			e.printStackTrace();
			
		}
		System.out.println("���ɹ�");
	}
	public static void fun6(Connection conn,String Kno,String Hno,int Inum) {
		try
		{
		    Statement s = conn.createStatement();//����һ��Statement����
			
			String sql="insert into BR values('O'+replace(replace(replace(convert(nvarchar,getdate(),120),'-',''),' ',''),':',''),'"+Kno+"','"+Hno+"',"+Inum+",0,'2019/5/2 08:45:47.673',NULL)" ;
			
			s.executeUpdate(sql);//ִ��sql���
		} catch (SQLException e)
		{
			e.printStackTrace();
			
		}
		System.out.println("����ɹ�");
	}
	public static void fun7(Connection conn,String Jno,int Rnum) {
		try
		{
		    Statement s = conn.createStatement();//����һ��Statement����
			
			String sql="execute huanhuo @Jno='"+Jno+" ' ,@Rnum="+Rnum+"" ;
			
			s.executeUpdate(sql);//ִ��sql���
		} catch (SQLException e)
		{
			e.printStackTrace();
			
		}
		System.out.println("�黹�ɹ�");
	}
	public static void fun4(Connection conn,String sql4) {
	    	
			try
			{
				Statement stmt = conn.createStatement();
		        stmt.executeUpdate(sql4);//ִ��sql���
			} catch (SQLException e)
			{
				
				e.printStackTrace();
			}	
			System.out.println("�޸ĵ����ݿ�ɹ�");
	}
	public static void fun5(Connection conn,String sql5) {
	    	
			try
			{
				Statement stmt = conn.createStatement();
	            stmt.executeUpdate(sql5);//ִ��sql���
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			System.out.println("ɾ�������ݿ�ɹ�");	
	    }


			
}
