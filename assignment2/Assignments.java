package assignment2;

import java.util.*;

public class Assignments extends BackPack implements Assessments {
	private String problemStatement;
	
//	Marks
	private int maxMarks;
	
	private boolean open;
	
	private ArrayList<Grading> studentGrading;
	
//	Constructor
	public Assignments() {
		this.setOpen(true);
		
//		List of student grades initialized
		studentGrading = new ArrayList<Grading>(BackPack.studentList.size());
		
//		Create Grading sheet for every student
		for (int i = 0; i < BackPack.studentList.size(); i++) {
			AssignmentGrading ag = new AssignmentGrading(BackPack.studentList.get(i));
			studentGrading.add(ag);
		}
	}

	@Override
	public void addAssessment() {
		// TODO Auto-generated method stub
		sc.nextLine();
		System.out.println("========================================");
		System.out.print("Enter Problem Statement: ");
		this.setProblemStatement(sc.nextLine());
		
		System.out.print("Enter Max Marks: ");
		this.setMaxMarks(sc.nextInt());
		System.out.println("========================================");
	}
	
	@Override
	public void displayAssessment() {
		// TODO Auto-generated method stub
		System.out.println("========================================");
//		Assignment Problem Statement
		System.out.println("Assignment: " + this.getProblemStatement());
//		Max Marks
		System.out.println("Max Marks: " + this.getMaxMarks());
		System.out.println("========================================");
	}
	
	@Override
	public void gradeAssessment(String gradedBy) {
		// TODO Auto-generated method stub
		System.out.println("========================================");
		System.out.println("List of Ungraded Submissions");
		System.out.println("========================================");
		
		boolean ungradedSubmission = true;
		
//		Print all ungraded submissions
		for (int i = 0; i < this.getStudentGrading().size(); i++) {
			ungradedSubmission = false;
			
//			Check if submission is ungraded
			if (this.getStudentGrading().get(i).isGraded() == false && this.getStudentGrading().get(i).isPending() == false) {
				System.out.println("========================================");
				System.out.println("Student " + i + ": " + BackPack.studentList.get(i).getName());
			}
		}
		
		if(ungradedSubmission) {
			System.out.println("========================================");
			System.out.println("No Ungraded Submission!!");
			System.out.println("========================================");
			return;
		}
		
		System.out.println("========================================");
		System.out.print("Enter ID from the ungraded Submissions: ");
		
//		Choice Input
		int submissionChoice = sc.nextInt();
		System.out.println("========================================");
		
		if (submissionChoice < 0 || submissionChoice >= this.getStudentGrading().size()) {
			System.out.println("Invalid Input!! :(");
			System.out.println("========================================");
			return;
		}
		
		System.out.println("========================================");
		System.out.println("Submission: " + this.getStudentGrading().get(submissionChoice).getSubmission());
		System.out.println("========================================");
		
		System.out.println("Maximum Marks: " + this.getMaxMarks());
		System.out.print("Enter Marks Scored: ");
		
		int marks = sc.nextInt();
		if (marks > this.getMaxMarks() || marks < 0) {
			System.out.println("Invalid Marks!! :(");
			return;
		}
		
//		Make relevant Changes in Student Grading Sheet
		this.getStudentGrading().get(submissionChoice).setGradedBy(gradedBy);
		this.getStudentGrading().get(submissionChoice).setMarksObtained(marks);
		this.getStudentGrading().get(submissionChoice).setGraded(true);
	}
	
	@Override
	public void closeAssessment() {
		// TODO Auto-generated method stub
		this.setOpen(false);
	}
	
	@Override
	public void submitAssessment(int studentID) {
		// TODO Auto-generated method stub
		sc.nextLine();
		System.out.println("========================================");
		System.out.print("Enter filename of assignment: ");
		
		String submission = sc.nextLine();
		System.out.println("========================================");
		
		if(submission.endsWith(".zip")) {
			this.getStudentGrading().get(studentID).setSubmission(submission);
			this.getStudentGrading().get(studentID).setPending(false);
		}
		else {
			System.out.println("Invalid File type!! :(");
			System.out.println("========================================");
		}
	}
	
	@Override
	public String getProblemQuestion() {
		return problemStatement;
	}
	
	
//	Getters and Setters
//	Problem Statement
	public String getProblemStatement() {
		return problemStatement;
	}
	
	public void setProblemStatement(String problemStatement) {
		this.problemStatement = problemStatement;
	}
	
//	Max Marks
	public int getMaxMarks() {
		return maxMarks;
	}
	
	public void setMaxMarks(int maxMarks) {
		this.maxMarks = maxMarks;
	}

//	closed or open
	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public ArrayList<Grading> getStudentGrading() {
		return studentGrading;
	}

	public void setStudentGrading(ArrayList<Grading> studentGrading) {
		this.studentGrading = studentGrading;
	}
	

////	Marks obtained
//	public int getMarksObtained() {
//		return marksObtained;
//	}
//
//	public void setMarksObtained(int marksObtained) {
//		this.marksObtained = marksObtained;
//	}
//
////	Graded or not
//	public boolean isGraded() {
//		return graded;
//	}
//
//	public void setGraded(boolean graded) {
//		this.graded = graded;
//	}
//
////	Pending or not
//	public boolean isPending() {
//		return pending;
//	}
//
//	public void setPending(boolean pending) {
//		this.pending = pending;
//	}
//
////	Assignment Graded By
//	public String getGradedBy() {
//		return gradedBy;
//	}
//
//	public void setGradedBy(String gradedBy) {
//		this.gradedBy = gradedBy;
//	}
}