package assignment1;

import java.util.*;

public class COWIN {
	static Scanner sc = new Scanner(System.in);
	
//	All the ArrayLists and HashMaps
//	List of available Vaccines
	static ArrayList<Vaccine> vaccineList = new ArrayList<Vaccine>();
	
//	List of Hospitals
	static ArrayList<Hospital> hospitalList = new ArrayList<Hospital>();
	
//	List of Citizens
	static ArrayList<Citizen> citizenList = new ArrayList<Citizen>();
	
//	Initializing the Hospital Counter with 0
	public static int HC = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		while (choice != 8) {
			printMenu();
			choice = sc.nextInt();
			System.out.println("========================================");
			
			switch (choice) {
				case 1: {
					addVaccine();
					break;
				}
				
				case 2: {
					registerHospital();
					break;
				}
				
				case 3: {
					registerCitizen();
					break;
				}
				
				case 4: {
					addSlots();
					break;
				}
				
				case 5: {
					bookSlotsCall();
					break;
				}
				
				case 6: {
					listAllSlots();
					break;
				}
				
				case 7: {
					checkVaccinationCall();
					break;
				}
				
				case 8: {
					System.out.println("Goodbye!! :)");
					System.out.println("========================================");
					break;
				}
				
				default: {
					System.out.println("Invalid input! :(");
					System.out.println("Try again!!");
					System.out.println("========================================");
				}	
			}
		}
		
//		Close scanner
		sc.close();
	}
	

	public static void printMenu() {
/*		1. Add Vaccine
		2. Register Hospital
		3. Register Citizen
		4. Add Slot for Vaccination
		6. List all slots for a hospital
		7. Check Vaccination Status
		8. Exit */
		
		System.out.println("========================================");
		System.out.println("MENU");
		System.out.println("========================================");
		System.out.println("1. Add Vaccine");
		System.out.println("2. Register Hospital");
		System.out.println("3. Register Citizen");
		System.out.println("4. Add Slot for Vaccination");
		System.out.println("5. Book Slot for Vaccination");
		System.out.println("6. List all slots for a hospital");
		System.out.println("7. Check Vaccination Status");
		System.out.println("8. Exit");
		System.out.println("========================================");
		System.out.print("Choose the relevant option: ");
	}
	
	
//	1 => Add Vaccine
	public static void addVaccine() {
		// TODO Auto-generated method stub
		
//		Required Inputs
//		Name input
		System.out.print("Vaccine Name: ");
		String name = sc.next();
		
//		# of doses input
		System.out.print("Number of Doses: ");
		int dosesReq = sc.nextInt();
		
		if(dosesReq == 1) {
//			Create Vaccine Object
			Vaccine vObj = new Vaccine(name, dosesReq, -1);
			
//			Adding to Vaccine List
			vaccineList.add(vObj);
			
//			Display new Vaccine
			vObj.display();
			
			return;
		}
		else {
//			Gap input
			System.out.print("Gap between Doses: ");
			int gap = sc.nextInt();
			
//			Create Vaccine Object
			Vaccine vObj = new Vaccine(name, dosesReq, gap);
			
//			Adding to Vaccine List
			vaccineList.add(vObj);
			
//			Display new Vaccine
			vObj.display();
		}
	}
	
	
//	2 => Register Hospital
	public static void registerHospital() {
		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
		
//		Required Inputs
//		Name input
		System.out.print("Hospital Name: ");
		String name = sc.next();
		
//		Pincode
		System.out.print("PinCode: ");
		String pincode = sc.next()	;
		
//		Unique ID
		String hospitalID = codeGen(HC);
		HC++;
		
//		Create hospital Object
		Hospital hp = new Hospital(name, hospitalID, pincode);
		
//		Add to Hospital List
		hospitalList.add(hp);
		
//		Display
		hp.Display();
	}
	
	
//	3 => Register Citizen
	public static void registerCitizen() {
		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
		
//		Required Inputs
//		Name input
		System.out.print("Enter Name: ");
		String name = sc.next();
		
//		Age
		System.out.print("Enter age: ");
		int age = sc.nextInt();
		sc.nextLine();
		
//		Check for age limit
		if(age < 18) {
			System.out.println("Only above 18 are allowed!");
			return;
		}
		
//		Unique ID
		System.out.print("Enter Unique CitizenID: ");
		String citizenID = sc.nextLine();
		
//		Check if already registered
		for(int i = 0; i < citizenList.size(); i++) {
			if(citizenList.get(i).uniqueID.equals(citizenID)) {
				System.out.println("Already Registered!!");
				return;
			}
		}
		
//		Create citizen Object
		Citizen ct = new Citizen(name, age, citizenID);
		
//		Add to Hospital List
		citizenList.add(ct);
		
//		Display
		ct.Display();
	}
	
//	4 => Add Slots
	public static void addSlots() {		
//		Required Inputs
//		ID input
		System.out.print("Enter the Hospital ID: ");
		String hID = sc.next();
		
//		Find the correct hospital
		for(int i = 0; i < hospitalList.size(); i++) {
			if(hospitalList.get(i).hospitalID.equals(hID)) {
//				Create slots in the hospital
				hospitalList.get(i).CreateSlots();
				break;
			}
		}
	}
	
//	5 => Book Slots
	public static void bookSlotsCall() {
//		Required Inputs
//		ID input
		System.out.print("Enter patient Unique ID: ");
		String cID = sc.next();
		
//		Find the correct Citizen
		for(int i = 0; i < citizenList.size(); i++) {
			if(citizenList.get(i).uniqueID.equals(cID)) {
//				Book slots in the citizen
				citizenList.get(i).bookSlots();
				break;
			}
		}
	}
	
//	6 => List Slots
	public static void listAllSlots() {
		System.out.print("Enter Hospital Id: ");
		String hID = sc.next();
		
//		Find the correct hospital
		for(int i = 0; i < hospitalList.size(); i++) {
			if(hospitalList.get(i).hospitalID.equals(hID)) {
				hospitalList.get(i).ListSlots();
				break;
			}
		}
	}
	
//	7 => Check Vaccination Status
	public static void checkVaccinationCall() {
//		Required Inputs
//		ID input
		System.out.print("Enter patient Unique ID: ");
		String cID = sc.next();
		
//		Find the correct Citizen
		for(int i = 0; i < citizenList.size(); i++) {
			if(citizenList.get(i).uniqueID.equals(cID)) {
//				Book slots in the citizen
				citizenList.get(i).checkVaccination();
				break;
			}
		}
	}
	
		
	
//	Miscellaneous
	public static String codeGen(int val) {
		String x = Integer.toBinaryString(val);
		String ans = "";
		if (x.length() < 6) {
//			we need to add zeros
			for (int i = 0; i < 6 - x.length(); i++) {
				ans = ans + "0";
			}
			ans = ans + x;
		}
		else if (x.length() == 6){
			ans = ans + x;
		}
		else {
			ans = ans + x.substring(1);
		}
		return ans;
	}
}