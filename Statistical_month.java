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

public class Statistical_month extends JFrame implements ActionListener {//���²�ѯ

	private JPanel contentPane;
	private JTable tabDemo;
	private JTableHeader jth;
	private JTextField Itime;
	private JScrollPane scpDemo; 
	JLabel label;
	JButton button;
	Function f1=new Function();
	
	String driverName =("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=WM"; // 1433�Ƕ˿ڣ�"USCSecondhandMarketDB"�����ݿ�����
	String userName = "sa"; // �û���
	String userPwd = "zj923326"; 
	Connection dbConn = null;
	public Statistical_month() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("\u6708\u4EFD");
		label.setBounds(35, 87, 81, 21);
		contentPane.add(label);
		
		Itime = new JTextField();
		Itime.setBounds(121, 84, 137, 27);
		contentPane.add(Itime);
		Itime.setColumns(10);
		
		button = new JButton("\u7EDF\u8BA1");
		button.setBounds(530, 83, 123, 29);
		contentPane.add(button);
		button.addActionListener(this);
		
		this.scpDemo = new JScrollPane();
		this.scpDemo.setBounds(33,220,663,228);
		getContentPane().add(this.scpDemo);
		try {
			dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e) {
		String sql = "select * from I where month(Itime)= "+Itime.getText(); // ������ѯ����
		PreparedStatement pstm;
		try {
			pstm = dbConn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();// ִ�в�ѯ
			
			int count = 0;// �����ж�������¼
			while(rs.next()){
			   count++;
			}
			rs = pstm.executeQuery();
			Object[][] info  ;
			info=new Object[count][6];// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
				
				String[] title = {"��ⵥ��","������","�ֿ���","�����","����Ա���","���ʱ��"};// �����ͷ
			this.tabDemo = new JTable(info,title);// ����JTable
			this.jth = this.tabDemo.getTableHeader();// ��ʾ��ͷ
			this.scpDemo.setViewportView(tabDemo);
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}

