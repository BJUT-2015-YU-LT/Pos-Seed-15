
public class Item{
	String barcode;  //商品编号
	String name;	 //商品名
	String unit;     //单位
	double  price;   //商品单价
	double discount; //商品折扣率
	double total;    //总价
	int num;        //商品数量
	boolean promotion; //是否 "买二赠一"
	public Item(String bar, String nam, String uni, double pri,double dis,boolean pro){
		barcode=bar;
		name=nam;
		unit=uni;
		price=pri;
		discount=dis;
		promotion=pro;
		num=1;
		total=price*num*discount;
	}
	public void addItemNum(){
		num++;
		total=price*num*discount;
	}
	public double getTotal(){
		if(promotion && num>=2){ //参加“买二赠一”
			return (price*(num-num/2));
		}
		return total;
	}
	public double getSave(){
		if(promotion && num>=2){ //参加“买二赠一”
			return price*(num/2);
		}
		return (num*price-total);
	}
	public String twoForOne(){
		if(promotion && num>=2){
			return ("名称："+name+"\t，数量："+(num/2)+unit+"\n");
		}
		return "";
	}
	public String toString(){
		return ("名称："+name+"\t,数量："+num+unit+"\t,单价："
				+price+"(元)"+"\t,小计："+getTotal()+"(元)"+"\n\n");
	}
}