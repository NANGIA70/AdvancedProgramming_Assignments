package assignment3;

public class KingCobra extends Snake{
	@Override
	public void Display() {
		System.out.println(this.getName() + " has reached a King Cobra Floor");
	}

	public KingCobra(String name) {
		// TODO Auto-generated constructor stub
		super(name);
		this.setPoint(-4);
		this.setNewPos(3);
		this.setFloorType("KingCobra");
	}
}
