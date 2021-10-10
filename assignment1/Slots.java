package assignment1;

public class Slots {
	String hospitalID;
	String Pincode;
	int day;
	int quantity;
	Vaccine V;
	
	public Slots(String hospitalID, String pincode, int day, int quantity, Vaccine v) {
		this.hospitalID = hospitalID;
		this.Pincode = pincode;
		this.day = day;
		this.quantity = quantity;
		this.V = v;
	}
	
	public void Display() {
		System.out.println("========================================");
		System.out.println("Day: " + this.day);
		System.out.println("Vaccine: " + V.name);
		System.out.println("Available Quantity: " + quantity);
		System.out.println("========================================");
	}
}
