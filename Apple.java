//2020/6/11 陳昭潔U10616001
//商品
//3-tier:Data Access

package javafinal;

public class Apple extends ProductSpecific {
	int value;
	public Apple(){ //價格
		value = 30;
	}
	@Override
	public int getProductValue(){ //得到價格
		return value;
	}
}
