package assignment1;

import java.util.*;

public class Hospital extends COWIN{
	String name;
	String hospitalID;
	String pincode;
	ArrayList<Slots> slotsList = new ArrayList<Slots>();
	
	public Hospital(String name, String hospitalID, String pincode) {
		this.name = name;
		this.hospitalID = hospitalID;
		this.pincode = pincode;
	}
	
	public void Display() {
		System.out.println("========================================");
		System.out.println("Hospital Added!! :)");
		System.out.println("Hospital Name: " + this.name);
		System.out.println("PinCode: " + this.pincode);
		System.out.println("Unique ID: " + this.hospitalID);
	}
	
	public void CreateSlots() {
//		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number of Slots to be added: ");
		int numSlots = sc.nextInt();
		
		for(int count = 1; count <= numSlots; count++) {
//			Take input of day/quantity.
			System.out.print("Enter Day Number: ");
			int day = sc.nextInt();
			
			System.out.print("Enter Quantity: ");
			int quantity = sc.nextInt();
			
//			Find the appropriate vaccine in the vaccine list(access through Covin)
			
//			Print Vaccine menu
			System.out.println("Select The Vaccine");
			for(int i = 0; i < COWIN.vaccineList.size(); i++) {
				System.out.println(i + ". " + COWIN.vaccineList.get(i).name);
			}
			System.out.println("Enter your Choice: ");
			int choice = sc.nextInt();
			
//			Choose Vaccine
			Vaccine v = COWIN.vaccineList.get(choice);
			
//			Create a slot 
			Slots s = new Slots(this.hospitalID, this.pincode, day, quantity, v);
			
//			Add the slot in ArrayList of this hospital
			slotsList.add(s);
			
//			Print Slot added;
			System.out.println("Slot added by Hospital " + this.hospitalID + " for Day: " + count);
			System.out.println("Available Quantity: " + quantity + " of Vaccine " + v.name);
		}
	}
	
	public void ListSlots() {
		System.out.println("========================================");
		System.out.println("Slots available in " + this.name + ": ");
		for (int i = 0; i < slotsList.size(); i++) {
			System.out.println("========================================");
			System.out.println("SLOT " + i);
			slotsList.get(i).Display();
		}
	}
}
