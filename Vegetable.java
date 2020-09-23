//2020/6/11 陳昭潔U10616001
//商品
//3-tier:Data Access

package javafinal;

public class Vegetable extends ProductSpecific{
	int value;
	public Vegetable(){
		value = 50;
	}
	@Override
	public int getProductValue(){
		return value;
	}
}
