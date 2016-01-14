package pos;

public class Item{
	String barcode;  //商品编号
	String name;	 //商品名
	String unit;     //单位
	Double  price;   //商品单价
	Double discount; //商品折扣率
	Double total;    //总价
	int num;        //商品数量

	public Item(String b, String n, String u, Double p, Double d){
		barcode=b;
		name=n;
		unit=u;
		price=p;
		num=1;
		total=p*d;
		discount=d;
	}
	public void addItemNum(){
		num++;
		total=price*num*discount;
	}
	public String toString(){
		return ("名称："+name+"\t,数量："+num+unit+"\t,单价："
				+price+"(元)"+"\t,小计："+total+"(元)"+"\n\n");
	}
	public Double getTotal(){
		return total;
	}
	public Double getSave(){
		return (num*price-total);
	}
}