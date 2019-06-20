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
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;

public class Delete extends JFrame implements ActionListener {//����

	private JPanel contentPane;
	private JTable tabDemo;
	private JTableHeader jth;
	private JScrollPane scpDemo; 
	JLabel label,label_1,label_2;
	JTextField Hno,Onum,Cno;//���������ı�
	Function f1=new Function();
	Connection dbConn = null;
	JButton button ;


	String driverName =("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=WM"; // 1433�Ƕ˿ڣ�"USCSecondhandMarketDB"�����ݿ�����
	String userName = "sa"; // �û���
	String userPwd = "zj923326"; 
	
	public Delete() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.scpDemo = new JScrollPane();
		this.scpDemo.setBounds(33,194,644,254);
		
		getContentPane().add(this.scpDemo);
		
		button= new JButton("\u51FA\u5E93");
		button.setBounds(554, 150, 123, 29);
		contentPane.add(button);
		button.addActionListener(this);
		
		label = new JLabel("\u8D27\u7269\u7F16\u53F7");
		label.setBounds(33, 15, 81, 21);
		contentPane.add(label);
		
		Hno = new JTextField();
		Hno.setBounds(129, 15, 187, 27);
		contentPane.add(Hno);
		Hno.setColumns(10);
		
		label_1 = new JLabel("\u51FA\u5E93\u6570\u91CF");
		label_1.setBounds(33, 124, 81, 21);
		contentPane.add(label_1);
		
		Onum = new JTextField();
		Onum.setBounds(129, 121, 187, 27);
		contentPane.add(Onum);
		Onum.setColumns(10);
		
		label_2 = new JLabel("\u4ED3\u5E93\u7F16\u53F7");
		label_2.setBounds(33, 70, 81, 21);
		contentPane.add(label_2);
		
		Cno = new JTextField();
		Cno.setBounds(129, 67, 187, 27);
		contentPane.add(Cno);
		Cno.setColumns(10);
		
		try {
			dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void actionPerformed(ActionEvent e){
		f1.fun2(dbConn,Hno.getText(),Integer.valueOf(Onum.getText()),Cno.getText());
		String sql = "select * from O"; // ������ѯ����
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
		   info=new Object[count][7];// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
			String[] title = {"���ⵥ��","������","�ֿ���","������","����Ա���","�ͻ����","����ʱ��"};// �����ͷ
			this.tabDemo = new JTable(info,title);// ����JTable
			this.jth = this.tabDemo.getTableHeader();// ��ʾ��ͷ
			this.scpDemo.getViewport().add(tabDemo); // ��JTable���뵽���������������
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}


}
