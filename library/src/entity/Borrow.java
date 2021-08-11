package entity;

import java.util.Date;

public class Borrow {
	private int user_id;
	private int book_id;
	private String borrow_start;
	private String borrow_end;
	private String borrow_back;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBorrow_start() {
		return borrow_start;
	}
	public void setBorrow_start(String borrow_start) {
		this.borrow_start = borrow_start;
	}
	public String getBorrow_end() {
		return borrow_end;
	}
	public void setBorrow_end(String borrow_end) {
		this.borrow_end = borrow_end;
	}
	public String getBorrow_back() {
		return borrow_back;
	}
	public void setBorrow_back(String borrow_back) {
		this.borrow_back = borrow_back;
	}
	
}
