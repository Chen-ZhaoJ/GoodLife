//2020/6/11 陳昭潔U10616001
//註冊panel後的主要UI
//3-tier:UI

package javafinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGui extends JPanel {
	JButton logoutbutton = new JButton("Log Out");
	JButton searchbutton = new JButton("Search Product");
	JButton viewproductbutton = new JButton("View Product");
	JButton viewcartbutton = new JButton("View Cart");
	JButton vieworderbutton = new JButton("View Order");
	public MainGui() { //UI設定
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(5,1));
		p1.add(logoutbutton);
		p1.add(searchbutton);
		p1.add(viewproductbutton);
		p1.add(viewcartbutton);
		p1.add(vieworderbutton);
		JPanel p2 = new JPanel();
		p2.add(p1);
		add(p2);
		logoutbutton.addActionListener(new ActionListener() { //登出
			@Override
			public void actionPerformed(ActionEvent e) {
				p2.removeAll(); //切換到註冊頁面
				Register register = new Register();
				p2.add(register);
				p2.revalidate(); //通知container調整
				p2.repaint();
			}
		});
		searchbutton.addActionListener(new ActionListener() { //搜尋
			@Override
			public void actionPerformed(ActionEvent e) {
				p2.removeAll(); //切換到搜尋頁面
				Search search = new Search();
				p2.add(search);
				p2.revalidate(); //通知container調整
				p2.repaint();
			}
		});
		viewproductbutton.addActionListener(new ActionListener() { //看商品
			@Override
			public void actionPerformed(ActionEvent e) {
				p2.removeAll(); //切換到看商品頁面
				ViewProduct vp = new ViewProduct();
				p2.add(vp);
				p2.revalidate(); //通知container調整
				p2.repaint();
			}
		});
		viewcartbutton.addActionListener(new ActionListener() { //看購物車
			@Override
			public void actionPerformed(ActionEvent e) {
				p2.removeAll(); //切換到購物車頁面
				ViewCart vc = new ViewCart();
				p2.add(vc);
				p2.revalidate(); //通知container調整
				p2.repaint();
			}
		});
		vieworderbutton.addActionListener(new ActionListener() { //看訂單
			@Override
			public void actionPerformed(ActionEvent e) {
				p2.removeAll(); //切換到看訂單頁面
				Order order = new Order();
				p2.add(order);
				p2.revalidate(); //通知container調整
				p2.repaint();
			}
		});
	}
}
