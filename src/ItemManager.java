import java.util.Vector;


public class ItemManager {
    Vector<Item> items=new Vector<Item>();

    public void addItem(String barcode, String name, String unit, double price){
        int n=0;
        for(Item item:items){
            if(item.barcode.equals(barcode)){
                item.addItemNum();
                break;
            }
            n++;
        }
        if(n==items.size())
            items.addElement(new Item( barcode,name,unit,price));
    }
    public double total(){
        double  totals=0.0;
        for(Item item:items){
            totals+=item.getTotal();
        }
        return totals;
    }
    public String toString(){
        String str="***商店购物清单***\n";
        for(Item item:items){
            str+=item.toString();
        }
        String str1="----------------------\n总计："
                +total()+"(元)\n"+
                "**********************";
        return str+str1;
    }
}
