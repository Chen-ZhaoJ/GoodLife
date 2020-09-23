//2020/6/11 陳昭潔U10616001
//商品特性
//3-tier:Business Logic

package javafinal;
public abstract class ProductSpecific {
	Item item;
	int value;
	public ProductSpecific() {
	}
	public int getProductNameLength() { //商品個數
		return Item.values().length;
	}
	public String getProductName(int number) { //得到商品名稱
		item = Item.values()[number];
		return item+" ";
	}
	public abstract int getProductValue(); //商品價格
}