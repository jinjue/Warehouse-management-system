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

public class Login1 extends JFrame implements ActionListener {//登录界面

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
					frame.setTitle("登录");
					frame.setVisible(true);
					
					 //插入图片        
					ImageIcon icon1=new ImageIcon("D:\\文件\\照片\\小魔女01.jpg" );       
					//添加JLabel 放置图片   
					JLabel label1=new JLabel(icon1);  
					//设置label的位置、大小，label大小为图片的大小   
					label1.setBounds(0,0,icon1.getIconWidth(),icon1.getIconHeight());    
					//在frame的底层容器添加label      
					frame.getLayeredPane().add(label1,new Integer(Integer.MIN_VALUE));     
					//panel   
					JPanel panel =new JPanel();      
					//panelTop，顶层容器      
					JPanel panelTop=new JPanel();      
					panelTop=(JPanel)frame.getContentPane();    
					//panel和panelTop设置透明    
					panelTop.setOpaque(false);      
					panel.setOpaque(false);       
					//label0，这个是对界面的自定义操作，用作效果展示   
					JLabel label0=new JLabel("这是一个Label");   
					panel.add(label0);  
					//添加panel，设置大小，可视     
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
		if(e.getSource()==button) {//如果鼠标点击的是button1（确认）按钮，当用户名，密码输入正确时，弹出显示界面
			Link link=new Link();
			int l=link.getConnectionSqlServer(user.getText(), String.valueOf(password.getPassword()));
			if(l==1) {
				Front ml = new Front();// 为跳转的界面
				ml.setVisible(true);
				ml.setSize(750,520);
				ml.setLocation(300, 400);	
				
			}
			else {//不正确时，提示错误
				JOptionPane.showMessageDialog(this,"错误的用户名或密码","消息",JOptionPane.WARNING_MESSAGE);
				
			}
			user.setText("");//按下“确认”按钮时，用户名，密码清空
			password.setText("");
			user.requestFocus();//获得焦点
	    }
		else if(e.getSource()==button_1){//如果鼠标点击的是button2（重置）按钮,用户名，密码清空
			user.setText("");
			password.setText("");
			user.requestFocus();//获得焦点
		}
	}
}
