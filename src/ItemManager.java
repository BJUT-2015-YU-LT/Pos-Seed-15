
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;


public class ItemManager {
	private Vector<Item> items=new Vector<Item>();
	private Vector<Index> index=new Vector<Index>();
	private Vector<User> users=new Vector<User>();
	private User user;
	/*
	 * 构造函数，初始化商品索引index，会员清单users
	 * */
	public ItemManager(String indexFileName,String usersFileName ){
		index.clear();
		users.clear();
		File file=new File(indexFileName);
		try {
			Scanner in=new Scanner(file);
			while(in.hasNext()){
				index.addElement(new Index(in.next(),in.next(),in.next(),in.nextDouble(),in.nextDouble(),in.nextBoolean(),in.nextDouble()));
			}
			file=new File(usersFileName);
			in=new Scanner(file);
			while(in.hasNext()){
				users.addElement(new User(in.next(),in.nextBoolean()));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 统计商品
	 * */
	private void addItem(String barcode, String name, String unit, double price, double discount,boolean promotion,boolean isVip,double vipDiscount){
		int n=0;
		for(Item item:items){
			if(item.barcode.equals(barcode)){
				item.addItemNum();
				break;
			}
			n++;
		}
		if(n==items.size())
			items.addElement(new Item( barcode,name,unit,price,discount,promotion,isVip,vipDiscount));
	}
	/*
	 * 计算客户购买商品的总价
	 * */
	public double total(){
		double  totals=0.0;
		for(Item item:items){
			totals+=item.getTotal();
		}
		return totals;
	}
	/*
	 * 计算节省的钱数
	 * */
	public double save(){
		double  saves=0.0;
		for(Item item:items){
			saves+=item.getSave();
		}
		return saves;
	}

	/*
	 * 文件输入客户购买的商品到items
	 * */
	public void fileInput(String fileName){
		items.clear();
		int n;
		String temp;
		File file=new File(fileName);
		try {
			Scanner in=new Scanner(file);
			if(in.hasNext()){//验证会员名是否已经存在
				n=0;
				temp=in.next(); //读取会员名
				for(User u:users){
					if(u.getName().equals(temp)){
						user=new User(u.getName(),u.getIsVip());
						break;
					}
					n++;
				}
				if(n==users.size()){//没有该用户
					System.out.println("没有用户："+temp+" 请注册会员!");
					System.exit(0);
				}
			}
			while(in.hasNext()){//读取商品到items
				n=0;
				temp=in.next();
				for(Index id:index){
					if(id.getBarcode().equals(temp)){
						addItem(id.getBarcode(),id.getName(),id.getUnit(),id.getPrice(),id.getDiscount(),id.getPromotion(),user.getIsVip(),id.getVipDiscount());
						break;
					}
					n++;
				}
				if(n==index.size()){
					System.out.println("没有商品：%s"+temp);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String toString(){
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
		String time=format.format(date);
		String str="*****商店购物清单*****\n\n"
				+"打印时间："
				+time
				+"\n\n----------------------\n\n";

		String str1="";
		for(Item item:items){
			str+=item.toString();
			str1+=item.twoForOne();
		}
		if(!str1.isEmpty()){
			str1="----------------------\n"
					+"挥泪赠送商品：\n"
					+str1;
		}
		String str2="----------------------\n"
				+"总计："+String.format("%.2f",total())+"(元)\n";
		if(save()>0.0){
			str2+="节省："+String.format("%.2f",save()) +"(元)\n"
					+"**********************";
		}else{
			str2+="**********************";
		}
		return str+str1+str2;
	}
}
