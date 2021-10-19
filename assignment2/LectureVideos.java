package assignment2;

import java.util.Date;

public class LectureVideos extends BackPack implements LectureMaterial{
	
//	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
//	LocalDateTime now = LocalDateTime.now();
	
	Date date = new Date();
	
	private String topic;
	private String filename;
	private String uploadDateTime;
	private String author;
	
//	Constructor
	public LectureVideos(String author) {
		this.setAuthor(author);
		
		String dateStr = String.format("%tc", date);
		this.setUploadDateTime(dateStr);
	}

	@Override
	public void addMaterial() {
		// TODO Auto-generated method stub
//		Input topic
		sc.nextLine();
		System.out.print("Enter topic of video: ");
		String topicInput = sc.nextLine();
		this.setTopic(topicInput);
		
//		Input file name
		System.out.print("Enter filename of video: ");
		String fname = sc.nextLine();

//		Check for file type
		if(fname.endsWith(".mp4")) {
			this.setFilename(fname);
		}
		else {
			System.out.println("Wrong File Type!! :(");
		}
	}

	@Override
	public void displayMaterial() {
		// TODO Auto-generated method stub
		System.out.println("========================================");
//		Title
		System.out.println("Topic: " + this.getTopic());
		
//		Filename
		System.out.println("File Name: " + this.getFilename());
		
//		Date of upload
		System.out.println("Date of upload: " + this.getUploadDateTime());
		
//		Author
		System.out.println("Uploaded by: " + this.getAuthor());
		System.out.println("========================================");
	}

	
//	Getters and Setters
//	Topic
	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

//	File Name
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

//	Upload Date and Time
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