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

public class Add extends JFrame implements ActionListener {//���

	private JPanel contentPane;
	private JTable tabDemo;
	private JTableHeader jth;
	private JTextField Hno,Cno,Inum,Mno;
	private JScrollPane scpDemo; 
	JLabel label,label_1,label_2,label_3;
	JButton button;
	Function f1=new Function();
	
	String driverName =("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=WM"; // 1433�Ƕ˿ڣ�"USCSecondhandMarketDB"�����ݿ�����
	String userName = "sa"; // �û���
	String userPwd = "zj923326"; 
	Connection dbConn = null;
	
	public Add() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("������");
		label.setBounds(29, 15, 81, 21);
		contentPane.add(label);
		
		Hno = new JTextField();
		Hno.setBounds(142, 12, 237, 27);
		contentPane.add(Hno);
		Hno.setColumns(10);
		
		label_3 = new JLabel("��������");
		label_3.setBounds(29, 93, 81, 21);
		contentPane.add(label_3);
		
		Inum = new JTextField();
		Inum.setBounds(142, 90, 237, 27);
		contentPane.add(Inum);
		Inum.setColumns(10);
		
		button = new JButton("\u5165\u5E93");
		button.setBounds(576, 165, 123, 29);
		contentPane.add(button);
		button.addActionListener(this);
		
		this.scpDemo = new JScrollPane();
		this.scpDemo.setBounds(33,220,663,228);
		
		getContentPane().add(this.scpDemo);
		
		label_1 = new JLabel("\u7BA1\u7406\u5458\u7F16\u53F7");
		label_1.setBounds(29, 134, 99, 21);
		contentPane.add(label_1);
		
		Mno= new JTextField();
		Mno.setBounds(142, 131, 237, 27);
		contentPane.add(Mno);
		Mno.setColumns(10);
		
		label_2 = new JLabel("�ֿ���");
		label_2.setBounds(29, 51, 81, 21);
		contentPane.add(label_2);
		
		Cno = new JTextField();
		Cno.setBounds(142, 48, 237, 27);
		contentPane.add(Cno);
		Cno.setColumns(10);
		try {
			dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		f1.fun3(dbConn,Hno.getText(),Integer.valueOf(Inum.getText()),Cno.getText(),Mno.getText());
			String sql = "select * from I"; // ������ѯ����
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
				}String[] title = {"��ⵥ��","������","�ֿ���","�����","����Ա���","���ʱ��"};// �����ͷ
				this.tabDemo = new JTable(info,title);// ����JTable
				this.jth = this.tabDemo.getTableHeader();// ��ʾ��ͷ
				this.scpDemo.setViewportView(tabDemo);
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}

}
