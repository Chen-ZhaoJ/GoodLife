//2020/6/11 陳昭潔U10616001
//商品
//3-tier:Data Access

package javafinal;

public class Banana extends ProductSpecific {
	int value;
	public Banana(){ //價格
		value = 25;
	}
	@Override
	public int getProductValue(){ //得到價格
		return value;
	}
}
