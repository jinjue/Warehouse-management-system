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

public class Look_Over extends JFrame {//�鿴����

	private JPanel contentPane;
	private JScrollPane scpDemo;  
	private JTableHeader jth;  
	private JTable tabDemo;  
	private JButton btnShow; 
	Function f1=new Function();
	Connection dbConn = null;
	public Look_Over(String table) {
		// �����������ԵĶ���
		super("��ѯ������Ϣ");
		this.setSize(640,400);
		this.setLayout(null);
		this.setLocation(100,50);
		// �������
		this.scpDemo = new JScrollPane();
		this.scpDemo.setBounds(10,50,600,270);
		/*this.btnShow = new JButton("��ʾ����");
		this.btnShow.setBounds(200,10,200,30);
		
		this.btnShow.addActionListener(new ActionListener(){//��ť�ĵ���¼�;��ѯ
			   public void actionPerformed(ActionEvent ae){
			     btnShow_ActionPerformed(ae,table);
			   }
			});*/
		add(this.scpDemo);// ��������뵽������
		//add(this.btnShow);
		
		this.setVisible(true);// ��ʾ����
	/*}
	public void btnShow_ActionPerformed(ActionEvent ae,String table){*/
		// ��������Դ����ʾ���ݵľ��崦����
			String driverName =("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=WM"; // 1433�Ƕ˿ڣ�"USCSecondhandMarketDB"�����ݿ�����
			String userName = "sa"; // �û���
			String userPwd = "zj923326"; 
			
		try{
			dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
			String sql = "select * from "+table; // ������ѯ����
			PreparedStatement pstm = dbConn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();// ִ�в�ѯ
			
			int count = 0;// �����ж�������¼
			while(rs.next()){
			   count++;
			}
			rs = pstm.executeQuery();
			Object[][] info  ;
			if(table.equals("C")) {
				   info=new Object[count][4];// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
				   count = 0;
					while(rs.next()){
						info[count][0] = rs.getString("Cno");
						info[count][1] = rs.getString("Cname");
						info[count][2] = Integer.valueOf( rs.getInt("Ccap") );
						info[count][3] = rs.getString("Cadd");
						count++;
					}
					
					String[] title = {"�ֿ���","�ֿ�����","  �ֿ����� ","�ֿ��ַ"};// �����ͷ
					this.tabDemo = new JTable(info,title);// ����JTable
			   }
			if(table.equals("Manager")){
				   info=new Object[count][7];// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
					
					String[] title = {"����Ա���","����","�Ա�","����","�绰����","����"};// �����ͷ
					this.tabDemo = new JTable(info,title);// ����JTable
			   }
				
			if(table.equals("G")){
				   info=new Object[count][5];// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
				   count = 0;
					while(rs.next()){
						info[count][0] = rs.getString("Gno");
						info[count][1] = rs.getString("Gname");
						info[count][2] = rs.getString("Gadd");
						info[count][3] = rs.getString("Gtel");
						info[count][4] = rs.getString("Gcom");
						count++;
					}
					
					String[] title = {"��Ӧ�̱��","��ϵ��","��ַ","�绰����","����"};// �����ͷ
					this.tabDemo = new JTable(info,title);// ����JTable
			   }
			if(table.equals("H")){
				   info=new Object[count][5];// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
				   count = 0;
					while(rs.next()){
						info[count][0] = rs.getString("Hno");
						info[count][1] = rs.getString("Hname");
						info[count][2] = rs.getString("Htype");
						info[count][3] = Integer.valueOf( rs.getInt("Hnum") );
						info[count][4] = Integer.valueOf( rs.getInt("Hprice") );
						count++;
					}
					
					String[] title = {"������","��������","��������","��������","���ﵥ��"};// �����ͷ
					this.tabDemo = new JTable(info,title);// ����JTable
			   }
			if(table.equals("K")){
				   info=new Object[count][5];// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
				   count = 0;
					while(rs.next()){
						info[count][0] = String.valueOf(rs.getString("Kno"));
						info[count][1] = String.valueOf(rs.getString("Kname"));
						info[count][2] = String.valueOf(rs.getString("Ksex"));
						info[count][3] = String.valueOf(rs.getString("Ktel"));
						info[count][4] = String.valueOf(rs.getString("Kadd"));
						count++;
					}
					
					String[] title = {"�ͻ����","����","�Ա�","�绰����","��ַ"};// �����ͷ
					this.tabDemo = new JTable(info,title);// ����JTable
			    }
			if(table.equals("Management")){
					   info=new Object[count][4];// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
					   count = 0;
						while(rs.next()){
							info[count][0] = rs.getString("Cno");
							info[count][1] = rs.getString("Mno");
							info[count][2] = rs.getString("Mname");
							info[count][3] = rs.getString("Mtime");
							count++;
						}
						
						String[] title = {"�ֿ���","����Ա���","����","����ʱ���"};// �����ͷ
						this.tabDemo = new JTable(info,title);// ����JTable
				}
			if(table.equals("S")){
					   info=new Object[count][5];// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
					   System.out.println(count);count = 0;
					   
						while(rs.next()){
							info[count][0] = rs.getString("Gno");
							info[count][1] = rs.getString("Cno");
							info[count][2] = rs.getString("Hno");
							info[count][3] = Integer.valueOf( rs.getInt("Snum") );
							info[count][4] =String.valueOf(rs.getString("Stime"));
							count++;
						}
						
						String[] title = {"��Ӧ�̱��","�ֿ���","������","��Ӧ��","��Ӧʱ��"};// �����ͷ
						this.tabDemo = new JTable(info,title);// ����JTable
				}
			if(table.equals("I")){
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
				}
			if(table.equals("O")){
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
				}
			if(table.equals("BR")){
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
				}
			if(table.equals("Limit")) {
			   info=new Object[count][5];// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
			   count = 0;
				while(rs.next()){
					info[count][0] = rs.getString("Hno");
					info[count][1] = rs.getString("Cno");
					info[count][2] = Integer.valueOf( rs.getInt("Lmin") );
					info[count][3] = Integer.valueOf( rs.getInt("Lmax") );
					info[count][4] = Integer.valueOf( rs.getInt("Cinv") );
					count++;
				}
				
				String[] title = {"������","�ֿ���","��Сֵ","���ֵ","�����"};// �����ͷ
				this.tabDemo = new JTable(info,title);// ����JTable
		}
			
			this.jth = this.tabDemo.getTableHeader();// ��ʾ��ͷ
			
			this.scpDemo.getViewport().add(tabDemo); // ��JTable���뵽���������������
		}
		catch(SQLException sqle){
		    JOptionPane.showMessageDialog(null,"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
