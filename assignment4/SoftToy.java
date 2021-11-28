package assignment4;

public class SoftToy implements Cloneable{
	private String name;
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	 
	public SoftToy(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}