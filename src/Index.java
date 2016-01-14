
public class Index {
	String barcode;  //商品编号
	String name;	 //商品名
	String unit;     //单位
	double  price;    //商品单价
	double discount;   //商品折扣率
	boolean promotion; //是否 "买二赠一"
	public Index(String bar, String nam, String uni, double pri,double dis,boolean pro){
		barcode=bar;
		name=nam;
		unit=uni;
		price=pri;
		discount=dis;
		promotion=pro;
	}
	public String getBarcode(){
		return barcode;
	}
	public String getName(){
		return name;
	}
	public String getUnit() {
		return unit;
	}
	public double getPrice() {
		return this.price;
	}
	public double getDiscount() {
		return discount;
	}
	public boolean getPromotion() {
		return promotion;
	}
}
