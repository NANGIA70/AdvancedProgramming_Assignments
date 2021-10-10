package assignment1;

public class Citizen extends COWIN{
	String name;
	int age;
	String uniqueID;
	String vaccinationStatus;
	Vaccine v_chosen;
	int dosesLeft;
	int dueDate = 0;
	boolean rodeo = false;
	
	public Citizen(String name, int age, String uniqueID) {
//		Constructor
		this.name = name;
		this.age = age;
		this.uniqueID = uniqueID;
		this.vaccinationStatus = "REGISTERED";
	}

	public void Display() {
//		Display
		System.out.println("Citizen Name: " + this.name);
		System.out.println("Age: " + this.age);
		System.out.println("Unique ID: " + this.uniqueID);
		System.out.println("Vaccination Status: "  + this.vaccinationStatus);
	}
	
	public void bookSlots() {	
		if(vaccinationStatus.equals("FULLY VACCINATED")) {
			System.out.println("You are already Vaccinated!! :)");
			return;
		}
		
		int choice = 0;
		
		while(choice != 3) {
			printSearchMenu();
			
			choice = sc.nextInt();
			switch (choice) {
				case 1: {
					searchByPincode();
					break;
				}
			
				case 2: {
					searchByVaccine();
					break;
				}
			
				case 3: {
					return;
				}
			
				default: {
					System.out.println("Invalid input! :(");
					System.out.println("Try again!!");
				}	
			}
		}
	}
	
	public void printSearchMenu() {
//		SEARCH MENU
		System.out.println("SEARCH MENU");
		System.out.println("1. Search By Area Pincode");
		System.out.println("2. Search By Vaccine");
		System.out.println("3. Exit ");
		System.out.print("Enter Your Choice: ");
	}
	
	public void searchByPincode() {
		System.out.println("SEARCH BY PINCODE");
		
//		Input Pincode
		System.out.print("Enter PinCode: ");
		String pin = sc.next();
		
//		Print list of Hospitals
		System.out.println("List of hospitals available in Pincode " + pin);
		for(int i = 0; i < COWIN.hospitalList.size(); i++) {
			if(COWIN.hospitalList.get(i).pincode.equals(pin)) {
				System.out.println("Hospital Name: " + COWIN.hospitalList.get(i).name + "	HospitalID: " + COWIN.hospitalList.get(i).hospitalID);
			}
		}
		
//		Input HID to select hospital
		System.out.print("Enter Hospital ID: ");
		String HID = sc.next();
		
//		Display Slots past the dueDate
		for(int i = 0; i < COWIN.hospitalList.size(); i++) {
			if(COWIN.hospitalList.get(i).hospitalID.equals(HID)) {
				for(int j = 0; j < COWIN.hospitalList.get(i).slotsList.size(); j++) {
					if(COWIN.hospitalList.get(i).slotsList.get(j).day >= this.dueDate) {
						System.out.println("========================================");
						System.out.println("SLOT " + j);
						COWIN.hospitalList.get(i).slotsList.get(j).Display();
					}
				}
			}
		}
		
//		Input slotChoice to select Slot
		System.out.print("Choose Slot: ");
		int slotChoice = sc.nextInt();
		
//		
		for(int i = 0; i < COWIN.hospitalList.size(); i++) {
			if(COWIN.hospitalList.get(i).hospitalID.equals(HID)) {
//				Check if patient is changing vaccines
				if(rodeo && !v_chosen.name.equals(COWIN.hospitalList.get(i).slotsList.get(slotChoice).V.name)) {
					System.out.println("You Cannot Switch Vaccines!! :("); 
					return;
				}
//				Otherwise Get correct Vaccine
				else {
					v_chosen = COWIN.hospitalList.get(i).slotsList.get(slotChoice).V;
				}
				
//				Use one vaccine -> reduce the quantity in hospital slot
				COWIN.hospitalList.get(i).slotsList.get(slotChoice).quantity--;
				
//				Change the next due Date to this day
				dueDate = COWIN.hospitalList.get(i).slotsList.get(slotChoice).day;
			}
		}
		
		System.out.println(this.name + " vaccinated by " + v_chosen.name);
		
//		Changes in Citizen information
//		Doses Left in vaccination
		if(rodeo) {
			dosesLeft--;
		}
		else {
			dosesLeft = v_chosen.dosesReq - 1;
		}
		
//		Vaccination Status Change
		if(dosesLeft == 0) {
			this.vaccinationStatus = "FULLY VACCINATED";
		}
		else {
			this.vaccinationStatus = "PARTIALLY VACCINATED";
//			Due Date of next Vaccination (Day number + Gap)
			dueDate += v_chosen.gap;
		}
		
//		He has recieved atleast one dose
		rodeo = true;
	}
	
	public void searchByVaccine() {
		System.out.println("SEARCH BY VACCINE");
		System.out.print("Enter Vaccine Name: ");
		String vName = sc.next();
		
//		Check if patient is switching vaccines
		if(rodeo && !v_chosen.name.equals(vName)) {
			System.out.println("You Cannot Switch Vaccines!! :("); 
			return;
		}
		else {
			for(int i = 0; i < COWIN.hospitalList.size(); i++) {
				for(int j = 0; j < COWIN.hospitalList.get(i).slotsList.size(); j++) {
					
				}
			}
		}
		
		
//		He has recieved atleast one dose
		rodeo = true;
	}
}
