package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Book;
import service.Service;

/**
 * Servlet implementation class editBookServlet
 */
@WebServlet("/editBookServlet")
public class editBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editBookServlet() {
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
		int book_id=Integer.parseInt(request.getParameter("id"));
		System.out.print(book_id);
		Book book=new Book();
		Service s=new Service();
		book=s.searchBookById(book_id);
		if(book!=null) {
			System.out.print(book);
			request.setAttribute("book", book);
			request.getRequestDispatcher("book-list.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("book-list.jsp").forward(request, response);
		}
	}

}
