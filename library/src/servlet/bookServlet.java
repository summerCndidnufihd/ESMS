package servlet;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Book;
import entity.User;
import service.Service;

/**
 * Servlet implementation class adminListServlet
 */
@WebServlet("/bookServlet")
public class bookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		List<Book> list=new ArrayList<Book>();
		System.out.print("×ªµ½servlet");
		Service s=new Service();
		list=s.bookList();
		System.out.print(list);
		if(list == null) {
			System.out.print("list¿Õ");
			request.getRequestDispatcher("book-list.jsp").forward(request, response);
			return;
		}else {
			request.setAttribute("book", list);
			System.out.print("servlet½áÊø");
			System.out.print(list);
			request.getRequestDispatcher("book-list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
