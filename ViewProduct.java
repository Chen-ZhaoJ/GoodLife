//2020/6/11 陳昭潔U10616001
//瀏覽商品
//3-tier:Business Logic

package javafinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewProduct extends JPanel {
	Apple apple = new Apple();
	Banana banana = new Banana();
	Potato potato = new Potato();
	Vegetable vegetable = new Vegetable();
	Cake cake = new Cake();
	Object[] product = {apple,banana,potato,vegetable,cake};
	ItemTheyWant iTW = new ItemTheyWant();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	JPanel p5 = new JPanel();
	JPanel p6 = new JPanel();
	JTextField a = new JTextField();
	JTextField b = new JTextField();
	JTextField p = new JTextField();
	JTextField v = new JTextField();
	JTextField c = new JTextField();
	JTextField message = new JTextField();
	JButton ab = new JButton("add apple to cart");
	JButton bb = new JButton("add banana to cart");
	JButton pb = new JButton("add potato to cart");
	JButton vb = new JButton("add vegetable to cart");
	JButton cb = new JButton("add cake to cart");
	JButton back = new JButton("back");
	JLabel hint = new JLabel("hint",JLabel.CENTER);
	public ViewProduct() { //瀏覽商品頁面UI
		p1.setLayout(new GridLayout(1,3));
		p1.add(new JLabel("<html>apple,<br>enter want number</html>"));
		p1.add(a);
		p1.add(ab);
		p2.setLayout(new GridLayout(1,3));
		p2.add(new JLabel("<html>banana,<br>enter want number</html>"));
		p2.add(b);
		p2.add(bb);
		p3.setLayout(new GridLayout(1,3));
		p3.add(new JLabel("<html>potato,<br>enter want number</html>"));
		p3.add(p);
		p3.add(pb);
		p4.setLayout(new GridLayout(1,3));
		p4.add(new JLabel("<html>vegetable,<br>enter want number</html>"));
		p4.add(v);
		p4.add(vb);
		p5.setLayout(new GridLayout(1,4));
		p5.add(new JLabel("<html>cake, enter want number<br>and message</html>"));
		p5.add(c);
		p5.add(message);
		p5.add(cb);
		p6.setLayout(new GridLayout(7,1,10,3));
		p6.add(p1);
		p6.add(p2);
		p6.add(p3);
		p6.add(p4);
		p6.add(p5);
		p6.add(hint);
		p6.add(back);
		add(p6);
		ab.addActionListener(new ActionListener() { //蘋果增加購物車
			@Override
			public void actionPerformed(ActionEvent e) {
				iTW.addToCart("apple", apple.getProductValue(),Integer.valueOf(a.getText()),"nocake");
				hint.setText("just added to cart");
			}
		});
		bb.addActionListener(new ActionListener() { //香蕉增加購物車
			@Override
			public void actionPerformed(ActionEvent e) {
				iTW.addToCart("banana", banana.getProductValue(),Integer.valueOf(b.getText()),"nocake");
				hint.setText("just added to cart");
			}
		});
		pb.addActionListener(new ActionListener() { //potato增加購物車
			@Override
			public void actionPerformed(ActionEvent e) {
				iTW.addToCart("patoto", potato.getProductValue(),Integer.valueOf(p.getText()),"nocake");
				hint.setText("just added to cart");
			}
		});
		vb.addActionListener(new ActionListener() { //蔬菜增加購物車
			@Override
			public void actionPerformed(ActionEvent e) {
				iTW.addToCart("vegetable", vegetable.getProductValue(),Integer.valueOf(v.getText()),"nocake");
				hint.setText("just added to cart");
			}
		});
		cb.addActionListener(new ActionListener() { //蛋糕增加購物車
			@Override
			public void actionPerformed(ActionEvent e) {
				iTW.addToCart("cake", cake.getProductValue(),Integer.valueOf(c.getText()),message.getText());
				hint.setText("just added to cart");
			}
		});
		back.addActionListener(new ActionListener() { //返回
			@Override
			public void actionPerformed(ActionEvent e) {
				p6.removeAll(); //切換到主要UI頁面
				MainGui maingui=new MainGui();
				p6.add(maingui);
				p6.revalidate(); //通知container調整
				p6.repaint();
			}
		});
	}
}
