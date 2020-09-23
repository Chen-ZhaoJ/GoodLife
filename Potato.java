//2020/6/11 陳昭潔U10616001
//商品
//3-tier:Data Access

package javafinal;

public class Potato extends ProductSpecific {
	int value;
	public Potato(){
		value = 25;
	}
	@Override
	public int getProductValue(){
		return value;
	}
}
