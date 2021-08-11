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
import entity.Borrow;
import entity.User;
import service.Service;

/**
 * Servlet implementation class continueBookServlet
 */
@WebServlet("/continueBookServlet")
public class continueBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public continueBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User u=(User) session.getAttribute("user");
		System.out.print("这是借书列表的：");
		int id=u.getId();
		System.out.print(id);
		List<Borrow> list=new ArrayList<Borrow>();
		Service s=new Service();
		String id1=String.valueOf(id);
		list=s.searchUserBorrowBook("userQuery",id1);
		if(list!=null) {
			request.setAttribute("con", list);
			System.out.print(list);
			request.getRequestDispatcher("continue.jsp").forward(request, response);
		}else {
			System.out.print("空的");
			request.getRequestDispatcher("continue.jsp").forward(request, response);
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
