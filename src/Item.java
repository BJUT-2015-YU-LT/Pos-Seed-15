public class Item{
    String barcode;  //��Ʒ���
    String name;	//��Ʒ��
    String unit;    //��λ
    double  price;
    int num;
    double total=0.0;
    public Item(String b, String n, String u, double p){
        barcode=b;
        name=n;
        unit=u;
        price=p;
        num=1;
        total=p;
    }
    public void addItemNum(){
        total+=price;
        num++;
    }
    public String toString(){
        return ("名称："+name+"，数量："+num+unit+"，单价："
                +price+"(元)"+"，小计："+total+"(元)"+"\n");
    }
    public double getTotal(){
        return total;
    }
}