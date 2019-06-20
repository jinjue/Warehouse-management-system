package w_m;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Login1 extends JFrame implements ActionListener {//��¼����

	private JPanel contentPane;
	private JTextField user;
	JPasswordField password;
	JButton button,button_1;
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login1 frame = new Login1();
					frame.setBounds(100,100,310,260);
					frame.setTitle("��¼");
					frame.setVisible(true);
					
					 //����ͼƬ        
					ImageIcon icon1=new ImageIcon("D:\\�ļ�\\��Ƭ\\СħŮ01.jpg" );       
					//���JLabel ����ͼƬ   
					JLabel label1=new JLabel(icon1);  
					//����label��λ�á���С��label��СΪͼƬ�Ĵ�С   
					label1.setBounds(0,0,icon1.getIconWidth(),icon1.getIconHeight());    
					//��frame�ĵײ��������label      
					frame.getLayeredPane().add(label1,new Integer(Integer.MIN_VALUE));     
					//panel   
					JPanel panel =new JPanel();      
					//panelTop����������      
					JPanel panelTop=new JPanel();      
					panelTop=(JPanel)frame.getContentPane();    
					//panel��panelTop����͸��    
					panelTop.setOpaque(false);      
					panel.setOpaque(false);       
					//label0������ǶԽ�����Զ������������Ч��չʾ   
					JLabel label0=new JLabel("����һ��Label");   
					panel.add(label0);  
					//���panel�����ô�С������     
					frame.getContentPane().add(panel);     
					frame.setSize(400,300);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Login1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 374, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u4ED3\u5E93\u7BA1\u7406\u7CFB\u7EDF");
		label.setBounds(133, 10, 86, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u767B\u5F55\u540D");
		label_1.setBounds(38, 62, 54, 15);
		contentPane.add(label_1);
		
		user = new JTextField();
		user.setBounds(117, 59, 155, 21);
		contentPane.add(user);
		user.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5BC6\u7801");
		label_2.setBounds(38, 103, 54, 15);
		contentPane.add(label_2);
		
		password = new JPasswordField();
		password.setBounds(117, 100, 155, 21);
		contentPane.add(password);
		password.setColumns(10);
		
		button = new JButton("\u786E\u8BA4");
		button.setBounds(38, 176, 93, 23);
		 button.addActionListener(this);
		contentPane.add(button);
		
		button_1 = new JButton("\u91CD\u7F6E");
		button_1.setBounds(223, 176, 93, 23);
		 button_1.addActionListener(this);
		contentPane.add(button_1);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {//������������button1��ȷ�ϣ���ť�����û���������������ȷʱ��������ʾ����
			Link link=new Link();
			int l=link.getConnectionSqlServer(user.getText(), String.valueOf(password.getPassword()));
			if(l==1) {
				Front ml = new Front();// Ϊ��ת�Ľ���
				ml.setVisible(true);
				ml.setSize(750,520);
				ml.setLocation(300, 400);	
				
			}
			else {//����ȷʱ����ʾ����
				JOptionPane.showMessageDialog(this,"������û���������","��Ϣ",JOptionPane.WARNING_MESSAGE);
				
			}
			user.setText("");//���¡�ȷ�ϡ���ťʱ���û������������
			password.setText("");
			user.requestFocus();//��ý���
	    }
		else if(e.getSource()==button_1){//������������button2�����ã���ť,�û������������
			user.setText("");
			password.setText("");
			user.requestFocus();//��ý���
		}
	}
}
