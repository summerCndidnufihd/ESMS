package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import entity.Book;
import entity.Borrow;
import entity.User;

public class Dao extends BaseDao{

	/**
	 * 登录
	 * @param user
	 * @return
	 */
	public User LoginDao(User user) {
		String sql="select * from tb_user where uName='"+user.getuName()+"' and uPwd='"+user.getuPwd()+"'";
		ResultSet result=select(sql);
		try {
			if(result.next()) {
				User user1=new User();
				user1.setId(result.getInt("id"));
				user1.setuName(result.getString("uName"));
				user1.setuRealName(result.getString("uRealName"));
				user1.setuPwd(result.getString("uPwd"));
				user1.setuSex(result.getString("uSex"));
				user1.setuAge(result.getInt("uAge"));
				user1.setuPhone(result.getString("uPhone"));
				user1.setActor(result.getInt("actor"));
				user1.setuBorrow(result.getInt("uBorrow"));
				return user1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 显示图书列表
	 * @param user
	 * @return
	 */
	public List<Book> bookList() {
		String sql="select * from tb_book";
		ResultSet result=select(sql);
		List<Book> list=new ArrayList<Book>();
		try {
			while(result.next()) {
				Book book=new Book();
				book.setBook_id(result.getInt("book_id"));
				book.setBook_name(result.getString("book_name"));
				book.setBook_author(result.getString("book_author"));
				book.setBook_publish(result.getString("book_publish"));
				book.setBook_type(result.getString("book_type"));
				book.setBook_outNum(result.getInt("book_outNum"));
				book.setBook_haveNum(result.getInt("book_haveNum"));
				book.setBook_state(result.getInt("book_state"));
				list.add(book);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 多条件查询
	 */
	public List<Book> searchByName(String search_item,String n) {
		String sql="";
		if(search_item.equals("book_id")) {
			int m=Integer.parseInt(n);
			sql="select * from tb_book where book_id ="+m;
		}else {
			if(search_item.equals("book_name")) {
				sql="select * from tb_book where book_name LIKE '%"+n+"%'";
			}else {
				if(search_item.equals("book_author")) {
					sql="select * from tb_book where book_author LIKE '%"+n+"%'";
				}else {
					if(search_item.equals("book_publish")) {
						sql="select * from tb_book where book_publish LIKE '%"+n+"%'";
					}
				}
			}
		}
		ResultSet result=select(sql);
		List<Book> list=new ArrayList<Book>();
		try {
			while(result.next()) {
				Book book=new Book();
				book.setBook_id(result.getInt("book_id"));
				book.setBook_name(result.getString("book_name"));
				book.setBook_author(result.getString("book_author"));
				book.setBook_publish(result.getString("book_publish"));
				book.setBook_type(result.getString("book_type"));
				book.setBook_outNum(result.getInt("book_outNum"));
				book.setBook_haveNum(result.getInt("book_haveNum"));
				book.setBook_state(result.getInt("book_state"));
				list.add(book);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
/**
 * 个人信息
 * @param id
 * @return
 */
	public List<Book> myselfInfo(int id) {
		System.out.print("个人喜喜");
			String sql = "select a.book_id,b.book_name,b.book_author,b.book_publish,b.book_type"
					+ " from tb_borrow a,tb_book b where a.book_id=b.book_id and a.user_id="+id;
			ResultSet result=select(sql);
			List<Book> list=new ArrayList<Book>();
			try {
				while(result.next()) {
					Book book=new Book();
					book.setBook_id(result.getInt("book_id"));
					book.setBook_name(result.getString("book_name"));
					book.setBook_author(result.getString("book_author"));
					book.setBook_publish(result.getString("book_publish"));
					book.setBook_type(result.getString("book_type"));
					list.add(book);
					return list;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}
/**
 * 借书
 * @param id1
 * @param id2
 * @param actor
 * @return
 */
	public boolean borrowBook(int id1, int id2,int actor) {
		String sql="update tb_user set uBorrow=uBorrow+"+1+" where id="+id1;
		update(sql);
		String sql1="update tb_book set book_outNum=book_outNum+"+1+",book_state=book_state+"+1+" where book_id="+id2;
		update(sql1);
		DateTimeFormatter fmt=DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
		LocalDateTime dateTime=LocalDateTime.now();
		String date1=dateTime.format(fmt);
		System.out.print(date1);
		String date2="";
		System.out.print("---");
		String mon=date1.substring(5,7);
		String mon2=date1.substring(7);
		System.out.print(mon);
		System.out.print("---");
		System.out.print(mon2);
		int m=Integer.parseInt(mon);
		String mo="";
		if(actor==0) {
			m=m+5;
			mo=Integer.toString(m);
			date2=date1.substring(0,5)+mo+date1.substring(7);
		}else {
			if(actor==1) {
				m=m+3;
				mo=Integer.toString(m);
				date2=date1.substring(0,5)+mo+date1.substring(7);
			}else {
				m=m+2;
				mo=Integer.toString(m);
				date2=date1.substring(0,5)+mo+date1.substring(7);
			}
		}
		String sql3="insert into tb_borrow(user_id,book_id,borrow_start,borrow_end,borrow_back) values("+id1+","+id2+",'"+date1+"','"+date2+"','未归还')";
//		System.out.print(date1);
		update(sql3);
		return true;
	}
/**
 * 根据id查找书籍
 * @param id
 * @return
 */
	public List<Borrow> continueBook(int id) {
		String sql="select * from tb_borrow where user_id="+id;
		ResultSet result=select(sql);
		List<Borrow> list=new ArrayList<Borrow>();
		try {
			while(result.next()) {
				Borrow ob=new Borrow();
				ob.setUser_id(result.getInt("user_id"));
				ob.setBook_id(result.getInt("book_id"));
				ob.setBorrow_start(result.getString("borrow_start"));
				ob.setBorrow_end(result.getString("borrow_end"));
				ob.setBorrow_back(result.getString("borrow_back"));
				list.add(ob);
				return list;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
/**
 * 归还图书
 * @param id1
 * @param id2
 * @return
 */
	public boolean backBook(int id1, int id2) {
			String sql="update tb_user set uBorrow=uBorrow-"+1+" where id="+id1;
			update(sql);
			String sql1="update tb_book set book_state=book_state+"+1+",book_outNum=book_outNum-"+1+" where book_id="+id2;
			update(sql1);
			DateTimeFormatter fmt=DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
			LocalDateTime dateTime=LocalDateTime.now();
			String date1=dateTime.format(fmt);
			String sql3="update tb_borrow set borrow_back='"+date1+"' where book_id="+id2;
			System.out.print(date1);
			update(sql3);
			return true;
	}
/**
 * 个人借阅记录
 * @param id
 * @return
 */
	public List<Borrow> borrowInfo(int id) {
		String sql="select * from tb_borrow where user_id="+id;
		ResultSet result=select(sql);
		List<Borrow> list=new ArrayList<Borrow>();
		try {
			while(result.next()) {
				Borrow ob=new Borrow();
				ob.setUser_id(result.getInt("user_id"));
				ob.setBook_id(result.getInt("book_id"));
				ob.setBorrow_start(result.getString("borrow_start"));
				ob.setBorrow_end(result.getString("borrow_end"));
				ob.setBorrow_back(result.getString("borrow_back"));
				list.add(ob);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
/**
 * 所有借阅记录
 * @param id
 * @return
 */
	public List<Book> borrowBookList(int id) {
		String sql = "select b.book_id,b.book_name,b.book_author,b.book_publish,b.book_type"
				+ " from tb_borrow a,tb_book b where a.book_id=b.book_id and a.user_id="+id;
		ResultSet result=select(sql);
		List<Book> list=new ArrayList<Book>();
		try {
			while(result.next()) {
				Book book=new Book();
				book.setBook_id(result.getInt("book_id"));
				book.setBook_name(result.getString("book_name"));
				book.setBook_author(result.getString("book_author"));
				book.setBook_publish(result.getString("book_publish"));
				book.setBook_type(result.getString("book_type"));
				list.add(book);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
/**
 * 编辑个人信息
 * @param user
 * @return
 */
	public boolean editInfo(User user) {
		String sql="update tb_user set uName='"+user.getuName()+"',uPwd='"+user.getuPwd()+"',"
				+"uRealName='"+user.getuRealName()+"',uAge="+user.getuAge()+",uPhone='"+user.getuPhone()+"'"
						+ "where id="+user.getId();
		System.out.print("修改sql");
		if(update(sql)) {
			return true;
		}else {
			return false;
		}
	}
/**
 * 查找个人信息
 * @param id
 * @return
 */
	public User searchInfo(int id) {
		String sql="select * from tb_user where id="+id;
		ResultSet result=select(sql);
		try {
			if(result.next()) {
				User user1=new User();
				user1.setId(result.getInt("id"));
				user1.setuName(result.getString("uName"));
				user1.setuRealName(result.getString("uRealName"));
				user1.setuPwd(result.getString("uPwd"));
				user1.setuSex(result.getString("uSex"));
				user1.setuAge(result.getInt("uAge"));
				user1.setuPhone(result.getString("uPhone"));
				user1.setActor(result.getInt("actor"));
				user1.setuBorrow(result.getInt("uBorrow"));
				user1.setuMaxBorrow(result.getInt("uMaxBorrow"));
				return user1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
/**
 * 添加图书
 * @param book
 * @return
 */
	public List<Book> addBook(Book book) {
		String sql ="insert into tb_book(book_id,book_name,book_author,book_publish,book_type,book_outNum,book_haveNum,book_state) "
				+ "values("+book.getBook_id()+",'"+book.getBook_name()+"','"
				+book.getBook_author()+"','"+book.getBook_publish()+"','"+book.getBook_type()+"',"+0+""
				+","+book.getBook_haveNum()+","+0+")";
		ResultSet result=null;
		if(update(sql)) {
			String sql1="select * from tb_book where book_id="+book.getBook_id();
			result=select(sql1);
		}
		List<Book> list=new ArrayList<Book>();
		try {
			while(result.next()) {
				Book book1=new Book();
				book1.setBook_id(result.getInt("book_id"));
				book1.setBook_name(result.getString("book_name"));
				book1.setBook_author(result.getString("book_author"));
				book1.setBook_publish(result.getString("book_publish"));
				book1.setBook_type(result.getString("book_type"));
				book1.setBook_outNum(result.getInt("book_outNum"));
				book1.setBook_haveNum(result.getInt("book_haveNum"));
				book1.setBook_state(result.getInt("book_state"));
				list.add(book);
				return list;
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
/**
 * 删除图书
 * @param id
 * @return
 */
	public boolean delBook(int id) {
		String sql="delete from tb_book where book_id="+id;
		if(update(sql)) {
			return true;
		}else {
			return false;
		}
	}
/**
 * 编辑图书后提交
 * @param book
 * @return
 */
	public boolean editBookSubmit(Book book) {
		String sql="update tb_user set book_name='"+book.getBook_name()+"',book_author='"+book.getBook_author()+"',"
				+"book_publish='"+book.getBook_publish()+"',book_haveNum="+book.getBook_haveNum()+",book_type='"+book.getBook_type()+"'"
						+ "where id="+book.getBook_id();
		System.out.print("修改sql");
		if(update(sql)) {
			return true;
		}else {
			return false;
		}
	}
/**
 * 根据id查找图书
 * @param book_id
 * @return
 */
	public Book searchBookById(int book_id) {
		String sql="select * from tb_book where book_id="+book_id;
		ResultSet result=select(sql);
		try {
			while(result.next()) {
				Book book=new Book();
				book.setBook_id(result.getInt("book_id"));
				book.setBook_name(result.getString("book_name"));
				book.setBook_author(result.getString("book_author"));
				book.setBook_publish(result.getString("book_publish"));
				book.setBook_type(result.getString("book_type"));
				book.setBook_outNum(result.getInt("book_outNum"));
				book.setBook_haveNum(result.getInt("book_haveNum"));
				book.setBook_state(result.getInt("book_state"));
				return book;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
/**
 * 统计图书
 * @param count_item
 * @return
 */
	public List<Map<String,Object>> countBook(String count_item) {
		String sql="";
		if(count_item.equals("book_author")) {
			sql="select "+count_item+",count(book_id) '图书ID统计:',SUM(book_outNum) '已借出总数:',SUM(book_haveNum) '剩余图书总数:',book_outNum+book_haveNum '总计:' from tb_book " + 
					" GROUP BY book_author";
		}else {
			if(count_item.equals("book_type")){
				sql="select "+count_item+",count(book_id) '图书ID统计:',SUM(book_outNum) '已借出总数:',SUM(book_haveNum) '剩余图书总数:',book_outNum+book_haveNum '总计:' from tb_book" + 
						" GROUP BY book_type";
			}else {
				sql="select "+count_item+" ,count(book_id) '图书ID统计:',SUM(book_outNum) '已借出总数:',SUM(book_haveNum) '剩余图书总数:',book_outNum+book_haveNum '总计:' from tb_book " + 
						" GROUP BY book_publish";
			}
		}
		return select1(sql);
	}
/**
 * 借阅者列表
 * @return
 */
	public List<User> userList() {
		String sql="select * from tb_user";
		ResultSet result=select(sql);
		List<User> list=new ArrayList<User>();
		try {
			while(result.next()) {
				User user1=new User();
				user1.setId(result.getInt("id"));
				user1.setuName(result.getString("uName"));
				user1.setuRealName(result.getString("uRealName"));
				user1.setuPwd(result.getString("uPwd"));
				user1.setuSex(result.getString("uSex"));
				user1.setuAge(result.getInt("uAge"));
				user1.setuPhone(result.getString("uPhone"));
				user1.setActor(result.getInt("actor"));
				user1.setuBorrow(result.getInt("uBorrow"));
				list.add(user1);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
/**
 * 删除借阅者
 * @param id
 * @return
 */
	public boolean delUser(int id) {
		String sql="delete from tb_user where id="+id;
		if(update(sql)) {
			return true;
		}else {
			return false;
		}
	}
/**
 * 添加借阅者
 * @param user
 * @return
 */
	public List<User> addUser(User user) {
		int a=0;
		if(user.getActor()==0) {
			a=5;
		}else {
			if(user.getActor()==1) {
				a=3;
			}else {
				a=2;
			}
		}
		String sql ="insert into tb_user(uName,uPwd,uRealName,uSex,uAge,uPhone,actor,uMaxBorrow) "
				+ "values('"+user.getuName()+"','"
				+user.getuPwd()+"','"+user.getuRealName()+"','"+user.getuSex()+"',"
				+user.getuAge()+",'"+user.getuPhone()+"',"+user.getActor()+","+a+")";
		ResultSet result=null;
		if(update(sql)) {
			String sql1="select * from tb_user where uName='"+user.getuName()+"'";
			result=select(sql1);
		}
		List<User> list=new ArrayList<User>();
		try {
			while(result.next()) {
				User user1=new User();
				user1.setId(result.getInt("id"));
				user1.setuName(result.getString("uName"));
				user1.setuPwd(result.getString("uPwd"));
				user1.setuRealName(result.getString("uRealName"));
				user1.setuSex(result.getString("uSex"));
				user1.setuAge(result.getInt("uAge"));
				user1.setuPhone(result.getString("uPhone"));
				user1.setActor(result.getInt("actor"));
				user1.setuBorrow(result.getInt("uBorrow"));
				user1.setuMaxBorrow(result.getInt("uMaxBorrow"));
				list.add(user1);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
/**
 * 多条件查找用户
 * @param search_item
 * @param name
 * @return
 */
	public List<User> searchUserByName(String search_item, String name) {
		String sql="";
		if(search_item.equals("id")) {
			int m=Integer.parseInt(name);
			sql="select * from tb_user where id ="+m;
		}else {
				sql="select * from tb_user where uName LIKE '%"+name+"%'";
			}
		ResultSet result=select(sql);
		List<User> list=new ArrayList<User>();
		try {
			while(result.next()) {
				User user1=new User();
				user1.setId(result.getInt("id"));
				user1.setuName(result.getString("uName"));
				user1.setuPwd(result.getString("uPwd"));
				user1.setuRealName(result.getString("uRealName"));
				user1.setuSex(result.getString("uSex"));
				user1.setuAge(result.getInt("uAge"));
				user1.setuPhone(result.getString("uPhone"));
				user1.setActor(result.getInt("actor"));
				user1.setuBorrow(result.getInt("uBorrow"));
				list.add(user1);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
/**
 * 所有借阅信息
 * @return
 */
	public List<Borrow> borrowAllInfo() {
		String sql="select * from tb_borrow";
		ResultSet result=select(sql);
		List<Borrow> list=new ArrayList<Borrow>();
		try {
			while(result.next()) {
				Borrow ob=new Borrow();
				ob.setUser_id(result.getInt("user_id"));
				ob.setBook_id(result.getInt("book_id"));
				ob.setBorrow_start(result.getString("borrow_start"));
				ob.setBorrow_end(result.getString("borrow_end"));
				ob.setBorrow_back(result.getString("borrow_back"));
				list.add(ob);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
/**
 * 查找用户的借阅记录
 * @param search_item
 * @param name
 * @return
 */
	public List<Borrow> searchUserBorrowBook(String search_item, String name) {
		int m=Integer.parseInt(name);
		String sql="";
		if(search_item.equals("userQuery")) {
			sql="select * from tb_borrow where user_id="+m;
		}else {
			sql="select * from tb_borrow where book_id="+m;
		}
		ResultSet result=select(sql);
		List<Borrow> list=new ArrayList<Borrow>();
		try {
			while(result.next()) {
				Borrow ob=new Borrow();
				ob.setUser_id(result.getInt("user_id"));
				ob.setBook_id(result.getInt("book_id"));
				ob.setBorrow_start(result.getString("borrow_start"));
				ob.setBorrow_end(result.getString("borrow_end"));
				ob.setBorrow_back(result.getString("borrow_back"));
				list.add(ob);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
/**
 * 更新用户信息
 * @param user
 * @return
 */
public int updateUserInfo(User user) {
	int a=0;
	Connection con = getConnection();
	PreparedStatement ps=null;
	String sql="update tb_user set uName=?,uPwd=?,uRealName=?,"
			+ "uSex=?,uAge=?,uPhone=? where id=?";
	try {
		ps=con.prepareStatement(sql);
		ps.setString(1, user.getuName());
		ps.setString(2, user.getuPwd());
		ps.setString(3, user.getuRealName());
		ps.setString(4, user.getuSex());
		ps.setInt(5, user.getuAge());
		ps.setString(6, user.getuPhone());
		ps.setInt(7, user.getId());
		a=ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return a;
}

public int updateBookInfo(Book book) {
	int a=0;
	Connection con = getConnection();
	PreparedStatement ps=null;
	String sql="update tb_book set book_name=?,book_author=?,book_publish=?,"
			+ "book_type=?,book_haveNum=? where book_id=?";
	try {
		ps=con.prepareStatement(sql);
		ps.setString(1, book.getBook_name());
		ps.setString(2, book.getBook_author());
		ps.setString(3, book.getBook_publish());
		ps.setString(4, book.getBook_type());
		ps.setInt(5, book.getBook_haveNum());
		ps.setInt(6, book.getBook_id());
		a=ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return a;
}

public int changePower(int actor, int uMaxBorrow, int borrow_end) {
	String sql="update tb_user set uMaxBorrow="+uMaxBorrow+" where actor="+actor;
	
	update(sql);
	//获取时间
	DateTimeFormatter fmt=DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
	LocalDateTime dateTime=LocalDateTime.now();
	String date1=dateTime.format(fmt);
	System.out.print(date1);
	String date2="";
	System.out.print("---");
	String mon=date1.substring(5,7);
	String mon2=date1.substring(7);
	System.out.print(mon);
	System.out.print("---");
	System.out.print(mon2);
	int m=Integer.parseInt(mon);
	String mo="";
	if(actor==0) {
		m=m+borrow_end;
		mo=Integer.toString(m);
		date2=date1.substring(0,5)+mo+date1.substring(7);
	}else {
		if(actor==1) {
			m=m+borrow_end;
			mo=Integer.toString(m);
			date2=date1.substring(0,5)+mo+date1.substring(7);
		}else {
			m=m+borrow_end;
			mo=Integer.toString(m);
			date2=date1.substring(0,5)+mo+date1.substring(7);
		}
	}
	String sql1="update tb_borrow set borrow_end='"+date2+"' where user_id in (select id from tb_user where actor="+actor+")";
	if(update(sql1)) {
		return 1;
	}else {
		return 0;
	}
	
}
}
