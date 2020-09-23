//2020/6/11 陳昭潔U10616001
//搜尋
//3-tier:Business Logic

package javafinal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Search extends JPanel {
	ItemTheyWant iTW = new ItemTheyWant();
	private int value;
	Item item;
	Apple a = new Apple();
	Banana b = new Banana();
	Potato p = new Potato();
	Vegetable v = new Vegetable();
	Cake c = new Cake();
	Object[] product = {a,b,p,v,c};
	JLabel hint = new JLabel("hint");
	JLabel cakehint = new JLabel("<html>if item is cake<br>enter cake message</html>");
	JTextField name = new JTextField();
	JTextField message = new JTextField();
	JTextField number = new JTextField();
	JButton cartbutton = new JButton("<html>enter product number<br>and add to cart</html>");
	JButton searchbutton = new JButton("search");
	JButton backbutton = new JButton("back");
	JButton cakebutton = new JButton("save message");
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	String sr;
	public Search() { //設定搜尋頁UI
		p1.setLayout(new GridLayout(1,3));
		p1.add(new JLabel("enter productname"));
		p1.add(name);
		p1.add(searchbutton);
		p2.setLayout(new GridLayout(1,3));
		p2.add(hint);
		p2.add(number);
		p2.add(cartbutton);
		cartbutton.hide();
		number.hide();
		p3.setLayout(new GridLayout(4,1));
		p3.add(p1);
		p3.add(p2);
		p4.setLayout(new GridLayout(1,3));
		p4.add(cakehint);
		p4.add(message);
		p4.add(cakebutton);
		cakehint.hide();
		message.hide();
		cakebutton.hide();
		p3.add(p4);
		p3.add(backbutton);
		add(p3);
		searchbutton.addActionListener(new ActionListener() { //搜尋
			@Override
			public void actionPerformed(ActionEvent e) {
				sr = name.getText();
				srvalue(sr); //做搜尋動作
			}
		});
		cartbutton.addActionListener(new ActionListener() { //加入購物車
			@Override
			public void actionPerformed(ActionEvent e) {
				if(name.getText().equals("cake")) { //處理蛋糕
					hint.setText("<html>在右下方輸入cake message<br>and save message</html>");
					iTW.addToCart(name.getText(), value,Integer.valueOf(number.getText()),message.getText());
				}else { //處理非蛋糕
					hint.setText("just added to cart");
					iTW.addToCart(name.getText(), value,Integer.valueOf(number.getText()),"nocake");
				}
			}
		});
		backbutton.addActionListener(new ActionListener() { //返回
			@Override
			public void actionPerformed(ActionEvent e) {
				p3.removeAll(); //切換到主UI頁面
				MainGui maingui=new MainGui(); 
				p3.add(maingui);
				p3.revalidate(); //通知container調整
				p3.repaint();
			}
		});
		cakebutton.addActionListener(new ActionListener() { //搜尋蛋糕
			@Override
			public void actionPerformed(ActionEvent e) {
				iTW.setMessage(message.getText());
				cakehint.setText("just saved");
			}
		});
	}
	public void srvalue(String pd) { //搜尋價格
		int num=-1;
		for(int i=0;i<=item.values().length-1;i++) {
			if(String.valueOf(item.values()[i]).equals(pd)) {
				num = i;
				break;
			}
		}
		if(num==-1) {
			hint.setText("商品不存在，請重新輸入");
		}else {
			value=((ProductSpecific) product[num]).getProductValue();
			sr = String.valueOf(value);
			hint.setText("此商品的價格為：NTD$"+sr);
			cartbutton.show();
			number.show();
			cakehint.show();
			message.show();
			cakebutton.show();
		}
	}
}
