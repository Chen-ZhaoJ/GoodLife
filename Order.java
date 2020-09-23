//2020/6/11 陳昭潔U10616001
//訂單資料
//3-tier:Data Access

package javafinal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Order extends JPanel {
	private int totalValue; //訂單總金額
	private int delivery; //運費
	private String trackNumber; //運送編號
	private int[] orderQuantity=new int[0]; //訂單商品數量
	private String[] orderMessage=new String[0]; //訂單商品客製化訊息
	private int[] orderValue=new int[0]; //訂單商品金額
	private String[] orderName=new String[0]; //訂單商品名稱
	Random random=new Random();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JButton back = new JButton("back");
	JLabel item = new JLabel();
	JLabel value = new JLabel();
	JLabel deliveryvalue = new JLabel();
	JLabel code = new JLabel();
	private int check=0;
	public Order() { //UI設定
		if (check == 0){
			printOrder();
		}
		p1.add(new JLabel("訂單內容如下:"));
		p1.add(item,BorderLayout.WEST);
		p1.setPreferredSize(new Dimension(350,200));
		p2.setLayout(new GridLayout(3,1));
		p2.add(value);
		p2.add(deliveryvalue);
		p2.add(code);
		p3.add(p1,BorderLayout.WEST);
		p3.add(p2,BorderLayout.CENTER);
		p3.add(back,BorderLayout.SOUTH);
		add(p3);
		back.addActionListener(new ActionListener() { //返回
			@Override
			public void actionPerformed(ActionEvent e) {
				p3.removeAll(); //切換到主要UI頁面
				MainGui maingui=new MainGui();
				p3.add(maingui);
				p3.revalidate(); //通知container調整
				p3.repaint();
			}
		});
	}
	public void addToOrder(){ //加入訂單
		check=1;
		ItemTheyWant iTW=new ItemTheyWant();
		orderQuantity=iTW.getAllQuantity(); //將購物車內容複製過來
		orderMessage=iTW.getAllMessage();
		orderName=iTW.getAllName();
		orderValue=iTW.getAllValue();
		iTW.cleanAll(); //購物車清空
		iTW.setTotalValue(); //購物車訂單金額重設
		setOrderTotalValue(); //計算訂單金額
		setDelivery(); //計算運費
		setTrackNumber(); //產出運輸編號
		printOrder(); //印出訂單內容
	}
	public void printOrder() { //印出訂單內容
		if(orderName.length > 0) { //如果訂單內有商品
			String k="";
			String i2="";
			for(int number=0;number<orderName.length;number++) {
				k = k+"<br>"+i2;
				if(orderName[number].equals("cake")==false) { //分為蛋糕商品的印法和非蛋糕商品的印法
					i2="("+(number+1)+")商品名稱:"+orderName[number]+" 商品數量:"+orderQuantity[number]+" 商品價格:"+orderQuantity[number]*orderValue[number];
				}else {
					i2="("+(number+1)+")商品名稱:"+orderName[number]+" 商品數量:"+orderQuantity[number]+" 商品價格:"+orderQuantity[number]*orderValue[number]+" 客製化訊息:"+orderMessage[number];
				}
				item.setText("<html>"+k+"<br>"+i2+"</html>");
			}
			value.setText("總訂單金額為:"+getOrderTotalValue());
			deliveryvalue.setText("運費為:"+getDelivery());
			code.setText("追蹤碼為:"+getTrackNumber());
		}else {
			item.setText("目前無訂單");
			value.setText("");
			deliveryvalue.setText("");
			code.setText("");
		}
	}
	public void setOrderTotalValue() { //計算訂單總金額
		totalValue=0;
		for(int i=0;i<orderName.length;i++) {
			totalValue=orderQuantity[i]*orderValue[i]+totalValue;
		}
	}
	public int getOrderTotalValue() { //得到訂單總金額
		return totalValue;
	}
	public void setDelivery() { //計算運費
		if(getOrderTotalValue() < 1200) {
			delivery = 200;
		}else {
			delivery = 0;
		}
	}
	public int getDelivery() { //得到運費
		return delivery;
	}
	public void setTrackNumber(){ //製造運輸編號
		String str = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ0123456789";
		StringBuffer stringBuffer = new StringBuffer(); //字串暫存
		for (int j = 0; j < 10; j++) { //長度為10的隨機字串
			int index = random.nextInt(str.length()); //隨機index
			char c = str.charAt(index); //從str找隨機字元
			stringBuffer.append(c);  //將隨機字元放進字串
		}	
		trackNumber=stringBuffer.toString();
	}
	public String getTrackNumber() {//得到運輸編號
		return trackNumber;
	}
	public static String[] addX(int n, String arr[], String x) { //將字串陣列加一個元素
	    int i; 
	  
	    // create a new array of size n+1 
	    String newarr[] = new String[n + 1]; 
	  
	    // insert the elements from 
	    // the old array into the new array 
	    // insert all elements till n 
	    // then insert x at n+1 
	    for (i = 0; i < n; i++) 
	        newarr[i] = arr[i]; 
	  
	    newarr[n] = x; 
	  
	    return newarr; 
	} 
	public static int[] addY(int n, int arr[], int x) { //將整數陣列加一個元素
	    int i; 
	  
	    // create a new array of size n+1 
	    int newarr[] = new int[n + 1]; 
	  
	    // insert the elements from 
	    // the old array into the new array 
	    // insert all elements till n 
	    // then insert x at n+1 
	    for (i = 0; i < n; i++) 
	        newarr[i] = arr[i]; 
	  
	    newarr[n] = x; 
	  
	    return newarr; 
	}
}
