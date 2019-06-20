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

public class Lend extends JFrame implements ActionListener {//�軹

	private JPanel contentPane;
	private JTable tabDemo;
	private JTableHeader jth;
	private JTextField Hno,Kno,Bnum;
	private JScrollPane scpDemo; 
	JLabel label,label_1,label_2;
	JButton button;
	Function f1=new Function();

	String driverName =("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=WM"; // 1433�Ƕ˿ڣ�"USCSecondhandMarketDB"�����ݿ�����
	String userName = "sa"; // �û���
	String userPwd = "zj923326"; 
	Connection dbConn = null;
	public Lend() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 750, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("\u5BA2\u6237\u7F16\u53F7");
		label.setBounds(30, 15, 81, 21);
		contentPane.add(label);
		
		Kno = new JTextField();
		Kno.setBounds(137, 12, 210, 27);
		contentPane.add(Kno);
		Kno.setColumns(10);
		
		label_1 = new JLabel("\u8D27\u7269\u7F16\u53F7");
		label_1.setBounds(30, 63, 81, 21);
		contentPane.add(label_1);
		
		Hno = new JTextField();
		Hno.setBounds(137, 60, 210, 27);
		contentPane.add(Hno);
		Hno.setColumns(10);
		
		label_2 = new JLabel("\u501F\u51FA\u6570\u91CF");
		label_2.setBounds(30, 107, 81, 21);
		contentPane.add(label_2);
		
		Bnum = new JTextField();
		Bnum.setBounds(137, 104, 210, 27);
		contentPane.add(Bnum);
		Bnum.setColumns(10);
		
		this.scpDemo = new JScrollPane();
		this.scpDemo.setBounds(30,192,663,256);
		getContentPane().add(this.scpDemo);
		
		button = new JButton("\u786E\u5B9A");
		button.setBounds(572, 148, 123, 29);
		contentPane.add(button);
		button.addActionListener(this);
		
		
		try {
			dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e){
		f1.fun6(dbConn,Kno.getText(),Hno.getText(),Integer.valueOf(Bnum.getText()));
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
