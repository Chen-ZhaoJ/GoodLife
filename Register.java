//2020/6/11 陳昭潔U10616001
//處理註冊和登入
//3-tier:Business Logic

package javafinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JPanel {
	Customer customer=new Customer();
	JTextField username = new JTextField();
	JTextField userphone = new JTextField();
	JTextField userpassword = new JTextField();
	JTextField useraddress = new JTextField();
	JButton registerbutton = new JButton("Register");
	JButton loginbutton = new JButton("Log In");
	int check=0;
	String phone;
	String passward;
	String address;
	String name;
	JLabel hint = new JLabel("if you want to log in, just enter phone and password");
	public Register() { //設定註冊頁面UI
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(5, 2));
		p1.setPreferredSize(new Dimension(390, 200));
		p1.add(new JLabel("enter username"));
		p1.add(username);
		p1.add(new JLabel("enter phone"));
		p1.add(userphone);
		p1.add(new JLabel("enter password"));
		p1.add(userpassword);
		p1.add(new JLabel("enter address"));
		p1.add(useraddress);
		p1.add(registerbutton);
		p1.add(loginbutton);
		JPanel p2 = new JPanel();
		p2.add(hint,BorderLayout.NORTH);
		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(2, 1));
		p3.add(p1);
		p3.add(p2);
		add(p3);
		registerbutton.addActionListener(new ActionListener() { //註冊
			@Override
			public void actionPerformed(ActionEvent e) {
				int number =0;
				name = username.getText();
				passward = userpassword.getText();
				address=useraddress.getText();
				phone=userphone.getText();
				number=customer.searchPhone(phone); //尋找輸入者輸入的電話
				if(username.getText()==null || userpassword.getText()==null || userphone.getText()==null || useraddress.getText()==null) {
					hint.setText("註冊未完成，請輸入完整資訊");
				}else if(number!=-1){
					hint.setText("電話已存在，請登入");
				}else {
					customer.setName(username.getText());
					customer.setPassward(userpassword.getText());
					customer.setPhone(userphone.getText());
					customer.setAddress(useraddress.getText());
					hint.setText("註冊成功，請登入");
				}
			}
		});
		loginbutton.addActionListener(new ActionListener() { //登入
			@Override
			public void actionPerformed(ActionEvent e) {
				int number=0;
				name = username.getText();
				passward = userpassword.getText();
				address=useraddress.getText();
				phone=userphone.getText();
				number=customer.searchPhone(phone); //尋找輸入者輸入的電話
				if(number==-1) { //找不到此電話
					hint.setText("電話不存在，請重新輸入");
				}else if(passward.equals(customer.getPassward(number))==true) { //找到電話且輸入整卻
					hint.setText("登入成功");
					p3.removeAll(); //切換到主要UI頁面
					MainGui maingui = new MainGui();
					p3.add(maingui);
					p3.revalidate(); //通知container調整
					p3.repaint();
					check=1;
				}else { //輸入錯誤
					hint.setText("密碼錯誤請重新登入");
				}
			}
		});
	}
}