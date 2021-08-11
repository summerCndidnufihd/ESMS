package service;

import java.util.List;
import java.util.Map;

import dao.Dao;
import entity.Book;
import entity.Borrow;
import entity.User;

public class Service {
	
	Dao bd=new Dao();
	/**
	 * 登录验证
	 * @param n
	 * @return
	 */
	public User loginService(User user) {
		return bd.LoginDao(user);
	}
	/**
	 * 按角色查询
	 * @param n
	 * @return
	 */
	public List<Book> bookList() {
		return bd.bookList();
	}
	/**
	 * 搜索查询
	 * @param n
	 * @return
	 */
	public List<Book> searchByName(String search_item,String n) {
		return bd.searchByName(search_item,n);
	}
    /**
     * 借书状态改变
     */
	public boolean borrowBook(int id1,int id2,int actor) {
		return bd.borrowBook(id1,id2,actor);
	}
	
	public List<Book> myselfInfo(int id) {
		return bd.myselfInfo(id);
	}
	public List<Borrow> continueBook(int id) {
		return bd.continueBook(id);
	}
	public boolean backBook(int id1, int id2) {
		return bd.backBook(id1,id2);
	}
	public List<Borrow> borrowInfo(int id) {
		return bd.borrowInfo(id);
	}
	public List<Book> borrowBookList(int id) {
		return bd.borrowBookList(id);
	}
	public boolean editInfo(User user) {
		return bd.editInfo(user);
	}
	public User searchInfo(int id) {
		return bd.searchInfo(id);
	}
	public List<Book> addBook(Book book) {
		return bd.addBook(book);
	}
	public boolean delBook(int id) {
		return bd.delBook(id);
	}
	public boolean editBookSubmit(Book book) {
		return bd.editBookSubmit(book);
	}
	public Book searchBookById(int book_id) {
		return bd.searchBookById(book_id);
	}
	public List<Map<String, Object>> countBook(String count_item) {
		return bd.countBook(count_item);
	}
	public List<User> userList() {
		return bd.userList();
	}
	public boolean delUser(int id) {
		return bd.delUser(id);
	}
	public List<User> addUser(User user) {
		return bd.addUser(user);
	}
	public List<User> searchUserByName(String search_item, String name) {
		return bd.searchUserByName(search_item,name);
	}
	public List<Borrow> borrowAllInfo() {
		return bd.borrowAllInfo();
	}
	public List<Borrow> searchUserBorrowBook(String search_item, String name) {
		return bd.searchUserBorrowBook(search_item,name);
	}
	public int updateUserInfo(User user) {
		return bd.updateUserInfo(user);
	}
	public int updateBookInfo(Book book) {
		return bd.updateBookInfo(book);
	}
	public int changePower(int actor, int uMaxBorrow, int borrow_end) {
		return bd.changePower(actor,uMaxBorrow,borrow_end);
	}
}
