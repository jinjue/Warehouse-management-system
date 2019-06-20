package w_m;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Look_Over extends JFrame {//查看界面

	private JPanel contentPane;
	private JScrollPane scpDemo;  
	private JTableHeader jth;  
	private JTable tabDemo;  
	private JButton btnShow; 
	Function f1=new Function();
	Connection dbConn = null;
	public Look_Over(String table) {
		// 窗体的相关属性的定义
		super("查询货物信息");
		this.setSize(640,400);
		this.setLayout(null);
		this.setLocation(100,50);
		// 创建组件
		this.scpDemo = new JScrollPane();
		this.scpDemo.setBounds(10,50,600,270);
		/*this.btnShow = new JButton("显示数据");
		this.btnShow.setBounds(200,10,200,30);
		
		this.btnShow.addActionListener(new ActionListener(){//按钮的点击事件;查询
			   public void actionPerformed(ActionEvent ae){
			     btnShow_ActionPerformed(ae,table);
			   }
			});*/
		add(this.scpDemo);// 将组件加入到窗体中
		//add(this.btnShow);
		
		this.setVisible(true);// 显示窗体
	/*}
	public void btnShow_ActionPerformed(ActionEvent ae,String table){*/
		// 连接数据源和显示数据的具体处理方法
			String driverName =("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=WM"; // 1433是端口，"USCSecondhandMarketDB"是数据库名称
			String userName = "sa"; // 用户名
			String userPwd = "zj923326"; 
			
		try{
			dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
			String sql = "select * from "+table; // 建立查询条件
			PreparedStatement pstm = dbConn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();// 执行查询
			
			int count = 0;// 计算有多少条记录
			while(rs.next()){
			   count++;
			}
			rs = pstm.executeQuery();
			Object[][] info  ;
			if(table.equals("C")) {
				   info=new Object[count][4];// 将查询获得的记录数据，转换成适合生成JTable的数据形式
				   count = 0;
					while(rs.next()){
						info[count][0] = rs.getString("Cno");
						info[count][1] = rs.getString("Cname");
						info[count][2] = Integer.valueOf( rs.getInt("Ccap") );
						info[count][3] = rs.getString("Cadd");
						count++;
					}
					
					String[] title = {"仓库编号","仓库名称","  仓库容量 ","仓库地址"};// 定义表头
					this.tabDemo = new JTable(info,title);// 创建JTable
			   }
			if(table.equals("Manager")){
				   info=new Object[count][7];// 将查询获得的记录数据，转换成适合生成JTable的数据形式
				   count = 0;
					while(rs.next()){
						info[count][0] = rs.getString("Mno");
						info[count][1] = rs.getString("Mname");
						info[count][2] = rs.getString("Msex");
						info[count][3] = Integer.valueOf( rs.getInt("Mage") );
						info[count][4] = rs.getString("MLeader");
						info[count][5] = rs.getString("Mtel");
						info[count][6] = rs.getString("Mpassword");
						count++;
					}
					
					String[] title = {"管理员编号","姓名","性别","年龄","电话号码","密码"};// 定义表头
					this.tabDemo = new JTable(info,title);// 创建JTable
			   }
				
			if(table.equals("G")){
				   info=new Object[count][5];// 将查询获得的记录数据，转换成适合生成JTable的数据形式
				   count = 0;
					while(rs.next()){
						info[count][0] = rs.getString("Gno");
						info[count][1] = rs.getString("Gname");
						info[count][2] = rs.getString("Gadd");
						info[count][3] = rs.getString("Gtel");
						info[count][4] = rs.getString("Gcom");
						count++;
					}
					
					String[] title = {"供应商编号","联系人","地址","电话号码","名称"};// 定义表头
					this.tabDemo = new JTable(info,title);// 创建JTable
			   }
			if(table.equals("H")){
				   info=new Object[count][5];// 将查询获得的记录数据，转换成适合生成JTable的数据形式
				   count = 0;
					while(rs.next()){
						info[count][0] = rs.getString("Hno");
						info[count][1] = rs.getString("Hname");
						info[count][2] = rs.getString("Htype");
						info[count][3] = Integer.valueOf( rs.getInt("Hnum") );
						info[count][4] = Integer.valueOf( rs.getInt("Hprice") );
						count++;
					}
					
					String[] title = {"货物编号","货物名称","货物类型","货物数量","货物单价"};// 定义表头
					this.tabDemo = new JTable(info,title);// 创建JTable
			   }
			if(table.equals("K")){
				   info=new Object[count][5];// 将查询获得的记录数据，转换成适合生成JTable的数据形式
				   count = 0;
					while(rs.next()){
						info[count][0] = String.valueOf(rs.getString("Kno"));
						info[count][1] = String.valueOf(rs.getString("Kname"));
						info[count][2] = String.valueOf(rs.getString("Ksex"));
						info[count][3] = String.valueOf(rs.getString("Ktel"));
						info[count][4] = String.valueOf(rs.getString("Kadd"));
						count++;
					}
					
					String[] title = {"客户编号","姓名","性别","电话号码","地址"};// 定义表头
					this.tabDemo = new JTable(info,title);// 创建JTable
			    }
			if(table.equals("Management")){
					   info=new Object[count][4];// 将查询获得的记录数据，转换成适合生成JTable的数据形式
					   count = 0;
						while(rs.next()){
							info[count][0] = rs.getString("Cno");
							info[count][1] = rs.getString("Mno");
							info[count][2] = rs.getString("Mname");
							info[count][3] = rs.getString("Mtime");
							count++;
						}
						
						String[] title = {"仓库编号","管理员编号","姓名","工作时间段"};// 定义表头
						this.tabDemo = new JTable(info,title);// 创建JTable
				}
			if(table.equals("S")){
					   info=new Object[count][5];// 将查询获得的记录数据，转换成适合生成JTable的数据形式
					   System.out.println(count);count = 0;
					   
						while(rs.next()){
							info[count][0] = rs.getString("Gno");
							info[count][1] = rs.getString("Cno");
							info[count][2] = rs.getString("Hno");
							info[count][3] = Integer.valueOf( rs.getInt("Snum") );
							info[count][4] =String.valueOf(rs.getString("Stime"));
							count++;
						}
						
						String[] title = {"供应商编号","仓库编号","货物编号","供应量","供应时间"};// 定义表头
						this.tabDemo = new JTable(info,title);// 创建JTable
				}
			if(table.equals("I")){
					   info=new Object[count][6];// 将查询获得的记录数据，转换成适合生成JTable的数据形式
					   count = 0;
						while(rs.next()){
							
							info[count][0] = rs.getString("Ino");
							info[count][1] = rs.getString("Hno");
							info[count][2] = rs.getString("Cno");
							info[count][3] = Integer.valueOf( rs.getInt("Inum") );
							info[count][4] = rs.getString("Mno");
							info[count][5] = String.valueOf(rs.getString("Itime"));
							count++;
						}
						
						String[] title = {"入库单号","货物编号","仓库编号","入库量","管理员编号","入库时间"};// 定义表头
						this.tabDemo = new JTable(info,title);// 创建JTable
				}
			if(table.equals("O")){
					   info=new Object[count][7];// 将查询获得的记录数据，转换成适合生成JTable的数据形式
					   count = 0;
						while(rs.next()){
							info[count][0] = rs.getString("Ono");
							info[count][1] = rs.getString("Hno");
							info[count][2] = rs.getString("Cno");
							info[count][3] = Integer.valueOf( rs.getInt("Onum") );
							info[count][4] = rs.getString("Mno");
							info[count][5] = rs.getString("Kno");
							info[count][6] = String.valueOf(rs.getString("Otime"));
							count++;
						}
						
						String[] title = {"出库单号","货物编号","仓库编号","出库量","管理员编号","客户编号","出库时间"};// 定义表头
						this.tabDemo = new JTable(info,title);// 创建JTable
				}
			if(table.equals("BR")){
					   info=new Object[count][7];// 将查询获得的记录数据，转换成适合生成JTable的数据形式
					   count = 0;
						while(rs.next()){
							info[count][0] = rs.getString("Jno");
							info[count][1] = rs.getString("Kno");
							info[count][2] = rs.getString("Hno");
							info[count][3] = Integer.valueOf( rs.getInt("Bnum") );
							info[count][4] = Integer.valueOf( rs.getInt("Rnum") );
							info[count][5] =String.valueOf(rs.getString("Btime"));
							info[count][6] = String.valueOf(rs.getString("Rtime"));
							count++;
						}
						
						String[] title = {"货物编号","客户编号","客户编号","租借量","归还量","借出时间","归还时间"};// 定义表头
						this.tabDemo = new JTable(info,title);// 创建JTable
				}
			if(table.equals("Limit")) {
			   info=new Object[count][5];// 将查询获得的记录数据，转换成适合生成JTable的数据形式
			   count = 0;
				while(rs.next()){
					info[count][0] = rs.getString("Hno");
					info[count][1] = rs.getString("Cno");
					info[count][2] = Integer.valueOf( rs.getInt("Lmin") );
					info[count][3] = Integer.valueOf( rs.getInt("Lmax") );
					info[count][4] = Integer.valueOf( rs.getInt("Cinv") );
					count++;
				}
				
				String[] title = {"货物编号","仓库编号","最小值","最大值","库存量"};// 定义表头
				this.tabDemo = new JTable(info,title);// 创建JTable
		}
			
			this.jth = this.tabDemo.getTableHeader();// 显示表头
			
			this.scpDemo.getViewport().add(tabDemo); // 将JTable加入到带滚动条的面板中
		}
		catch(SQLException sqle){
		    JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
