package assignment3;

public class Empty extends Floor{
	private int point;
	private int newPos;
	
	public Empty(String name) {
		// TODO Auto-generated constructor stub
		super(name);
		this.setPoint(1);
		this.setNewPos(getFloorNumber());
		this.setFloorType("Empty");
	}

	public void Display() {
		System.out.println(this.getName() + " has reached an Empty Floor");
	}

//	Getters and Setters
//	Points
	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

//	New Position => no change
	public int getNewPos() {
		return newPos;
	}

	public void setNewPos(int newPos) {
		this.newPos = newPos;
	}
	
	
}
