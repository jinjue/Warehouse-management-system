package w_m;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;

public class DownLag extends JFrame {//查询界面

	protected static JScrollPane scrollPane;
	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=225,14
	 */
	private final JTextField 入库 = new JTextField();
	private JTextField Ino,Ono,Hno,Itime;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	protected JTable tabDemo;
	protected JTableHeader jth;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DownLag frame = new DownLag();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	String driverName =("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=WM"; // 1433是端口，"USCSecondhandMarketDB"是数据库名称
	String userName = "sa"; // 用户名
	String userPwd = "zj923326"; 
	Connection dbConn = null;
	public DownLag() {
		try {
			dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		入库.setColumns(10);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 683, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 43, 111, 23);
		contentPane.add(menuBar);
		
		JMenu menu = new JMenu("入库单号");
		menuBar.add(menu);
		
		textField = new JTextField();
		textField.setBounds(126, 43, 155, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		Ino=textField;
		
		JButton btnI = new JButton("I20190619200700");
		btnI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("入库单号"));
				textField.setText(btnI.getText());
				
			}
			
		});
		menu.add(btnI);
		
		JButton btnI_1 = new JButton("I20190619200713");
		btnI_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("入库单号"));
				textField.setText(btnI_1.getText());
			}
			
		});
		menu.add(btnI_1);
		
		JButton btnI_2 = new JButton("I20190619200718");
		btnI_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("入库单号"));
				textField.setText(btnI_2.getText());
			}
			
		});
		menu.add(btnI_2);
		
		JButton btnI_3 = new JButton("I20190619200722");
		btnI_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("入库单号"));
				textField.setText(btnI_3.getText());
			}
			
		});
		menu.add(btnI_3);
		
		JButton btnI_4 = new JButton("I20190619200726");
		btnI_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("入库单号"));
				textField.setText(btnI_4.getText());
			}
			
		});
		menu.add(btnI_4);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(10, 76, 111, 23);
		contentPane.add(menuBar_1);
		
		JMenu menu_1 = new JMenu("出库单号");
		menuBar_1.add(menu_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(126, 74, 155, 21);
		contentPane.add(textField_1);
		Ono=textField_1;
		
		JButton btnO = new JButton("O20190619200747");
		btnO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("出库单号"));
				textField_1.setText(btnO.getText());
			}
			
		});
		menu_1.add(btnO);
		
		JButton btnO_1 = new JButton("O20190619200750");
		btnO_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("出库单号"));
				textField_1.setText(btnO_1.getText());
			}
			
		});
		menu_1.add(btnO_1);
		
		JButton btnO_2 = new JButton("O20190619200753");
		btnO_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("出库单号"));
				textField_1.setText(btnO_2.getText());
			}
			
		});
		menu_1.add(btnO_2);
		
		JButton btnO_3 = new JButton("O20190619200756");
		btnO_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("出库单号"));
				textField_1.setText(btnO_3.getText());
			}
			
		});
		menu_1.add(btnO_3);
		
		JButton btnO_4 = new JButton("O20190619200780");
		btnO_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("出库单号"));
				textField_1.setText(btnO_4.getText());
			}
			
		});
		menu_1.add(btnO_4);
		
		JMenuBar menuBar_2 = new JMenuBar();
		menuBar_2.setBounds(10, 109, 111, 23);
		contentPane.add(menuBar_2);
		
		JMenu menu_2 = new JMenu("货物");
		menuBar_2.add(menu_2);
		
		JButton btnV = new JButton("V0009");
		btnV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("货物"));
				textField_2.setText(btnV.getText());
			}
			
		});
		menu_2.add(btnV);
		
		JButton btnV_1 = new JButton("V0023");
		btnV_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("货物"));
				textField_2.setText(btnV_1.getText());
			}
			
		});
		menu_2.add(btnV_1);
		
		JButton btnV_2 = new JButton("V0003");
		btnV_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("货物"));
				textField_2.setText(btnV_2.getText());
			}
			
		});
		menu_2.add(btnV_2);
		
		JButton btnV_3 = new JButton("V0008");
		btnV_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("货物"));
				textField_2.setText(btnV_3.getText());
			}
			
		});
		menu_2.add(btnV_3);
		
		JButton btnV_4 = new JButton("V0090");
		btnV_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("货物"));
				textField_2.setText(btnV_4.getText());
			}
			
		});
		menu_2.add(btnV_4);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(126, 109, 155, 21);
		contentPane.add(textField_2);
		Hno=textField_2;
		
		JMenuBar menuBar_3 = new JMenuBar();
		menuBar_3.setBounds(10, 140, 111, 23);
		contentPane.add(menuBar_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(126, 142, 155, 21);
		contentPane.add(textField_3);
		Itime=textField_3;
		
		JMenu menu_3 = new JMenu("时间");
		menuBar_3.add(menu_3);
		
		JButton btnNewButton = new JButton("2019-06-19 20:07:00.213");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("时间"));
				textField_3.setText(btnNewButton.getText());
			}
		});
		menu_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("2019-06-19 20:07:13.667");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("时间"));
				textField_3.setText(btnNewButton_1.getText());
			}
		});
		menu_3.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("2019-06-19 20:07:18.507");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("时间"));
				textField_3.setText(btnNewButton_2.getText());
			}
		});
		menu_3.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("2019-06-19 20:07:22.987");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("时间"));
				textField_3.setText(btnNewButton_3.getText());
			}
		});
		menu_3.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("2019-06-19 20:07:26.527");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("时间"));
				textField_3.setText(btnNewButton_4.getText());
			}
		});
		menu_3.add(btnNewButton_4);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 225, 649, 173);
		contentPane.add(scrollPane);
		
		JLabel label = new JLabel("\u67E5\u8BE2\u7ED3\u679C");
		label.setBounds(300, 178, 155, 31);
		contentPane.add(label);
		
		JButton button = new JButton("\u786E\u8BA4");
		button.setBounds(440, 43, 97, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "select * from I where Ino='"+Ino.getText()+"'"; // 建立查询条件
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
					}String[] title = {"入库单号","货物编号","仓库编号","入库量","管理员编号","入库时间"};// 定义表头
					tabDemo = new JTable(info,title);// 创建JTable
					jth = tabDemo.getTableHeader();// 显示表头
					textField.setText(null);
					scrollPane.setViewportView(tabDemo);
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				
			}
			}
			
		});
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u786E\u8BA4");
		button_1.setBounds(440, 73, 97, 23);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String sql = "select * from O where Ono='"+Ono.getText()+"'"; // 建立查询条件
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
					tabDemo = new JTable(info,title);// 创建JTable
				    jth = tabDemo.getTableHeader();// 显示表头
				    textField_1.setText(null);
					scrollPane.setViewportView(tabDemo);
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				
			}
			}
			
		});
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u786E\u8BA4");
		button_2.setBounds(440, 108, 97, 23);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "select * from H where Hno='"+Hno.getText()+"'"; // 建立查询条件
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
						
						String[] title = {"货物编号","货物名称","货物类型","货物数量","货物单价"};
						tabDemo = new JTable(info,title);// 创建JTable
					    jth = tabDemo.getTableHeader();// 显示表头
					    textField_2.setText(null);
					scrollPane.setViewportView(tabDemo);
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				
			}
			}
			
		});
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("\u786E\u8BA4");
		button_3.setBounds(440, 140, 97, 23);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "select * from I where Itime='"+Itime.getText()+"'"; // 建立查询条件
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
						tabDemo = new JTable(info,title);// 创建JTable
					    jth = tabDemo.getTableHeader();// 显示表头
					    textField_3.setText(null);
					scrollPane.setViewportView(tabDemo);
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				
			}
			}
			
		});
		contentPane.add(button_3);
		
		
	}
}
