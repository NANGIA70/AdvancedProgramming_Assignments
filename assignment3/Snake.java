package assignment3;

public class Snake extends Floor{
	private int point;
	private int newPos;

	public void Display() {
		System.out.println(this.getName() + " has reached a Normal Snake Floor");
	}

	public Snake(String name) {
		// TODO Auto-generated constructor stub
		super(name);
		this.setPoint(-2);
		this.setNewPos(1);
		this.setFloorType("Snake");
	}

//	Getters and Setters
//	Points
	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

//	New Position
	public int getNewPos() {
		return newPos;
	}

	public void setNewPos(int newPos) {
		this.newPos = newPos;
	}
}
