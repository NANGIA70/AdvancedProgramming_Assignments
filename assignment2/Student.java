package assignment2;

public class Student extends BackPack implements Account{
	private int studentID;
	private String name;
	
//	Constructor
	public Student(String name, int studentID) {
		this.setName(name);
		this.setStudentID(studentID);
	}

	@Override
	public void showMenu() {
		// TODO Auto-generated method stub
/*		1. View lecture materials
		2. View assessments
		3. Submit assessment
		4. View grades
		5. View comments
		6. Add comments
		7. Logout */
		
		System.out.println("========================================");
		System.out.println("Welcome " + this.getName());
		System.out.println("========================================");
		System.out.println("STUDENT MENU");
		System.out.println("========================================");
		System.out.println("1. View lecture materials");
		System.out.println("2. View assessments");
		System.out.println("3. Submit assessment");
		System.out.println("4. View grades");
		System.out.println("5. View comments");
		System.out.println("6. Add comments");
		System.out.println("7. Logout");
		System.out.println("========================================");
		System.out.print("Choose the relevant option: ");
		
	}

	@Override
	public int functionCall(int choice) {
		// TODO Auto-generated method stub
		switch (choice) {
			case 1: {
//				View Lecture Material
				viewLectureMaterials();
				return 0;
			}
	
			case 2: {
//				View Assessments
				viewAssessments();
				return 0;
			}
	
			case 3: {
//				Submit Assessments
				submitAssessments();
				return 0;
			}
	
			case 4: {
//				View Grades
				viewGrades();
				return 0;
			}
	
			case 5: {
//				View Comments
				viewComments();
				return 0;
			}
	
			case 6: {
//				Add Comments
				addComments();
				return 0;
			}
	
			case 7: {
				System.out.println("Goodbye!! :)");
				System.out.println("========================================");
				return -1;
			}
	
			default: {
				System.out.println("Invalid input! :(");
				System.out.println("Try again!!");
				System.out.println("========================================");
				return 0;
			}	
		}
	}

//	Functions to submit Assessments
	public void submitCall(Assessments A) {
//		Submit
		A.submitAssessment(this.getStudentID());
	}
	
	public void submitAssessments() {
		System.out.println("========================================");
		System.out.println("List of Pending Assessments");
		System.out.println("========================================");
		
		boolean pendingFlag = true;
		
//		Print all open assessments
		for (int i = 0; i < BackPack.assessmentsList.size(); i++) {
//			Check if assignment is open and pending
			if (BackPack.assessmentsList.get(i).isOpen() && BackPack.assessmentsList.get(i).getStudentGrading().get(this.getStudentID()).isPending()) {
				pendingFlag = false;
				
				System.out.println("========================================");
				System.out.println("Assessment ID " + i + ": ");
				BackPack.assessmentsList.get(i).displayAssessment();
			}
		}
		
		if(pendingFlag) {
			System.out.println("========================================");
			System.out.println("NO open Assessments!!");
			System.out.println("========================================");
			return;
		}
		
		System.out.println("========================================");
		System.out.print("Enter ID of assessment: ");
		
//		Choice Input
		int assessmentSubmitChoice = sc.nextInt();
		System.out.println("========================================");
		
//		Check for invalid input
		if(assessmentSubmitChoice < 0 || assessmentSubmitChoice >= BackPack.assessmentsList.size()) {
			System.out.println("Invalid input!! :(");
			System.out.println("========================================");
			return;
		}
		
//		Close call;
		submitCall(BackPack.assessmentsList.get(assessmentSubmitChoice));
	}
	
	
	public void viewGrades() {
		System.out.println("========================================");
		System.out.println("Graded Submissions");
		System.out.println("========================================");
		
//		Print all Graded assessments
		for (int i = 0; i < BackPack.assessmentsList.size(); i++) {
//			Check if assignment is Graded
			if (BackPack.assessmentsList.get(i).getStudentGrading().get(this.getStudentID()).isGraded()) {			
				System.out.println("========================================");
				System.out.println("Assessment " + i + ": " + BackPack.assessmentsList.get(i).getProblemQuestion());
				System.out.println("Submission: " + BackPack.assessmentsList.get(i).getStudentGrading().get(this.getStudentID()).getSubmission());
				System.out.println("Marks Obtained: " + BackPack.assessmentsList.get(i).getStudentGrading().get(this.getStudentID()).getMarksObtained());
				System.out.println("Max Marks: " + BackPack.assessmentsList.get(i).getMaxMarks());
				System.out.println("Graded By: " + BackPack.assessmentsList.get(i).getStudentGrading().get(this.getStudentID()).getGradedBy());
				System.out.println("========================================");
			}
		}
		
		System.out.println("========================================");
		System.out.println("Ungraded Submissions");
		System.out.println("========================================");
		
//		Print all Ungraded assessments
		for (int i = 0; i < BackPack.assessmentsList.size(); i++) {
//			Check if assignment is Graded
			if (BackPack.assessmentsList.get(i).getStudentGrading().get(this.getStudentID()).isGraded() == false && BackPack.assessmentsList.get(i).getStudentGrading().get(this.getStudentID()).isPending() == false) {			
				System.out.println("========================================");
				System.out.println("Assessment " + i + ": " + BackPack.assessmentsList.get(i).getProblemQuestion());
				System.out.println("Submission: " + BackPack.assessmentsList.get(i).getStudentGrading().get(this.getStudentID()).getSubmission());
				System.out.println("========================================");
			}
		}
	}
	
//	Interface Methods
	@Override
	public void viewLectureMaterials() {
		// TODO Auto-generated method stub
		System.out.println("========================================");
		System.out.println("LECTURE MATERIALS");
		System.out.println("========================================");
		
//		Display all lecture materials
		for (int i = 0; i < BackPack.lectureMaterialList.size(); i++) {
			BackPack.lectureMaterialList.get(i).displayMaterial();
		}
	}
	
	@Override
	public void viewAssessments() {
		// TODO Auto-generated method stub
		System.out.println("========================================");
		System.out.println("ASSESSMENTS");
		System.out.println("========================================");
		
//		Display all lecture materials
		for (int i = 0; i < BackPack.assessmentsList.size(); i++) {
			BackPack.assessmentsList.get(i).displayAssessment();
		}
	}

	@Override
	public void viewComments() {
		// TODO Auto-generated method stub
		System.out.println("========================================");
		System.out.println("COMMENTS FORUM");
		System.out.println("========================================");
		
//		Display all comments
		for (int i = 0; i < BackPack.commentsList.size(); i++) {
			BackPack.commentsList.get(i).Display();
		}
	}

	@Override
	public void addComments() {
		// TODO Auto-generated method stub
		sc.nextLine();
		System.out.println("========================================");
//		Input content
		System.out.print("Enter Comment: ");
		String content = sc.nextLine();
		
//		Object with author name and content
		Comment C = new Comment(this.getName(), content);
		
//		Add to the forum/commentsList
		BackPack.commentsList.add(C);
		System.out.println("========================================");
	}	
	

//	Getters and Setters
//	Name
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	Student ID
	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
}