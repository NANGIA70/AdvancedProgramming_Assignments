package assignment2;

public interface Grading {
	public String getGradedBy();
	
	public void setGradedBy(String gradedBy);
	
	public int getMarksObtained();
	
	public void setMarksObtained(int marksObtained);
	
	public boolean isPending();
	
	public void setPending(boolean pending);
	
	public boolean isGraded();
	
	public void setGraded(boolean graded);
	
	public Student getStudent();
	
	public String getSubmission();
	
	public void setSubmission(String submission);
}
