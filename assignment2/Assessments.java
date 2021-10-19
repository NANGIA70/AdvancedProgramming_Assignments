package assignment2;

import java.util.ArrayList;

public interface Assessments {
//	Add
	public void addAssessment();
	
//	View
	public void displayAssessment();
	
//	Grade
	public void gradeAssessment(String gradedBy);
	
//	Submit
	public void submitAssessment(int studentID);
	
//	Close
	public void closeAssessment();
	
//	Check if open
	public boolean isOpen();
	
//	Student Grading
	public ArrayList<Grading> getStudentGrading();
	
//	Max Marks
	public int getMaxMarks();
	
//	Statement
	public String getProblemQuestion();
}