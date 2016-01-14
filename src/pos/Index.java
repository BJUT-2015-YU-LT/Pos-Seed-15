package pos;

public class Index {
	String barcode;  //商品编号
	String name;	 //商品名
	String unit;     //单位
	Double  price;   //商品单价
	Double discount; //商品折扣率
	public Index(String b, String n, String u, Double p,Double d){
		barcode=b;
		name=n;
		unit=u;
		price=p;
		discount=d;
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
	public Double getPrice() {
		return this.price;
	}
	public Double getDiscount() {
		return discount;
	}
}
