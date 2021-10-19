package assignment2;

import java.util.*;

public class Quiz extends BackPack implements Assessments{
	private String question;
//	private String gradedBy;
	
//	Marks
	private int maxMarks;
//	private int marksObtained;
	
	private boolean open;
//	private boolean pending;
//	private boolean graded;
	
	private ArrayList<Grading> studentGrading;
	
//	Constructor
	public Quiz() {
		// TODO Auto-generated constructor stub
		this.setOpen(true);
		this.setMaxMarks(1);
//		this.setPending(true);
//		this.setGraded(false);
//		this.setMarksObtained(-1);
		
//		List of student grades initialized
		studentGrading = new ArrayList<Grading>(BackPack.studentList.size());
		
//		Create Grading sheet for every student
		for (int i = 0; i < BackPack.studentList.size(); i++) {
			QuizGrading qg = new QuizGrading(BackPack.studentList.get(i));
			studentGrading.add(qg);
		}
	}

	@Override
	public void addAssessment() {
		// TODO Auto-generated method stub
		sc.nextLine();
		System.out.println("========================================");
		System.out.print("Enter Quiz Question: ");
		this.setQuestion(sc.nextLine());	
		System.out.println("========================================");
	}

	@Override
	public void displayAssessment() {
		// TODO Auto-generated method stub
//		Quiz Problem
		System.out.println("========================================");
		System.out.println("Question: " + this.getQuestion());
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
		System.out.println("Question: " + this.getQuestion());
		System.out.println("Answer: " + this.getStudentGrading().get(submissionChoice).getSubmission());
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
		System.out.print(this.getQuestion() + ": ");
		
		String submission = sc.nextLine();
		System.out.println("========================================");
		
		this.getStudentGrading().get(studentID).setSubmission(submission);
		this.getStudentGrading().get(studentID).setPending(false);
	}
	
	@Override
	public String getProblemQuestion() {
		return question;
	}

	
//	Getters and Setters
//	Question
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

//	Max marks
	public int getMaxMarks() {
		return maxMarks;
	}

	public void setMaxMarks(int maxMarks) {
		this.maxMarks = maxMarks;
	}

//	Open or Closed
	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}
	
//	studentGrading
	public ArrayList<Grading> getStudentGrading() {
		return studentGrading;
	}

	public void setStudentGrading(ArrayList<Grading> studentGrading) {
		this.studentGrading = studentGrading;
	}

////Marks Obtained
//public int getMarksObtained() {
//	return marksObtained;
//}
//
//public void setMarksObtained(int marksObtained) {
//	this.marksObtained = marksObtained;
//}
	
////	Pending or not
//	public boolean isPending() {
//		return pending;
//	}
//	
//	public void setPending(boolean pending) {
//		this.pending = pending;
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
////	Quiz Graded By
//	public String getGradedBy() {
//		return gradedBy;
//	}
//
//	public void setGradedBy(String gradedBy) {
//		this.gradedBy = gradedBy;
//	}
}