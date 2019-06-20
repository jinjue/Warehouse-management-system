package w_m;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Return extends JFrame implements ActionListener {//归还

	private JPanel contentPane;
	private JTable tabDemo;
	private JTableHeader jth;
	private JTextField Jno,Rnum;
	private JScrollPane scpDemo; 
	JLabel label,label_1;
	JButton button;
	Function f1=new Function();

	String driverName =("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=WM"; // 1433是端口，"USCSecondhandMarketDB"是数据库名称
	String userName = "sa"; // 用户名
	String userPwd = "zj923326"; 
	Connection dbConn = null;
	public Return() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("\u501F\u8D27\u5355\u53F7");
		label.setBounds(37, 15, 81, 21);
		contentPane.add(label);
		
		Jno = new JTextField();
		Jno.setBounds(121, 12, 267, 27);
		contentPane.add(Jno);
		Jno.setColumns(10);
		
		label_1 = new JLabel("\u5F52\u8FD8\u6570\u91CF");
		label_1.setBounds(37, 61, 81, 21);
		contentPane.add(label_1);
		
		Rnum = new JTextField();
		Rnum.setBounds(121, 58, 267, 27);
		contentPane.add(Rnum);
		Rnum.setColumns(10);
		
		button = new JButton("\u5F52\u8FD8");
		button.setBounds(572, 98, 123, 29);
		contentPane.add(button);
		button.addActionListener(this);
		
		this.scpDemo = new JScrollPane();
		this.scpDemo.setBounds(30,192,663,256);
		getContentPane().add(this.scpDemo);
		
		try {
			dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e){
		f1.fun7(dbConn,Jno.getText(),Integer.valueOf(Rnum.getText()));
		String sql = "select * from BR"; // 建立查询条件
		PreparedStatement pstm;
		try {
			pstm = dbConn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();// 执行查询
			
			int count = 0;// 计算有多少条记录
			while(rs.next()){
			   count++;
			}
			rs = pstm.executeQuery();
			Object[][] info  ;
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
			this.jth = this.tabDemo.getTableHeader();// 显示表头
			this.scpDemo.setViewportView(tabDemo);
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}		
	}
}
