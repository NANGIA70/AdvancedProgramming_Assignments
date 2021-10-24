package assignment3;

public abstract class Floor {
	private String name;
	private int floorNumber;
	private String floorType;
	
	public abstract void Display();
	
	public abstract int getPoint();
	
	public abstract int getNewPos();
	
//	constructor
	public Floor(String name) {
		super();
		this.name = name;
	}

//	Getters and Setters
//	Floor number
	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

//	Name of player
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFloorType() {
		return floorType;
	}

	public void setFloorType(String floorType) {
		this.floorType = floorType;
	}
}
