import java.io.IOException;
import java.util.Scanner;

/**
 * Created by suseng on 2016/1/5.
 */
public class Main {
    public static void main(String[] args)throws IOException
    {   String barcode,name,unit;
        double price;
        char ch;
        Scanner sc=new Scanner(System.in);
        ItemManager items =new ItemManager();
        do{

            System.out.print("barcode:");
            barcode=sc.next();
            System.out.print("name:");
            name=sc.next();
            System.out.print("unit:");
            unit=sc.next();
            System.out.print("price:");
            price=sc.nextDouble();
            items.addItem(barcode,name, unit, price);
            System.out.print("是否继续？Y/N:");
            ch=sc.next().charAt(0);
        }while(ch=='Y');
        System.out.println(items.toString());
    }
}
