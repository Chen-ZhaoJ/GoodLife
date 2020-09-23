//2020/6/11 陳昭潔U10616001
//商品
//3-tier:Data Access

package javafinal;

import java.util.Scanner;
import java.util.Arrays;

public class ItemTheyWant {
	private static int totalValue; //購物車總價格
	private int quantity; //數量
	private String message; //客製化訊息
	private int value; //價格
	private String name; //姓名
	private static int[] allQuantity=new int[0]; //購物車內所有商品數量
	private static String[] allMessage=new String[0]; //購物車內所有商品客製化訊息
	private static int[] allValue=new int[0]; //購物車內所有商品價格
	private static String[] allName=new String[0]; //購物車內所有商品名稱
	Scanner sc=new Scanner(System.in);
	public ItemTheyWant() {
		
	}
	public void setQuantity(int quantity) { //將數量加入購物車內所有商品數量的陣列
		allQuantity = addY(allQuantity.length, allQuantity, quantity); 
	}
	public int getQuantity(int number) { //得到購物車內的商品數量
		quantity=allQuantity[number];
		return quantity;
	}
	public void setMessage(String message) { //將客製化訊息加入購物車內所有商品客製化訊息的陣列
		allMessage = addX(allMessage.length, allMessage, message);
	}
	public String getMessage(int number) { //得到購物車內的商品客製化訊息
		message=allMessage[number];
		return message;
	}
	public void setValue(int value) { //將價格加入購物車內所有商品價格的陣列
		allValue = addY(allValue.length, allValue, value);
	}
	public int getValue(int number) { //得到購物車內的商品價格
		value=allValue[number];
		return value;
	}
	public void setName(String name) { //將商品名稱加入購物車內所有商品名稱的陣列
		allName = addX(allName.length, allName, name);
	}
	public String getName(int number) { //得到購物車內的商品名稱
		name=allName[number];
		return name;
	}
	public int getLength() { //得到購物車內的商品個數
		return allName.length;
	}
	public void cleanup() { //整理購物車內的商品
		for(int i=0;i<allName.length;i++) { //從第一個商品開始
			for(int k=i+1;k<allName.length;k++) { //從上面index+1的商品開始
				if(allName[i].equals("cake")==false){ //如果不是蛋糕
					if(allName[i].equals(allName[k])==true) { //如果有同樣名字的商品
						allQuantity[i]=allQuantity[i]+allQuantity[k]; //將商品數量整合
						for(int j=k;j<allName.length-1;j++) { //將後面的商品往前移
							allName[j]=allName[j+1];
							allQuantity[j]=allQuantity[j+1];
							allValue[j]=allValue[j+1];
							allMessage[j]=allMessage[j+1];
						}
						deleteAll(allName.length);
					}
				}
			}
		}
	}
	public void addToCart(String pd,int value,int q,String m) { //加入購物車
		setName(pd); //將商品名稱加入購物車
		setValue(value); //將商品個數加入購物車
		setQuantity(q);
		setMessage(m);
		cleanup(); //整理購物車
	}
	public void setTotalValue() {//計算購物車價格
		totalValue=0; //初始化總價格
		for(int i=0;i<allName.length;i++) { //從購物車所有的數量和價格相乘以計算
			totalValue=allQuantity[i]*allValue[i]+totalValue;
		}
	}
	public int getTotalValue() { //得到購物車價格
		return totalValue;
	}
	public void deleteFromCart(int item,int value) { //刪除購物車的某商品
		allQuantity[item-1]=allQuantity[item-1]-value; //將此商品的數量-1
		if(allQuantity[item-1]<=0) { //如果此商品數量為0
			deleteAll(item); //刪除此商品的位置
		}
	}
	public void deleteAll(int number) { //刪除此商品的位置
		allName[number-1]=allName[allName.length-1]; //將最後一個商品在陣列的位置移到刪除的商品在陣列的位置
		allName = Arrays.copyOf(allName, allName.length-1); //陣列縮容
		allQuantity[number-1]=allQuantity[allQuantity.length-1];
		allQuantity = Arrays.copyOf(allQuantity, allQuantity.length-1);
		allValue[number-1]=allValue[allValue.length-1];
		allValue = Arrays.copyOf(allValue, allValue.length-1);
		allMessage[number-1]=allMessage[allMessage.length-1];
		allMessage = Arrays.copyOf(allMessage, allMessage.length-1);
	}
	public String[] getAllName() { //得到所有商品名稱
		return allName;
	}
	public int[] getAllValue() { //得到所有商品價格
		return allValue;
	}
	public int[] getAllQuantity() { //得到所有商品數量
		return allQuantity;
	}
	public String[] getAllMessage() { //得到所有商品客製化訊息
		return allMessage;
	}
	public void cleanAll() { //清空購物車
		allQuantity = new int[0]; //歸零陣列內容
		allName = new String[0];
		allValue = new int[0];
		allMessage = new String[0];
	}
	public static String[] addX(int n, String arr[], String x) {  //將字串加入字串陣列
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
	public static int[] addY(int n, int arr[], int x) {  //將整數加入整數陣列
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
