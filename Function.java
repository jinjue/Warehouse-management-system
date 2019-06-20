package w_m;


import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Function {

	public static Connection fun1() {//连接数据库
    	Connection conn = null;
    	try {
    		String driverName =("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=WM"; // 1433是端口，"USCSecondhandMarketDB"是数据库名称
    		String userName = "sa"; // 用户名
    		String userPwd = "zj923326"; // 密码
    		
            conn=DriverManager.getConnection(dbURL, userName, userPwd);
            System.out.println("连接数据库成功");
    	} 
    	catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }	
    	return conn;
    }
	public static int i=1;
	public static void fun2(Connection conn,String Hno,int Onum,String Cno) {//出库
		try
		{
		    Statement s = conn.createStatement();//创建一个Statement对象
			
			String sql="insert into O values('O'+replace(replace(replace(convert(nvarchar,getdate(),120),'-',''),' ',''),':',''),'"+Hno+"','"+Cno+"',"+Onum+",'A917181103','K4362612',GETDATE())" ;
			
			s.executeUpdate(sql);//执行sql语句
		} catch (SQLException e)
		{
			e.printStackTrace();
			
		}
		System.out.println("出库成功");
	}
	public static void fun3(Connection conn,String Hno,int Inum,String Cno,String Mno) {
		try
		{
		    Statement s = conn.createStatement();//创建一个Statement对象
			
			String sql="insert into I values('I'+replace(replace(replace(convert(nvarchar,getdate(),120),'-',''),' ',''),':',''),'"+Hno+"','"+Cno+"',"+Inum+",'"+Mno+"',GETDATE())" ;
			
			s.executeUpdate(sql);//执行sql语句
		} catch (SQLException e)
		{
			e.printStackTrace();
			
		}
		System.out.println("入库成功");
	}
	public static void fun6(Connection conn,String Kno,String Hno,int Inum) {
		try
		{
		    Statement s = conn.createStatement();//创建一个Statement对象
			
			String sql="insert into BR values('O'+replace(replace(replace(convert(nvarchar,getdate(),120),'-',''),' ',''),':',''),'"+Kno+"','"+Hno+"',"+Inum+",0,'2019/5/2 08:45:47.673',NULL)" ;
			
			s.executeUpdate(sql);//执行sql语句
		} catch (SQLException e)
		{
			e.printStackTrace();
			
		}
		System.out.println("借出成功");
	}
	public static void fun7(Connection conn,String Jno,int Rnum) {
		try
		{
		    Statement s = conn.createStatement();//创建一个Statement对象
			
			String sql="execute huanhuo @Jno='"+Jno+" ' ,@Rnum="+Rnum+"" ;
			
			s.executeUpdate(sql);//执行sql语句
		} catch (SQLException e)
		{
			e.printStackTrace();
			
		}
		System.out.println("归还成功");
	}
	public static void fun4(Connection conn,String sql4) {
	    	
			try
			{
				Statement stmt = conn.createStatement();
		        stmt.executeUpdate(sql4);//执行sql语句
			} catch (SQLException e)
			{
				
				e.printStackTrace();
			}	
			System.out.println("修改到数据库成功");
	}
	public static void fun5(Connection conn,String sql5) {
	    	
			try
			{
				Statement stmt = conn.createStatement();
	            stmt.executeUpdate(sql5);//执行sql语句
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			System.out.println("删除到数据库成功");	
	    }


			
}
