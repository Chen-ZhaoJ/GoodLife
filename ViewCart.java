//2020/6/11 陳昭潔U10616001
//處理購物車資訊
//3-tier:Business Logic

package javafinal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ViewCart extends JPanel {
	ItemTheyWant iTW = new ItemTheyWant();
	JLabel item = new JLabel();
	JLabel hint = new JLabel("hint",JLabel.CENTER);
	JLabel itemvalue = new JLabel("",JLabel.CENTER);
	JPanel p1 = new JPanel(new BorderLayout());
	JPanel p2 = new JPanel(new BorderLayout());
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel(new BorderLayout());
	JPanel p5 = new JPanel(new BorderLayout());
	JPanel p6 = new JPanel();
	JButton back = new JButton("back");
	JButton addorder = new JButton("add to order");
	JButton delete = new JButton("delete");
	JTextField deleteitem = new JTextField();
	JTextField deletenum = new JTextField();
	String i;
	public ViewCart() { //購物車頁面UI設定
		p1.add(item,BorderLayout.CENTER);
		p1.setPreferredSize(new Dimension(300,200));
		cart();
		count();
		p2.add(p1,BorderLayout.NORTH);
		p2.add(itemvalue,BorderLayout.CENTER);
		p3.setLayout(new GridLayout(3,2));
		p3.add(new JLabel("enter要刪的物品編號"));
		p3.add(deleteitem);
		p3.add(new JLabel("enter要刪的物品數量"));
		p3.add(deletenum);
		p3.add(delete);
		p3.add(addorder);
		p4.add(p3,BorderLayout.NORTH);
		p6.setLayout(new GridLayout(2,1));
		p6.add(hint);
		p6.add(back);
		p4.add(p6,BorderLayout.CENTER);
		p5.add(p2,BorderLayout.WEST);
		p5.add(p4,BorderLayout.CENTER);
		add(p5,BorderLayout.CENTER);
		back.addActionListener(new ActionListener() { //返回
			@Override
			public void actionPerformed(ActionEvent e) {
				p5.removeAll(); //切換到主要UI頁面
				MainGui maingui=new MainGui();
				p5.add(maingui);
				p5.revalidate(); //通知container調整
				p5.repaint();
			}
		});
		addorder.addActionListener(new ActionListener() { //加入到訂單
			@Override
			public void actionPerformed(ActionEvent e) {
				if(iTW.getTotalValue() < 400) {
					hint.setText("<html>總價格要超過400才能成立訂單<br>請繼續選購再成立訂單</html>");
				}else {
					Order order = new Order(); //切換到訂單頁面
					order.addToOrder();
					p5.removeAll();
					p5.add(order);
					p5.revalidate(); //通知container調整
					p5.repaint();
				}
			}
		});
		delete.addActionListener(new ActionListener() { //刪除購物車商品
			@Override
			public void actionPerformed(ActionEvent e) {
				iTW.deleteFromCart(Integer.valueOf(deleteitem.getText()),Integer.valueOf(deletenum.getText()));
				cart(); //重整購物車
				count();
				hint.setText("已刪除");
			}
		});
	}
	public void cart() { //表示購物車
		String k="";
		String i2="";
		for(int number=0;number< iTW.getLength();number++) {
			k = k+"<br>"+i2;
			if(iTW.getName(number).equals("cake")==false) { //購物車內容不是蛋糕的話
				i2="("+(number+1)+")商品名稱:"+iTW.getName(number)+" 商品數量:"+iTW.getQuantity(number)+" 商品價格:"+iTW.getQuantity(number)*iTW.getValue(number);
			}else {
				i2="("+(number+1)+")商品名稱:"+iTW.getName(number)+" 商品數量:"+iTW.getQuantity(number)+" 商品價格:"+iTW.getQuantity(number)*iTW.getValue(number)+" 客製化訊息:"+iTW.getMessage(number);
			}
			item.setText("<html>"+k+"<br>"+i2+"</html>");
		}
	}
	public void count() { //表示價格
		iTW.setTotalValue(); //計算購物車總價格
		i="購物車總價格為:"+iTW.getTotalValue();
		itemvalue.setText(i);
	}
}
