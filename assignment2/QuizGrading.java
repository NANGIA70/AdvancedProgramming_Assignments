package assignment2;

public class QuizGrading implements Grading{
	private Student student;
	
	private String gradedBy;
	private String submission;
	
	private int marksObtained;
	
	private boolean pending;
	private boolean graded;
	
	public QuizGrading(Student stu) {
		// TODO Auto-generated constructor stub
		this.setStudent(stu);
		this.setMarksObtained(-1);
		this.setGraded(false);
		this.setPending(true);
	}


	//	Getters and Setters
//	Student
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

//	Quiz Graded By
	public String getGradedBy() {
		return gradedBy;
	}

	public void setGradedBy(String gradedBy) {
		this.gradedBy = gradedBy;
	}

//	Submission
	public String getSubmission() {
		return submission;
	}

	public void setSubmission(String submission) {
		this.submission = submission;
	}

//	Marks Obtained
	public int getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(int marksObtained) {
		this.marksObtained = marksObtained;
	}

//	Pending or not
	public boolean isPending() {
		return pending;
	}

	public void setPending(boolean pending) {
		this.pending = pending;
	}

//	Graded or not
	public boolean isGraded() {
		return graded;
	}

	public void setGraded(boolean graded) {
		this.graded = graded;
	}
}
