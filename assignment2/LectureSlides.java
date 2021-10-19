package assignment2;

//import java.time.*;
//import java.time.format.*;
import java.util.ArrayList;
import java.util.Date;

public class LectureSlides extends BackPack implements LectureMaterial{
	
//	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
//	LocalDateTime now = LocalDateTime.now();
	Date date = new Date();
	
	private String title;
	private int numberOfSlides;
	private String uploadDateTime;
	private String author;
	
	private ArrayList<String> content = new ArrayList<String>();
	
	public LectureSlides(String author) {
		this.setAuthor(author);
		
		String dateStr = String.format("%tc", date);
		this.setUploadDateTime(dateStr);
	}
	
	@Override
	public void addMaterial() {
		// TODO Auto-generated method stub
//		Input topic
		sc.nextLine();
		System.out.print("Enter Title of slides: ");
		String titleInput = sc.nextLine();
		
//		Input Number of Slides
		System.out.print("Enter Number of slides: ");
		int numSlides = sc.nextInt();
		sc.nextLine();
		
//		Input content of slides
		System.out.println("Enter Content of Slides: ");
		for (int i = 0; i < numSlides; i++) {
			System.out.print("Content of Slide " + (i + 1) + " : ");
			content.add(sc.nextLine());
		}
		
		this.setTitle(titleInput);
		this.setNumberOfSlides(numSlides);
	}
	
	@Override
	public void displayMaterial() {
		// TODO Auto-generated method stub
		System.out.println("========================================");
//		Title
		System.out.println("Title: " + this.getTitle());
		
//		Number of slides
		System.out.println("Number of Slides: " + this.getNumberOfSlides());
		
//		Content of Slides
		for (int i = 0; i < this.getNumberOfSlides(); i++) {
			System.out.println("Slide " + i + " : " + content.get(i));
		}
		
//		Date of upload
		System.out.println("Date of upload: " + this.getUploadDateTime());
		
//		Author
		System.out.println("Uploaded by: " + this.getAuthor());
		System.out.println("========================================");
	}
	
	
//	Getters and Setters
//	Title
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
//	Number of slides
	public int getNumberOfSlides() {
		return numberOfSlides;
	}
	
	public void setNumberOfSlides(int numberOfSlides) {
		this.numberOfSlides = numberOfSlides;
	}
	
//	Upload date and time
	public String getUploadDateTime() {
		return uploadDateTime;
	}
	
	public void setUploadDateTime(String uploadDateTime) {
		this.uploadDateTime = uploadDateTime;
	}
	
//	Instructor who uploaded
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
}