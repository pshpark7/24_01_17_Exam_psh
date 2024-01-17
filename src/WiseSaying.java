
public class WiseSaying {
	private int id;
	private String content;
	private String author;
	private String regDate;

	public WiseSaying(int id, String content, String author, String regDate) {
		this.id = id;
		this.content = content;
		this.author = author;
		this.regDate = regDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

}
