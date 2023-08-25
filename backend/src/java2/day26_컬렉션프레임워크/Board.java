package java2.day26_컬렉션프레임워크;

public class Board {
	private String subject;
	private String content;
	private String writetr;
	
	
	public Board() {
		// TODO Auto-generated constructor stub
	}


	public Board(String subject, String content, String writetr) {
		super();
		this.subject = subject;
		this.content = content;
		this.writetr = writetr;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getWritetr() {
		return writetr;
	}


	public void setWritetr(String writetr) {
		this.writetr = writetr;
	}


	@Override
	public String toString() {
		return "Board [subject=" + subject + ", content=" + content + ", writetr=" + writetr + "]\n";
	}
	
	
	
}
