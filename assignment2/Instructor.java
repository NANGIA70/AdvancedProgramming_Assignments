package assignment2;

public class Instructor extends BackPack implements Account{
	private int instructorID;
	private String name;
	
//	Constructor
	public Instructor(String name, int instructorID) {
		this.setName(name);
		this.setInstructorID(instructorID);
	}

	@Override
	public void showMenu() {
		// TODO Auto-generated method stub
/*		1. Add class material
		2. Add assessments
		3. View lecture materials
		4. View assessments
		5. Grade assessments
		6. Close assessment
		7. View comments
		8. Add comments
		9. Logout */
		
		System.out.println("========================================");
		System.out.println("Welcome " + this.getName());
		System.out.println("========================================");
		System.out.println("INSTRUCTOR MENU");
		System.out.println("========================================");
		System.out.println("1. Add class material");
		System.out.println("2. Add assessments");
		System.out.println("3. View lecture materials");
		System.out.println("4. View assessments");
		System.out.println("5. Grade assessments");
		System.out.println("6. Close assessment");
		System.out.println("7. View comments");
		System.out.println("8. Add comments");
		System.out.println("9. Logout");
		System.out.println("========================================");
		System.out.print("Choose the relevant option: ");
	}
	
	@Override
	public int functionCall(int choice) {
		// TODO Auto-generated method stub
		switch (choice) {
			case 1: {
//				Add Class Material
				addLectureMaterials();
				return 0;
			}
		
			case 2: {
//				Add assessments
				addAssessments();
				return 0;
			}
		
			case 3: {
//				View Lecture Material
				viewLectureMaterials();
				return 0;
			}
		
			case 4: {
//				View Assessments
				viewAssessments();
				return 0;
			}
		
			case 5: {
//				Grade Assessments
				gradeAssessments();
				return 0;
			}
		
			case 6: {
//				Close Assessments
				closeAssessments();
				return 0;
			}
		
			case 7: {
//				View Comments
				viewComments();
				return 0;
			}
		
			case 8: {
//				Add Comments
				addComments();
				return 0;
			}
		
			case 9: {
				System.out.println("Goodbye!! :)");
				System.out.println("========================================");
				return -1;
			}
		
			default: {
				System.out.println("Invalid input!! :(");
				System.out.println("Try again!!");
				System.out.println("========================================");
				return 0;
			}	
		}
	}
	
//	Functions to add Lecture Materials
	public void addLMCall(LectureMaterial LM) {
//		Add content and details
		LM.addMaterial();
		
//		Add material to Lecture Material List
		BackPack.lectureMaterialList.add(LM);
	}
	
	public void addLectureMaterials() {
		System.out.println("========================================");
		System.out.println("1. Add Lecture Slide");
		System.out.println("2. Add Lecture Video");
		System.out.println("========================================");
		System.out.print("Choose the relevant option: ");
		
//		Choice Input
		int materialChoice = sc.nextInt();
		System.out.println("========================================");
		
		switch (materialChoice) {
			case 1: {
//				Add Lecture Slide
				LectureSlides LS = new LectureSlides(this.getName());
				addLMCall(LS);
				break;			
			}
			
			case 2: {
//				Add Lecture Video
				LectureVideos LV = new LectureVideos(this.getName());
				addLMCall(LV);
				break;
			}
		
			default: {
				System.out.println("Invalid input!! :(");
				System.out.println("========================================");
				return;
			}	
		}
	}
	
//	Functions to add Assessments
	public void addACall(Assessments A) {
//		Add content and details
		A.addAssessment();
		
//		Add assessment to the Assessments List
		BackPack.assessmentsList.add(A);
	}
	
	public void addAssessments() {
		System.out.println("========================================");
		System.out.println("1. Add Assignment");
		System.out.println("2. Add Quiz");
		System.out.println("========================================");
		System.out.print("Choose the relevant option: ");
		
//		Choice Input
		int assessmentChoice = sc.nextInt();
		System.out.println("========================================");
		
		switch (assessmentChoice) {
			case 1: {
//				Add Assignment
				Assignments AS = new Assignments();
				addACall(AS);
				break;			
			}
			
			case 2: {
//				Add Quiz
				Quiz Q = new Quiz();
				addACall(Q);
				break;
			}
		
			default: {
				System.out.println("Invalid input!! :(");
				System.out.println("========================================");
				return;
			}	
		}
	}
	
	
//	Functions to close Assessments
	public void closeCall(Assessments A) {
//		Close
		A.closeAssessment();
	}
	
	public void closeAssessments() {
		System.out.println("========================================");
		System.out.println("List of Open Assessments");
		System.out.println("========================================");
		
		boolean openFlag = true;
		
//		Print all open assessments
		for (int i = 0; i < BackPack.assessmentsList.size(); i++) {
//			Check if assignment is open
			if (BackPack.assessmentsList.get(i).isOpen()) {
				openFlag = false;
				System.out.println("========================================");
				System.out.println("Assessment ID " + i + ": ");
				BackPack.assessmentsList.get(i).displayAssessment();
			}
		}
		
		if(openFlag) {
			System.out.println("========================================");
			System.out.println("NO open Assessments!!");
			System.out.println("========================================");
			return;
		}
		
		System.out.println("========================================");
		System.out.print("Enter ID of assessment to close: ");
		
//		Choice Input
		int assessmentCloseChoice = sc.nextInt();
		System.out.println("========================================");
		
//		Check for invalid input
		if(assessmentCloseChoice < 0 || assessmentCloseChoice >= BackPack.assessmentsList.size()) {
			System.out.println("Invalid input!! :(");
			System.out.println("========================================");
			return;
		}
		
//		Close call;
		closeCall(BackPack.assessmentsList.get(assessmentCloseChoice));
	}
	
//	Functions to grade Assessments
	public void gradeCall(Assessments A) {
//		Grade
		A.gradeAssessment(this.getName());
	}
	
	public void gradeAssessments() {
		System.out.println("========================================");
		System.out.println("List of Assessments");
		System.out.println("========================================");
		
		boolean openFlag = true;
		
//		Print all open assessments
		for (int i = 0; i < BackPack.assessmentsList.size(); i++) {
//			Check if assignment is open
			if (BackPack.assessmentsList.get(i).isOpen()) {
				openFlag = false;
				System.out.println("========================================");
				System.out.println("Assessment ID " + i + ": ");
				BackPack.assessmentsList.get(i).displayAssessment();
			}
		}
		
		if(openFlag) {
			System.out.println("========================================");
			System.out.println("NO open Assessments!!");
			System.out.println("========================================");
			return;
		}
		
		System.out.println("========================================");
		System.out.print("Enter ID of assessment to grade Submissions: ");
		
//		Choice Input
		int assessmentGradeChoice = sc.nextInt();
		System.out.println("========================================");
		
//		Check for invalid input
		if(assessmentGradeChoice < 0 || assessmentGradeChoice >= BackPack.assessmentsList.size()) {
			System.out.println("Invalid input!! :(");
			System.out.println("========================================");
			return;
		}	
		
//		Grade call;
		gradeCall(BackPack.assessmentsList.get(assessmentGradeChoice));
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

//	Instructor ID
	public int getInstructorID() {
		return instructorID;
	}

	public void setInstructorID(int instructorID) {
		this.instructorID = instructorID;
	}
}