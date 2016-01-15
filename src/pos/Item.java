package pos;

public class Item{
    String barcode;     // �商品编码�
    String name;	     //�商品名�
    String unit;        //��单位
    Double  price;    //商品单价
    int num;           //商品数量
    Double total=0.0;  //总价
    public Item(String b, String n, String u, Double p){
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
    public Double getTotal(){
        return total;
    }
}