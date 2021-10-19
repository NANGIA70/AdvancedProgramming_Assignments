package assignment2;

import java.util.Date;

public class Comment {
//	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
//	LocalDateTime now = LocalDateTime.now(); 
	
	Date date = new Date();
	
	private String account;
	private String content;
	private String currTime;
	
	public Comment(String account, String content) {
		this.setAccount(account);
		this.setContent(content);
		
		String dateStr = String.format("%tc", date);
		this.setCurrTime(dateStr);
	}
	
	public void Display() {
		System.out.println("========================================");
//		Content
		System.out.println(this.getContent() + " - " + this.getAccount());
		
//		Upload Date and time
		System.out.println(this.getCurrTime());
		System.out.println("========================================");
	}

//	Account Name
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

//	Content of Comment
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

//	Time of comment
	public String getCurrTime() {
		return currTime;
	}

	public void setCurrTime(String currTime) {
		this.currTime = currTime;
	}
}