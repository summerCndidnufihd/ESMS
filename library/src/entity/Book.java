package entity;

public class Book {
	private int book_id;
	private String book_name;
	private String book_author;
	private String book_publish;
	private int book_outNum;
	private int book_haveNum;
	private String book_type;
	private int book_state;
	
	public int getBook_state() {
		return book_state;
	}
	public void setBook_state(int book_state) {
		this.book_state = book_state;
	}
	public int getBook_outNum() {
		return book_outNum;
	}
	public void setBook_outNum(int book_outNum) {
		this.book_outNum = book_outNum;
	}
	public int getBook_haveNum() {
		return book_haveNum;
	}
	public void setBook_haveNum(int book_haveNum) {
		this.book_haveNum = book_haveNum;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public String getBook_publish() {
		return book_publish;
	}
	public void setBook_publish(String book_publish) {
		this.book_publish = book_publish;
	}
	public String getBook_type() {
		return book_type;
	}
	public void setBook_type(String book_type) {
		this.book_type = book_type;
	}
	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", book_name=" + book_name + ", book_author=" + book_author
				+ ", book_publish=" + book_publish + ", book_outNum=" + book_outNum + ", book_haveNum=" + book_haveNum
				+ ", book_type=" + book_type + "]";
	}
	
	
}
