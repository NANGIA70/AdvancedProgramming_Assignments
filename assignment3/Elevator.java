package assignment3;

public class Elevator extends Ladder{
	@Override
	public void Display() {
		System.out.println(this.getName() + " has reached an Elevator Floor");
	}

	public Elevator(String name) {
		// TODO Auto-generated constructor stub
		super(name);
		this.setPoint(4);
		this.setNewPos(10);
		this.setFloorType("Elevator");
	}
}
