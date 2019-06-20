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

public class Return extends JFrame implements ActionListener {//�黹

	private JPanel contentPane;
	private JTable tabDemo;
	private JTableHeader jth;
	private JTextField Jno,Rnum;
	private JScrollPane scpDemo; 
	JLabel label,label_1;
	JButton button;
	Function f1=new Function();

	String driverName =("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=WM"; // 1433�Ƕ˿ڣ�"USCSecondhandMarketDB"�����ݿ�����
	String userName = "sa"; // �û���
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
		String sql = "select * from BR"; // ������ѯ����
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
				info[count][0] = rs.getString("Jno");
				info[count][1] = rs.getString("Kno");
				info[count][2] = rs.getString("Hno");
				info[count][3] = Integer.valueOf( rs.getInt("Bnum") );
				info[count][4] = Integer.valueOf( rs.getInt("Rnum") );
				info[count][5] =String.valueOf(rs.getString("Btime"));
				info[count][6] = String.valueOf(rs.getString("Rtime"));
				count++;
			}
			String[] title = {"������","�ͻ����","�ͻ����","�����","�黹��","���ʱ��","�黹ʱ��"};// �����ͷ
			this.tabDemo = new JTable(info,title);// ����JTable
			this.jth = this.tabDemo.getTableHeader();// ��ʾ��ͷ
			this.scpDemo.setViewportView(tabDemo);
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}		
	}
}
