package pos;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;


public class ItemManager {
	Vector<Item> items=new Vector<Item>();
	Vector<Index> index=new Vector<Index>();
	/*
	 * 构造函数，初始化商品索引index
	 * */
	public ItemManager(String fileName){
		index.clear();
		File file=new File(fileName);
		try {
			Scanner in=new Scanner(file);
			while(in.hasNext()){
				index.addElement(new Index(in.next(),in.next(),in.next(),in.nextDouble(),in.nextDouble(),in.nextBoolean()));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 统计商品
	 * */
	public void addItem(String barcode, String name, String unit, Double price, Double discount,boolean promotion){
		int n=0;
		for(Item item:items){
			if(item.barcode.equals(barcode)){
				item.addItemNum();
				break;
			}
			n++;
		}
		if(n==items.size())
			items.addElement(new Item( barcode,name,unit,price,discount,promotion));
	}
	/*
	 * 计算客户购买商品的总价
	 * */
	public Double total(){
		Double  totals=0.0;
		for(Item item:items){
			totals+=item.getTotal();
		}
		return totals;
	}
	/*
	 * 计算节省的钱数
	 * */
	public Double save(){
		Double  saves=0.0;
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
			while(in.hasNext()){
				n=0;
				temp=in.next();
				for(Index id:index){
					if(id.getBarcode().equals(temp)){
						addItem(id.getBarcode(),id.getName(),id.getUnit(),id.getPrice(),id.getDiscount(),id.getPromotion());
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
				+"总计："+total()+"(元)\n";
		if(save()>0.0){
			str2+="节省："+save() +"(元)\n"
					+"**********************";
		}else{
			str2+="**********************";
		}
		return str+str1+str2;
	}
}
