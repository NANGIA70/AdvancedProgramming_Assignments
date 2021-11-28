package assignment4;

public class Tiles {
	private SoftToy st;

	public Tiles(String name) {
		this.setSt(new SoftToy(name));
	}

	public SoftToy getSt() {
		return st;
	}

	public void setSt(SoftToy st) {
		this.st = st;
	}
	
	public SoftToy win() {
		System.out.println("You have won a " + st.getName() + " Soft Toy!! :)");
		
		SoftToy st2 = new SoftToy(" ");
		
//		Clone
		try {
			st2 = (SoftToy)st.clone();
		}
		catch (CloneNotSupportedException cnse) {
			System.out.println(cnse.getMessage());
		}
		return st2;
	}
}