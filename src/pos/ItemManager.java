package pos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;


public class ItemManager {
	Vector<Item> items=new Vector<Item>();
	Vector<Index> index=new Vector<Index>();
	public ItemManager(String fileName){
		index.clear();
		File file=new File(fileName);
		try {
			Scanner in=new Scanner(file);
			while(in.hasNext()){
				index.addElement(new Index(in.next(),in.next(),in.next(),in.nextDouble(),in.nextDouble()));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void addItem(String barcode, String name, String unit, Double price, Double discount){
		int n=0;
		for(Item item:items){
			if(item.barcode.equals(barcode)){
				item.addItemNum();
				break;
			}
			n++;
		}
		if(n==items.size())
			items.addElement(new Item( barcode,name,unit,price,discount));
	}
	public Double total(){
		Double  totals=0.0;
		for(Item item:items){
			totals+=item.getTotal();
		}
		return totals;
	}
	public Double save(){
		Double  saves=0.0;
		for(Item item:items){
			saves+=item.getSave();
		}
		return saves;
	}
	public String toString(){
		String str="*****商店购物清单*****\n";
		for(Item item:items){
			str+=item.toString();
		}
		String str1="----------------------\n"
				+"总计："+total()+"(元)\n";
		if(save()>0.0)
			str1+="节省："+save() +"(元)\n";

		str1+="**********************";
		return str+str1;
	}
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
						addItem(id.getBarcode(),id.getName(),id.getUnit(),id.getPrice(),id.getDiscount());
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
}
