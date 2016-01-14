
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;


public class ItemManager {
	Vector<Item> items=new Vector<Item>();

	public void addItem(String barcode, String name, String unit, double price, double discount){
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
	public double total(){
		double  totals=0.0;
		for(Item item:items){
			totals+=item.getTotal();
		}
		return totals;
	}
	public double save(){
		double  saves=0.0;
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
		File file=new File(fileName);
		try {
			Scanner in=new Scanner(file);
			while(in.hasNext()){
				addItem(in.next(),in.next(),in.next(),in.nextDouble(),in.nextDouble());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
