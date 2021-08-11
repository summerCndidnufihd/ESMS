package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Book;
import entity.User;
import service.Service;

/**
 * Servlet implementation class addBookServlet
 */
@WebServlet("/addBookServlet")
public class addBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.print("Ìí¼ÓÍ¼ÊéµÄ");
		List<Book> list=new ArrayList<Book>();
		int book_id=Integer.parseInt(request.getParameter("book_id"));
		String book_name=request.getParameter("book_name");
		String book_author=request.getParameter("book_author");
		String book_publish=request.getParameter("book_publish");
		String book_type=request.getParameter("book_type");
		int book_haveNum=Integer.parseInt(request.getParameter("book_haveNum"));
		Book book=new Book();
		book.setBook_id(book_id);
		book.setBook_name(book_name);
		book.setBook_author(book_author);
		book.setBook_publish(book_publish);
		book.setBook_type(book_type);
		book.setBook_haveNum(book_haveNum);
		Service s=new Service();
		list=s.addBook(book);
		if(list!=null) {
			System.out.print(list);
			request.setAttribute("book", list);
			request.getRequestDispatcher("addSuccess.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("addBook.jsp").forward(request, response);
		}
	}

}
