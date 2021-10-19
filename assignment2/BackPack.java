package assignment2;

import java.util.*;

public class BackPack {
	static Scanner sc = new Scanner(System.in);
	
//	All the ArrayLists 
//	List of instructors
	protected final static ArrayList<Instructor> instructorList = new ArrayList<Instructor>();
	
//	List of students
	protected final static ArrayList<Student> studentList = new ArrayList<Student>();
	
//	List of comments
	protected static ArrayList<Comment> commentsList = new ArrayList<Comment>();
	
//	List of Lecture Materials
	protected static ArrayList<LectureMaterial> lectureMaterialList = new ArrayList<LectureMaterial>();
	
//	List of Assessments
	protected static ArrayList<Assessments> assessmentsList = new ArrayList<Assessments>();
	
//	public BackPack() {
//		// TODO Auto-generated constructor stub
////		Initializing Class
////		Initializing Instructors
//		Instructor I0 = new Instructor("I0", 0);
//		instructorList.add(I0);
//		
//		Instructor I1 = new Instructor("I1", 1);
//		instructorList.add(I1);
//		
////		Initializing Students
//		Student S0 = new Student("SO", 0);
//		studentList.add(S0);
//		
//		Student S1 = new Student("S1", 1);
//		studentList.add(S1);
//		
//		Student S2 = new Student("S2", 2);
//		studentList.add(S2);
//		
///*		In general case:-
//		addInstructor();
//		addStudent(); */
//		
//	}
	
	
	public static void main(String[] args) {
		Instructor I0 = new Instructor("I0", 0);
		instructorList.add(I0);
		
		Instructor I1 = new Instructor("I1", 1);
		instructorList.add(I1);
		
//		Initializing Students
		Student S0 = new Student("SO", 0);
		studentList.add(S0);
		
		Student S1 = new Student("S1", 1);
		studentList.add(S1);
		
		Student S2 = new Student("S2", 2);
		studentList.add(S2);
		
		int choice = 0;
		
		while (choice != 3) {
			printMenu();
			
			choice = sc.nextInt();
			System.out.println("========================================");
			
			switch (choice) {
				case 1: {
//					Instructor
					listInstructors();
					
					int instructorChoice = sc.nextInt();
					System.out.println("========================================");
					
					if (instructorChoice < 0 || instructorChoice >= instructorList.size()) {
						System.out.println("Invalid Input!! :(");
						System.out.println("Try again!!");
						System.out.println("========================================");
						break;
					}
					else {
						funcCall(instructorList.get(instructorChoice));
					}
					
					break;
				}
		
				case 2: {
//					Student
					listStudents();
					
					int studentChoice = sc.nextInt();
					System.out.println("========================================");
					
					if (studentChoice < 0 || studentChoice >= studentList.size()) {
						System.out.println("Invalid Input!! :(");
						System.out.println("Try again!!");
						System.out.println("========================================");
						break;
					}
					else {
						funcCall(studentList.get(studentChoice));
					}
					
					break;
				}
				
				case 3: {
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
	}

	public static void printMenu() {
		// TODO Auto-generated method stub
		System.out.println("========================================");
		System.out.println("Welcome to BackPack");
		System.out.println("========================================");
		System.out.println("MENU");
		System.out.println("========================================");
		System.out.println("1. Enter as Instructor");
		System.out.println("2. Enter as Student");
		System.out.println("3. Exit");
		System.out.println("========================================");
		System.out.print("Choose the relevant option: ");
	}
	
	public static void listInstructors() {
		System.out.println("========================================");
		System.out.println("Instructors");
		System.out.println("========================================");
		for (int i = 0; i < instructorList.size(); i++) {
			System.out.println(i + " - " + instructorList.get(i).getName());
		}
		System.out.println("========================================");
		System.out.print("Choose the ID: ");
	}
	
	public static void listStudents() {
		System.out.println("========================================");
		System.out.println("Students");
		System.out.println("========================================");
		for (int i = 0; i < studentList.size(); i++) {
			System.out.println(i + " - " + studentList.get(i).getName());
		}
		System.out.println("========================================");
		System.out.print("Choose the ID: ");
	}
	
	public static void funcCall(Account acc) {
		int flag = 0;
		while (flag != -1) {
//			Print the Account menu
			acc.showMenu();
			
//			Choice Input
			int accChoice = sc.nextInt();
			System.out.println("========================================");
			
//			Call the function call of the account
			flag = acc.functionCall(accChoice);
		}
	}
	
	
//	Functions to expand the Class if needed
//	Increase Instructors
	public static void addInstructor() {
		int numOfInstructors;
		System.out.println("========================================");
		System.out.print("Enter the number of instructors to be added: ");
		numOfInstructors = sc.nextInt();
		
		for (int i = 0; i < numOfInstructors; i++) {
			System.out.print("Enter the name of instructor " + i + ": ");
			String instructorName = sc.next();
			
			Instructor I = new Instructor(instructorName, i);
			instructorList.add(I);
		}
		System.out.println("========================================");
	}
	
//	Increase Students
	public static void addStudent() {
		int numOfStudents;
		System.out.println("========================================");
		System.out.print("Enter the number of Students to be added: ");
		numOfStudents= sc.nextInt();
		
		for (int i = 0; i < numOfStudents; i++) {
			System.out.print("Enter the name of student " + i + ": ");
			String studentName = sc.next();
			
			Student S = new Student(studentName, i);
			studentList.add(S);
		}
		System.out.println("========================================");
	}
}