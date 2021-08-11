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
import service.Service;

/**
 * Servlet implementation class backBookServlet
 */
@WebServlet("/backBookServlet")
public class backBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public backBookServlet() {
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
		int id1=Integer.parseInt(request.getParameter("id1"));
		int id2=Integer.parseInt(request.getParameter("id2"));
		Service s=new Service();
		//List<Borrow> list=new ArrayList<Borrow>();
		if(s.backBook(id1,id2)) {
			List<Borrow> list=new ArrayList<Borrow>();
			Service s1=new Service();
			String id="";
			id=String.valueOf(id1);
			list=s1.searchUserBorrowBook("", id);
			System.out.print(list);
			request.setAttribute("con", list);
			request.getRequestDispatcher("continue.jsp").forward(request, response);
			return;
		}
	}

}
