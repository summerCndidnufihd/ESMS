package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Borrow;
import entity.User;
import service.Service;

/**
 * Servlet implementation class searchUserBorrowBookServlet
 */
@WebServlet("/searchUserBorrowBookServlet")
public class searchUserBorrowBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchUserBorrowBookServlet() {
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
		List<Borrow> list=new ArrayList<Borrow>();
		String search_item=request.getParameter("search_item");
		String name=request.getParameter("name");
		Service s=new Service();
		list=s.searchUserBorrowBook(search_item,name);
		System.out.print(list);
		if(list == null) {
			System.out.print("list¿Õ");
			request.getRequestDispatcher("user-list.jsp").forward(request, response);
			return;
		}else {
			request.setAttribute("borrow", list);
			System.out.print("servlet½áÊø");
			System.out.print(list);
			request.getRequestDispatcher("borrowInfo.jsp").forward(request, response);
		}
	}

}
