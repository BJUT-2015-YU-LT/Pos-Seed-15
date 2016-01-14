
public class PosMain {
	public static void main(String[] args) {
		ItemManager items =new ItemManager();
		items.fileInput("Items.txt");
		System.out.println(items.toString());
	}


}
