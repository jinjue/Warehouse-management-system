package w_m;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class Front extends JFrame implements ActionListener{//操作界面
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnNewMenu = new JMenu("库存查询");
	private final JMenu mnNewMenu_1 = new JMenu("产品出/入库");
	public Front() {
		getContentPane().setLayout(null);
		
		setJMenuBar(menuBar);
		JButton button_4 = new JButton("当前库存");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Look_Over l=new Look_Over("H");
				l.setVisible(true);
			}
		});
		mnNewMenu.add(button_4);
		JButton button_7 = new JButton("按条件查询");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DownLag l=new DownLag();
				l.setVisible(true);
			}
		});
		mnNewMenu.add(button_7);
		
		menuBar.add(mnNewMenu);
		
		JButton button_5 = new JButton("出库");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete l=new Delete();
				l.setVisible(true);
			}
		});
		mnNewMenu_1.add(button_5);
		
		JButton button_6 = new JButton("入库");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add l=new Add();
				l.setVisible(true);
			}
		});
		mnNewMenu_1.add(button_6);
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_3 = new JMenu("产品借还");
		menuBar.add(mnNewMenu_3);
		
		JButton button = new JButton("\u501F\u51FA\u4FE1\u606F");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Lend l=new Lend();
				l.setVisible(true);
			}
		});
		mnNewMenu_3.add(button);
		
		JButton button_1 = new JButton("\u5F52\u8FD8\u4FE1\u606F");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Return l=new Return();
				l.setVisible(true);
			}
		});
		mnNewMenu_3.add(button_1);
		
		JMenu mnNewMenu_4 = new JMenu("盘库");
		menuBar.add(mnNewMenu_4);
		
		JButton button_2 = new JButton("\u6309\u6708\u76D8\u70B9");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statistical_month l=new Statistical_month();
				l.setVisible(true);
			}
		});
		mnNewMenu_4.add(button_2);
		
		JButton button_3 = new JButton("\u6309\u5E74\u76D8\u70B9");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statistical_Year l=new Statistical_Year();
				l.setVisible(true);
			}
		});
		mnNewMenu_4.add(button_3);
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("wenben"));
	}
}
