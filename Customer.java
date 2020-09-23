//2020/6/11 陳昭潔U10616001
//客戶資料
//3-tier:Data Access

package javafinal;

public class Customer {
	private String address; //地址
	private String name; //姓名
	private String phone; //電話
	private String passward; //密碼
	private static String[] allAddress=new String[0]; //所有客戶地址
	private static String[] allName=new String[0]; //所有客戶名字
	private static String[] allPhone=new String[0]; //所有客戶電話
	private static String[] allPassward=new String[0]; //所有客戶密碼
	public Customer() {
		
	}
	public void setAddress(String address) { //將客戶地址加入所有客戶地址的陣列
		allAddress = addX(allAddress.length, allAddress, address); 
	}
	public String getAddress(int number) { //得到客戶地址
		address=allAddress[number];
		return address;
	}
	public void setName(String name) { //將客戶姓名加入所有客戶姓名的陣列
		allName = addX(allName.length, allName, name); 
	}
	public String getName(int number) { //得到客戶姓名
		name=allName[number];
		return name;
	}
	public void setPhone(String phone) { //將客戶電話加入所有客戶電話的陣列
		allPhone = addX(allPhone.length, allPhone, phone); 
	}
	public String getPhone(int number) { //得到客戶電話
		phone=allPhone[number];
		return phone;
	}
	public int searchPhone(String phone) { //尋找客戶電話在陣列裡的第幾個位址
		for(int i=0;i<allPhone.length;i++) {
			if(String.valueOf(allPhone[i].equals(phone))=="true") {
				return i;
			}
		}
		return -1;
	}
	public void setPassward(String passward) { //將客戶密碼加入所有客戶密碼的陣列
		allPassward = addX(allPassward.length, allPassward, passward); 
	}
	public String getPassward(int number) { //得到客戶密碼
		passward=allPassward[number];
		return passward;
	}
	public static String[] addX(int n, String arr[], String x) { //將字串加入字串陣列 
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
}
