package pos;

public class User {
	private String name;
	private boolean isVip;
	public User(String name,boolean isVip){
		this.name=name;
		this.isVip=isVip;
	}
	public String getName(){
		return name;
	}
	public boolean getIsVip(){
		return isVip;
	}
}
