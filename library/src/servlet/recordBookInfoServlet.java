package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Book;
import entity.User;
import service.Service;

/**
 * Servlet implementation class recordBookInfoServlet
 */
@WebServlet("/recordBookInfoServlet")
public class recordBookInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public recordBookInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Service s=new Service();
		Book book=new Book();
		int id=Integer.parseInt(request.getParameter("id"));
		book.setBook_id(id);
		book=s.searchBookById(id);
		request.setAttribute("book", book);
		System.out.print("servlet½áÊø");
		System.out.print(book);
		request.getRequestDispatcher("editBook.jsp").forward(request, response);
	}

}
