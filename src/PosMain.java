
public class PosMain {
	public static void main(String[] args) {
		ItemManager items =new ItemManager("index.txt");
		items.fileInput("Items.txt");
		System.out.println(items.toString());
	}
}